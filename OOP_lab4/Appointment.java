import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment  {
    private Patient patient;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private String purpose;

    public Appointment (Patient patient, LocalDate date, LocalTime time, Doctor doctor, String purpose){
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.purpose = purpose;
    }

    public Appointment(){
        // for loading from file
    }

    public Patient getPatient(){
        return patient;
    }
    public LocalDate getDate(){
        return date;
    }
    public LocalTime getTime(){
        return time;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public String getPurpose(){
        return purpose;
    }


     @Override
    public String toString() {
        return date + " | " + purpose + " | Doctor: " +
                doctor.getName() + " | Patient: " +
                patient.getName();
    }
}
