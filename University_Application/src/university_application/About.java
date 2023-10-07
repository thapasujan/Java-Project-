package university_application;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        setTitle("About Section");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Developed By: Sujan, Raman & Anish");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(name);
        
        JLabel rollno = new JLabel("Symbol Numbers: 345342, 344938 & 344929");
        rollno.setBounds(70, 280, 550, 40);
        rollno.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        add(rollno);
        
        JLabel contact = new JLabel("Contact: bit2020@gmail.com");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(contact);
        
        setLayout(null);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new About();
    }
}