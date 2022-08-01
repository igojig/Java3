package lesson_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson4 {


    public static int COUNT = 10;

    public static void main(String[] args) {
        PrintSequentially printSequental = new PrintSequentially();

        ExecutorService executorService=Executors.newFixedThreadPool(3);

        Runnable r1=()->{
            for (int i = 0; i < COUNT; i++) {
                printSequental.printA();
            }
        };

        Runnable r2=()->{
            for (int i = 0; i < COUNT; i++) {
                printSequental.printB();
            }
        };
        Runnable r3=()->{
            for (int i = 0; i < COUNT; i++) {
                printSequental.printC();
            }
        };

        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);

        executorService.shutdown();

    }
}



