package university_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Forgot_Password extends JFrame implements ActionListener {

    JTextField tfemail, tfpassword;
    JButton Jsubmit;
    JLabel jemail, jpassword;

    Forgot_Password() {
        setTitle("Forgot Password");
        setSize(500, 250);
        setLocation(450, 300);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        jemail = new JLabel("Enter Email:");
        jemail.setBounds(50, 70, 80, 20);
        add(jemail);

        tfemail = new JTextField();
        tfemail.setBounds(150, 70, 200, 20);
        add(tfemail);

        jpassword = new JLabel("New Password:");
        jpassword.setBounds(50, 100, 120, 20);
        add(jpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 100, 200, 20);
        add(tfpassword);

        Jsubmit = new JButton("Change password");
        Jsubmit.setBounds(120, 150, 180, 30);
        Jsubmit.setBackground(Color.BLACK);
        Jsubmit.setForeground(Color.WHITE);
        Jsubmit.addActionListener(this);
        Jsubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Jsubmit);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Jsubmit) {
            String emailId = tfemail.getText();
            String password = tfpassword.getText();

            if (emailId == null || emailId.trim().isEmpty()
                    || password == null || password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill required field.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/University_Management_System", "root", "sujan123");

                    String query1 = "select * from account where email_id=?";
                    PreparedStatement verify = connection.prepareStatement(query1);
                    verify.setString(1, emailId);
                    ResultSet rs = verify.executeQuery();
                    if (rs.next()) {
                        String updatePasswordQuery = "UPDATE account SET password=? WHERE email_id=?";
                        PreparedStatement updatePasswordStatement = connection.prepareStatement(updatePasswordQuery);
                        updatePasswordStatement.setString(1, password);
                        updatePasswordStatement.setString(2, emailId);
                        int rowsAffected = updatePasswordStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            setVisible(false);
                            new Login();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to change password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Email doesn't exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Forgot_Password();
    }

}
