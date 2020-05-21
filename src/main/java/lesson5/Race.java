package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {

    private Track track;
    private Car[] cars;
    private RaceThread[] raceThreads;
    private CountDownLatch raceEndLatch;
    private CountDownLatch raceReadyLatch;
    private CyclicBarrier readBarrier;

    public Race(Track track, Car[] cars) {
        this.track = track;
        this.cars = cars;
        this.raceEndLatch = new CountDownLatch(cars.length);
        this.raceReadyLatch = new CountDownLatch(cars.length);
        this.readBarrier = new CyclicBarrier(cars.length);
        raceThreads = new RaceThread[cars.length];
        for (int i = 0; i < cars.length; i++) {
            raceThreads[i] = new RaceThread(track,
                    cars[i],
                    this.raceEndLatch,
                    this.raceReadyLatch,
                    this.readBarrier
            );
        }
    }

    public void start() throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        for (int i = 0; i < raceThreads.length; i++) {
            new Thread(raceThreads[i]).start();
        }
        raceReadyLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        raceEndLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
