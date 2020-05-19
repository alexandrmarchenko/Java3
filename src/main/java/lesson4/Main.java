package lesson4;

public class Main {
    private final Object syncObj = new Object();
    private char currentLetter = 'A';

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Main example = new Main();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                example.printA();
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                example.printB();
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                example.printC();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        synchronized (syncObj) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') {
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(currentLetter);
                currentLetter = 'B';
                syncObj.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (syncObj) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(currentLetter);
                currentLetter = 'C';
                syncObj.notifyAll();
            }
        }
    }

    public void printC() {
        synchronized (syncObj) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C') {
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(currentLetter);
                currentLetter = 'A';
                syncObj.notifyAll();
            }
        }
    }
}
