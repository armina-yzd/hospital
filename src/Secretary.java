public class Secretary extends Person{
    private String Password;
    private int Salary;

    public Secretary(int iD, String name, String phoneNumber, int age, Gender gender, String address, String nationalID,
                     String password, int salary) {
        super(iD, name, phoneNumber, age, gender, address, nationalID);
        Password = password;
        Salary = salary;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }


}
