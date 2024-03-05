public class Treatment {
    private int ID;
    private int NurseID;
    private int DoctorID;
    private int PatientID;
    private String Illness;
    private String Description;
    private String Medicine;
    private String Visitdate;
    private boolean TreatmentState;

    public Treatment(int iD, int nurseID, int doctorID, int patientID, String illness,String visitDate) {

        TreatmentState=true;
        //"yyyyMMddHH"
        Visitdate = visitDate;
        ID = iD;
        NurseID = nurseID;
        DoctorID = doctorID;
        PatientID = patientID;
        Illness = illness;
    }



    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getNurseID() {
        return NurseID;
    }

    public void setNurseID(int nurseID) {
        NurseID = nurseID;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getIllness() {
        return Illness;
    }

    public void setIllness(String illness) {
        Illness = illness;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMedicine() {
        return Medicine;
    }

    public void setMedicine(String medicine) {
        Medicine = medicine;
    }

    public String getVisitDate() {
        return Visitdate;
    }

    public void setVisitDate(String visitDate) {
        Visitdate = visitDate;
    }



    public String getVisitdate() {
        return Visitdate;
    }



    public void setVisitdate(String visitdate) {
        Visitdate = visitdate;
    }



    public String isTreatmentState() {
        if(TreatmentState){
            return "still in progress";
        }
        return "finished";


    }



    public void setTreatmentState(boolean treatmentState) {
        TreatmentState = treatmentState;
    }

}
