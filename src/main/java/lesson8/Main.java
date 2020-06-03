package lesson8;

public class Main {
    private static int SIZE = 6;

    public static void main(String[] args) {
        int[][] arr = new int[SIZE][SIZE];
        fillSpiral(arr);
        print(arr);
    }

    private static void fillSpiral(int[][] arr) {
        int value = 1;
        int iter = 0;

        while (value <= SIZE * SIZE) {
            for (int i = iter; i < SIZE - iter; i++) {
                arr[iter][i] = value++;
            }
            for (int i = iter + 1; i < SIZE - iter; i++) {
                arr[i][SIZE - iter - 1] = value++;
            }
            for (int i = SIZE - iter - 2; i >= iter; i--) {
                arr[SIZE - iter - 1][i] = value++;
            }
            for (int i = SIZE - iter - 2; i > iter; i--) {
                arr[i][iter] = value++;
            }
            iter++;
        }


    }

    private static void print(int[][] arr) {
        for (int[] rows : arr) {
            for (int val : rows) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
