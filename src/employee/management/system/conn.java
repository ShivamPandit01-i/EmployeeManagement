package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conn {
    public Connection connection;
    public Statement statement;

    public conn() {
        try {
            // Load MySQL JDBC Driver
            System.out.println("Trying to load driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");

            // Connect to database
            System.out.println("Trying to connect to database...");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement", // DB name
                    "root",      // MySQL username
                    "Admin@003"  // MySQL password
            );
            System.out.println("Database connected successfully!");

            // Create statement
            statement = connection.createStatement();
            System.out.println("Statement created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Database Connection Failed!\n" + e.getMessage());
        }
    }

    // Test main method
    public static void main(String[] args) {
        new conn();
    }
}
