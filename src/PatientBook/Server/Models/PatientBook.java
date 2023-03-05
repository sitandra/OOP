package PatientBook.Server.Models;

import java.util.ArrayList;
import java.util.List;

public class PatientBook {
    private final List<Patient> patients;

    public PatientBook() {
        this.patients = new ArrayList<>();
    }

    public PatientBook add(Patient patient) {
        if (!patients.contains(patient))
            patients.add(patient);
        return this;
    }
}
