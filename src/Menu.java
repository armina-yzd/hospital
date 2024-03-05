import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Menu {

    static ArrayList<Admin> admins = Database.GetAdmin();
    static ArrayList<Doctor> doctors = Database.GetDoctor();
    static ArrayList<Patient> patients = Database.GetPatient();
    static ArrayList<Personnel> personnels = Database.GetPersonnel();
    static ArrayList<Secretary> secretaries = Database.GetSecretary();
    static ArrayList<Treatment> treatments = Database.GetTreatment();
    static ArrayList<Nurse> nurses = Database.GetNurse();

    static Scanner n=new Scanner(System.in);
    static String Illness;
    //*
    public static void HomePage(){

        System.out.println("1.Admin");
        System.out.println("2.Doctor");
        System.out.println("3.Patient");
        System.out.println("4.Nurse");
        System.out.println("5.Secretary\n");
        System.out.println("Enter Number : ");
        try {
            int x = n.nextInt();
            switch(x){
                case 1:
                    AdminLoginPage();
                    break;

                case 2:
                    DoctorPage();
                    break;

                case 3:
                    PatientPage();
                    break;

                case 4:
                    NursePage();
                    break;

                case 5:
                    SecretaryPage();
                    break;

                default:
                    System.out.println("\nWrong Number!!!\n");
                    HomePage();
            }
        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            HomePage();
        }

    }

    //*
    public static void AdminLoginPage(){

        System.out.println("\nEnter Username : ");
        String User = n.nextLine();
        System.out.println("Enter Password : ");
        String Pass = n.nextLine();
        for(int i=0;i<admins.size();i++){
            if(admins.size()==0){
                System.out.println("help");
            }

            if(admins.get(i).getUserName().equals(User) && admins.get(i).getPassword().equals(Pass)){

                System.out.println("\n * Welcome To Our Hospital *");
                AdminHomePage();
                return;
            }
        }
        System.out.println("Wrong Username Or Password");
        AdminLoginPage();
    }
    //*
    public static void AdminHomePage(){
        System.out.println("\n1.Add Personnel");
        System.out.println("2.Show Personnel");
        System.out.println("3.Dismiss Personnel");
        System.out.println("4.Show Patient");
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            switch(index){
                case 1:
                    AddPersonnel();
                    break;
                case 2:
                    ShowPersonnel();
                    break;
                case 3:
                    DismissPersonel();
                    break;
                case 4:
                    ShowPatient();
                    break;
                default:
                    System.out.println("\nWrong Number!!!\n");
                    AdminHomePage();
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            AdminHomePage();
        }
    }

    //*
    public static void AddPersonnel(){
        System.out.println("\n1.Doctor");
        System.out.println("2.Nurse");
        System.out.println("3.Add Secretary");
        System.out.println("4.Other Personnel\n");
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            switch(index){
                case 1:
                    AddDoctor();
                    break;
                case 2:
                    AddNurse();
                    break;
                case 3:
                    AddSecretary();
                    break;
                case 4:
                    AddOtherPersonnel();
                    break;
                default:
                    System.out.println("\nWrong Number!!!\n");
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            AddPersonnel();
        }
    }
    //*
    public static void AddDoctor(){
        try {

            System.out.println("\nEnter Name : ");
            String name = n.nextLine();
            System.out.println("Enter Age : ");
            int age = n.nextInt();
            System.out.println("Enter PhoneNumber : ");
            String phonenumber = n.nextLine();
            System.out.println("Gender : ");
            System.out.println("1.Female    2.Male   3.None_binary");
            int gender = n.nextInt();
            System.out.println("Enter Address : ");
            String address = n.nextLine();
            System.out.println("Speciality : ");
            System.out.println("1.Cardiologist 2.General 3.Neurologist 4.Dermatologist 5.Orthopedist");
            int speciality = n.nextInt();
            System.out.println("Enter Password : ");
            String password = n.nextLine();
            System.out.println("Enter National ID : ");
            String nationalid = n.nextLine();
            System.out.println("Enter Salary : ");
            int salay = n.nextInt();
            Database.AddDoctor(name, age, phonenumber, gender, address, speciality, password, nationalid, salay);
            doctors=Database.GetDoctor();
            System.out.println("Doctor Added Succsessfully\n\n");
            AdminHomePage();


        } catch (Exception e) {
            AddDoctor();
        }

    }
    //*
    public static void AddNurse(){
        try {

            System.out.println("\nEnter Name : ");
            String name = n.nextLine();
            System.out.println("Enter Age : ");
            int age = n.nextInt();
            System.out.println("Enter PhoneNumber : ");
            String phonenumber = n.nextLine();
            System.out.println("Gender : ");
            System.out.println("1.Female    2.Male   3.None_binary");
            int gender = n.nextInt();
            System.out.println("Enter Address : ");
            String address = n.nextLine();
            System.out.println("Enter Password : ");
            String password = n.nextLine();
            System.out.println("Enter National ID : ");
            String nationalid = n.nextLine();
            System.out.println("Enter Salary : ");
            int salay = n.nextInt();
            Database.AddNurse(name, age, phonenumber, gender, address,password, nationalid, salay);
            nurses=Database.GetNurse();
            System.out.println("Nurse Added Succsessfully\n\n");
            AdminHomePage();


        } catch (Exception e) {
            AddNurse();
        }

    }
    //*
    public static void AddSecretary(){
        try {

            System.out.println("\nEnter Name : ");
            String name = n.nextLine();
            System.out.println("Enter Age : ");
            int age = n.nextInt();
            System.out.println("Enter PhoneNumber : ");
            String phonenumber = n.nextLine();
            System.out.println("Gender : ");
            System.out.println("1.Female    2.Male   3.None_binary");
            int gender = n.nextInt();
            System.out.println("Enter Address : ");
            String address = n.nextLine();
            System.out.println("Enter Password : ");
            String password = n.nextLine();
            System.out.println("Enter National ID : ");
            String nationalid = n.nextLine();
            System.out.println("Enter Salary : ");
            int salay = n.nextInt();
            Database.AddSecretary(name,password, age, phonenumber, gender, address, nationalid, salay);
            secretaries=Database.GetSecretary();
            System.out.println("Secretary Added Succsessfully\n\n");
            AdminHomePage();

        } catch (Exception e) {
            AddSecretary();
        }
    }
    //*
    public static void AddOtherPersonnel(){
        try {

            System.out.println("\nEnter Name : ");
            String name = n.nextLine();
            System.out.println("Enter Age : ");
            int age = n.nextInt();
            System.out.println("Enter PhoneNumber : ");
            String phonenumber = n.nextLine();
            System.out.println("Gender : ");
            System.out.println("1.Female    2.Male   3.None_binary");
            int gender = n.nextInt();
            System.out.println("Enter Address : ");
            String address = n.nextLine();
            System.out.println("Enter National ID : ");
            String nationalid = n.nextLine();
            System.out.println("Enter Salary : ");
            int salay = n.nextInt();
            System.out.println("Work :");
            System.out.println("1.Janitor 2.SecurityGuard 3.Chef");
            int work =n.nextInt();
            Database.AddPersonnel(name, phonenumber, gender,  nationalid, work,address, salay,age);
            personnels=Database.GetPersonnel();
            System.out.println("Personnel Added Succsessfully\n\n");
            AdminHomePage();


        } catch (Exception e) {
            AddOtherPersonnel();
        }
    }

    //*
    public static void ShowPersonnel(){
        System.out.println("\n1.Doctor");
        System.out.println("2.Nurse");
        System.out.println("3.Secretary");
        System.out.println("4.Other Personnel\n");
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            switch(index){
                case 1:
                    DoctorList();
                    break;
                case 2:
                    NurseList();
                    break;
                case 3:
                    SecretryList();
                case 4:
                    PersonnelList();
                    break;
                default:
                    System.out.println("\nWrong Number!!!\n");
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            ShowPersonnel();
        }

    }
    //*
    public static void DoctorList(){
        if(doctors.size()==0){
            System.out.println("There is No Doctor");
            ShowPersonnel();
        }
        System.out.println("   Name         "+"         Speciality   ");
        for(int i=0; i<doctors.size(); i++){
            System.out.println((i+1)+ "." + doctors.get(i).getName() +"      "+ doctors.get(i).getSpeciality());
        }
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            if(index<=doctors.size() && index>0){
                System.out.println("Name : "+doctors.get(index-1).getName());
                System.out.println("National ID : "+doctors.get(index-1).getNationalID());
                System.out.println("Speciality : "+doctors.get(index-1).getSpeciality());
                System.out.println("Age : "+doctors.get(index-1).getAge());
                System.out.println("PhoneNumber : "+doctors.get(index-1).getPhoneNumber());
                System.out.println("Gender : "+doctors.get(index-1).getGender());
                System.out.println("Address : "+doctors.get(index-1).getAddress());
                System.out.println("Salary : "+doctors.get(index-1).getSalary());
                System.out.println("   Patient Name         ");
                for(int i=0;i<doctors.get(index-1).patient.size();i++){
                    System.out.println((i+1)+doctors.get(index-1).patient.get(i).getName());
                }
            }else{
                System.out.println("Wrong Number!!!");
                DoctorList();
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            DoctorList();
        }

    }
    //*
    public static void NurseList(){
        if(nurses.size()==0){
            System.out.println("There is No Nurse");
            ShowPersonnel();
        }
        System.out.println("   Name         ");
        for(int i=0; i<nurses.size(); i++){
            System.out.println((i+1)+ "." + nurses.get(i).getName() );
        }
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            if(index<=nurses.size() && index>0){
                System.out.println("Name : "+nurses.get(index-1).getName());
                System.out.println("National ID : "+nurses.get(index-1).getNationalID());
                System.out.println("Age : "+nurses.get(index-1).getAge());
                System.out.println("PhoneNumber : "+nurses.get(index-1).getPhoneNumber());
                System.out.println("Gender : "+nurses.get(index-1).getGender());
                System.out.println("Address : "+nurses.get(index-1).getAddress());
                System.out.println("Salary : "+nurses.get(index-1).getSalary());
                System.out.println("   Patient Name         ");
                for(int i=0;i<nurses.get(index-1).patient.size();i++){
                    System.out.println((i+1)+nurses.get(index-1).patient.get(i).getName());
                }
            }else{
                System.out.println("Wrong Number!!!");
                NurseList();
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            NurseList();
        }

    }
    //*
    public static void SecretryList(){
        if(secretaries.size()==0){
            System.out.println("There is No Secretary");
            ShowPersonnel();
        }

        for(int i=0; i<secretaries.size(); i++){
            System.out.println((i+1)+"  Name :"+secretaries.get(i).getName());
            System.out.println("   National ID : "+secretaries.get(i).getNationalID());
            System.out.println("   Age : "+secretaries.get(i).getAge());
            System.out.println("   PhoneNumber : "+secretaries.get(i).getPhoneNumber());
            System.out.println("   Gender : "+secretaries.get(i).getGender());
            System.out.println("   Address : "+secretaries.get(i).getAddress());
            System.out.println("   Salary : "+secretaries.get(i).getSalary());
        }
    }
    //*
    public static void PersonnelList(){
        if(personnels.size()==0){
            System.out.println("There is No Personnel");
            ShowPersonnel();
        }

        for(int i=0; i<personnels.size(); i++){
            System.out.println((i+1)+"  Name :"+personnels.get(i).getName());
            System.out.println("   Work : "+personnels.get(i).getWork());
            System.out.println("   National ID : "+personnels.get(i).getNationalID());
            System.out.println("   Age : "+personnels.get(i).getAge());
            System.out.println("   PhoneNumber : "+personnels.get(i).getPhoneNumber());
            System.out.println("   Gender : "+personnels.get(i).getGender());
            System.out.println("   Address : "+personnels.get(i).getAddress());
            System.out.println("   Salary : "+personnels.get(i).getSalary());
        }
    }

    //*
    public static void DismissPersonel(){
        System.out.println("\n1.Doctor");
        System.out.println("2.Nurse");
        System.out.println("3.Secretary");
        System.out.println("4.Other Personnel\n");
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            switch(index){
                case 1:
                    DismissDoctor();
                    break;
                case 2:
                    DismissNurse();
                    break;
                case 3:
                    DismissSecretary();
                    break;
                case 4:
                    DismissPersonnel();
                    break;
                default:
                    System.out.println("\nWrong Number!!!\n");
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            ShowPersonnel();
        }
    }
    //*
    public static void DismissDoctor(){
        System.out.println("Enter National ID : ");
        String nid=n.nextLine();
        for(int i=0; i<doctors.size(); i++){
            if(doctors.get(i).getNationalID().equals(nid)){
                Database.DismissDoctor(doctors.get(i).getID());
                doctors = Database.GetDoctor();
            }
        }
    }
    //*
    public static void DismissNurse(){
        System.out.println("Enter National ID : ");
        String nid=n.nextLine();
        for(int i=0; i<nurses.size(); i++){
            if(nurses.get(i).getNationalID().equals(nid)){
                Database.DismissNurse(nurses.get(i).getID());
                nurses = Database.GetNurse();
            }
        }
    }
    //*
    public static void DismissSecretary(){
        System.out.println("Enter National ID : ");
        String nid=n.nextLine();
        for(int i=0; i<secretaries.size(); i++){
            if(secretaries.get(i).getNationalID().equals(nid)){
                Database.DismissSecretary(secretaries.get(i).getID());
                secretaries = Database.GetSecretary();
            }
        }
    }
    //*
    public static void DismissPersonnel(){
        System.out.println("Enter National ID : ");
        String nid=n.nextLine();
        for(int i=0; i<personnels.size(); i++){
            if(personnels.get(i).getNationalID().equals(nid)){
                Database.DismissPersonnel(personnels.get(i).getID());
                personnels = Database.GetPersonnel();
            }
        }
    }

    //*
    public static void ShowPatient(){
        System.out.println("     Name");
        for(int i=0; i<patients.size(); i++){
            System.out.println((i+1)+patients.get(i).getName());
        }
        boolean Check = true;
        while(Check){
            System.out.println("Enter Number : ");

            try {
                int index = n.nextInt();

                if(index <= patients.size() && index>0){
                    System.out.println("   Name :"+patients.get(index-1).getName());
                    System.out.println("   Gender : "+patients.get(index-1).getGender());
                    System.out.println("   Age : "+patients.get(index-1).getAge());
                    System.out.println("   Blood Type : "+patients.get(index-1).getBloodType());
                    System.out.println("   Body Condition : "+patients.get(index-1).getBodyCondition());
                    System.out.println("   Special Medicine : "+patients.get(index-1).getSpMedicine());
                    System.out.println("   Address : "+patients.get(index-1).getAddress());
                    System.out.println("   National ID : "+patients.get(index-1).getNationalID());
                    System.out.println("   PhoneNumber : "+patients.get(index-1).getPhoneNumber());
                    System.out.println("   Marital Status : "+patients.get(index-1).getMaritalStatus());
                    System.out.println("   Pregnancy Status : "+patients.get(index-1).getPregnancyStatus());

                    if(patients.get(index-1).treatment.size()>0){
                        System.out.println("1. Illness : "+patients.get(index-1).treatment.get(0).getIllness());

                    }
                    for(int j=1; j<patients.get(index-1).treatment.size(); j++){
                        if(patients.get(index-1).treatment.get(j-1).getIllness().equals(patients.get(index-1).treatment.get(j).getIllness())){
                            System.out.println("گی ونه دله");
                        }else{
                            System.out.println((j+1)+" Illness : "+patients.get(index-1).treatment.get(j).getIllness());
                        }
                    }
                    System.out.println("Enter Number : ");

                    boolean gvd=true;
                    while(gvd){
                        try {
                            int x=n.nextInt();
                            if(x <= patients.get(index-1).treatment.size() && x>0){
                                for(int k=0; k<patients.get(index-1).treatment.size(); k++){
                                    for(int l=0; l<doctors.size(); l++){
                                        if(doctors.get(l).getID()==patients.get(index-1).treatment.get(x-1).getDoctorID()){
                                            System.out.println("Doctor Name : "+ doctors.get(l).getName());
                                            break;
                                        }
                                    }
                                    if(patients.get(index-1).treatment.get(x-1).getIllness().equals(patients.get(index-1).treatment.get(k).getIllness())){
                                        System.out.println("Visit Date : "+patients.get(index-1).treatment.get(k).getVisitDate());
                                        System.out.println("Medicine : "+patients.get(index-1).treatment.get(k).getMedicine());
                                        System.out.println("Description : "+patients.get(index-1).treatment.get(k).getDescription());
                                        System.out.println("TreatmentState"+patients.get(index-1).treatment.get(k).isTreatmentState());
                                    }

                                }
                            }
                            gvd=false;


                        } catch (Exception e) {
                            System.out.println("Wrong Input!!!");
                        }

                    }
                    Check=false;

                }else{
                    System.out.println("Wrong Number!!!");

                }

            } catch (Exception e) {
                System.out.println("Wrong Input!!!");

            }
        }

    }

    //*
    public static void DoctorPage(){

        System.out.println("\nEnter National ID : ");
        String id = n.nextLine();
        System.out.println("Enter Password : ");
        String pass = n.nextLine();
        for(int i=0;i<doctors.size();i++){
            if(doctors.size()==0){
                System.out.println("help");
            }

            if(doctors.get(i).getNationalID().equals(id) && doctors.get(i).getPassword().equals(pass)) {

                System.out.println("\n * Welcome To Hospital *");
                ShowPatientDoctor(doctors.get(i));
                return;
            }
        }
        DoctorPage();


    }
    //*
    public static void ShowPatientDoctor(Doctor doctor){
        //shayad nashe
        if(doctor.patient.size() == 0){
            System.out.println("You Have No Patients");
        }else{

            System.out.println("    Name                     Illness");
            for(int i=0; i<doctor.patient.size(); i++){
                for(int j=0; j<doctor.patient.get(i).treatment.size(); j++){
                    if(doctor.patient.get(i).treatment.get(j).getDoctorID()==doctor.getID()){
                        Illness = doctor.patient.get(i).treatment.get(j).getIllness();
                        break;
                    }
                }

                System.out.println((i+1)+doctor.patient.get(i).getName()+Illness);
            }
            boolean Check=true;
            while(Check){
                System.out.println("Enter Number : ");

                try {
                    int index = n.nextInt();
                    if(index <= doctor.patient.size() && index>0){
                        System.out.println("   Name :"+doctor.patient.get(index-1).getName());
                        System.out.println("   Gender : "+doctor.patient.get(index-1).getGender());
                        System.out.println("   Age : "+doctor.patient.get(index-1).getAge());
                        System.out.println("   Illness : "+Illness);
                        System.out.println("   Blood Type : "+doctor.patient.get(index-1).getBloodType());
                        System.out.println("   Body Condition : "+doctor.patient.get(index-1).getBodyCondition());
                        System.out.println("   Special Medicine : "+doctor.patient.get(index-1).getSpMedicine());
                        for(int i=0;i<doctor.patient.get(index-1).treatment.size(); i++){
                            if(doctor.patient.get(index-1).treatment.get(i).getDoctorID()==doctor.getID()){
                                System.out.println("Visit Date : "+doctor.patient.get(index-1).treatment.get(i).getVisitDate());
                                System.out.println("Medicine : "+doctor.patient.get(index-1).treatment.get(i).getMedicine());
                                System.out.println("Description : "+doctor.patient.get(index-1).treatment.get(i).getDescription());
                                System.out.println("TreatmentState : "+doctor.patient.get(index-1).treatment.get(i).isTreatmentState());
                            }
                        }
                        PatientOptionsDoctor(doctor,doctor.patient.get(index-1),Illness);
                        Check=false;

                    }else{
                        System.out.println("Wrong Number!!!");

                    }
                } catch (Exception e) {
                    System.out.println("Wrong Input!!!");

                }
            }
        }

    }
    //*
    public static void PatientOptionsDoctor(Doctor doctor,Patient patient,String Illness){
        System.out.println("\n1.Dismiss Patient");
        System.out.println("2.Write Description");
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            switch(index){
                case 1:
                    DismissPatient(doctor,patient,Illness);
                    break;
                case 2:
                    WriteDescription(doctor,patient,Illness);
                    break;
                default:
                    System.out.println("Wrong Number!!!");
                    PatientOptionsDoctor(doctor,patient,Illness);

            }

        } catch (Exception e) {
            System.out.println("Wrong Input!!!");
        }
    }
    //*
    public static void DismissPatient(Doctor doctor,Patient patient,String Illness){

        for(int i=0; i<patient.treatment.size(); i++){
            if(patient.treatment.get(i).getDoctorID()==doctor.getID() && patient.treatment.get(i).getIllness().equals(Illness)){
                Database.UpdateTreatment(patient.treatment.get(i).getID());
                treatments = Database.GetTreatment();
                patients = Database.GetPatient();
                System.out.println("Patient Dissmissed");
            }
        }


    }
    //*
    public static void WriteDescription(Doctor doctor,Patient patient,String Illness){
        System.out.println("Write Medicine : ");
        String Medicine = n.nextLine();
        System.out.println("Write Description : ");
        String Description = n.nextLine();
        for(int i=0; i<patient.treatment.size(); i++){
            if(patient.treatment.get(i).getDoctorID()==doctor.getID() && patient.treatment.get(i).getIllness().equals(Illness)){
                Database.UpdateTreatment(patient.treatment.get(i).getID(),Medicine,Description);
                treatments = Database.GetTreatment();
                patients = Database.GetPatient();
            }
        }

    }

    //*
    public static void PatientPage(){

        System.out.println("1.Log in");
        System.out.println("2.Sign Up");

        int x = n.nextInt();
        switch(x){
            case 1:
                PatientLoginPage();
                break;
            case 2:
                PatientSignUpPage();
                break;
            default:
                System.out.println("Wrong Number!!!");
                PatientPage();
        }

    }
    //*
    public static void PatientLoginPage(){

        System.out.println("\nEnter National ID : ");
        String id = n.nextLine();
        System.out.println("Enter Password : ");
        String pass = n.nextLine();
        for(int i=0;i<patients.size();i++){
            if(patients.size()==0){
                System.out.println("help");
            }

            if(patients.get(i).getNationalID().equals(id) && patients.get(i).getPassword().equals(pass)) {

                System.out.println("\n * Welcome To Our Hospital *");
                PatientHomePage(patients.get(i));
                return;
            }
        }
        PatientPage();
    }
    //*
    public static void PatientSignUpPage(){
        try {

            System.out.println("Enter Name : ");
            String name = n.nextLine();
            System.out.println("Enter Age : ");
            int age = n.nextInt();
            System.out.println("Enter PhoneNumber: ");
            String phonenumber = n.nextLine();
            System.out.println("Gender : ");
            System.out.println("1.Female    2.Male   3.None_binary");
            int gender = n.nextInt();
            System.out.println("Enter Address : ");
            String address = n.nextLine();
            System.out.println("Enter National ID : ");
            String nationalid = n.nextLine();
            System.out.println("Blood Type  : ");
            System.out.println("1.A+  2.A-  3.B+  4.B-  5.AB+  6.AB-  7.O+  8.O-");
            int bloodtype = n.nextInt();
            System.out.println("Do You Have An Insurance ?  1.Yes  2.NO");
            int insurance = n.nextInt();
            System.out.println("MaritalStatus  : ");
            System.out.println("1.Married  2.Single");
            int maritalStatus = n.nextInt();
            System.out.println("Body Condition : ");
            System.out.println("1.Diabetes 2.High Blood Pressure 3.Heart Disease 4.Thyroid Illness");
            System.out.println("5.Hormone 6.Liver Problem 7.Hepapetheus 8.HIV 9.None");
            System.out.println("Any Other Illness :");
            String bodycondition = n.nextLine();
            System.out.println("Current Drug Use : ");
            String spmedicine = n.nextLine();
            System.out.println("Pregnancy Status : ");
            System.out.println("1.Pregnant 2.BreastFeeding 3.None");
            int pregnancyStatus = n.nextInt();
            System.out.println("Password : ");
            String password = n.nextLine();
            Database.AddPatient(name, age, phonenumber, gender, address, nationalid, bloodtype, insurance, maritalStatus, bodycondition, spmedicine, pregnancyStatus, password);
            patients=Database.GetPatient();
            System.out.println("\n * Welcome To Our Hospital *");
            PatientHomePage(patients.get(patients.size()-1));
        } catch (Exception e) {
            System.out.println("Wrong Input!!!");
            PatientSignUpPage();
        }


    }
    //*
    public static void PatientHomePage(Patient patient){
        System.out.println("\n1.Show Doctors");
        System.out.println("2.Show Appointment");
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            switch(index){
                case 1:
                    ShowDoctorsPatient(patient);
                    break;
                case 2:
                    ShowAppointents(patient);
                    break;
                default:
                    System.out.println("Wrong Number!!!");
                    PatientHomePage(patient);
            }
        } catch (Exception e) {
            System.out.println("Wrong Input!!!");
            PatientHomePage(patient);
        }

    }

    //*
    public static void ShowDoctorsPatient(Patient patient){
        if(doctors.size()==0){
            System.out.println("There is No Doctor");
            ShowPersonnel();
        }
        System.out.println("   Name         "+"         Speciality   ");
        for(int i=0; i<doctors.size(); i++){
            System.out.println((i+1)+ "." + doctors.get(i).getName() +"      "+ doctors.get(i).getSpeciality());
        }
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            if(index<=doctors.size() && index>0){
                System.out.println("Enter Illness : ");
                String x=n.nextLine();
                GetAppointment(doctors.get(index-1),patient,x);
            }else{
                System.out.println("Wrong Number!!!");
                ShowDoctorsPatient(patient);
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            ShowDoctorsPatient(patient);
        }

    }
    //*
    public static Integer GetDate(String datetime){
        String Pdate;

        Pdate = Character.toString(datetime.charAt(0))+Character.toString(datetime.charAt(1))
                +Character.toString(datetime.charAt(2))+Character.toString(datetime.charAt(3))
                +Character.toString(datetime.charAt(4))+Character.toString(datetime.charAt(5))+
                Character.toString(datetime.charAt(6))+Character.toString(datetime.charAt(7));

        Integer date;
        date = Integer.parseInt(Pdate);
        return date;
    }
    //*
    public static int GetDay(String date){
        String [] Pdate = new String[3];
        Pdate[0] = Character.toString(date.charAt(0))+Character.toString(date.charAt(1))
                +Character.toString(date.charAt(2))+Character.toString(date.charAt(3));
        Pdate[1] = Character.toString(date.charAt(4))+Character.toString(date.charAt(5));
        Pdate[2] = Character.toString(date.charAt(6))+Character.toString(date.charAt(7));

        int Year,Month,Day;
        Year = Integer.parseInt(Pdate[0]);
        Month = Integer.parseInt(Pdate[1]);
        Day = Integer.parseInt(Pdate[2]);

        Calendar one = new GregorianCalendar(Year, Month-1, Day);
        int day = one.get(Calendar.DAY_OF_WEEK);
        return day;
    }
    //*
    public static void GetAppointment(Doctor doctor,Patient patient,String illness){

        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter Dateformat = DateTimeFormatter.ofPattern("yyyyMMddHH");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String date = date1.format(Dateformat);

        String d=GetDate(date).toString();
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(d));
        }catch(ParseException e){
            e.printStackTrace();
        }

        cal.add(Calendar.DAY_OF_MONTH, 6);
        String dateAfter = sdf.format(cal.getTime());


        ArrayList<Treatment> treatment = new ArrayList<>();
        for(int k=0; k<treatments.size(); k++){
            if(treatments.get(k).getDoctorID() == doctor.getID()){
                treatment.add(treatments.get(k));
            }
        }
        int i,x;
        for(i=0; i<treatment.size(); i++){
            if(Integer.parseInt(treatment.get(i).getVisitDate())==Integer.parseInt(date)){
                break;
            }
        }

        for(int j=i; j<treatment.size(); j++){

            x=GetDay(treatment.get(j).getVisitDate());


            if(GetDate(treatment.get(j-1).getVisitDate())!= GetDate(treatment.get(j).getVisitDate()) || j==i){
                switch(x){
                    case 1:
                        System.out.println("Sunday :");

                        break;
                    case 2:
                        System.out.println("Monday :");
                        break;
                    case 3:
                        System.out.println("Tuesday :");
                        break;
                    case 4:
                        System.out.println("Wednesday :");
                        break;
                    case 5:
                        System.out.println("Thursday :");
                        break;
                    case 6:
                        System.out.println("Friday :");
                        break;
                    case 7:
                        System.out.println("Saturday :");
                        break;
                }
            }

            String [] Pdate = new String[4];
            Pdate[0] = Character.toString(treatment.get(j).getVisitDate().charAt(0))+Character.toString(treatment.get(j).getVisitDate().charAt(1))
                    +Character.toString(treatment.get(j).getVisitDate().charAt(2))+Character.toString(treatment.get(j).getVisitDate().charAt(3));
            Pdate[1] = Character.toString(treatment.get(j).getVisitDate().charAt(4))+Character.toString(treatment.get(j).getVisitDate().charAt(5));
            Pdate[2] = Character.toString(treatment.get(j).getVisitDate().charAt(6))+Character.toString(treatment.get(j).getVisitDate().charAt(7));
            Pdate[3]= Character.toString(treatment.get(j).getVisitDate().charAt(8))+Character.toString(treatment.get(j).getVisitDate().charAt(9));

            System.out.println(Pdate[0]+"/"+Pdate[1]+"/"+Pdate[2]+"  "+Pdate[3]);
            ktd(doctor,patient,illness);
        }

    }
    //*
    public static void ktd(Doctor doctor,Patient patient,String illness){
        try {
            System.out.println("Working Hour 8-16");
            System.out.println("Enter The Date Of Appointment ");
            System.out.println("Year : ");
            Integer year = n.nextInt();
            System.out.println("Month : ");
            Integer month = n.nextInt();
            System.out.println("Day : ");
            Integer day = n.nextInt();
            System.out.println("Hour : ");
            Integer hour = n.nextInt();

            String m=month.toString();
            String d=day.toString();
            String h=hour.toString();

            if(month<10){
                m="0"+m;
            }else if(month>12){
                System.out.println("جنده");
                ktd(doctor,patient,illness);
            }

            if (day<10){
                d="0"+d;
            }else if(day>30){
                System.out.println("جنده");
                ktd(doctor,patient,illness);
            }

            if(hour<10){
                h="0"+h;
            }else if(hour>16 && hour<8){
                System.out.println("جنده");
                ktd(doctor,patient,illness);
            }

            String ktdt=year.toString()+m+d+h;
            ShowNursePatient(doctor, patient, illness, ktdt);

        } catch (Exception e ) {
            System.out.println("Wrong Input!!!");
        }

    }
    //*
    public static void ShowNursePatient(Doctor doctor,Patient patient,String illness,String date){
        if(nurses.size()==0){
            System.out.println("There is No Nurse");
            ShowPersonnel();
        }
        System.out.println("   Name         ");
        for(int i=0; i<nurses.size(); i++){
            System.out.println((i+1)+ "." + nurses.get(i).getName() );
        }
        System.out.println("Enter Number : ");

        try {

            int index = n.nextInt();
            if(index<=nurses.size() && index>0){
                Database.AddTreatment(patient.getID(), doctor.getID(), nurses.get(index-1).getID(), date, illness);
                treatments = Database.GetTreatment();
                patients = Database.GetPatient();
                doctors = Database.GetDoctor();
                nurses = Database.GetNurse();
                System.out.println("کتاب موفقیت امیز");
            }else{
                System.out.println("Wrong Number!!!");
                ShowNursePatient(doctor, patient, illness, date);
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            ShowNursePatient(doctor, patient, illness, date);
        }

    }
    //*
    public static void ShowAppointents(Patient patient){
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter Dateformat = DateTimeFormatter.ofPattern("yyyyMMddHH");
        String date = date1.format(Dateformat);

        int i;
        for(i=0; i<patient.treatment.size(); i++){
            if(Integer.parseInt(patient.treatment.get(i).getVisitDate())==Integer.parseInt(date)){
                break;
            }
        }


        for(int x=i; x<patient.treatment.size(); x++){
            for(int j=0; j<doctors.size(); j++){
                if(patient.treatment.get(x).getDoctorID()==doctors.get(j).getID()){
                    System.out.println(doctors.get(j).getName());
                    break;
                }
            }
            for(int k=0; k<doctors.size(); k++){
                if(patient.treatment.get(x).getNurseID()==nurses.get(k).getID()){
                    System.out.println(nurses.get(k).getName());
                    break;
                }
            }
            System.out.println(patient.treatment.get(x).getIllness());
            System.out.println(patient.treatment.get(x).getVisitDate());
            System.out.println(patient.treatment.get(x).getMedicine());
        }
    }

    //*
    public static void NursePage(){

        System.out.println("\nEnter National ID : ");
        String id = n.nextLine();
        System.out.println("Enter Password : ");
        String pass = n.nextLine();
        for(int i=0;i<nurses.size();i++){
            if(nurses.size()==0){
                System.out.println("help");
            }

            if(nurses.get(i).getNationalID().equals(id) && nurses.get(i).getPassword().equals(pass)) {

                System.out.println("\n * Welcome To Hospital *");
                ShowPatientNurse(nurses.get(i));
                return;
            }
        }
        NursePage();
    }
    //*
    public static void ShowPatientNurse(Nurse nurse){
        //shayad nashe
        //امیدوارم بشه
        if(nurse.patient.size() == 0){
            System.out.println("You Have No Patients");
        }else{
            System.out.println("    Name                     Illness");
            for(int i=0; i<nurse.patient.size(); i++){
                for(int j=0; j<nurse.patient.get(i).treatment.size(); j++){
                    if(nurse.patient.get(i).treatment.get(j).getNurseID()==nurse.getID()){
                        Illness = nurse.patient.get(i).treatment.get(j).getIllness();
                        break;
                    }
                }
                System.out.println((i+1)+nurse.patient.get(i).getName()+Illness);
            }
            boolean Check=true;
            while(Check){
                System.out.println("Enter Number : ");

                try {
                    int index = n.nextInt();
                    if(index <= nurse.patient.size() && index>0){
                        System.out.println("   Name :"+nurse.patient.get(index).getName());
                        System.out.println("   Gender : "+nurse.patient.get(index).getGender());
                        System.out.println("   Age : "+nurse.patient.get(index).getAge());
                        System.out.println("   Illness : "+Illness);
                        System.out.println("   Blood Type : "+nurse.patient.get(index).getBloodType());
                        System.out.println("   Body Condition : "+nurse.patient.get(index).getBodyCondition());
                        System.out.println("   Special Medicine : "+nurse.patient.get(index).getSpMedicine());
                        for(int i=0;i<nurse.patient.get(index-1).treatment.size(); i++){
                            if(nurse.patient.get(index-1).treatment.get(i).getNurseID()==nurse.getID()){
                                System.out.println("Visit Date : "+nurse.patient.get(index-1).treatment.get(i).getVisitDate());
                                System.out.println("Medicine : "+nurse.patient.get(index-1).treatment.get(i).getMedicine());
                                System.out.println("Description : "+nurse.patient.get(index-1).treatment.get(i).getDescription());
                                System.out.println("TreatmentState"+nurse.patient.get(index-1).treatment.get(i).isTreatmentState());
                            }
                        }
                        Check=false;

                    }else{
                        System.out.println("Wrong Number!!!");

                    }
                } catch (Exception e) {
                    System.out.println("Wrong Input!!!");

                }
            }
        }

    }

    //*
    public static void SecretaryPage(){

        System.out.println("\nEnter National ID : ");
        String id = n.nextLine();
        System.out.println("Enter Password : ");
        String pass = n.nextLine();
        for(int i=0;i<secretaries.size();i++){
            if(secretaries.size()==0){
                System.out.println("help");
            }

            if(secretaries.get(i).getNationalID().equals(id) && secretaries.get(i).getPassword().equals(pass)) {

                System.out.println("\n * Welcome To Hospital *");
                DoctorListSecretary();
                return;
            }
        }
        SecretaryPage();
    }
    //*
    public static void DoctorListSecretary(){
        if(doctors.size()==0){
            System.out.println("There is No Doctor");
            ShowPersonnel();
        }
        System.out.println("   Name         "+"         Speciality   ");
        for(int i=0; i<doctors.size(); i++){
            System.out.println((i+1)+ "." + doctors.get(i).getName() +"      "+ doctors.get(i).getSpeciality());
        }
        System.out.println("Enter Number : ");

        try {
            int index = n.nextInt();
            if(index<=doctors.size() && index>0){
                ShowAppointentsSecretary(doctors.get(index-1));
            }else{
                System.out.println("Wrong Number!!!");
                DoctorListSecretary();
            }

        } catch (Exception e) {
            System.out.println("\nWrong Input!!!\n");
            DoctorListSecretary();
        }

    }

    public static void ShowAppointentsSecretary(Doctor doctor){
        System.out.println("\n"+doctor.getName());
        for(int i=0; i<treatments.size(); i++){

            if(treatments.get(i).getDoctorID()==doctor.getID()){
                for(int j=0; j<patients.size(); j++){
                    if(treatments.get(i).getPatientID()==patients.get(j).getID()){
                        String [] Pdate = new String[4];
                        Pdate[0] = Character.toString(treatments.get(i).getVisitDate().charAt(0))+Character.toString(treatments.get(i).getVisitDate().charAt(1))
                                +Character.toString(treatments.get(i).getVisitDate().charAt(2))+Character.toString(treatments.get(i).getVisitDate().charAt(3));
                        Pdate[1] = Character.toString(treatments.get(i).getVisitDate().charAt(4))+Character.toString(treatments.get(i).getVisitDate().charAt(5));
                        Pdate[2] = Character.toString(treatments.get(i).getVisitDate().charAt(6))+Character.toString(treatments.get(i).getVisitDate().charAt(7));
                        Pdate[3]= Character.toString(treatments.get(i).getVisitDate().charAt(8))+Character.toString(treatments.get(i).getVisitDate().charAt(9));


                        System.out.println("Date : "+Pdate[0]+"/"+Pdate[1]+"/"+Pdate[2]+"  "+Pdate[3]+"     Patient Name : "+patients.get(j).getName());
                    }
                }
            }
        }
    }

}
