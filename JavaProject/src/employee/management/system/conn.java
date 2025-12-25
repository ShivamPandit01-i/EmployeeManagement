package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conn {

    public Connection connection;
    public Statement statement;

    public conn() {   // ✅ constructor name fixed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement",
                    "root",
                    "Admin@003"
            );

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Database Connection Failed!\n" + e.getMessage());
        }
    }
}
