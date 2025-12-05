import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Natembea system = new Natembea();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== NANTEMBEA HEALTH CLINIC =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View All Patients");
            System.out.println("4. View Appointment Schedule");
            System.out.println("5. Save Data");
            System.out.println("6. Load Data");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    system.addPatient(id, name);
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    int pid = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    System.out.print("Enter time (HH:MM): ");
                    String time = sc.nextLine();

                    System.out.print("Enter doctor name: ");
                    String doctor = sc.nextLine();

                    System.out.print("Enter purpose: ");
                    String purpose = sc.nextLine();

                    system.addAppointment(pid, date, time, doctor, purpose);
                    break;

                case 3:
                    system.printPatients();
                    break;

                case 4:
                    system.printSchedule();
                    break;

                case 5:
                    system.saveAll();
                    break;

                case 6:
                    system.loadAll();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
