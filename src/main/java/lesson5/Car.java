package lesson5;

public class Car {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(int speed) {
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
}
