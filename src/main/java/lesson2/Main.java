package lesson2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
