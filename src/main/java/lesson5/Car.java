package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch raceEndLatch;
    private static CountDownLatch readyLatch;
    private static CyclicBarrier readyBarrier;

    static {
        CARS_COUNT = 0;
    }
    private Track track;
    private int speed;
    private String name;

    public static void setReadyLatch(CountDownLatch readyLatch) {
        Car.readyLatch = readyLatch;
    }

    public static void setRaceEndLatch(CountDownLatch raceEndLatch) {
        Car.raceEndLatch = raceEndLatch;
    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Track track, int speed) {
        this.track = track;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        readyBarrier = new CyclicBarrier(CARS_COUNT);
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            readyLatch.countDown();
            readyBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < track.getStages().size(); i++) {
            track.getStages().get(i).go(this);
        }
        raceEndLatch.countDown();
    }
}
