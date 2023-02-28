package PatientBook.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем соединение....");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            endlessLoop: while (true) {
                String clientRequest = dataInputStream.readUTF();
                System.out.println("Мы получили строку: " + clientRequest);
                String[] requestParts = clientRequest.split(" ");
                try {
                    PatientBookCommands command = PatientBookCommands.valueOf(requestParts[0].toUpperCase());
                    switch (command) {
                        /** @// TODO: 28.02.2023 Осталось реализовать функционал каждой команды */
                        case SHOW -> dataOutputStream.writeUTF(PatientBookCommands.SHOW.toString());
                        case ADD -> dataOutputStream.writeUTF(PatientBookCommands.ADD.toString());
                        case REMOVE -> dataOutputStream.writeUTF(PatientBookCommands.REMOVE.toString());
                        case SAVE -> dataOutputStream.writeUTF(PatientBookCommands.SAVE.toString());
                        case HELP -> dataOutputStream.writeUTF(PatientBookCommands.help());
                        case EXIT -> {
                            break endlessLoop;
                        }
                        default -> dataOutputStream.writeUTF("Команда " + clientRequest + " не реализована");
                    }
                } catch (Exception ignored) {
                    dataOutputStream.writeUTF("Неизвестная команда: " + clientRequest + "\n"
                            + "Доступные команды: " + Arrays.toString(PatientBookCommands.values()) + ".");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
