public class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization){
        super(name, age);
        this.specialization = specialization;
    }

    public String getSpecialization(){
        return specialization;
    }

    @Override
    public String getDetails() {
        return "Dr. " + getName() + " - " + specialization;
    }
}
