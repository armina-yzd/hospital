import java.sql.*;
import java.util.ArrayList;

public class Database {

    static final String DB_URL="jdbc:mysql://127.0.0.1:3306/hospital";
    static final String USER="root";
    static final String PASS= "a13811383";

    public static ArrayList<Admin> GetAdmin(){
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from admin");
            while(resultSet.next()){
                String Password =resultSet.getString(2);
                String UserName =resultSet.getString(3);
                Admin admin = new Admin(UserName, Password);
                admins.add(admin);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static ArrayList<Personnel> GetPersonnel(){
        ArrayList<Personnel> personnels = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from personnel");
            while(resultSet.next()){
                int ID =resultSet.getInt(1);
                String Name =resultSet.getString(2);
                String PhoneNumber =resultSet.getString(3);
                Gender gender =Gender.valueOf(resultSet.getString(4));
                String NationalID =resultSet.getString(5);
                Work work=Work.valueOf(resultSet.getString(6));
                String Address=resultSet.getString(7);
                int Salary = resultSet.getInt(8);
                int Age =resultSet.getInt(9);

                Personnel personnel = new Personnel(ID, Name, PhoneNumber, Age, gender, Address, NationalID, work, Salary);
                personnels.add(personnel);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return personnels;
    }

    public static ArrayList<Secretary> GetSecretary(){
        ArrayList<Secretary> secretaries = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from secretary");
            while(resultSet.next()){
                int ID =resultSet.getInt(1);
                String Name =resultSet.getString(2);
                String Password =resultSet.getString(3);
                int Age =resultSet.getInt(4);
                String PhoneNumber =resultSet.getString(5);
                Gender gender =Gender.valueOf(resultSet.getString(6));
                String Address=resultSet.getString(7);
                String NationalID =resultSet.getString(8);
                int Salary = resultSet.getInt(9);




                Secretary secretary = new Secretary(ID,Name,PhoneNumber,Age,gender,Address,NationalID,Password,Salary);
                secretaries.add(secretary);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return secretaries;
    }

    public static ArrayList<Treatment> GetTreatment(){
        ArrayList<Treatment> treatments = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from treatment");
            while(resultSet.next()){
                int ID =resultSet.getInt(1);
                int PatientID =resultSet.getInt(2);
                int DoctorID =resultSet.getInt(3);
                int  NurseID=resultSet.getInt(4);
                String visitDate = resultSet.getString(5);
                String Description =resultSet.getString(6);
                String  Illness= resultSet.getString(7);
                String  Medicine= resultSet.getString(8);
                int Treatmentstate =resultSet.getInt(3);
                boolean TreatmentState;
                if(Treatmentstate==1){
                    TreatmentState=true;
                }else{
                    TreatmentState=false;
                }

                Treatment treatment = new Treatment(ID,NurseID,DoctorID,PatientID,Illness,visitDate);
                treatment.setDescription(Description);
                treatment.setMedicine(Medicine);
                treatment.setTreatmentState(TreatmentState);

                treatments.add(treatment);

            }

            //sort treatment by date
            Treatment temp=new Treatment(0, 0, 0, 0, null, null);

            for(int i=0; i < treatments.size(); i++){
                for(int j=1; j < (treatments.size()-i); j++){

                    if(Integer.parseInt(treatments.get(j-1).getVisitDate()) > Integer.parseInt(treatments.get(j).getVisitDate())){

                        temp.setID(treatments.get(j-1).getID());
                        temp.setDoctorID(treatments.get(j-1).getDoctorID());
                        temp.setNurseID(treatments.get(j-1).getNurseID());
                        temp.setPatientID(treatments.get(j-1).getPatientID());
                        temp.setDescription(treatments.get(j-1).getDescription());
                        temp.setIllness(treatments.get(j-1).getIllness());
                        temp.setMedicine(treatments.get(j-1).getMedicine());
                        temp.setVisitDate(treatments.get(j-1).getVisitDate());

                        treatments.get(j-1).setID(treatments.get(j).getID());
                        treatments.get(j-1).setDoctorID(treatments.get(j).getDoctorID());
                        treatments.get(j-1).setNurseID(treatments.get(j).getNurseID());
                        treatments.get(j-1).setPatientID(treatments.get(j).getPatientID());
                        treatments.get(j-1).setDescription(treatments.get(j).getDescription());
                        treatments.get(j-1).setIllness(treatments.get(j).getIllness());
                        treatments.get(j-1).setMedicine(treatments.get(j).getMedicine());
                        treatments.get(j-1).setVisitDate(treatments.get(j).getVisitDate());

                        treatments.get(j).setID(temp.getID());
                        treatments.get(j).setDoctorID(temp.getDoctorID());
                        treatments.get(j).setNurseID(temp.getNurseID());
                        treatments.get(j).setPatientID(temp.getPatientID());
                        treatments.get(j).setDescription(temp.getDescription());
                        treatments.get(j).setIllness(temp.getIllness());
                        treatments.get(j).setMedicine(temp.getMedicine());
                        treatments.get(j).setVisitDate(temp.getVisitDate());

                    }
                }
            }




        }catch (SQLException e) {
            e.printStackTrace();
        }
        return treatments ;
    }

    public static ArrayList<Doctor> GetDoctor(){
        ArrayList<Doctor> doctors = new ArrayList<>();

        ArrayList<Treatment> treatments=GetTreatment();
        ArrayList<Patient> patients=GetPatient();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from doctor");

            while(resultSet.next()){

                int ID =resultSet.getInt(1);
                String Name =resultSet.getString(2);
                int Age =resultSet.getInt(3);
                String PhoneNumber =resultSet.getString(4);
                Gender gender =Gender.valueOf(resultSet.getString(5));
                String Address=resultSet.getString(6);
                Speciality speciality = Speciality.valueOf(resultSet.getString(7));
                String Password =resultSet.getString(8);
                String NationalID =resultSet.getString(9);
                int Salary = resultSet.getInt(10);



                Doctor doctor = new Doctor(ID,Name,PhoneNumber,Age,gender,Address,NationalID,Password,speciality,Salary);
                doctors.add(doctor);

                for(int i=0;i<treatments.size();i++){
                    if(treatments.get(i).getDoctorID()==doctor.getID()){
                        for(int j=0;j<patients.size();j++){
                            if(treatments.get(i).getPatientID()==patients.get(j).getID()){
                                doctor.setPatient(patients.get(j));
                            }
                        }
                    }

                }


            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors ;
    }

    public static ArrayList<Patient> GetPatient(){
        ArrayList<Patient> patients = new ArrayList<>();

        ArrayList<Treatment> treatments=Database.GetTreatment();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from patient");
            while(resultSet.next()){
                int ID =resultSet.getInt(1);
                String Name =resultSet.getString(2);
                int Age =resultSet.getInt(3);
                String PhoneNumber =resultSet.getString(4);
                Gender gender =Gender.valueOf(resultSet.getString(5));
                String Address=resultSet.getString(6);
                String NationalID =resultSet.getString(7);
                BloodType bloodType =BloodType.valueOf(resultSet.getString(8));
                int Insure =resultSet.getInt(9);
                boolean Insurance;
                if(Insure==1){
                    Insurance=true;
                }else{
                    Insurance=false;
                }
                MaritalStatus maritalStatus=MaritalStatus.valueOf(resultSet.getString(10));
                String BodyCondition=resultSet.getString(11);
                String SpMedicine=resultSet.getString(12);
                PregnancyStatus pregnancyStatus=PregnancyStatus.valueOf(resultSet.getString(13));
                String Password =resultSet.getString(14);


                Patient patient = new Patient(ID,Name,PhoneNumber,Age,gender,Address,NationalID,Password,bloodType,Insurance,maritalStatus,BodyCondition,SpMedicine,pregnancyStatus);
                patients.add(patient);

                for(int i=0;i<treatments.size();i++){
                    if(treatments.get(i).getPatientID()==patient.getID()){
                        patient.setTreatment(treatments.get(i));
                    }
                }

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return patients ;
    }

    public static ArrayList<Nurse> GetNurse(){
        ArrayList<Nurse> nurses = new ArrayList<>();

        ArrayList<Treatment> treatments=GetTreatment();
        ArrayList<Patient> patients=GetPatient();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from nurse");
            while(resultSet.next()){
                int ID =resultSet.getInt(1);
                String Name =resultSet.getString(2);
                int Age =resultSet.getInt(3);
                String PhoneNumber =resultSet.getString(4);
                Gender gender =Gender.valueOf(resultSet.getString(5));
                String Address=resultSet.getString(6);
                String Password =resultSet.getString(7);
                String NationalID =resultSet.getString(8);
                int Salary = resultSet.getInt(9);




                Nurse nurse = new Nurse(ID,Name,PhoneNumber,Age,gender,Address,NationalID,Salary,Password);
                nurses.add(nurse);

                for(int i=0;i<treatments.size();i++){
                    if(treatments.get(i).getNurseID()==nurse.getID()){
                        for(int j=0;j<patients.size();j++){
                            if(treatments.get(i).getPatientID()==patients.get(j).getID()){
                                nurse.setPatient(patients.get(j));
                            }
                        }
                    }

                }

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return nurses ;
    }



    public static void AddDoctor(String name, int age, String Phonenumber, int gender,
                                 String address, int speciality, String password, String nationalid, int salary){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO doctor (Name, Age, PhoneNumber, Gender, Address, Speciality, Password, NationalID, Salay)"
                    + " VALUES ( '"+name+"', '"+age+"', '"+Phonenumber+"', '"+gender+"', '"+address+"', '"+speciality+"', '"+password+"', '"+nationalid+"', '"+salary+"')";
            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void AddNurse(String name, int age, String Phonenumber, int gender,
                                String address, String password, String nationalid, int salary){

        Connection conn = null;
        Statement stmt = null;

        try {
            try {

                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }

            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            //INSERT INTO `Hospital`.`Nurse` (`idNurse`, `Name`, `Age`, `PhoneNumber`, `Gender`, `Address`, `Password`, `NationalID`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1');

            String query1 = "INSERT INTO nurse (Name, Age, PhoneNumber, Gender, Address, Password, NationalID,Salary)"
                    + " VALUES ( '"+name+"', '"+age+"', '"+Phonenumber+"', '"+gender+"', '"+address+"', '"+password+"', '"+nationalid+"', '"+salary+"')";

            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public static void AddSecretary(String name, String password, int age, String Phonenumber, int gender,
                                    String address, String nationalid, int salary){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO secretary (Name, Password,Age, PhoneNumber,  Gender, Address, NationalID,Salary)"
                    + " VALUES ( '"+name+"', '"+password+"', '"+age+"', '"+Phonenumber+"', '"+gender+"', '"+address+"', '"+nationalid+"', '"+salary+"')";

            stmt.executeUpdate(query1);

        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public static void AddPersonnel(String name, String Phonenumber, int gender,
                                    String nationalid,int work,String address,int salary,int age){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO personnel (Name, PhoneNumber, Gender,NationalID,Work, Address,Salary, Age)"
                    + " VALUES ( '"+name+"', '"+Phonenumber+"', '"+gender+"', '"+nationalid+"', '"+work+"', '"+address+"', '"+salary+"', '"+age+"')";

            stmt.executeUpdate(query1);

        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void AddPatient(String name, int age,String phonenumber, int gender,
                                  String address,String nationalid,int bloodtype,int insurance,int maritalStatus,
                                  String bodycondition,String spmedicine,int pregnancyStatus,String password){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO patient (Name,Age, PhoneNumber, Gender,Address,NationalID,BloodType, insurance,MaritalStatus,BodyCondition,SpMedicine,PregnancyStatus,Password)"
                    + " VALUES ( '"+name+"', '"+age+"', '"+phonenumber+"', '"+gender+"', '"+address+"', '"+nationalid+"', '"+bloodtype+
                    "', '"+insurance+"', '"+maritalStatus+"', '"+bodycondition+"', '"+spmedicine+"', '"+pregnancyStatus+"', '"+password+"')";

            stmt.executeUpdate(query1);

        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public static void AddTreatment(int patientid, int doctorid, int nurseid,
                                    String date,String illness){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO treatment (`Patient ID`, `Doctor ID`, `Nurse ID`,`Date`,`illness`,`TreatmentState`)"
                    + " VALUES ( '"+patientid+"', '"+doctorid+"', '"+nurseid+"', '"+date+"', '"+illness+"', '"+1+"')";

            stmt.executeUpdate(query1);

        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }



    public static void DismissDoctor(int doctorid){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "delete from  doctor " +
                    "where idDoctor='"+doctorid+"'";
            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void DismissNurse(int nurseid){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "delete from  nurse " +
                    "where idNurse='"+nurseid+"'";
            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void DismissSecretary(int secretaryid){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "delete from  secretary " +
                    "where idSecretary='"+secretaryid+"'";
            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void DismissPersonnel(int personnelid){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "delete from  personnel " +
                    "where idPersonnel='"+personnelid+"'";
            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public static void UpdateTreatment(int treatmentid,String Medicine,String Description){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "UPDATE treatment SET Description = '" +Description+"', Medicine = '"+Medicine+
                    "' where (idTreatment='"+treatmentid+"')";

            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public static void UpdateTreatment(int treatmentid){
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.hospital");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection(DB_URL, USER,PASS );
            stmt = (Statement) conn.createStatement();
            String query1 = "UPDATE treatment SET TreatmentState = '" +2+"' where (idTreatment='"+treatmentid+"')";

            stmt.executeUpdate(query1);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}

