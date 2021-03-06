package lesson5;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {


        Track track = new Track(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(20 + (int) (Math.random() * 10));
        }

        Race race = new Race(track, cars);

        try {
            race.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


