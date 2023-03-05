package PatientBook.Server.Views;

public class ViewContent {
    private String header;
    private final String text;

    public ViewContent(String text) {
        this.text = text;
    }
    public ViewContent(String text, String header) {
        this(text);
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }
}
