import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;


public class Frame extends JFrame {

    static ArrayList<Admin> admins=Database.GetAdmin();
    static ArrayList<Doctor> doctors=Database.GetDoctor();
    static ArrayList<Patient> patients=Database.GetPatient();
    static ArrayList<Personnel> personnels=Database.GetPersonnel();
    static ArrayList<Secretary> secretaries=Database.GetSecretary();
    static ArrayList<Treatment> treatments=Database.GetTreatment();
    static ArrayList<Nurse> nurses =Database.GetNurse();

    static String Illness;


    public void HomePage(){

        JFrame frame = new JFrame(" * HOSPITAL * ");

        Color lightred=new Color(225, 181, 181);
        frame.getContentPane().setBackground(lightred);
        Color pinkk=new Color(225, 0, 102);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        String t=". Admin .";
        JButton b1=new JButton(t);
        b1.setBounds(125,50, 150, 40);
        b1.setFont(f1);
        b1.setForeground(pinkk);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminLoginPage();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Doctor .");
        b2.setBounds(125,100, 150, 40);
        b2.setForeground(pinkk);
        b2.setFont(f1);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorLogin();
                frame.dispose();
            }
        });

        JButton b3=new JButton(". Patient .");
        b3.setBounds(125,150, 150, 40);
        b3.setForeground(pinkk);
        b3.setFont(f1);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientPage();
                frame.dispose();
            }
        });

        JButton b4=new JButton(". Nurse .");
        b4.setBounds(125,200, 150, 40);
        b4.setForeground(pinkk);
        b4.setFont(f1);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NurseLogin();
                frame.dispose();
            }
        });

        JButton b5=new JButton(". Secretary .");
        b5.setBounds(125,250, 150, 40);
        b5.setForeground(pinkk);
        b5.setFont(f1);
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SecretaryLogin();
                frame.dispose();
            }
        });

        frame.add(b1); frame.add(b2); frame.add(b3); frame.add(b4); frame.add(b5);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public void AdminLoginPage(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        final JPasswordField value = new JPasswordField();
        final JTextField text = new JTextField();
        label.setBounds(125,55, 130, 35);
        value.setBounds(125,105, 130, 35);
        text.setBounds(125,55, 130, 35);
        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel(" UserName:   ");
        l1.setBounds(55,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);


        JLabel l2=new JLabel(" Password:  ");
        l2.setBounds(55,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);

        JButton b = new JButton("  Login  ");
        b.setBounds(125,200, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<admins.size();i++){

                    if(admins.get(i).getUserName().equals(text.getText()) && admins.get(i).getPassword().equals(value.getText())){

                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }
                int x = JOptionPane.showConfirmDialog( frame, "Wrong UserName Or Password \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    AdminLoginPage();
                    frame.dispose();
                }
                else {
                    HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HomePage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(value); frame.add(l1);frame.add(l2); frame.add(label); frame.add(b); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void AdminPage(){

        JFrame frame= new JFrame(" * Admin * ");

        Color lightblue=new Color(204, 229, 255);
        Color blue=new Color(0, 0, 204);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        JButton b1=new JButton(". Add Personnel .");
        b1.setBounds(75,70, 250, 40);
        b1.setForeground(blue);
        b1.setFont(f1);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Addpersonnel();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Show Personnel .");
        b2.setBounds(75,120, 250, 40);
        b2.setForeground(blue);
        b2.setFont(f1);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Showpersonnel();
                frame.dispose();
            }
        });

        JButton b3=new JButton(". Dismiss Personnel .");
        b3.setBounds(75,170, 250, 40);
        b3.setForeground(blue);
        b3.setFont(f1);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissPersonel();
                frame.dispose();
            }
        });

        JButton b4=new JButton(". Show Patient .");
        b4.setBounds(75,220, 250, 40);
        b4.setForeground(blue);
        b4.setFont(f1);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(blue);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminLoginPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.setSize(400,400);
        frame.add(b1); frame.add(b2); frame.add(b3); frame.add(b4);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    public void DoctorLogin(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JPasswordField value = new JPasswordField();
        value.setBounds(125,105,130,35);
        final JTextField text = new JTextField();
        text.setBounds(125,55, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  National ID:  ");
        l1.setBounds(45,50, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JLabel l2=new JLabel("  Password:  ");
        l2.setBounds(55,100, 150,40);
        l2.setFont(f1);
        l2.setForeground(green);

        JButton b = new JButton("Login");
        b.setBounds(150,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<doctors.size();i++){

                    if(doctors.get(i).getNationalID().equals(text.getText()) && doctors.get(i).getPassword().equals(value.getText())) {
                        // int x = JOptionPane.showConfirmDialog( frame,"okeye", " ", JOptionPane.OK_OPTION);
                        ShowPatientDoctor(doctors.get(i));
                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong UserName Or NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    DoctorLogin();
                    frame.dispose();
                }
                else {
                    HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HomePage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(value); frame.add(b); frame.add(label);frame.add(l1); frame.add(l2); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void NurseLogin(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JPasswordField value = new JPasswordField();
        value.setBounds(125,105,130,35);
        final JTextField text = new JTextField();
        text.setBounds(125,55, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  National ID:  ");
        l1.setBounds(45,50, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JLabel l2=new JLabel("  Password:  ");
        l2.setBounds(55,100, 150,40);
        l2.setFont(f1);
        l2.setForeground(green);

        JButton b = new JButton("Login");
        b.setBounds(150,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<doctors.size();i++){

                    if(nurses.get(i).getNationalID().equals(text.getText()) && nurses.get(i).getPassword().equals(value.getText())) {

                        ShowPatientNurse(nurses.get(i));
                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong UserName Or NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    NurseLogin();
                    frame.dispose();
                }
                else {
                    HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HomePage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(value); frame.add(b); frame.add(label);frame.add(l1); frame.add(l2); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void SecretaryLogin(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(125,55, 130,35);
        final JPasswordField value = new JPasswordField();
        value.setBounds(125,105,130,35);
        final JTextField text = new JTextField();
        text.setBounds(125,55, 130,35);


        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  National ID:  ");
        l1.setBounds(45,50, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JLabel l2=new JLabel("  Password:  ");
        l2.setBounds(55,100, 150,40);
        l2.setFont(f1);
        l2.setForeground(green);

        JButton b = new JButton("Login");
        b.setBounds(125,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<secretaries.size();i++){

                    if(secretaries.get(i).getNationalID().equals(text.getText()) && secretaries.get(i).getPassword().equals(value.getText())) {

                        DoctorListSecretary();
                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong UserName Or NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    SecretaryLogin();
                    frame.dispose();
                }
                else {
                    HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HomePage();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(value); frame.add(b); frame.add(label);frame.add(l1); frame.add(l2); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public void PatientPage(){

        JFrame frame= new JFrame(" * Patient * ");

        Color lightpurple=new Color(204, 204, 255);
        Color  purple=new Color(102, 0, 204);
        frame.getContentPane().setBackground(lightpurple);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);


        JButton b1=new JButton(". Log In .");
        b1.setBounds(125,110, 150, 40);
        b1.setFont(f1);
        b1.setForeground(purple);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientLogin();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Sign Up .");
        b2.setBounds(125,170, 150, 40);
        b2.setFont(f1);
        b2.setForeground(purple);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientSignUpPage();
                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(purple);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HomePage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b1); frame.add(b2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void PatientLogin(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(125,55, 130,35);
        final JPasswordField value = new JPasswordField();
        value.setBounds(125,105,130,35);
        final JTextField text = new JTextField();
        text.setBounds(125,55, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);


        JLabel l1=new JLabel("  National ID:  ");
        l1.setBounds(45,50, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JLabel l2=new JLabel("  Password:  ");
        l2.setBounds(55,100, 150,40);
        l2.setFont(f1);
        l2.setForeground(green);

        JButton b = new JButton("Login");
        b.setBounds(125,200,150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<patients.size();i++){

                    if(patients.get(i).getNationalID().equals(text.getText()) && patients.get(i).getPassword().equals(value.getText())) {

                        PatientHomePage(patients.get(i));

                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong UserName Or NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    PatientLogin();
                    frame.dispose();
                }
                else {
                    HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(value); frame.add(b); frame.add(label);frame.add(l1); frame.add(l2); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void PatientSignUpPage(){

        JFrame frame=new JFrame();

        Color lightBlue=new Color(205, 253, 255);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightBlue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 11);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(20,20, 150, 20);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(140,20, 130, 20);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(20,50, 150, 20);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(140,50, 130, 20);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(20,80, 150, 20);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(140,80, 130, 20);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(20,110, 150, 20);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();
        text4.setBounds(140,110, 130, 20);



        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(20,140, 150, 20);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(140, 140,130,20);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(20,170, 150, 20);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(140,170, 130, 20);

        JLabel l8=new JLabel("  Current Drug Use :");
        l8.setBounds(20,230, 150, 20);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(140,230, 130, 20);

        JLabel l9=new JLabel("  Password :");
        l9.setBounds(20,260, 150, 20);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(140,260, 130, 20);


        JLabel l10=new JLabel("  Blood Type  : ");
        l10.setBounds(20,290, 150, 20);
        l10.setFont(f1);
        l10.setForeground(green);
        String Bloodtype[]={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        final JComboBox cb2=new JComboBox(Bloodtype);
        cb2.setBounds(140, 290,130,20);


        JLabel l11=new JLabel("  Pregnancy Status  : ");
        l11.setBounds(20,320, 150, 20);
        l11.setFont(f1);
        l11.setForeground(green);
        String ps[]={"Pregnant","BreastFeeding","None"};
        final JComboBox cb3=new JComboBox(ps);
        cb3.setBounds(140, 320,130,20);

        JLabel l12=new JLabel("  Marital Status  : ");
        l12.setBounds(20,350, 150, 20);
        l12.setFont(f1);
        l12.setForeground(green);
        String ms[]={"Married","Single"};
        final JComboBox cb4=new JComboBox(ms);
        cb4.setBounds(140, 350,130,20);


        JLabel l14=new JLabel("  Insurance  : ");
        l14.setBounds(20,200, 150, 20);
        l14.setFont(f1);
        l14.setForeground(green);

        JRadioButton r9 =new JRadioButton("Yes");
        r9.setBounds(140,200, 130, 20);
        JRadioButton r10 =new JRadioButton("No");
        r10.setBounds(220,200, 130, 20);

        ButtonGroup kr= new ButtonGroup();
        kr.add(r9);kr.add(r10);






        JLabel l13=new JLabel("  Body Condition  : ");
        l13.setBounds(20,380, 150, 20);
        l13.setFont(f1);
        l13.setForeground(green);
        JRadioButton r1 =new JRadioButton("Diabetes");
        r1.setBounds(140,380, 130, 20);
        JRadioButton r2 =new JRadioButton("High Blood Pressure");
        r2.setBounds(270,380, 160, 20);
        JRadioButton r3 =new JRadioButton("Heart Disease");
        r3.setBounds(140,410, 130, 20);
        JRadioButton r4 =new JRadioButton("Thyroid Illness");
        r4.setBounds(270,410, 130, 20);
        JRadioButton r5 =new JRadioButton("Hormone");
        r5.setBounds(140,440, 130, 20);
        JRadioButton r6 =new JRadioButton("Liver Problem");
        r6.setBounds(270,440, 130, 20);
        JRadioButton r7 =new JRadioButton("Hepapetheus");
        r7.setBounds(140,470, 130, 20);
        JRadioButton r8 =new JRadioButton("HIV");
        r8.setBounds(270,470, 130, 20);

        JButton b = new JButton("Sign up");
        b.setBounds(165,540, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                String bodycondition="";
                if(r1.isSelected()){
                    bodycondition+="Diabetes ";
                }
                if(r2.isSelected()){
                    bodycondition+="High Blood Pressure  ";
                }
                if(r3.isSelected()){
                    bodycondition+="Heart Disease  ";
                }
                if(r4.isSelected()){
                    bodycondition+="Thyroid Illness  ";
                }
                if(r5.isSelected()){
                    bodycondition+="Hormone  ";
                }
                if(r6.isSelected()){
                    bodycondition+="Liver Problem  ";
                }
                if(r7.isSelected()){
                    bodycondition+="Hepapetheus  ";
                }
                if(r8.isSelected()){
                    bodycondition+="HIV  ";
                }


                int insurance=0;
                if(r9.isSelected()){
                    insurance=1;
                }else{
                    insurance=0;
                }

                int y1=0;
                try {
                    String txt1=text4.getText();
                    y1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddDoctor();
                        frame.dispose();
                        return;
                    }else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }



                int x1,x2,x3,x4;

                if(cb2.getSelectedItem().equals("A+")){
                    x1=1;
                }else if(cb2.getSelectedItem().equals("A-")){
                    x1=2;
                }else if(cb2.getSelectedItem().equals("B+")){
                    x1=3;
                }else if(cb2.getSelectedItem().equals("B-")){
                    x1=4;
                }else if(cb2.getSelectedItem().equals("AB+")){
                    x1=5;
                }else if(cb2.getSelectedItem().equals("AB-")){
                    x1=6;
                }else if(cb2.getSelectedItem().equals("O+")){
                    x1=7;
                }else{
                    x1=8;
                }


                if(cb3.getSelectedItem().equals("Pregnant")){
                    x2=1;
                }else if(cb3.getSelectedItem().equals("BreastFeeding")){
                    x2=2;
                }else{
                    x2=3;
                }

                if(cb4.getSelectedItem().equals("Married")){
                    x4=1;
                }else if(cb4.getSelectedItem().equals("Single")){
                    x4=2;
                }else{
                    x4=3;
                }

                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }

                Database.AddPatient(text1.getText(), y1 , text3.getText(), x3, text5.getText(), text2.getText(), x1, insurance, x4, bodycondition, text6.getText(), x2, text7.getText());
                patients=Database.GetPatient();


                PatientHomePage(patients.get(patients.size()-1));
                frame.dispose();

            }



        });

        JButton back=new JButton("<-");
        back.setBounds(20,630, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l8);frame.add(l9);frame.add(l10);frame.add(l11);frame.add(l12);
        frame.add(l13);frame.add(l14);
        frame.add(cb1);frame.add(cb2);frame.add(cb3);frame.add(cb4);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);
        frame.add(text6);
        frame.add(text7);
        frame.add(r1);frame.add(r2);frame.add(r3);frame.add(r4);frame.add(r5);frame.add(r6);frame.add(r7);frame.add(r8);frame.add(r9);frame.add(r10);
        frame.add(b);
        frame.setSize(500,700);
        frame.setLayout(null);
        frame.setVisible(true);


    }



    public void Addpersonnel(){
        JFrame frame= new JFrame();
        frame.setSize(400,400);


        Color lightyellow=new Color(255, 255, 204);
        Color  orange=new Color(255, 128, 0);
        frame.getContentPane().setBackground(lightyellow);


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        JButton b1=new JButton(". Doctor .");
        b1.setBounds(100,70, 200, 40);
        b1.setFont(f1);
        b1.setForeground(orange);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddDoctor();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Nurse .");
        b2.setBounds(100,120, 200, 40);
        b2.setFont(f1);
        b2.setForeground(orange);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddNurse();
                frame.dispose();
            }
        });


        JButton b3=new JButton(". Secretary .");
        b3.setBounds(100,170, 200, 40);
        b3.setFont(f1);
        b3.setForeground(orange);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddSecretary();
                frame.dispose();
            }
        });


        JButton b4=new JButton(". Other Personnel .");
        b4.setBounds(100,220, 200, 40);
        b4.setFont(f1);
        b4.setForeground(orange);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddOtherPersonnel();
                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(orange);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b1); frame.add(b2); frame.add(b3); frame.add(b4);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void AddOtherPersonnel(){

        JFrame frame= new JFrame();

        frame.setSize(400,400);

        Color lightgray=new Color(224, 224, 224);
        Color  gray=new Color(96, 96, 96);
        frame.getContentPane().setBackground(lightgray);


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);


        JButton b1=new JButton(". SecurityGuard .");
        b1.setBounds(100,95, 200, 40);
        b1.setFont(f1);
        b1.setForeground(gray);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddSecurityGuard();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Janitor .");
        b2.setBounds(100,145, 200, 40);
        b2.setFont(f1);
        b2.setForeground(gray);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });


        JButton b3=new JButton(". Chef .");
        b3.setBounds(100,195, 200, 40);
        b3.setFont(f1);
        b3.setForeground(gray);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(gray);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(b1); frame.add(b2); frame.add(b3);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public void AddDoctor(){

        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(50,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,55, 130, 35);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(50,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,105, 130, 35);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(50,150, 150, 40);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(170,155, 130, 35);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(50,200, 150, 40);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();
        text4.setBounds(170,205, 130, 35);



        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(50,250, 150, 40);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(170, 255,130,35);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(50,300, 150, 40);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(170,305, 130, 35);

        JLabel l7=new JLabel("  Speciality :  ");
        l7.setBounds(50,350, 150, 40);
        l7.setFont(f1);
        l7.setForeground(green);
        String Speciality[]={"Cardiologist","General","Neurologist","Dermatologist","Orthopedist"};
        final JComboBox cb2=new JComboBox(Speciality);
        cb2.setBounds(170, 355,130,40);

        JLabel l8=new JLabel("  Salary :  ");
        l8.setBounds(50,400, 150, 40);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(170,405, 130, 35);




        JLabel l9=new JLabel("  Password :  ");
        l9.setBounds(50,450, 150, 40);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(170,455, 130, 35);

        JButton b = new JButton("Add");
        b.setBounds(125,550, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                int x1=0;
                try {
                    String txt1=text4.getText();
                    x1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddDoctor();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x2=0;
                try {
                    String txt2=text6.getText();
                    x2=Integer.parseInt(txt2);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddDoctor();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x3,x4;
                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }

                if(cb1.getSelectedItem().equals("Cardiologist")){
                    x4=1;
                }else if(cb1.getSelectedItem().equals("General")){
                    x4=2;
                }else if(cb1.getSelectedItem().equals("Neurologist")){
                    x4=3;
                }else if(cb1.getSelectedItem().equals("Dermatologist")){
                    x4=4;
                }else{
                    x4=5;
                }

                Database.AddDoctor(text1.getText(), x1, text3.getText(),x3, text5.getText(), x4, text7.getText(), text2.getText(), x2);
                doctors=Database.GetDoctor();

                AdminPage();
                frame.dispose();

            }



        });

        JButton back=new JButton("<-");
        back.setBounds(20,630, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Addpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);frame.add(l9);
        frame.add(cb1);
        frame.add(cb2);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);
        frame.add(text6);
        frame.add(text7);
        frame.add(b);
        frame.setSize(400,700);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void AddNurse(){

        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(50,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,55, 130, 35);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(50,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,105, 130, 35);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(50,150, 150, 40);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(170,155, 130, 35);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(50,200, 150, 40);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();

        text4.setBounds(170,205, 130, 35);





        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(50,250, 150, 40);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(170, 255,130,35);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(50,300, 150, 40);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(170,305, 130, 35);

        JLabel l8=new JLabel("  Salary :  ");
        l8.setBounds(50,350, 150, 40);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(170,355, 130, 35);


        JLabel l9=new JLabel("  Password :  ");
        l9.setBounds(50,400, 150, 40);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(170,405, 130, 35);

        JButton b = new JButton("Add");
        b.setBounds(125,480, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                int x1=0;
                try {
                    String txt1=text4.getText();
                    x1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddDoctor();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x2=0;
                try {
                    String txt2=text6.getText();
                    x2=Integer.parseInt(txt2);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddNurse();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x3;
                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }


                Database.AddNurse(text1.getText() , x1 , text3.getText() , x3 , text5.getText() , text7.getText() , text2.getText() , x2);
                nurses=Database.GetNurse();
                AdminPage();
                frame.dispose();

            }


        });

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Addpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l8);frame.add(l9);
        frame.add(cb1);
        frame.add(text1); frame.add(text2);frame.add(text3);frame.add(text4);frame.add(text5);
        frame.add(text6);frame.add(text7);
        frame.add(b);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void AddSecretary(){


        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(50,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,55, 130, 35);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(50,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,105, 130, 35);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(50,150, 150, 40);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(170,155, 130, 35);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(50,200, 150, 40);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();

        text4.setBounds(170,205, 130, 35);

        int x1;
        x1=Integer.parseInt(text4.getText());



        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(50,250, 150, 40);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(170, 255,130,35);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(50,300, 150, 40);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(170,305, 130, 35);

        JLabel l8=new JLabel("  Salary :  ");
        l8.setBounds(50,350, 150, 40);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(170,355, 130, 35);


        JLabel l9=new JLabel("  Password :  ");
        l9.setBounds(50,400, 150, 40);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(170,405, 130, 35);

        JButton b = new JButton("Add");
        b.setBounds(125,480, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                int x1=0;
                try {
                    String txt1=text4.getText();
                    x1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecretary();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x2=0;
                try {
                    String txt2=text6.getText();
                    x2=Integer.parseInt(txt2);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecretary();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x3;
                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }
                Database.AddSecretary(text1.getText() ,text7.getText(), x1, text3.getText(), x3, text5.getText(), text2.getText(), x2);
                secretaries=Database.GetSecretary();
                AdminPage();
                frame.dispose();

            }


        });

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Addpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l8);frame.add(l9);
        frame.add(cb1);
        frame.add(text1); frame.add(text2);frame.add(text3);frame.add(text4);frame.add(text5);
        frame.add(text6);frame.add(text7);
        frame.add(b);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void AddSecurityGuard(){

        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(50,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,55, 130, 35);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(50,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,105, 130, 35);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(50,150, 150, 40);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(170,155, 130, 35);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(50,200, 150, 40);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();

        text4.setBounds(170,205, 130, 35);


        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(50,250, 150, 40);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(170, 255,130,35);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(50,300, 150, 40);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(170,305, 130, 35);

        JLabel l8=new JLabel("  Salary :  ");
        l8.setBounds(50,350, 150, 40);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(170,355, 130, 35);


        JLabel l9=new JLabel("  Password :  ");
        l9.setBounds(50,400, 150, 40);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(170,405, 130, 35);

        JButton b = new JButton("Add");
        b.setBounds(125,480, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                int x1=0;
                try {
                    String txt1=text4.getText();
                    x1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecurityGuard();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x2=0;
                try {
                    String txt2=text6.getText();
                    x2=Integer.parseInt(txt2);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecurityGuard();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x3;
                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }

                Database.AddPersonnel(text1.getText(), text3.getText(), x3,  text2.getText(), 2,text5.getText(), x2,x1);
                personnels=Database.GetPersonnel();
                AdminPage();

            }


        });

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddOtherPersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l8);frame.add(l9);
        frame.add(cb1);
        frame.add(text1); frame.add(text2);frame.add(text3);frame.add(text4);frame.add(text5);
        frame.add(text6);frame.add(text7);
        frame.add(b);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void AddJanitor(){

        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(50,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,55, 130, 35);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(50,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,105, 130, 35);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(50,150, 150, 40);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(170,155, 130, 35);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(50,200, 150, 40);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();
        text4.setBounds(170,205, 130, 35);


        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(50,250, 150, 40);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(170, 255,130,35);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(50,300, 150, 40);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(170,305, 130, 35);

        JLabel l8=new JLabel("  Salary :  ");
        l8.setBounds(50,350, 150, 40);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(170,355, 130, 35);


        JLabel l9=new JLabel("  Password :  ");
        l9.setBounds(50,400, 150, 40);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(170,405, 130, 35);

        JButton b = new JButton("Add");
        b.setBounds(125,480, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                int x1=0;
                try {
                    String txt1=text4.getText();
                    x1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecurityGuard();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x2=0;
                try {
                    String txt2=text6.getText();
                    x2=Integer.parseInt(txt2);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecurityGuard();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x3;
                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }


                Database.AddPersonnel(text1.getText(), text3.getText(), x3,  text2.getText(), 1,text5.getText(), x2,x1);
                personnels=Database.GetPersonnel();
                AdminPage();
                frame.dispose();

            }


        });

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddOtherPersonnel();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l8);frame.add(l9);
        frame.add(cb1);
        frame.add(text1); frame.add(text2);frame.add(text3);frame.add(text4);frame.add(text5);
        frame.add(text6);frame.add(text7);
        frame.add(b);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void AddChef(){

        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("  Name :  ");
        l1.setBounds(50,50, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,55, 130, 35);


        JLabel l2=new JLabel("  National ID :  ");
        l2.setBounds(50,100, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,105, 130, 35);

        JLabel l3=new JLabel("  Phone Number :  ");
        l3.setBounds(50,150, 150, 40);
        l3.setFont(f1);
        l3.setForeground(green);
        final JTextField text3 = new JTextField();
        text3.setBounds(170,155, 130, 35);

        JLabel l4=new JLabel("  Age :  ");
        l4.setBounds(50,200, 150, 40);
        l4.setFont(f1);
        l4.setForeground(green);
        JTextField text4 = new JTextField();

        text4.setBounds(170,205, 130, 35);


        JLabel l5=new JLabel("  Gender :  ");
        l5.setBounds(50,250, 150, 40);
        l5.setFont(f1);
        l5.setForeground(green);
        String Gender[]={"Male","Female","None-binary"};
        final JComboBox cb1=new JComboBox(Gender);
        cb1.setBounds(170, 255,130,35);



        JLabel l6=new JLabel("  Address :  ");
        l6.setBounds(50,300, 150, 40);
        l6.setFont(f1);
        l6.setForeground(green);
        final JTextField text5 = new JTextField();
        text5.setBounds(170,305, 130, 35);

        JLabel l8=new JLabel("  Salary :  ");
        l8.setBounds(50,350, 150, 40);
        l8.setFont(f1);
        l8.setForeground(green);
        JTextField text6 = new JTextField();
        text6.setBounds(170,355, 130, 35);


        JLabel l9=new JLabel("  Password :  ");
        l9.setBounds(50,400, 150, 40);
        l9.setFont(f1);
        l9.setForeground(green);
        final JTextField text7 = new JTextField();
        text7.setBounds(170,405, 130, 35);

        JButton b = new JButton("Add");
        b.setBounds(125,480, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                int x1=0;
                try {
                    String txt1=text4.getText();
                    x1=Integer.parseInt(txt1);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecurityGuard();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x2=0;
                try {
                    String txt2=text6.getText();
                    x2=Integer.parseInt(txt2);
                } catch (Exception gggg) {
                    int x = JOptionPane.showConfirmDialog( frame, "Wrong Input\n Age And Salary Should Be Integer\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                    if (x==JOptionPane.YES_OPTION){
                        AddSecurityGuard();
                        frame.dispose();
                        return;
                    }
                    else {
                        AdminPage();
                        frame.dispose();
                        return;
                    }
                }

                int x3;
                if(cb1.getSelectedItem().equals("Male")){
                    x3=1;
                }else if(cb1.getSelectedItem().equals("Female")){
                    x3=2;
                }else{
                    x3=3;
                }



                Database.AddPersonnel(text1.getText(), text3.getText(), x3,  text2.getText(), 3 , text5.getText(), x2,x1);
                personnels=Database.GetPersonnel();
                AdminPage();
                frame.dispose();

            }


        });

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddOtherPersonnel();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l8);frame.add(l9);
        frame.add(cb1);
        frame.add(text1); frame.add(text2);frame.add(text3);frame.add(text4);frame.add(text5);
        frame.add(text6);frame.add(text7);
        frame.add(b);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public void Showpersonnel(){
        JFrame frame= new JFrame();
        frame.setSize(400,400);


        Color lightyellow=new Color(255, 255, 204);
        Color  orange=new Color(255, 128, 0);
        frame.getContentPane().setBackground(lightyellow);


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        JButton b1=new JButton(". Doctor .");
        b1.setBounds(100,70, 200, 40);
        b1.setFont(f1);
        b1.setForeground(orange);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowDoctors();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Nurse .");
        b2.setBounds(100,120, 200, 40);
        b2.setFont(f1);
        b2.setForeground(orange);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowNurse();
                frame.dispose();
            }
        });


        JButton b3=new JButton(". Secretary .");
        b3.setBounds(100,170, 200, 40);
        b3.setFont(f1);
        b3.setForeground(orange);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowSecretary();
                frame.dispose();
            }
        });


        JButton b4=new JButton(". Other Personnel .");
        b4.setBounds(100,220, 200, 40);
        b4.setFont(f1);
        b4.setForeground(orange);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowOtherPersonnel();
                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(orange);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(b1); frame.add(b2); frame.add(b3); frame.add(b4);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void ShowOtherPersonnel(){

        JFrame frame= new JFrame();

        frame.setSize(400,400);

        Color lightgray=new Color(224, 224, 224);
        Color  gray=new Color(96, 96, 96);
        frame.getContentPane().setBackground(lightgray);


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);


        JButton b1=new JButton(". SecurityGuard .");
        b1.setBounds(100,95, 200, 40);
        b1.setFont(f1);
        b1.setForeground(gray);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                frame.dispose();
            }
        });

        JButton b2=new JButton(". Janitor .");
        b2.setBounds(100,145, 200, 40);
        b2.setFont(f1);
        b2.setForeground(gray);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });


        JButton b3=new JButton(". Chef .");
        b3.setBounds(100,195, 200, 40);
        b3.setFont(f1);
        b3.setForeground(gray);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(gray);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b1); frame.add(b2); frame.add(b3);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public void ShowDoctors(){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[doctors.size()];
        String[] speciality=new String[doctors.size()];


        for(int i=0;i<doctors.size();i++){
            name[i]=doctors.get(i).getName();
            speciality[i]=doctors.get(i).getSpeciality().toString();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<doctors.size();i++){

            l1.addElement(name[i]);
        }

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<doctors.size();i++){

            l2.addElement(speciality[i]);
        }
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<doctors.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowDoctors(m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JLabel la3=new JLabel("  Speciality  ");
        la3.setBounds(125,0, 150,40);
        la3.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JList<String> list2 = new JList<>(l2);
        list2.setBounds(130,30, 400,400);
        list2.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(purple);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Showpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(la3);
        frame.add(list1);
        frame.add(list2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void ShowDoctors(String id){

        JFrame frame= new JFrame(" * Doctors * ");

        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        int ID=Integer.parseInt(id);
        JLabel l1=new JLabel(("Name : "+doctors.get(ID-1).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("National ID : "+doctors.get(ID-1).getNationalID());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l3=new JLabel("Speciality : "+doctors.get(ID-1).getSpeciality());
        l3.setBounds(30,110, 350, 30);
        l3.setFont(f1);

        JLabel l4=new JLabel("Age : "+doctors.get(ID-1).getAge());
        l4.setBounds(30,150, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("PhoneNumber : "+doctors.get(ID-1).getPhoneNumber());
        l5.setBounds(30,190, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Gender : "+doctors.get(ID-1).getGender());
        l6.setBounds(30,230, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Address : "+doctors.get(ID-1).getAddress());
        l7.setBounds(30,270, 350, 30);
        l7.setFont(f1);

        JLabel l8=new JLabel("Salary : "+doctors.get(ID-1).getSalary());
        l8.setBounds(30,310, 350, 30);
        l8.setFont(f1);

        JLabel l9=new JLabel("* Patient Name *");
        l9.setBounds(30,350, 350, 30);
        l9.setFont(f1);

        int y=390;
        for(int i=0;i<doctors.get(ID-1).patient.size();i++){
            JLabel l10=new JLabel((i+1)+doctors.get(ID-1).patient.get(i).getName());
            l10.setBounds(30,y, 400, 30);
            y+=30;
            l10.setFont(f1);
            frame.add(l10);
        }
        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowDoctors();
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(l1);frame.add(l2);frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);frame.add(l9);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowNurse(){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[nurses.size()];


        for(int i=0;i<nurses.size();i++){
            name[i]=nurses.get(i).getName();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<nurses.size();i++){

            l1.addElement(name[i]);
        }


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<nurses.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowNurse(m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(purple);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Showpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(la1);
        frame.add(la2);
        frame.add(list1);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void ShowNurse(String id){

        JFrame frame= new JFrame(" * Nurses * ");

        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        int ID=Integer.parseInt(id);
        JLabel l1=new JLabel(("Name : "+nurses.get(ID-1).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("National ID : "+nurses.get(ID-1).getNationalID());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l4=new JLabel("Age : "+nurses.get(ID-1).getAge());
        l4.setBounds(30,150, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("PhoneNumber : "+nurses.get(ID-1).getPhoneNumber());
        l5.setBounds(30,190, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Gender : "+nurses.get(ID-1).getGender());
        l6.setBounds(30,230, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Address : "+nurses.get(ID-1).getAddress());
        l7.setBounds(30,270, 350, 30);
        l7.setFont(f1);

        JLabel l8=new JLabel("Salary : "+nurses.get(ID-1).getSalary());
        l8.setBounds(30,110, 350,30);
        l8.setFont(f1);

        JLabel l9=new JLabel("* Patient Name *");
        l9.setBounds(30,350, 350, 30);
        l9.setFont(f1);
        int y=400;
        for(int i=0;i<nurses.get(ID-1).patient.size();i++){
            JLabel l10=new JLabel((i+1)+nurses.get(ID-1).patient.get(i).getName());
            l10.setBounds(30,y, 400, 30);
            y+=30;
            l10.setFont(f1);
            frame.add(l10);
        }

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowNurse();
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(l1);frame.add(l2);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);frame.add(l9);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowSecretary(){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[secretaries.size()];


        for(int i=0;i<secretaries.size();i++){
            name[i]=secretaries.get(i).getName();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<secretaries.size();i++){

            l1.addElement(name[i]);
        }


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<secretaries.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowSecretary(m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(purple);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Showpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(list1);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowSecretary(String id){

        JFrame frame= new JFrame(" * Secretaries * ");

        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        int ID=Integer.parseInt(id);
        JLabel l1=new JLabel(("Name : "+secretaries.get(ID-1).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("National ID : "+secretaries.get(ID-1).getNationalID());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l4=new JLabel("Age : "+secretaries.get(ID-1).getAge());
        l4.setBounds(30,150, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("PhoneNumber : "+secretaries.get(ID-1).getPhoneNumber());
        l5.setBounds(30,190, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Gender : "+secretaries.get(ID-1).getGender());
        l6.setBounds(30,230, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Address : "+secretaries.get(ID-1).getAddress());
        l7.setBounds(30,270, 350, 30);
        l7.setFont(f1);

        JLabel l8=new JLabel("Salary : "+secretaries.get(ID-1).getSalary());
        l8.setBounds(30,110, 350,30);
        l8.setFont(f1);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowSecretary();
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(l1);frame.add(l2);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowOtherPersonnell(){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[personnels.size()];


        for(int i=0;i<personnels.size();i++){
            name[i]=personnels.get(i).getName();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<personnels.size();i++){

            l1.addElement(name[i]);
        }


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<personnels.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowOtherPersonnell(m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(purple);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(list1);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowOtherPersonnell(String id){

        JFrame frame= new JFrame(" * Other Personnel * ");

        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        int ID=Integer.parseInt(id);
        JLabel l1=new JLabel(("Name : "+personnels.get(ID-1).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("National ID : "+personnels.get(ID-1).getNationalID());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l8=new JLabel("Work : "+personnels.get(ID-1).getWork());
        l8.setBounds(30,110, 350,30);
        l8.setFont(f1);

        JLabel l4=new JLabel("Age : "+personnels.get(ID-1).getAge());
        l4.setBounds(30,150, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("PhoneNumber : "+personnels.get(ID-1).getPhoneNumber());
        l5.setBounds(30,190, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Gender : "+personnels.get(ID-1).getGender());
        l6.setBounds(30,230, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Address : "+personnels.get(ID-1).getAddress());
        l7.setBounds(30,270, 350, 30);
        l7.setFont(f1);

        JLabel l9=new JLabel("Salary : "+personnels.get(ID-1).getSalary());
        l9.setBounds(30,310, 350,30);
        l9.setFont(f1);

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Showpersonnel();
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(l1);frame.add(l2);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);frame.add(l9);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public void DismissPersonel(){
        JFrame frame= new JFrame();
        frame.setSize(400,400);


        Color lightyellow=new Color(255, 255, 204);
        Color  orange=new Color(255, 128, 0);
        frame.getContentPane().setBackground(lightyellow);


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        JButton b1=new JButton(". Doctor .");
        b1.setBounds(100,70, 200, 40);
        b1.setFont(f1);
        b1.setForeground(orange);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissDoctor();
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Nurse .");
        b2.setBounds(100,120, 200, 40);
        b2.setFont(f1);
        b2.setForeground(orange);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissNurse();
                frame.dispose();
            }
        });


        JButton b3=new JButton(". Secretary .");
        b3.setBounds(100,170, 200, 40);
        b3.setFont(f1);
        b3.setForeground(orange);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissSecretary();
                frame.dispose();
            }
        });


        JButton b4=new JButton(". Other Personnel .");
        b4.setBounds(100,220, 200, 40);
        b4.setFont(f1);
        b4.setForeground(orange);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissOtherPersonnel();
                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(orange);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(b1); frame.add(b2); frame.add(b3); frame.add(b4);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void DismissDoctor(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JTextField text = new JTextField();
        text.setBounds(140,125, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel(" National ID:  ");
        l1.setBounds(55,120, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JButton b = new JButton("Dismiss");
        b.setBounds(110,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<doctors.size();i++){

                    if(doctors.get(i).getNationalID().equals(text.getText())){
                        Database.DismissDoctor(doctors.get(i).getID());
                        doctors = Database.GetDoctor();


                        int x = JOptionPane.showConfirmDialog( frame," Dismissed ", " ", JOptionPane.OK_OPTION);

                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    DismissDoctor();
                    frame.dispose();
                }
                else {
                    // HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissPersonel();
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(b); frame.add(label);frame.add(l1); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void DismissNurse(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JTextField text = new JTextField();
        text.setBounds(140,125, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel(" National ID:  ");
        l1.setBounds(55,120, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JButton b = new JButton("Dismiss");
        b.setBounds(110,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<nurses.size();i++){

                    if(nurses.get(i).getNationalID().equals(text.getText())){
                        Database.DismissNurse(nurses.get(i).getID());
                        nurses = Database.GetNurse();


                        int x = JOptionPane.showConfirmDialog( frame," Dismissed ", " ", JOptionPane.OK_OPTION);

                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    DismissNurse();
                    frame.dispose();
                }
                else {
                    // HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissPersonel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b); frame.add(label);frame.add(l1); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void DismissSecretary(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JTextField text = new JTextField();
        text.setBounds(140,125, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel(" National ID:  ");
        l1.setBounds(55,120, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JButton b = new JButton("Dismiss");
        b.setBounds(110,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<secretaries.size();i++){

                    if(secretaries.get(i).getNationalID().equals(text.getText())){
                        Database.DismissSecretary(secretaries.get(i).getID());
                        secretaries = Database.GetSecretary();


                        int x = JOptionPane.showConfirmDialog( frame," Dismissed ", " ", JOptionPane.OK_OPTION);

                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    DismissSecretary();
                    frame.dispose();
                }
                else {
                    // HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissPersonel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b); frame.add(label);frame.add(l1); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void DismissOtherPersonnel(){

        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JTextField text = new JTextField();
        text.setBounds(140,125, 130,35);

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel(" National ID:  ");
        l1.setBounds(55,120, 150,40);
        l1.setFont(f1);
        l1.setForeground(green);

        JButton b = new JButton("Dismiss");
        b.setBounds(110,200, 150,40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0;i<personnels.size();i++){

                    if(personnels.get(i).getNationalID().equals(text.getText())){
                        Database.DismissPersonnel(personnels.get(i).getID());
                        personnels = Database.GetPersonnel();


                        int x = JOptionPane.showConfirmDialog( frame," Dismissed ", " ", JOptionPane.OK_OPTION);

                        frame.dispose();
                        return;
                    }
                }

                int x = JOptionPane.showConfirmDialog( frame, "Wrong NationalID \n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION){
                    DismissOtherPersonnel();
                    frame.dispose();
                }
                else {
                    // HomePage();
                    frame.dispose();
                    return;
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(green);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissOtherPersonnel();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b); frame.add(label);frame.add(l1); frame.add(b); frame.add(text);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    public void ShowPatient(){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[patients.size()];


        for(int i=0;i<patients.size();i++){
            name[i]=patients.get(i).getName();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<patients.size();i++){

            l1.addElement(name[i]);
        }


        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<patients.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowPatient(m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.setForeground(purple);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(list1);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void ShowPatient(String id){

        JFrame frame= new JFrame(" * patients * ");

        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);

        int ID=Integer.parseInt(id);
        JLabel l1=new JLabel(("Name : "+patients.get(ID-1).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("National ID : "+patients.get(ID-1).getNationalID());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l4=new JLabel("Age : "+patients.get(ID-1).getAge());
        l4.setBounds(30,110, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("PhoneNumber : "+patients.get(ID-1).getPhoneNumber());
        l5.setBounds(30,150, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Gender : "+patients.get(ID-1).getGender());
        l6.setBounds(30,190, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Address : "+patients.get(ID-1).getAddress());
        l7.setBounds(30,230, 350, 30);
        l7.setFont(f1);

        JLabel l8=new JLabel("Blood Type : "+patients.get(ID-1).getBloodType());
        l8.setBounds(30,270, 350, 30);
        l8.setFont(f1);

        JLabel l9=new JLabel("Body Condition : "+patients.get(ID-1).getBodyCondition());
        l9.setBounds(30,310, 350, 30);
        l9.setFont(f1);

        JLabel l10=new JLabel("Special Medicine : "+patients.get(ID-1).getSpMedicine());
        l10.setBounds(30,350, 350, 30);
        l10.setFont(f1);

        JLabel l11=new JLabel("Marital Status : "+patients.get(ID-1).getMaritalStatus());
        l11.setBounds(30,390, 350, 30);
        l11.setFont(f1);

        JLabel l12=new JLabel("Pregnancy Status : "+patients.get(ID-1).getPregnancyStatus());
        l12.setBounds(30,430, 350, 30);
        l12.setFont(f1);


        if(patients.get(ID-1).treatment.size()>0){
            JLabel l13=new JLabel("1. Illness : "+patients.get(ID-1).treatment.get(0).getIllness());
            l13.setBounds(30,470, 350, 30);
            l13.setFont(f1);
            frame.add(l13);

        }
        for(int j=1; j<patients.get(ID-1).treatment.size(); j++){
            if(patients.get(ID-1).treatment.get(j-1).getIllness().equals(patients.get(ID-1).treatment.get(j).getIllness())){

            }else{
                JLabel l14=new JLabel((j+1)+"Illness : "+patients.get(ID-1).treatment.get(j).getIllness());
                l14.setBounds(30,510, 350, 30);
                l14.setFont(f1);
                frame.add(l14);
            }
        }


        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowPatient();
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(l1);frame.add(l2);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);frame.add(l9);frame.add(l10);frame.add(l11);
        frame.add(l12);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public void ShowPatientDoctor(Doctor doctor){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[doctor.patient.size()];
        String[] illness=new String[doctor.patient.size()];

        for(int i=0; i<doctor.patient.size(); i++){
            for(int j=0; j<doctor.patient.get(i).treatment.size(); j++){
                if(doctor.patient.get(i).treatment.get(j).getDoctorID()==doctor.getID()){
                    Illness = doctor.patient.get(i).treatment.get(j).getIllness();
                    break;
                }
            }
            name[i]=doctor.patient.get(i).getName();
            illness[i]=Illness;
        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<doctor.patient.size();i++){

            l1.addElement(name[i]);
        }

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<doctor.patient.size();i++){

            l2.addElement(illness[i]);
        }
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<doctor.patient.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int ID=Integer.parseInt(m);
                    ShowPatientDoctor(doctor,ID-1,illness[ID-1]);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JLabel la3=new JLabel("  Illness  ");
        la3.setBounds(125,0, 150,40);
        la3.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JList<String> list2 = new JList<>(l2);
        list2.setBounds(130,30, 400,400);
        list2.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorLogin();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(la3);
        frame.add(list1);
        frame.add(list2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowPatientDoctor(Doctor doctor,int id,String illness){
        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JTextField text = new JTextField();
        text.setBounds(140,125, 130,35);

        Color blue=new Color(0, 0, 204);
        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);


        JLabel l1=new JLabel(("Name : "+doctor.patient.get(id).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("Gender : "+doctor.patient.get(id).getGender());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l8=new JLabel("Illness : "+illness);
        l8.setBounds(30,110, 350,30);
        l8.setFont(f1);

        JLabel l4=new JLabel("Age : "+doctor.patient.get(id).getAge());
        l4.setBounds(30,150, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("Blood Type : "+doctor.patient.get(id).getBloodType());
        l5.setBounds(30,190, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Body Condition : "+doctor.patient.get(id).getBodyCondition());
        l6.setBounds(30,230, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Special Medicine : "+doctor.patient.get(id).getSpMedicine());
        l7.setBounds(30,270, 350, 30);
        l7.setFont(f1);

        for(int i=0;i<doctor.patient.get(id).treatment.size(); i++){
            if(doctor.patient.get(id).treatment.get(i).getDoctorID()==doctor.getID()){
                JLabel l9=new JLabel("Visit Date : "+doctor.patient.get(id).treatment.get(i).getVisitDate());
                l9.setBounds(30,310, 350,30);
                l9.setFont(f1);
                JLabel l10=new JLabel("Medicine : "+doctor.patient.get(id).treatment.get(i).getMedicine());
                l10.setBounds(30,350, 350,30);
                l10.setFont(f1);
                JLabel l11=new JLabel("Description : "+doctor.patient.get(id).treatment.get(i).getDescription());
                l11.setBounds(30,390, 350,30);
                l11.setFont(f1);
                JLabel l12=new JLabel("TreatmentState : "+doctor.patient.get(id).treatment.get(i).isTreatmentState());
                l12.setBounds(30,430, 350,30);
                l12.setFont(f1);

                frame.add(l9);frame.add(l10);frame.add(l11);frame.add(l12);
            }
        }

        JButton b1=new JButton(". Dismiss Patient .");
        b1.setBounds(45,470, 150, 30);
        b1.setForeground(blue);
        b1.setFont(f1);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DismissPatient(doctor,doctor.patient.get(id),illness);
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Write Description .");
        b2.setBounds(200,470, 150, 30);
        b2.setForeground(blue);
        b2.setFont(f1);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                WriteDescription(doctor,doctor.patient.get(id),illness);
                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowPatientDoctor(doctor);
                frame.dispose();
            }
        });
        frame.add(back);



        frame.add(l1);frame.add(l2);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);frame.add(b1);frame.add(b2);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void DismissPatient(Doctor doctor,Patient patient,String Illness){
        JFrame frame=new JFrame();
        for(int i=0; i<patient.treatment.size(); i++){
            if(patient.treatment.get(i).getDoctorID()==doctor.getID() && patient.treatment.get(i).getIllness().equals(Illness)){
                Database.UpdateTreatment(patient.treatment.get(i).getID());
                treatments = Database.GetTreatment();
                patients = Database.GetPatient();
                System.out.println("Patient Dissmissed");
                int x = JOptionPane.showConfirmDialog( frame, "Patient Dissmissed", " ", JOptionPane.OK_OPTION);


            }
        }


    }

    public void WriteDescription(Doctor doctor,Patient patient,String Illness){

        JFrame frame=new JFrame();

        Color lightGreen=new Color(229, 255, 204);
        Color green =new Color(0, 102, 102);
        frame.getContentPane().setBackground(lightGreen);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel l1=new JLabel("Write Medicine : ");
        l1.setBounds(50,100, 150, 40);
        l1.setFont(f1);
        l1.setForeground(green);
        final JTextField text1 = new JTextField();
        text1.setBounds(170,105, 170, 35);


        JLabel l2=new JLabel("Write Description : ");
        l2.setBounds(50,150, 150, 40);
        l2.setFont(f1);
        l2.setForeground(green);
        final JTextField text2 = new JTextField();
        text2.setBounds(170,155, 170, 35);


        JButton b = new JButton("Add");
        b.setBounds(125,200, 150, 40);
        b.setFont(f1);
        b.setForeground(green);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                for(int i=0; i<patient.treatment.size(); i++){
                    if(patient.treatment.get(i).getDoctorID()==doctor.getID() && patient.treatment.get(i).getIllness().equals(Illness)){
                        Database.UpdateTreatment(patient.treatment.get(i).getID(),text1.getText(),text2.getText());
                        treatments = Database.GetTreatment();
                        patients = Database.GetPatient();
                    }
                }
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,630, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowPatientDoctor(doctor);
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(l1); frame.add(l2);
        frame.add(b);
        frame.setSize(400,700);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    public void PatientHomePage(Patient patient){
        JFrame frame = new JFrame();
        Color purple=new Color(154, 72, 134);
        Color lightpink=new Color(223, 185, 214);
        frame.getContentPane().setBackground(lightpink);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JButton b1=new JButton(". Show Doctors .");
        b1.setBounds(80,80, 170, 50);
        b1.setForeground(purple);
        b1.setFont(f1);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowDoctorsPatient(patient);
                frame.dispose();
            }
        });

        JButton b2=new JButton(". Show Appointment .");
        b2.setBounds(80,140, 170, 50);
        b2.setForeground(purple);
        b2.setFont(f1);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //;
                frame.dispose();
            }
        });

        JButton back=new JButton("<-");
        back.setBounds(20,280, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientPage();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(b1);frame.add(b2);
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowDoctorsPatient(Patient patient){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[doctors.size()];
        String[] speciality=new String[doctors.size()];


        for(int i=0;i<doctors.size();i++){
            name[i]=doctors.get(i).getName();
            speciality[i]=doctors.get(i).getSpeciality().toString();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<doctors.size();i++){

            l1.addElement(name[i]);
        }

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<doctors.size();i++){

            l2.addElement(speciality[i]);
        }
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;

        JButton b1 = new JButton();
        for(int i=0; i<doctors.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowDoctorsPatient(patient,m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JLabel la3=new JLabel("  Speciality  ");
        la3.setBounds(125,0, 150,40);
        la3.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JList<String> list2 = new JList<>(l2);
        list2.setBounds(130,30, 400,400);
        list2.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientHomePage(patient);
                frame.dispose();
            }
        });
        frame.add(back);
        frame.add(la1);
        frame.add(la2);
        frame.add(la3);
        frame.add(list1);
        frame.add(list2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void ShowDoctorsPatient(Patient patient,String id){
        JFrame frame= new JFrame(" * Appointment * ");

        Color lightblue=new Color(165, 207, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 14);
        Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 9);



        int ID=Integer.parseInt(id);
        JLabel l1=new JLabel(("Name : "+doctors.get(ID-1).getName()));
        l1.setBounds(20,20, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("Speciality : "+doctors.get(ID-1).getSpeciality());
        l2.setBounds(20,50, 350, 30);
        l2.setFont(f1);

        JLabel l3=new JLabel("Illness :  ");
        l3.setBounds(20,80, 80, 30);
        l3.setFont(f1);

        final JTextField text3 = new JTextField();
        text3.setBounds(80,85, 130, 25);

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

        cal.add(Calendar.DAY_OF_MONTH, 7);
        String dateAfter = sdf.format(cal.getTime());

        ArrayList<Treatment> treatment = new ArrayList<>();
        for(int k=0; k<treatments.size(); k++){
            if(treatments.get(k).getDoctorID() == doctors.get(ID-1).getID()){
                treatment.add(treatments.get(k));
            }
        }



        int i;
        for(i=0; i<treatment.size(); i++){
            if(Integer.parseInt(treatment.get(i).getVisitDate())==Integer.parseInt(date)){
                break;
            }
        }

        String x1="",x2="",x3="",x4="",x5="",x6="",x7="";
        x1+=x1;
        for(int j=i; j<treatment.size(); j++){

            if(GetDate(dateAfter)>=GetDate(treatment.get(j).getVisitDate())){


                String[] Pdate = new String[4];
                Pdate[0] = Character.toString(treatment.get(j).getVisitDate().charAt(0))+Character.toString(treatment.get(j).getVisitDate().charAt(1))
                        +Character.toString(treatment.get(j).getVisitDate().charAt(2))+Character.toString(treatment.get(j).getVisitDate().charAt(3));
                Pdate[1] = Character.toString(treatment.get(j).getVisitDate().charAt(4))+Character.toString(treatment.get(j).getVisitDate().charAt(5));
                Pdate[2] = Character.toString(treatment.get(j).getVisitDate().charAt(6))+Character.toString(treatment.get(j).getVisitDate().charAt(7));
                Pdate[3]= Character.toString(treatment.get(j).getVisitDate().charAt(8))+Character.toString(treatment.get(j).getVisitDate().charAt(9));
                String visdate = new String(Pdate[3]);



                int x=GetDay(date);

                switch((GetDay(treatment.get(j).getVisitDate())%x)+1){
                    case 1:
                        x1+=visdate+"   ";
                        break;
                    case 2:
                        x2+=visdate+"   ";
                        break;
                    case 3:
                        x3+=visdate+"   ";
                        break;
                    case 4:
                        x4+=visdate+"   ";
                        break;
                    case 5:
                        x5+=visdate+"   ";
                        break;
                    case 6:
                        x6+=visdate+"   ";
                        break;
                    case 7:
                        x7+=visdate+"   ";
                        break;
                }
            }else{
                break;
            }
        }
        JLabel l4=new JLabel(x1);
        l4.setBounds(100,100, 80, 20);
        l4.setFont(f1);
        JLabel l5=new JLabel(x2);
        l5.setBounds(100,120, 80, 20);
        l5.setFont(f1);
        JLabel l6=new JLabel(x3);
        l6.setBounds(100,140, 80, 20);
        l6.setFont(f1);
        JLabel l7=new JLabel(x4);
        l7.setBounds(100,160, 80, 20);
        l7.setFont(f1);
        JLabel l8=new JLabel(x5);
        l8.setBounds(100,160, 80, 20);
        l8.setFont(f1);
        JLabel l9=new JLabel(x6);
        l9.setBounds(100,160, 80, 20);
        l9.setFont(f1);
        JLabel l10=new JLabel(x7);
        l10.setBounds(100,160, 80, 20);
        l10.setFont(f1);

        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel();
        JPanel p6=new JPanel();
        JPanel p7=new JPanel();

        JTabbedPane tp=new JTabbedPane();
        tp.setBounds(90,130,200,200);
        String y1="",y2="",y3="",y4="",y5="",y6="",y7="";
        int x=GetDay(date);
        switch(x){
            case 1:
                tp.add("Sunday",p1);
                tp.add("Monday",p2);
                tp.add("Tuesday",p3);
                tp.add("Wednesday",p4);
                tp.add("Thursday",p5);
                tp.add("Friday",p6);
                tp.add("Saturday",p7);

                y1="Sunday";
                y2="Monday";
                y3="Tuesday";
                y4="Wednesday";
                y5="Thursday";
                y6="Friday";
                y7="Saturday";

                break;

            case 2:
                tp.add("Monday",p1);
                tp.add("Tuesday",p2);
                tp.add("Wednesday",p3);
                tp.add("Thursday",p4);
                tp.add("Friday",p5);
                tp.add("Saturday",p6);
                tp.add("Sunday",p7);

                y1="Monday";
                y2="Tuesday";
                y3="Wednesday";
                y4="Thursday";
                y5="Friday";
                y6="Saturday";
                y7="Sunday";

                break;

            case 3:
                tp.add("Tuesday",p1);
                tp.add("Wednesday",p2);
                tp.add("Thursday",p3);
                tp.add("Friday",p4);
                tp.add("Saturday",p5);
                tp.add("Sunday",p6);
                tp.add("Monday",p7);

                y1="Tuesday";
                y2="Wednesday";
                y3="Thursday";
                y4="Friday";
                y5="Saturday";
                y6="Sunday";
                y7="Monday";

                break;

            case 4:
                tp.add("Wednesday",p1);
                tp.add("Thursday",p2);
                tp.add("Friday",p3);
                tp.add("Saturday",p4);
                tp.add("Sunday",p5);
                tp.add("Monday",p6);
                tp.add("Tuesday",p7);

                y1="Wednesday";
                y2="Thursday";
                y3="Friday";
                y4="Saturday";
                y5="Sunday";
                y6="Monday";
                y7="Tuesday";

                break;

            case 5:
                tp.add("Thursday",p1);
                tp.add("Friday",p2);
                tp.add("Saturday",p3);
                tp.add("Sunday",p4);
                tp.add("Monday",p5);
                tp.add("Tuesday",p6);
                tp.add("Wednesday",p7);

                y1="Thursday";
                y2="Friday";
                y3="Saturday";
                y4="Sunday";
                y5="Monday";
                y6="Tuesday";
                y7="Wednesday";

                break;

            case 6:
                tp.add("Friday",p1);
                tp.add("Saturday",p2);
                tp.add("Sunday",p3);
                tp.add("Monday",p4);
                tp.add("Tuesday",p5);
                tp.add("Wednesday",p6);
                tp.add("Thursday",p7);

                y1="Friday";
                y2="Saturday";
                y3="Sunday";
                y4="Monday";
                y5="Tuesday";
                y6="Wednesday";
                y7="Thursday";

                break;

            case 7:
                tp.add("Saturday",p1);
                tp.add("Sunday",p2);
                tp.add("Monday",p3);
                tp.add("Tuesday",p4);
                tp.add("Wednesday",p5);
                tp.add("Thursday",p6);
                tp.add("Friday",p7);

                y1="Saturday";
                y2="Sunday";
                y3="Monday";
                y4="Tuesday";
                y5="Wednesday";
                y6="Thursday";
                y7="Friday";

                break;
        }
        JLabel l12=new JLabel("These Dates Are Already Reserved");
        l12.setBounds(110,110, 200, 20);
        l12.setFont(f2);


        JLabel k=new JLabel("Day : ");
        k.setBounds(90,340, 100, 20);
        k.setFont(f1);
        String Day[]={y1,y2,y3,y4,y5,y6,y7};
        final JComboBox cb1=new JComboBox(Day);
        cb1.setBounds(60, 370,120,20);


        JLabel k1=new JLabel("Hour : ");
        k1.setBounds(220,340, 100, 20);
        k1.setFont(f1);
        String Hour[]={"08-09","09-10","10-11","11-12","12-13","13-14","14-15","15-16"};
        final JComboBox cb2=new JComboBox(Hour);
        cb2.setBounds(190, 370,120,20);





        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowDoctorsPatient(patient);
                frame.dispose();
            }
        });

        String treatmentdate="";

        if(cb2.getSelectedItem().equals(y1)){
            LocalDateTime date2 = LocalDateTime.now();
            DateTimeFormatter Dateformat1 = DateTimeFormatter.ofPattern("yyyyMMdd");
            treatmentdate = date2.format(Dateformat1);

        }else if(cb2.getSelectedItem().equals(y2)){
            cal.add(Calendar.DAY_OF_MONTH, 1);
            treatmentdate = sdf.format(cal.getTime());

        }else if(cb2.getSelectedItem().equals(y3)){
            cal.add(Calendar.DAY_OF_MONTH, 2);
            treatmentdate = sdf.format(cal.getTime());

        }else if(cb2.getSelectedItem().equals(y4)){
            cal.add(Calendar.DAY_OF_MONTH, 3);
            treatmentdate = sdf.format(cal.getTime());

        }else if(cb2.getSelectedItem().equals(y5)){
            cal.add(Calendar.DAY_OF_MONTH, 4);
            treatmentdate = sdf.format(cal.getTime());

        }else if(cb2.getSelectedItem().equals(y6)){
            cal.add(Calendar.DAY_OF_MONTH, 5);
            treatmentdate = sdf.format(cal.getTime());

        }else{
            cal.add(Calendar.DAY_OF_MONTH, 6);
            treatmentdate = sdf.format(cal.getTime());

        }

        String treatmenthour="";

        if(cb2.getSelectedItem().equals("08-09")){
            treatmenthour="08";
        }else if(cb2.getSelectedItem().equals("09-10")){
            treatmenthour="09";
        }else if(cb2.getSelectedItem().equals("10-11")){
            treatmenthour="10";
        }else if(cb2.getSelectedItem().equals("11-12")){
            treatmenthour="11";
        }else if(cb2.getSelectedItem().equals("12-13")){
            treatmenthour="12";
        }else if(cb2.getSelectedItem().equals("13-14")){
            treatmenthour="13";
        }else if(cb2.getSelectedItem().equals("14-15")){
            treatmenthour="14";
        }else{
            treatmenthour="15";
        }

        String treatmentdatetime=treatmentdate+treatmenthour;

        for(int z=0; z<treatments.size();z++){
            if(treatmentdatetime.equals(treatments.get(z).getVisitDate())){
                int w = JOptionPane.showConfirmDialog( frame, "This Date Is Already Reserved\n Do You Want To Try Again?", " ", JOptionPane.YES_NO_OPTION);
                if (w==JOptionPane.YES_OPTION){
                    ShowDoctorsPatient(patient,id);
                    frame.dispose();
                    return;
                }
                else {
                    ShowDoctorsPatient(patient);
                    frame.dispose();
                    return;
                }
            }
        }

        JButton S=new JButton("Submit");
        S.setBounds(140,430, 100, 20);
        S.setFont(f1);
        S.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowNursePatient(doctors.get(ID-1),patient,text3.getText(),treatmentdatetime);
                frame.dispose();
            }
        });
        frame.add(S);

        frame.add(back);

        p1.add(l4);p1.add(l5);p1.add(l6);p1.add(l7);p1.add(l8);p1.add(l9);p1.add(l10);frame.add(l12);

        frame.add(tp);frame.add(l1);frame.add(l2);frame.add(l3);
        frame.add(text3);frame.add(k);frame.add(cb1);frame.add(cb2);frame.add(k1);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowNursePatient(Doctor doctor,Patient patient,String illness,String date){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[nurses.size()];

        for(int i=0; i<nurses.size(); i++){
            name[i]=nurses.get(i).getName();
        }

        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<nurses.size();i++){

            l1.addElement(name[i]);
        }

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;

        JButton b1 = new JButton();
        for(int i=0; i<nurses.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int ID=Integer.parseInt(m);
                    Database.AddTreatment(patient.getID(), doctor.getID(), nurses.get(ID-1).getID(), date, illness);
                    treatments = Database.GetTreatment();
                    patients = Database.GetPatient();
                    doctors = Database.GetDoctor();
                    nurses = Database.GetNurse();
                    int x = JOptionPane.showConfirmDialog( frame," Appointment Reserved ", " ", JOptionPane.OK_OPTION);
                    PatientHomePage(patient);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);

        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PatientHomePage(patient);
                frame.dispose();
            }
        });
        frame.add(back);
        frame.add(la1);
        frame.add(la2);
        frame.add(list1);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public void ShowPatientNurse(Nurse nurse){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[nurse.patient.size()];
        String[] illness=new String[nurse.patient.size()];

        for(int i=0; i<nurse.patient.size(); i++){
            for(int j=0; j<nurse.patient.get(i).treatment.size(); j++){
                if(nurse.patient.get(i).treatment.get(j).getNurseID()==nurse.getID()){
                    Illness = nurse.patient.get(i).treatment.get(j).getIllness();
                    break;
                }
            }
            name[i]=nurse.patient.get(i).getName();
            illness[i]=Illness;
        }

        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<nurse.patient.size();i++){

            l1.addElement(name[i]);
        }

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<nurse.patient.size();i++){

            l2.addElement(illness[i]);
        }
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<nurse.patient.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int ID=Integer.parseInt(m);
                    ShowPatientNurse(nurse,ID-1,illness[ID-1]);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JLabel la3=new JLabel("  Illness  ");
        la3.setBounds(125,0, 150,40);
        la3.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JList<String> list2 = new JList<>(l2);
        list2.setBounds(130,30, 400,400);
        list2.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NurseLogin();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(la3);
        frame.add(list1);
        frame.add(list2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void ShowPatientNurse(Nurse nurse,int id,String illness){
        JFrame frame=new JFrame();
        final JLabel label = new JLabel();
        label.setBounds(120,55, 130,35);
        final JTextField text = new JTextField();
        text.setBounds(140,125, 130,35);


        Color lightblue=new Color(204, 229, 255);
        frame.getContentPane().setBackground(lightblue);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);


        JLabel l1=new JLabel(("Name : "+nurse.patient.get(id).getName()));
        l1.setBounds(30,30, 350, 30);
        l1.setFont(f1);

        JLabel l2=new JLabel("Gender : "+nurse.patient.get(id).getGender());
        l2.setBounds(30,70, 350, 30);
        l2.setFont(f1);

        JLabel l8=new JLabel("Illness : "+illness);
        l8.setBounds(30,110, 350,30);
        l8.setFont(f1);

        JLabel l4=new JLabel("Age : "+nurse.patient.get(id).getAge());
        l4.setBounds(30,150, 350, 30);
        l4.setFont(f1);

        JLabel l5=new JLabel("Blood Type : "+nurse.patient.get(id).getBloodType());
        l5.setBounds(30,190, 350, 30);
        l5.setFont(f1);

        JLabel l6=new JLabel("Body Condition : "+nurse.patient.get(id).getBodyCondition());
        l6.setBounds(30,230, 350, 30);
        l6.setFont(f1);

        JLabel l7=new JLabel("Special Medicine : "+nurse.patient.get(id).getSpMedicine());
        l7.setBounds(30,270, 350, 30);
        l7.setFont(f1);

        for(int i=0;i<nurse.patient.get(id).treatment.size(); i++){
            if(nurse.patient.get(id).treatment.get(i).getNurseID()==nurse.getID()){
                JLabel l9=new JLabel("Visit Date : "+nurse.patient.get(id).treatment.get(i).getVisitDate());
                l9.setBounds(30,310, 350,30);
                l9.setFont(f1);
                JLabel l10=new JLabel("Medicine : "+nurse.patient.get(id).treatment.get(i).getMedicine());
                l10.setBounds(30,350, 350,30);
                l10.setFont(f1);
                JLabel l11=new JLabel("Description : "+nurse.patient.get(id).treatment.get(i).getDescription());
                l11.setBounds(30,390, 350,30);
                l11.setFont(f1);
                JLabel l12=new JLabel("TreatmentState : "+nurse.patient.get(id).treatment.get(i).isTreatmentState());
                l12.setBounds(30,430, 350,30);
                l12.setFont(f1);

                frame.add(l9);frame.add(l10);frame.add(l11);frame.add(l12);
            }
        }

        JButton back=new JButton("<-");
        back.setBounds(20,530, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ShowPatientNurse(nurse);
                frame.dispose();
            }
        });
        frame.add(back);

        frame.add(l1);frame.add(l2);frame.add(l4);frame.add(l5);frame.add(l6);
        frame.add(l7);frame.add(l8);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    public void DoctorListSecretary(){
        JFrame frame= new JFrame();
        Color purple=new Color(204, 195, 255);
        frame.getContentPane().setBackground(purple);

        String[] name=new String[doctors.size()];
        String[] speciality=new String[doctors.size()];


        for(int i=0;i<doctors.size();i++){
            name[i]=doctors.get(i).getName();
            speciality[i]=doctors.get(i).getSpeciality().toString();

        }



        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<doctors.size();i++){

            l1.addElement(name[i]);
        }

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<doctors.size();i++){

            l2.addElement(speciality[i]);
        }
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        int y=31;
        JButton b1 = new JButton();
        for(int i=0; i<doctors.size(); i++){
            Integer n=i+1;
            String m=n.toString();
            b1=new JButton(m);
            b1.setBounds(0,y, 20, 15);
            b1.setFont(f1);
            b1.setBackground(purple);
            y+=17;
            frame.add(b1);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ShowAppointentsSecretary(m);
                    frame.dispose();
                }
            });

        }



        JLabel la1=new JLabel("ID  ");
        la1.setBounds(0,0, 150,40);
        la1.setFont(f1);

        JLabel la2=new JLabel("  Name  ");
        la2.setBounds(20,0, 150,40);
        la2.setFont(f1);


        JLabel la3=new JLabel("  Speciality  ");
        la3.setBounds(125,0, 150,40);
        la3.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(30,30, 100,400);
        list1.setBackground(purple);

        JList<String> list2 = new JList<>(l2);
        list2.setBounds(130,30, 400,400);
        list2.setBackground(purple);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SecretaryLogin();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(la3);
        frame.add(list1);
        frame.add(list2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void ShowAppointentsSecretary(String id){
        int ID=Integer.parseInt(id);
        JFrame frame= new JFrame();
        Color blue=new Color(199, 250, 250);
        frame.getContentPane().setBackground(blue);

        ArrayList<Treatment> treatment = new ArrayList<>();
        for(int i=0; i<treatments.size(); i++){
            if(treatments.get(i).getDoctorID()==doctors.get(ID-1).getID()){
                treatment.add(treatments.get(i));
            }
        }

        String[] Patientname=new String[treatment.size()];
        String[] visdate=new String[treatment.size()];



        DefaultListModel<String> l1 = new DefaultListModel<>();

        for(int i=0;i<treatment.size();i++){
            String [] Pdate = new String[4];
            Pdate[0] = Character.toString(treatments.get(i).getVisitDate().charAt(0))+Character.toString(treatments.get(i).getVisitDate().charAt(1))
                    +Character.toString(treatments.get(i).getVisitDate().charAt(2))+Character.toString(treatments.get(i).getVisitDate().charAt(3));
            Pdate[1] = Character.toString(treatments.get(i).getVisitDate().charAt(4))+Character.toString(treatments.get(i).getVisitDate().charAt(5));
            Pdate[2] = Character.toString(treatments.get(i).getVisitDate().charAt(6))+Character.toString(treatments.get(i).getVisitDate().charAt(7));
            Pdate[3]= Character.toString(treatments.get(i).getVisitDate().charAt(8))+Character.toString(treatments.get(i).getVisitDate().charAt(9));

            visdate[i]=Pdate[0]+"/"+Pdate[1]+"/"+Pdate[2]+"    "+Pdate[3];

            l1.addElement(visdate[i]);

        }

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<treatment.size();i++){
            for(int j=0; j<patients.size(); j++){
                if(treatment.get(i).getPatientID()==patients.get(j).getID()){
                    Patientname[i]=patients.get(j).getName();
                    l2.addElement(Patientname[i]);
                }
            }

        }
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
        Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 18);

        JLabel la1=new JLabel(doctors.get(ID-1).getName());
        la1.setBounds(20,0, 150,40);
        la1.setFont(f2);

        JLabel la2=new JLabel("Date  ");
        la2.setBounds(20,30, 150,40);
        la2.setFont(f1);

        JLabel la4=new JLabel("Hour  ");
        la4.setBounds(110,30, 150,40);
        la4.setFont(f1);


        JLabel la3=new JLabel("Patient Name  ");
        la3.setBounds(200,30, 150,40);
        la3.setFont(f1);


        JList<String> list1 = new JList<>(l1);
        list1.setBounds(20,60, 400,400);
        list1.setBackground(blue);

        JList<String> list2 = new JList<>(l2);
        list2.setBounds(200,60, 400,400);
        list2.setBackground(blue);

        JButton back=new JButton("<-");
        back.setBounds(20,330, 70, 30);
        back.setFont(f1);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorListSecretary();
                frame.dispose();
            }
        });
        frame.add(back);


        frame.add(la1);
        frame.add(la2);
        frame.add(la3);
        frame.add(la4);
        frame.add(list1);
        frame.add(list2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }


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


}
 