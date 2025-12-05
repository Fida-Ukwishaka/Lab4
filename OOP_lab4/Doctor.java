public class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age,  String gender, String email, String phone, String specialization) {
        super(name, age, gender, email, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }

    @Override
    public String getDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return getName() + " (" + specialization + ")";
    }
}

