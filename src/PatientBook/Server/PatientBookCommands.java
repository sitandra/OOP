package PatientBook.Server;

public enum PatientBookCommands {
    SHOW ("show", "Показать книгу"),
    ADD ("add","Добавить пациента"),
    REMOVE ("remove", "Удалить пациента"),
    SORT ("sort", "Сортировать книгу"),
    SAVE ("save", "Сохранить книгу"),
    HELP("help", "Показать команды"),
    EXIT ("exit", "Выйти из программы");

    private final String code;
    private final String title;

    PatientBookCommands(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String toString() {
        return code + " – \"" + title + '"';
    }

    public static String help() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (PatientBookCommands command : PatientBookCommands.values()) {
            sb.append("\t *\t").append(command.toString()).append("\n");
        }
        return sb.toString();
    }
}
