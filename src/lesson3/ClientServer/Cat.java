package lesson3.ClientServer;

import java.io.Serializable;

public class Cat implements Serializable {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
