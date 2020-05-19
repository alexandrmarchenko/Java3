package lesson3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class BookReader {
    static final int PAGE_SIZE = 1800;
    public static void main(String[] args) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile("123/book.txt", "r");) {
            int page;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                Long t = System.currentTimeMillis();
                System.out.println("Page:");
                page = scanner.nextInt();
                raf.seek((page - 1) * PAGE_SIZE);
                int x;
                for (int i = 0; i < PAGE_SIZE; i++) {
                    if ((x = raf.read()) != -1) {
                        System.out.print((char) x);
                    }
                }
                System.out.println("\n" + (System.currentTimeMillis() - t));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
