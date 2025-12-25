package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Main_Class extends JFrame {

    Main_Class() {
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 400, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        // Add Employee button
        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmployee();
            }
        });
        img.add(add);

        // View Employee button
        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee();
            }
        });
        img.add(view);

        // Remove Employee button
        JButton rem = new JButton("Remove Employee");
        rem.setBounds(335, 370, 150, 40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();
            }
        });
        img.add(rem);

        // Update Employee button
        JButton update = new JButton("Update Employee");
        update.setBounds(565, 370, 150, 40);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Ask user for employee ID first
                    String empId = JOptionPane.showInputDialog(null, "Enter Employee ID to update:");
                    if (empId != null && !empId.trim().isEmpty()) {
                        setVisible(false);
                        new UpdateEmployee(empId.trim()); // Pass empId to UpdateEmployee
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error opening Update Employee!");
                }
            }
        });
        img.add(update);

        // Back button
        JButton back = new JButton("Back");
        back.setBounds(450, 470, 150, 40);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login(); // Go back to login window
            }
        });
        img.add(back);

        // JFrame settings
        setSize(1120, 630);
        setLayout(null);
        setLocationRelativeTo(null); // Center window on screen
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main_Class();
    }
}
