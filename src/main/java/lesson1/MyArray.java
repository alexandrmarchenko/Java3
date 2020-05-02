package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray<T> {
    private final T[] data;

    public MyArray(T[] data) {
        this.data = data;
    }

    public T[] getData() {
        return data;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        if (data.length != 0) {
            arrayList.addAll(Arrays.asList(data));
        }
        return arrayList;
    }

    public void swapElements(int pos1, int pos2) {
        int length = data.length;
        if (pos1 >= 0 && pos2 >= 0 && pos1 < length && pos2 < length) {
            T el = data[pos1];
            data[pos1] = data[pos2];
            data[pos2] = el;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
