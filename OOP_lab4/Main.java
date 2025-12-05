import java.util.*;
3

public class Main {
    public static void main(String[] args) {
        Natembea cms = new Natembea();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== CLINIC MENU ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Generate Report");
            System.out.println("5. Save Data");
            System.out.println("6. Load Data");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");

            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Patient ID:");
                    int pid = Integer.parseInt(input.nextLine());
                    System.out.println("Enter Name:");
                    String name = input.nextLine();
                    System.out.println("Enter Age:");
                    int age = Integer.parseInt(input.nextLine());
                    System.out.println("Enter Email:");
                    String email = input.nextLine();
                    System.out.println("Enter Phone:");
                    String phone = input.nextLine();
                    System.out.println("Enter Gender:");
                    String gender = input.nextLine();

                    Patient p = new Patient(pid, name, age, email, phone, gender);
                    cms.addPatient(p);
                }

                case 2 -> {
                    System.out.println("Enter Doctor ID:");
                    String did = input.nextLine();
                    System.out.println("Enter Age:");
                    int age = Integer.parseInt(input.nextLine());
                    System.out.println("Enter Name:");
                    String name = input.nextLine();
                    System.out.println("Enter Email:");
                    String email = input.nextLine();
                    System.out.println("Enter Phone:");
                    String phone = input.nextLine();
                    System.out.println("Enter Gender:");
                    String gender = input.nextLine();
                    System.out.println("Enter Specialization:");
                    String spec = input.nextLine();

                    Doctor d = new Doctor(did, age, name, email, phone, gender);
                    cms.addDoctor(d);
                }

                case 3 -> {
                    System.out.println("Enter Patient ID:");
                    int pid = Integer.parseInt(input.nextLine());
                    Patient p = cms.getPatientById(pid);

                    if (p == null) {
                        System.out.println("Patient not found.");
                        break;
                    }

                    System.out.println("Enter Date (YYYY-MM-DD):");
                    java.time.LocalDate date = java.time.LocalDate.parse(input.nextLine());
                    System.out.println("Enter Time (HH:MM):");
                    java.time.LocalTime time = java.time.LocalTime.parse(input.nextLine());
                    System.out.println("Enter Purpose:");
                    String purpose = input.nextLine();

                    // Assign doctor randomly for simplicity
                    Doctor d = cms.getDoctors().get(0);

                    Appointment appt = new Appointment(p, date, time, d, purpose);
                    cms.scheduleAppointment(appt);
                }

                case 4 -> cms.generateReport();

                case 5 -> cms.saveToFile("patients.txt");

                case 6 -> cms.loadFromFile("patients.txt");

                case 0 -> {
                    System.out.println("Have A Nice Day!");
                    return;
                }
            }
        }
    }
}
