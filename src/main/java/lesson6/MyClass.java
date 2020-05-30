package lesson6;


import java.util.Arrays;

public class MyClass {
    private int SEARCH_NUM = 4;
    public int[] arrayAfter4(int[] arr) {
        int lastIndex = lastIndex(arr, SEARCH_NUM);
        if (lastIndex == -1) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(arr, lastIndex + 1, arr.length);
//        return Arrays.stream(arr).skip(lastIndex + 1).toArray();
    }

    private int lastIndex(int[] array, int o) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean contain(int[] arr) {
        boolean contain1 = false;
        boolean contain4 = false;
        for (int i : arr) {
            if (i == 1) {
                contain1 = true;
            }
            if(i == 4) {
                contain4 = true;
            }
        }
        return contain1 && contain4;
    }
}
