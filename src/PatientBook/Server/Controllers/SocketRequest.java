package PatientBook.Server.Controllers;

import PatientBook.Server.Models.PatientBookCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocketRequest implements PBRequest {
    private final PatientBookCommand command;
    private final String content;

    SocketRequest(String inputText) {
        PatientBookCommand command;
        List<String> requestParts = new ArrayList<>(Arrays.asList(inputText.split(" ")));
        try {
            command = PatientBookCommand.valueOf(requestParts.get(0).toUpperCase());
            requestParts.remove(0);
        } catch (Exception e) {
            command = PatientBookCommand.UNKNOWN;
        }
        this.command = command;
        content = String.join(" ", requestParts);
    }

    @Override
    public PatientBookCommand getCommand() {
        return command;
    }

    @Override
    public String getContent() {
        return content;
    }
}
