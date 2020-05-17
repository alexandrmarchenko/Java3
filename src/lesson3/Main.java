package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int PAGE_SIZE = 1800;

    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("123/file1.txt");
//        byte[] arr = fis.readAllBytes();
//        for (byte b : arr) {
//            System.out.print(b);
//        }
//        fis.close();


//        ArrayList<InputStream> al = new ArrayList<>();
//        al.add(new FileInputStream("123/file1.txt"));
//        al.add(new FileInputStream("123/file2.txt"));
//        al.add(new FileInputStream("123/file3.txt"));
//        al.add(new FileInputStream("123/file4.txt"));
//        al.add(new FileInputStream("123/file5.txt"));
//        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
//        FileOutputStream fos = new FileOutputStream("123/file6.txt");
//        int x;
//        while((x = in.read()) != -1) {
//            fos.write(x);
//        }
//        in.close();
//        fos.close();

        RandomAccessFile raf = new RandomAccessFile("123/book.txt", "r");
        int page = 1;
        raf.seek((page - 1) * PAGE_SIZE);
        int x;
        for (int i = 0; i < PAGE_SIZE; i++) {
            if ((x = raf.read()) != -1) {
                System.out.print((char) x);
            }
        }
        raf.close();

    }
}
