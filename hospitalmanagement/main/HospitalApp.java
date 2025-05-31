package hospitalmanagement.main;

import hospitalmanagement.service.HospitalService;
import hospitalmanagement.model.Patient;
import hospitalmanagement.model.Doctor;
import hospitalmanagement.model.Appointment;

import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalService service = new HospitalService();

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Patient ID: ");
                    String pId = scanner.nextLine();
                    System.out.print("Patient Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Patient Age: ");
                    int pAge = scanner.nextInt();
                    scanner.nextLine();
                    service.addPatient(pId, pName, pAge);
                    System.out.println("Patient added.");
                    break;

                case 2:
                    System.out.print("Doctor ID: ");
                    String dId = scanner.nextLine();
                    System.out.print("Doctor Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Specialization: ");
                    String spec = scanner.nextLine();
                    service.addDoctor(dId, dName, spec);
                    System.out.println("Doctor added.");
                    break;

                case 3:
                    System.out.print("Patient ID: ");
                    String apPatientId = scanner.nextLine();
                    System.out.print("Doctor ID: ");
                    String apDoctorId = scanner.nextLine();
                    System.out.print("Date & Time (e.g. 2025-06-01 10:00): ");
                    String dt = scanner.nextLine();
                    if (service.scheduleAppointment(apPatientId, apDoctorId, dt)) {
                        System.out.println("Appointment scheduled.");
                    } else {
                        System.out.println("Invalid patient or doctor ID.");
                    }
                    break;

                case 4:
                    for (Patient patient : service.getAllPatients()) {
                        System.out.println(patient);
                    }
                    break;

                case 5:
                    for (Doctor doctor : service.getAllDoctors()) {
                        System.out.println(doctor);
                    }
                    break;

                case 6:
                    for (Appointment appointment : service.getAllAppointments()) {
                        System.out.println(appointment);
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
