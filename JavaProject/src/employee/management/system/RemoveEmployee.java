package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEMPID;
    JButton delete, back;
    JLabel textName, textPhone, textEmail;

    RemoveEmployee() {

        setLayout(null);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT empId FROM employee");
            while (rs.next()) {
                choiceEMPID.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        textName = new JLabel();
        textName.setBounds(200, 100, 150, 30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhone);

        textPhone = new JLabel();
        textPhone.setBounds(200, 150, 150, 30);
        add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelEmail);

        textEmail = new JLabel();
        textEmail.setBounds(200, 200, 150, 30);
        add(textEmail);

        // Load default details
        if (choiceEMPID.getItemCount() > 0) {
            loadEmployeeDetails(choiceEMPID.getSelectedItem());
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadEmployeeDetails(choiceEMPID.getSelectedItem());
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Delete image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80, 200, 200);
        add(img);

        // Background
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        setSize(1000, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ================= LOAD EMPLOYEE DETAILS =================
    private void loadEmployeeDetails(String empId) {
        try {
            if (empId == null || empId.isEmpty()) return;

            conn c = new conn();
            PreparedStatement ps = c.connection.prepareStatement(
                    "SELECT name, phone, email FROM employee WHERE empId=?"
            );
            ps.setString(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textPhone.setText(rs.getString("phone"));
                textEmail.setText(rs.getString("email"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ================= BUTTON ACTIONS =================
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == delete) {
            String empId = choiceEMPID.getSelectedItem();
            if (empId == null || empId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID to delete!");
                return;
            }

            try {
                conn c = new conn();
                PreparedStatement ps = c.connection.prepareStatement(
                        "DELETE FROM employee WHERE empId=?"
                );
                ps.setString(1, empId);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Main_Class();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting employee!");
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
