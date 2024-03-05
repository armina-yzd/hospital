import java.util.ArrayList;

public class Nurse extends Person{
    private int Salary;
    private String Password;

    ArrayList<Patient> patient = new ArrayList<Patient>();


    public Nurse(int iD, String name, String phoneNumber, int age, Gender gender, String address, String nationalID,
                 int salary, String password) {
        super(iD, name, phoneNumber, age, gender, address, nationalID);
        Salary = salary;
        Password = password;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public ArrayList<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Patient index) {
        patient.add(index);
    }
}
