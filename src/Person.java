public class Person{

    private int ID;
    private String Name;
    private String PhoneNumber;
    private int Age;
    private Gender gender;
    private String Address;
    private String NationalID;



    public Person(int iD, String name, String phoneNumber, int age, Gender gender, String address, String nationalID) {
        ID = iD;
        Name = name;
        PhoneNumber = phoneNumber;
        Age = age;
        this.gender = gender;
        Address = address;
        NationalID = nationalID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNationalID() {
        return NationalID;
    }

    public void setNationalID(String nationalID) {
        NationalID = nationalID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

}