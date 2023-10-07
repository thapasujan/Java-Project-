package university_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel, registerUser, forgotPass;
    JTextField tfusername, tfpassword;

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setTitle("Login Page");
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 140, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        registerUser = new JButton("RegisterUser");
        registerUser.setBounds(40,200, 150, 30);    
        registerUser.setBackground(Color.BLACK);
        registerUser.setForeground(Color.WHITE);
        registerUser.addActionListener(this);
        registerUser.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(registerUser);
        
        forgotPass = new JButton("Forgot Password");
        forgotPass.setBounds(200,200, 170, 30);    
        forgotPass.setBackground(Color.BLACK);
        forgotPass.setForeground(Color.WHITE);
        forgotPass.addActionListener(this);
        forgotPass.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(forgotPass);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==forgotPass){
            setVisible(false);
            new Forgot_Password();
        }
        if (ae.getSource() == registerUser) {
            setVisible(false);
            new UserRegistration();
        } else if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            if (username == null || username.trim().isEmpty()
                    || password == null || password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username & Password are required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String query = "select * from account where user_name='" + username + "' and password='" + password + "'";

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                    if (rs.next()) {
                        setVisible(false);
                        new Project();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password try again");
                        //setVisible(false);
                    }
                    c.s.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
