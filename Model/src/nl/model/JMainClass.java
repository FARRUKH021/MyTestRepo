package nl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JMainClass {
    public JMainClass() {
        super();
    }

    public static void main(String[] args) {
        JMainClass jMainClass = new JMainClass();
        Connection conn = null;
        try {
            ResultSet rs = null;
            Statement statement = null;
            conn = initializeDatabase();
            statement = conn.createStatement();
            System.out.println("hello");
            rs = statement.executeQuery("select count(1) from tab");
            rs.next();
            System.out.println(rs.getInt(1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected static Connection initializeDatabase() 
                throws SQLException, ClassNotFoundException 
            { 
                // Initialize all the information regarding 
                // Database Connection 
                String dbURL = "jdbc:oracle:thin:@localhost:1521/ELEVENG";
                           String strUserID = "SCOTT";
                           String strPassword = "TIGER";
                Class.forName("oracle.jdbc.driver.OracleDriver"); 
                //Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(dbURL , 
                                                             strUserID,  
                                                             strPassword); 
                return con; 
            } 
}
