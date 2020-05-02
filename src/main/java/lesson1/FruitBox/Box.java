package lesson1.FruitBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public Box() {
        fruits = new ArrayList<>();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public int getFruitsCount() {
        return fruits.size();
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public float getWeight() {
        return fruits.stream().map(Fruit::getWeight).reduce(0.0f, Float::sum);
    }

    public void transferToAnotherBox(Box<T> box) {
        box.getFruits().addAll(this.getFruits());
        this.getFruits().clear();
    }
}
