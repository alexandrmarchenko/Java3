package lesson3.ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static final String SERVER_ADDR = "localhost";

    public static void main(String[] args) {
        initServerConnection();
    }

    private static void initServerConnection() {
        try (Socket socket = new Socket(SERVER_ADDR, EchoServer.SERVER_PORT)) {
            System.out.println("Client started");

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            Cat cat = new Cat("Барсик");
            sendObject(outputStream, cat);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private void sendObject(ObjectOutputStream outputStream, Cat cat) throws IOException {
        outputStream.writeObject(cat);
    }


}
