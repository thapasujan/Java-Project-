/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university_application;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfcitizenship;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbqualification, cbfaculty;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(900, 650);
        setTitle("Add Teacher");
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(250, 50, 300, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 120, 100, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 120, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(440, 120, 150, 30);
        lblfname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 120, 150, 30);
        add(tffname);

        labelempId = new JLabel(" Employee ID");
        labelempId.setBounds(50, 170, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 15));
        add(labelempId);

        labelempId = new JLabel("1533" + first4);
        labelempId.setBounds(200, 170, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 15));
        add(labelempId);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(440, 170, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 170, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 220, 150, 30);
        lbladdress.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 220, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(440, 220, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 220, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 270, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 270, 150, 30);
        add(tfemail);

        JLabel lblctz = new JLabel("Citizenship Number");
        lblctz.setBounds(440, 270, 150, 30);
        lblctz.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblctz);

        tfcitizenship = new JTextField();
        tfcitizenship.setBounds(600, 270, 150, 30);
        add(tfcitizenship);

        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 320, 150, 30);
        lblqualification.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblqualification);

        String qualification[] = {"Bachelors", "Masters", "M.Phil", "PHD"};
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(200, 320, 150, 30);
        cbqualification.setBackground(Color.WHITE);
        add(cbqualification);

        JLabel lblfaculty = new JLabel("Faculty");
        lblfaculty.setBounds(440, 320, 150, 30);
        lblfaculty.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblfaculty);

        String faculty[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbfaculty = new JComboBox(faculty);
        cbfaculty.setBounds(600, 320, 150, 30);
        cbfaculty.setBackground(Color.WHITE);
        add(cbfaculty);

        submit = new JButton("Submit");
        submit.setBounds(280, 450, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(430, 450, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String Empid = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String Ctz = tfcitizenship.getText();
            String qualification = (String) cbqualification.getSelectedItem();
            String faculty = (String) cbfaculty.getSelectedItem();
            
            int len = phone.length();
            if (len != 10) {
                    JOptionPane.showMessageDialog(null, "Enter valid phone number (must contains 10 digits).", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (name == null || name.trim().isEmpty()
                    || fname == null || fname.trim().isEmpty()
                    || dob == null || dob.trim().isEmpty()
                    || Empid == null || Empid.trim().isEmpty()
                    || address == null || address.trim().isEmpty()
                    || phone.trim().isEmpty()
                    || email == null || email.trim().isEmpty()
                    || Ctz == null || Ctz.trim().isEmpty()
                    || qualification == null || qualification.trim().isEmpty()
                    || faculty == null || faculty.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (email.endsWith("@gmail.com")) {
                try {
                    String query = "insert into teacher values('" + name + "', '" + fname + "', '" + Empid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + Ctz + "', '" + qualification + "', '" + faculty + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
