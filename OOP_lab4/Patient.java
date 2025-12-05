import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;



public class Patient extends Person implements FileOperations {
    private int patientId;
    private ArrayList<MedicalRecord> medicalHistory;
    private TreeMap<LocalDate, Appointment> appointments;

    public Patient(int patientId, String name, int age, String email, String gender,String phone) {
        super(name, age, email, gender, phone);
        this.patientId = patientId;
        this.medicalHistory = new ArrayList<>();
        this.appointments = new TreeMap<>();
    }

    public int getPatientId() {
         return patientId; 
    }
    public ArrayList<MedicalRecord> getMedicalHistory() { 
        return medicalHistory; 
    }
    public TreeMap<LocalDate, Appointment> getAppointments() { 
        return appointments; 
    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalHistory.add(record);
    }

    public void addAppointment(Appointment appt) {
        appointments.put(appt.getDate(), appt);
    }

    @Override
    public void saveToFile(String filename) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(patientId + "," + getName() + "," + getEmail() + "," + getPhone() + "\n");
        } catch (Exception e) {
            System.out.println("Error saving patient: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                // For reading purposes only
            }
        } catch (Exception e) {
            System.out.println("Error loading patient: " + e.getMessage());
        }
    }

    @Override
        public String getDetails() {
            return "Patient ID: " + patientId +
                   ", Name: " + getName() +
                   ", Age: " + getAge() +
                   ", Email: " + getEmail() +
                   ", Gender: " + getGender() +
                   ", Phone: " + getPhone();
        }
}
