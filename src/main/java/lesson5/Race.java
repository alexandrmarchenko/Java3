package lesson5;

import java.util.concurrent.CountDownLatch;

public class Race {

    private Car[] cars;
    CountDownLatch raceEndLatch;
    CountDownLatch raceReadyLatch;

    public Race(Car[] cars) {
        this.cars = cars;
        new CountDownLatch(cars.length);
        new CountDownLatch(cars.length);
        raceEndLatch = new CountDownLatch(cars.length);
        raceReadyLatch = new CountDownLatch(cars.length);
    }

    public void start() throws InterruptedException {
        Car.setReadyLatch(raceReadyLatch);
        Car.setRaceEndLatch(raceEndLatch);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        for (Car car : cars) {
            new Thread(car).start();
        }
        raceReadyLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        raceEndLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
