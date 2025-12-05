import java.util.Date;

public class MedicalRecord {
    private Date date;
    private String diagnosis;
    private String prescription;

    public MedicalRecord(Date date, String diagnosis, String prescription) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public Date getDate() { 
        return date; 
    }
    public String getDiagnosis() {
         return diagnosis; 
        }
    public String getPrescription() { 
        return prescription; 
    }

    @Override
    public String toString() {
        return date + " | Diagnosis: " + diagnosis + " | Prescription: " + prescription;
    }
}

