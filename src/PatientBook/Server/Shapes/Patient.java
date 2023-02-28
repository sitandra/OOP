package PatientBook.Server.Shapes;

import java.util.Date;
import java.util.Objects;

public class Patient implements Comparable<Patient> {
    private String name;
    private String surname;
    private Date birthdate;

    public Patient(String name, String surname, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    @Override
    public int compareTo(Patient o) {
        String patient_1 = surname + ' ' + name + ' ' + birthdate;
        String patient_2 = o.surname + ' ' + o.name + ' ' + o.birthdate;
        return patient_1.compareTo(patient_2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return name.equals(patient.name) && surname.equals(patient.surname) && Objects.equals(birthdate, patient.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthdate);
    }
}
