package lesson1;

import lesson1.FruitBox.Apple;
import lesson1.FruitBox.Box;
import lesson1.FruitBox.Orange;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Integer[] nums = {1, 2, 3, 4, 5, 6};
        String[] strings = {"1", "2", "3", "4", "5"};

        MyArray<Integer> array = new MyArray<>(nums);
        MyArray<String> array1 = new MyArray<>(strings);

        array.swapElements(1, 3);
        System.out.println(array.toString());

        array1.swapElements(1, 6);
        System.out.println(array1.toString());

        List<Integer> list = array.toArrayList();
        System.out.println(list);

//        Box<Apple> appleBox = new Box<>();
//        Box<Orange> orangeBox = new Box<>();
//        Box<Apple> newAppleBox = new Box<>();
//
//        appleBox.addFruit(new Apple());
//        appleBox.addFruit(new Apple());
//        appleBox.addFruit(new Apple());
//        appleBox.addFruit(new Apple());
//
//        orangeBox.addFruit(new Orange());
//        orangeBox.addFruit(new Orange());
//        orangeBox.addFruit(new Orange());
//
//        System.out.println("Apple box weight: " + appleBox.getWeight());
//        System.out.println("Orange box weight: " + orangeBox.getWeight());
//        System.out.println(orangeBox.compare(appleBox));
//
//        System.out.println("Transfer apples to the new box");
//        appleBox.transferToAnotherBox(newAppleBox);
//        System.out.println("Old apple box weight: " + appleBox.getWeight());
//        System.out.println("New apple box weight: " + newAppleBox.getWeight());
    }



    public static void swapElements(Object[] array, int pos1, int pos2) {
        int length = array.length;
        if (pos1 >= 0 && pos2 >= 0 && pos1 < length && pos2 < length) {
            Object el = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = el;
        }
    }


}
