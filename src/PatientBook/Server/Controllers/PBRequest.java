package PatientBook.Server.Controllers;

import PatientBook.Server.Models.PatientBookCommand;

public interface PBRequest {
    PatientBookCommand getCommand();
    String getContent();
}
