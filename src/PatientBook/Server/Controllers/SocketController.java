package PatientBook.Server.Controllers;

import PatientBook.Server.Views.View;
import PatientBook.Server.Views.ViewContent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketController implements PBController<SocketRequest> {
    private final View view;
    protected DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public SocketController(View view) {
        this.view = view;
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            this.view.print(new ViewContent("Сервер запущен, ожидаем соединение...."));
            Socket socket = serverSocket.accept();
            this.view.print(new ViewContent("Клиент подключился к серверу!"));
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketRequest get() {
        try {
            String inputText = dataInputStream.readUTF();
            view.print(new ViewContent(inputText, "Получили строку"));
            return new SocketRequest(inputText);
        } catch (IOException ignored) {
            return null;
        }
    }

    public void send(String reply) {
        try {
            dataOutputStream.writeUTF(reply);
            view.print(new ViewContent(reply, "Отправили ответ"));
        } catch (IOException ignored) {
            view.print(new ViewContent(reply, "Не получилось отправить ответ"));
        }
    }
}
