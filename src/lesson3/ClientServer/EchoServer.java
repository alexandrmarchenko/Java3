package lesson3.ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    static final int SERVER_PORT = 8189;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = null;
        System.out.println("Start echo-server");
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {

            System.out.println("Server is waiting for connections...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());


            Cat cat = (Cat) inputStream.readObject();
            cat.info();

        } catch (IOException e) {
            System.out.println("Port " + SERVER_PORT + " is already used!");
            e.printStackTrace();
        }
        finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }

    static private void writeMessages(DataOutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            outputStream.writeUTF(message);
            if (message.equals("/end")) {
                break;
            }
        }
    }
}
