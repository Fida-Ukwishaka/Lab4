public abstract class Person {
    private String name;
    private int age;
    private String email;
    private String gender;
    private String phone;


    public Person(String name, int age, String email, String gender,String phone){
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }
    public Person(){}

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getPhone(){
        return phone;
    }


     public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public abstract String getDetails();
}
