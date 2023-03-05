package PatientBook.Server;

import PatientBook.Server.Views.ConsoleView;
import PatientBook.Server.Controllers.PBController;
import PatientBook.Server.Controllers.SocketController;
import PatientBook.Server.Controllers.SocketRequest;

public class Main {
    public static void main(String[] args) {
        PBController<SocketRequest> PBC = new SocketController(new ConsoleView());
        PBC.run();
    }
}
