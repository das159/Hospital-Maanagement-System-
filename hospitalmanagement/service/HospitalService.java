package hospitalmanagement.service;

import hospitalmanagement.model.Patient;
import hospitalmanagement.model.Doctor;
import hospitalmanagement.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addPatient(String id, String name, int age) {
        patients.add(new Patient(id, name, age));
    }

    public void addDoctor(String id, String name, String specialization) {
        doctors.add(new Doctor(id, name, specialization));
    }

    public Patient findPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public Doctor findDoctorById(String id) {
        for (Doctor d : doctors) {
            if (d.getId().equals(id)) return d;
        }
        return null;
    }

    public boolean scheduleAppointment(String patientId, String doctorId, String dateTime) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);
        if (patient != null && doctor != null) {
            appointments.add(new Appointment(patient, doctor, dateTime));
            return true;
        }
        return false;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}
