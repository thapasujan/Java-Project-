package university_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail, tfname, tname, tfx, tfxii, tfcitizenship;
    JLabel labelrollno;
    JButton submit, cancel;
    JComboBox cbcourse, cbbranch;
    Choice crollno;

    UpdateStudent() {
        
        setTitle("Update Student");
        setSize(900, 650);
        setLocation(250, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
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

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 15));
        add(lbldob);

        JLabel labeldob = new JLabel();
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

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(450, 300, 150, 30);
        lblx.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 200, 30);
        tfx.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 150, 30);
        lblxii.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 200, 30);
        tfxii.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfxii);

        JLabel lblctz = new JLabel("Citizenship Number");
        lblctz.setBounds(450, 350, 150, 30);
        lblctz.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblctz);

        tfcitizenship = new JTextField();
        tfcitizenship.setBounds(600, 350, 200, 30);
        add(tfcitizenship);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 150, 30);
        lblcourse.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblcourse);

        String course[] = {"B.Tech", "BBA", "BCA", "BIT", "BE", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 200, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(450, 400, 150, 30);
        lblbranch.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblbranch);

        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 200, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfx.setText(rs.getString("class_x"));
                tfxii.setText(rs.getString("class_xii"));
                tfcitizenship.setText(rs.getString("Ctz"));
                labelrollno.setText(rs.getString("rollno"));
                cbcourse.setSelectedItem(rs.getString("course"));
                cbbranch.setSelectedItem(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        tname.setText(rs.getString("name"));
                        tfname.setText(rs.getString("fname"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfx.setText(rs.getString("class_x"));
                        tfxii.setText(rs.getString("class_xii"));
                        tfcitizenship.setText(rs.getString("Ctz"));
                        labelrollno.setText(rs.getString("rollno"));
                        cbcourse.setSelectedItem(rs.getString("course"));
                        cbbranch.setSelectedItem(rs.getString("branch"));
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

            String rollno = labelrollno.getText();
            String name = tname.getText();
            String fname = tfname.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String Ctz = tfcitizenship.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            int len = phone.length();
            if (len != 10) {
                    JOptionPane.showMessageDialog(null, "Enter valid phone number (must contains 10 digits).", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (name == null || name.trim().isEmpty()
                    || fname == null || fname.trim().isEmpty()
                    || address == null || address.trim().isEmpty()
                    || phone.trim().isEmpty()
                    || email == null || email.trim().isEmpty()
                    || x == null || x.trim().isEmpty()
                    || xii == null || xii.trim().isEmpty()
                    || Ctz == null || Ctz.trim().isEmpty()
                    || course == null || course.trim().isEmpty()
                    || branch == null || branch.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if(email.endsWith("@gmail.com")){
                try {
                    String query = "update student set name='" + name + "',fname= '" + fname + "', address= '" + address + "',"
                            + "phone= '" + phone + "', email= '" + email + "', class_x= '" + x + "', class_xii= '" + xii + "', "
                            + "Ctz= '" + Ctz + "', course = '" + course + "', branch = '" + branch + "' where rollno = '" + rollno + "'";
                    Conn con = new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }

}
