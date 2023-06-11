package ExceptionHandling.homework3;

public class LineParseException extends Exception {

    private static final String comment = "Ошибка при разборе данных: ";

    public LineParseException(String message) {
        super(comment + message);
    }

    public LineParseException(String message, Throwable cause) {
        super(comment + message, cause);
    }
}
