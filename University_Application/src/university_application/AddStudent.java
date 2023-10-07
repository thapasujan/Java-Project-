package university_application;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudent extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfcitizenship;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(900, 650);
        setTitle("Add Student");
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
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

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 170, 150, 30);
        lblrollno.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblrollno);

        labelrollno = new JLabel("1533" + first4);
        labelrollno.setBounds(200, 170, 150, 30);
        labelrollno.setFont(new Font("serif", Font.PLAIN, 15));
        add(labelrollno);

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

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(440, 270, 150, 30);
        lblx.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 270, 150, 30);
        add(tfx);

        JLabel lblctz = new JLabel("Citizenship Number");
        lblctz.setBounds(50, 320, 150, 30);
        lblctz.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblctz);

        tfcitizenship = new JTextField();
        tfcitizenship.setBounds(200, 320, 150, 30);
        add(tfcitizenship);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(440, 320, 150, 30);
        lblxii.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(600, 320, 150, 30);
        add(tfxii);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 370, 150, 30);
        lblcourse.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblcourse);

        String course[] = {"B.Tech", "BBA", "BCA", "BIT", "BE", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 370, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(440, 370, 150, 30);
        lblbranch.setFont(new Font("serif", Font.PLAIN, 15));
        add(lblbranch);

        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 370, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

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
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
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
                    || dob == null || dob.trim().isEmpty()
                    || rollno == null || rollno.trim().isEmpty()
                    || email == null || email.trim().isEmpty()
                    || address == null || address.trim().isEmpty()
                    || phone.trim().isEmpty()
                    || x == null || x.trim().isEmpty()
                    || xii == null || xii.trim().isEmpty()
                    || Ctz == null || Ctz.trim().isEmpty()
                    || course == null || course.trim().isEmpty()
                    || branch == null || branch.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (email.endsWith("@gmail.com")) {
                try {
                    String query = "insert into student values('" + name + "', '" + fname + "', '" + rollno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + Ctz + "', '" + course + "', '" + branch + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
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
        new AddStudent();
    }

}
