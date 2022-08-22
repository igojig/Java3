package lesson_5;


import lesson_5.stage.Road;
import lesson_5.stage.Tunnel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class MainClass {
    public static final int CARS_COUNT = 3;

    public static void main(String[] args) {

        // кол-во потоков + поток main
        CyclicBarrier cyclicBarrier=new CyclicBarrier(CARS_COUNT+1);
        Semaphore semaphore=new Semaphore(CARS_COUNT/2);


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        List<Car> carList=new ArrayList<>(CARS_COUNT);
        for (int i = 0; i < CARS_COUNT; i++) {
            carList.add(new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier));
        }
        for (Car car : carList) {
            new Thread(car).start();
        }

        try {
            //ждем подготовку машин
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            //для предотвращения старта машин до вывода надписи "Гонка началась"
            cyclicBarrier.await();

            //ждем окончания гонки
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
//        System.out.println(Car.winner);
    }
}
