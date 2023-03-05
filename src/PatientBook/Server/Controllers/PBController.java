package PatientBook.Server.Controllers;

import PatientBook.Server.Models.PatientBookCommand;

public interface PBController<T1 extends PBRequest> {
    T1 get();
    void send(String reply);


    default void run() {
        endlessLoop:
        while (true) {
            PBRequest request = this.get();
            String result;
            switch (request.getCommand()) {
                /** @// TODO: 28.02.2023 Осталось реализовать функционал каждой команды */
                case SHOW -> result = PatientBookCommand.SHOW.toString();
                case ADD -> result = PatientBookCommand.ADD.toString();
                case REMOVE -> result = PatientBookCommand.REMOVE.toString();
                case SAVE -> result = PatientBookCommand.SAVE.toString();
                case HELP -> result = PatientBookCommand.help();
                case UNKNOWN -> result = "Неизвестная команда! \n" + request.getContent();
                case EXIT -> {
                    break endlessLoop;
                }
                default -> result = "Команда не реализована";
            }
            this.send(result);
        }
    }
}
