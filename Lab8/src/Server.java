import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущено. Очікування клієнта...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клієнт підключився: " + clientSocket.getInetAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                String message = input.readUTF();
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Клієнт завершив з'єднання.");
                    break;
                }

                System.out.println("Повідомлення від клієнта: " + message);
                String response = "Сервер отримав: " + message;
                output.writeUTF(response);
            }

            clientSocket.close();
            System.out.println("Сервер завершив роботу.");
        } catch (IOException e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }
}
