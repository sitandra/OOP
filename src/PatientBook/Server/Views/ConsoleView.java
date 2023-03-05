package PatientBook.Server.Views;

public class ConsoleView implements View {
    @Override
    public void print(ViewContent viewContent) {
        if (viewContent.getHeader() == null)
            System.out.println(viewContent.getText());
        else System.out.println(viewContent.getHeader() + ": " + viewContent.getText());
    }
}
