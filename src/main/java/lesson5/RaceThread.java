package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceThread implements Runnable {

    private Track track;
    private Car car;

    private CountDownLatch raceEndLatch;
    private CountDownLatch raceReadyLatch;
    private CyclicBarrier readyBarrier;

    private AtomicInteger place;


    public RaceThread(Track track, Car car, AtomicInteger place, CountDownLatch raceEndLatch, CountDownLatch raceReadyLatch, CyclicBarrier readyBarrier) {
        this.track = track;
        this.car = car;
        this.raceEndLatch = raceEndLatch;
        this.raceReadyLatch = raceReadyLatch;
        this.readyBarrier = readyBarrier;
        this.place = place;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.car.getName() + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.car.getName() + " готов");
            raceReadyLatch.countDown();
            readyBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < track.getStages().size(); i++) {
            track.getStages().get(i).go(this.car);
        }
        if (place.incrementAndGet() == 1) {
            System.out.println(this.car.getName() + " - WIN!");
        }
        raceEndLatch.countDown();
    }
}
