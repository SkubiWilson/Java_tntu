import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 12345;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Підключено до сервера.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Введіть повідомлення (exit для виходу): ");
                String message = scanner.nextLine();
                output.writeUTF(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String response = input.readUTF();
                System.out.println("Відповідь сервера: " + response);
            }

            System.out.println("З'єднання завершено.");
        } catch (IOException e) {
            System.out.println("Помилка клієнта: " + e.getMessage());
        }
    }
}
