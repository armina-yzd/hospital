import java.util.ArrayList;

public class Doctor extends Person{
    private String Password;
    private Speciality speciality;
    private int Salary;


    ArrayList<Patient> patient = new ArrayList<Patient>();

    public Doctor(int iD, String name, String phoneNumber, int age, Gender gender, String address, String nationalID,
                  String password, Speciality speciality, int salary) {
        super(iD, name, phoneNumber, age, gender, address, nationalID);
        Password = password;
        this.speciality = speciality;
        Salary = salary;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public ArrayList<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Patient index) {
        patient.add(index);
    }




}
