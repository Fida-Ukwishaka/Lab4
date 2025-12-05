import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Patient extends Person {
    private int id;
    private ArrayList<String> MedicalHistory; 
    private TreeMap<Date, Appointment> Appointments;

    public Patient(int id, String name, int age){
        super(name, age);
        this.id = id;
        this.MedicalHistory = new ArrayList<>();
        this.Appointments = new TreeMap<>();
    }

     public int getID(){
        return id;
    }
    public ArrayList<String> getMedicalHistory(){
        return MedicalHistory;
    }
    public TreeMap<Date, Appointment> getAppointments() {
        return Appointments;
    }

    public void addMedicalRecord(String record) {
        MedicalHistory.add(record);
    }
     public void addAppointment(Date date, Appointment appt) {
        Appointments.put(date, appt);
    }

    @Override
    public String getDetails() {
        return "Patient: " + getName() + " (ID: " + id + ")";
    }
}
/*  

   

    public Patient(){
        // for looping from file
    }


    


    @Override
    public void deserialize(String data){
        String[] parts = data.split("\\|");
        this.id = Integer.parseInt(parts[0]);
        this.name = parts[1];

        if (parts.length > 2 && !parts[2].isEmpty()){
            history = new ArrayList<>(Arrays.asList(parts[2].split(";")));
        }      
    }

    @Override
    public String toString(){
        return id + " - " + name + " (History entries: " + history.size() + ")";
    }
    
}
*/
