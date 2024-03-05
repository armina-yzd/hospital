import java.util.ArrayList;

public class Patient extends Person{
    ArrayList<Treatment> treatment = new ArrayList<Treatment>();
    private String Password;
    private BloodType bloodType;
    private boolean Insurance;
    private MaritalStatus maritalStatus;
    private String BodyCondition;
    private String SpMedicine;
    private PregnancyStatus pregnancyStatus;




    public Patient(int iD, String name, String phoneNumber, int age, Gender gender, String address, String nationalID,
                   String password, BloodType bloodType, boolean insurance, MaritalStatus maritalStatus,
                   String bodyCondition, String spMedicine, PregnancyStatus pregnancyStatus) {
        super(iD, name, phoneNumber, age, gender, address, nationalID);
        Password = password;
        this.bloodType = bloodType;
        Insurance = insurance;
        this.maritalStatus = maritalStatus;
        BodyCondition = bodyCondition;
        SpMedicine = spMedicine;
        this.pregnancyStatus = pregnancyStatus;
    }

    public void setTreatment(Treatment index) {
        treatment.add(index);
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public boolean isInsurance() {
        return Insurance;
    }

    public void setInsurance(boolean insurance) {
        Insurance = insurance;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBodyCondition() {
        return BodyCondition;
    }

    public void setBodyCondition(String bodyCondition) {
        BodyCondition = bodyCondition;
    }

    public String getSpMedicine() {
        return SpMedicine;
    }

    public void setSpMedicine(String spMedicine) {
        SpMedicine = spMedicine;
    }

    public PregnancyStatus getPregnancyStatus() {
        return pregnancyStatus;
    }

    public void setPregnancyStatus(PregnancyStatus pregnancyStatus) {
        this.pregnancyStatus = pregnancyStatus;
    }

}
