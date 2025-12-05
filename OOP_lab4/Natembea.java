import java.io.*;
import java.util.*;


public class Natembea implements FileOperations, ReportGenerator {

    private HashMap<Integer, Patient> patients;
    private ArrayList<Doctor> doctors;
    private TreeMap<String, ArrayList<Appointment>> appointmentsByDate;

    public Natembea() {
        patients = new HashMap<>();
        doctors = new ArrayList<>();
        appointmentsByDate = new TreeMap<>();
    }

    // Add patient
    public void addPatient(Patient p) {
        patients.put(p.getPatientId(), p);
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients.values()) {
            if (patient.getPatientId() == id) {
                return patient;
            }
        }
        return null;
    }

    // Add doctor
    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    // Schedule appointment
    public void scheduleAppointment(Appointment appt) {
        String dateKey = appt.getDate().toString();
        appointmentsByDate.putIfAbsent(dateKey, new ArrayList<>());
        appointmentsByDate.get(dateKey).add(appt);

        appt.getPatient().addAppointment(appt);
    }

   

    // ---------------- FILE OPERATIONS ----------------

    @Override
    public void saveToFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (Patient p : patients.values()) {
                fw.write(p.getPatientId() + "," + p.getName() + ","  + p.getAge() +  "," +
                         p.getEmail() + p.getGender() + "," + p.getPhone() + "," +"\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String gender = parts[3];
                String email = parts[4];
                String phone = parts[5];

                Patient p = new Patient(id, name, age, email, gender, phone);

                addPatient(p);
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // ---------------- REPORT GENERATOR ----------------

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n===== Clinic Report =====\n");
        report.append("Total Patients: ").append(patients.size()).append("\n");
        report.append("Total Doctors: ").append(doctors.size()).append("\n");
        report.append("Scheduled Appointment Days: ").append(appointmentsByDate.size()).append("\n");
        return report.toString();
    }
}
