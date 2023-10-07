package university_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail, tfname, tname, tfcitizenship;
    JLabel labelempid, labeldob;
    JButton submit, cancel;
    JComboBox cbqualification, cbfaculty;
    Choice cEmpid;

    UpdateTeacher() {

        setTitle("Update Teacher");
        setSize(900, 650);
        setLocation(250, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        labelempid = new JLabel("Select Employee id");
        labelempid.setBounds(50, 100, 200, 20);
        labelempid.setFont(new Font("serif", Font.PLAIN, 15));
        add(labelempid);

        cEmpid = new Choice();
        cEmpid.setBounds(250, 100, 200, 20);
        add(cEmpid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                cEmpid.add(rs.getString("Empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblname);

        tname = new JTextField();
        tname.setBounds(200, 150, 200, 30);
        tname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblfname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 200, 30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 150, 30);
        lblrollno.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblrollno);

        labelempid = new JLabel();
        labelempid.setBounds(200, 200, 200, 30);
        labelempid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelempid);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 200, 200, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(450, 250, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 200, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 200, 30);
        add(tfemail);

        JLabel lblctz = new JLabel("Citizenship Number");
        lblctz.setBounds(450, 300, 150, 30);
        lblctz.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblctz);

        tfcitizenship = new JTextField();
        tfcitizenship.setBounds(600, 300, 200, 30);
        add(tfcitizenship);

        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 350, 150, 30);
        lblqualification.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblqualification);

        String qualification[] = {"B.Tech", "BBA", "BCA", "BIT", "BE", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(200, 350, 200, 30);
        cbqualification.setBackground(Color.WHITE);
        add(cbqualification);

        JLabel lblfaculty = new JLabel("Faculty");
        lblfaculty.setBounds(450, 350, 200, 30);
        lblfaculty.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblfaculty);

        String faculty[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbfaculty = new JComboBox(faculty);
        cbfaculty.setBounds(600, 350, 200, 30);
        cbfaculty.setBackground(Color.WHITE);
        add(cbfaculty);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where Empid='" + cEmpid.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfcitizenship.setText(rs.getString("Ctz"));
                labelempid.setText(rs.getString("Empid"));
                cbqualification.setSelectedItem(rs.getString("qualification"));
                cbfaculty.setSelectedItem(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where Empid='" + cEmpid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        tname.setText(rs.getString("name"));
                        tfname.setText(rs.getString("fname"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfcitizenship.setText(rs.getString("Ctz"));
                        labelempid.setText(rs.getString("Empid"));
                        cbqualification.setSelectedItem(rs.getString("qualification"));
                        cbfaculty.setSelectedItem(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
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

            String Empid = labelempid.getText();
            String name = tname.getText();
            String fname = tfname.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String Ctz = tfcitizenship.getText();
            String qualification = (String) cbqualification.getSelectedItem();
            String branch = (String) cbfaculty.getSelectedItem();
            
            int len = phone.length();
            if (len != 10) {
                    JOptionPane.showMessageDialog(null, "Enter valid phone number (must contains 10 digits).", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (name == null || name.trim().isEmpty()
                    || fname == null || fname.trim().isEmpty()
                    || Empid == null || Empid.trim().isEmpty()
                    || address == null || address.trim().isEmpty()
                    || phone.trim().isEmpty()
                    || email == null || email.trim().isEmpty()
                    || Ctz == null || Ctz.trim().isEmpty()
                    || qualification == null || qualification.trim().isEmpty()
                    || branch == null || branch.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (email.endsWith("@gmail.com")) {

                try {
                    String query = "update teacher set name='" + name + "',fname= '" + fname + "', address= '" + address + "',"
                            + "phone= '" + phone + "', email= '" + email + "' , "
                            + "Ctz= '" + Ctz + "', qualification = '" + qualification + "', branch = '" + branch + "' where Empid = '" + Empid + "'";
                    Conn con = new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "teacher Details Updated Successfully");
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
        new UpdateTeacher();
    }

}
