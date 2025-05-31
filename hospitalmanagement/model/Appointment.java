package hospitalmanagement.model;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String dateTime;  // Simplified as String for this example

    public Appointment(Patient patient, Doctor doctor, String dateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Appointment[Patient=" + patient.getName() + ", Doctor=" + doctor.getName() + ", DateTime=" + dateTime + "]";
    }
}
