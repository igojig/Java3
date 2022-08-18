package lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Car implements Runnable {

    private static String winner;
//    static AtomicBoolean atomicBoolean=new AtomicBoolean(false);


    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    private CyclicBarrier cyclicBarrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
//        CARS_COUNT++;
        this.name = "Участник #" + ++CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 1000));
            System.out.println(this.name + " готов");

            //ждем подготовку машин
            cyclicBarrier.await();

            //для предотвращения старта машин до вывода надписи "Гонка началась"
            cyclicBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        race.getStages().forEach(o->o.go(this));


        // только один поток может установить победителя
        synchronized (Car.class) {
            if (winner == null) {
//                какое-то сложное действие
//                try {
//                    Thread.sleep((long) (Math.random()*10));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                winner = name;
                System.out.println("Winner: " + winner);
            }
        }

        try {
            //ждем окончания гонки
            cyclicBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}