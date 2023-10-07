
package university_application;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///University_Management_System", "root", "sujan123");
            s = c.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException a){
            a.printStackTrace();
        }
    }

    ResultSet executeQuery(String select__from_student) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
