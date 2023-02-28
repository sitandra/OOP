package PatientBook.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 1234)) {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Подключение к серверу успешно.");
            dataOutputStream.writeUTF("help");
            System.out.println(dataInputStream.readUTF());
            while (true) {
                // System.out.println("- ");
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);
                if (request.equals("exit")) break;
                System.out.println("Reply: \n\t" + dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
