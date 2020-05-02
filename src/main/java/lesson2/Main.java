package lesson2;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            connect();
            connection.setAutoCommit(false);

            int res = stmt.executeUpdate("Create table users (\n" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "login text(20)," +
                    "password text(20)," +
                    "nickname text(15))");

//            int res = stmt.executeUpdate("delete from users");
//
//            pstmt = connection.prepareStatement("insert into users(login,password,nickname) values(?,?,?)");
//            for (int i = 0; i < 5; i++) {
//                pstmt.setString(1, "login" + (i + 1));
//                pstmt.setString(2, "pass" + (i + 1));
//                pstmt.setString(3, "nickname" + (i + 1));
//                pstmt.addBatch();
//            }
//            pstmt.executeBatch();

//            pstmt = connection.prepareStatement("update users set nickname=? where id=?");
//            pstmt.setString(1,"nickname7");
//            pstmt.setInt(2,3);
//            pstmt.executeUpdate();

//            stmt.executeQuery("Delete from users where login='login1'");

            disconnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
