import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Natembea {

    private HashMap<Integer, Patient> patients = new HashMap<>();
    private TreeMap<LocalDate, ArrayList<Appointment>> schedule = new TreeMap<>();

    private DataManager<Patient> PatientManager = new DataManager<>();
    private DataManager<Appointment> AppointmentManager = new DataManager<>();

    // Patient

    public void addPatient(int id, String name) {
        if (patients.containsKey(id)) {
            System.out.println("Patient ID already exists.");
            return;
        }
        patients.put(id, new Patient(id, name));
        System.out.println("Patient added successfully.");
    }

    public Patient getPatient(int id) {
        return patients.get(id);
    }

    // Appointment

    public void addAppointment(int patientId, LocalDate date, String timeStr, String doctor, String purpose) {

        if (!patients.containsKey(patientId)) {
            System.out.println("Patient not found.");
            return;
        }

        Appointment appt = new Appointment(
            patientId,
            date,
            java.time.LocalTime.parse(timeStr),
            doctor,
            purpose
        );

        schedule.putIfAbsent(date, new ArrayList<>());
        schedule.get(date).add(appt);

        System.out.println("Appointment scheduled.");
    }

    //file I/O 

    public void loadAll() {
        // Load patients
        ArrayList<Patient> plist = PatientManager.load("patients.txt", new Patient());
        for (Patient p : plist) {
            patients.put(p.getID(), p);
        }

        // Load appointments
        ArrayList<Appointment> alist = AppointmentManager.load("appointments.txt", new Appointment());
        for (Appointment a : alist) {
            schedule.putIfAbsent(a.getDate(), new ArrayList<>());
            schedule.get(a.getDate()).add(a);
        }

        System.out.println("Data loaded.");
    }

    public void saveAll() {
        // Save patients
        ArrayList<Patient> plist = new ArrayList<>(patients.values());
        PatientManager.save("patients.txt", plist);

        // Save appointments
        ArrayList<Appointment> allAppointments = new ArrayList<>();
        for (var entry : schedule.values()) {
            allAppointments.addAll(entry);
        }
        AppointmentManager.save("appointments.txt", allAppointments);

        System.out.println("Data saved.");
    }

    // Reports 

    public void printPatients() {
        System.out.println("\n--- Patient List ---");
        for (Patient p : patients.values()) {
            System.out.println(p);
        }
    }

    public void printSchedule() {
        System.out.println("\n--- Appointment Schedule ---");
        for (var entry : schedule.entrySet()) {
            System.out.println("\nDate: " + entry.getKey());
            for (Appointment a : entry.getValue()) {
                System.out.println("  " + a);
            }
        }
    }
}

    

