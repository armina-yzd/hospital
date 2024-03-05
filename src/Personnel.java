public class Personnel extends Person{
    private Work work;
    private int Salary;


    public Personnel(int iD, String name, String phoneNumber, int age, Gender gender, String address, String nationalID,
                     Work work, int salary) {
        super(iD, name, phoneNumber, age, gender, address, nationalID);
        this.work = work;
        Salary = salary;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }


}
