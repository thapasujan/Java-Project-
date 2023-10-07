package university_application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {

    private long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    UserRegistration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("User Registration");
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 130, 830, 400);
        setResizable(false);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(620, 80, 200, 200);
        add(image);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
        lblNewUserRegister.setBounds(100, 52, 400, 50);
        add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(20, 130, 110, 20);
        add(lblName);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        firstname.setBounds(140, 130, 150, 30);
        add(firstname);
        firstname.setColumns(10);

        JLabel lblNewLabel = new JLabel("Last name:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(20, 180, 110, 20);
        add(lblNewLabel);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lastname.setBounds(140, 180, 150, 30);
        add(lastname);
        lastname.setColumns(10);

        JLabel lblEmailAddress = new JLabel("Email:");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmailAddress.setBounds(20, 230, 110, 20);
        add(lblEmailAddress);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        email.setBounds(140, 230, 150, 30);
        add(email);
        email.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(320, 130, 110, 20);
        add(lblUsername);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        username.setBounds(440, 130, 150, 30);
        add(username);
        username.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(320, 180, 110, 20);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(440, 180, 150, 30);
        add(passwordField);

        JLabel lblMobileNumber = new JLabel("Phone:");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMobileNumber.setBounds(320, 230, 110, 20);
        add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        mob.setBounds(440, 230, 150, 30);
        add(mob);
        mob.setColumns(10);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                } else if (firstName == null || firstName.trim().isEmpty()
                        || lastName == null || lastName.trim().isEmpty()
                        || emailId == null || emailId.trim().isEmpty()
                        || userName == null || userName.trim().isEmpty()
                        || mobileNumber.trim().isEmpty()
                        || password == null || password.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (emailId.endsWith("@gmail.com")) {
                    try {
                        

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/University_Management_System", "root", "sujan123");

                        String query1 = "select * from account where email_id=?";
                        PreparedStatement verify = connection.prepareStatement(query1);
                        verify.setString(1, emailId);
                        ResultSet rs = verify.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {

                            String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','"
                                    + password + "','" + emailId + "','" + mobileNumber + "')";

                            Statement sta = connection.createStatement();
                            int x = sta.executeUpdate(query);
                            if (x == 0) {
                                JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                            } else {
                                JOptionPane.showMessageDialog(btnNewButton,
                                        "Welcome, " + msg + "Your account is sucessfully created");
                                setVisible(false);
                                new Login();
                            }
                        }

                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(230, 280, 150, 30);
        add(btnNewButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserRegistration();
    }
}
