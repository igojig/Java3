package lesson_4;

public class PrintSequentially {

    public static final int COUNT = 10;
    char lastChar = 'C';

    void printA() {
        synchronized (this) {
            while (lastChar != 'C') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print('A');
            lastChar = 'A';
            notifyAll();
        }

    }

    void printB() {
        synchronized (this) {
            while (lastChar != 'A') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print('B');
            lastChar = 'B';
            notifyAll();
        }

    }

    void printC() {
        synchronized (this) {
            while (lastChar != 'B') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print('C');
            System.out.print(' ');
            lastChar = 'C';
            notifyAll();
        }

    }
}


