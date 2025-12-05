import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Recordable {
    private int patientID;
    private LocalDate date;
    private LocalTime time;
    private String doctor;
    private String purpose;

    public Appointment (int patientID, LocalDate date, LocalTime time, String doctor, String purpose){
        this.patientID = patientID;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.purpose = purpose;
    }

    public Appointment(){
        // for loading from file
    }

    public int getPatientID(){
        return patientID;
    }
    public LocalDate getDate(){
        return date;
    }
    public LocalTime getTime(){
        return time;
    }
    public String getDoctor(){
        return doctor;
    }
    public String getPurpose(){
        return purpose;
    }

    @Override
    public String serialize(){
        return patientID + "|" + date + "|" + time + "|" + doctor + "|" + purpose;
    }

    @Override
    public void deserialize(String data){
        String[] parts = data.split("\\|");
        this.patientID = Integer.parseInt(parts[0]);
        this.date = LocalDate.parse(parts[1]);
        this.time = LocalTime.parse(parts[2]);
        this.doctor = parts[3];
        this.purpose = parts[4];
    }

    @Override
    public String toString() {
        return date + " " + time + " – " + purpose + " with " + doctor 
               + " (Patient ID: " + patientID + ")";
    }
}
