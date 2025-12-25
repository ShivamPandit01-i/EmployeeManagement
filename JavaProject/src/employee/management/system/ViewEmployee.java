package employee.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;

    ViewEmployee() {

        // Frame settings
        setSize(900, 700);
        setLayout(null);
        setLocationRelativeTo(null); // center window
        getContentPane().setBackground(new Color(255, 131, 122));

        // Search label
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        // Choice dropdown
        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT empId FROM employee");
            while (rs.next()) {
                choiceEMP.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        refreshTable();  // Show all employees initially

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        // Buttons
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    // ================= REFRESH TABLE =================
    private void refreshTable() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= BUTTON ACTIONS =================
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchbtn) {
            String empId = choiceEMP.getSelectedItem();
            if (empId == null || empId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID to search!");
                return;
            }

            try {
                conn c = new conn();
                PreparedStatement ps = c.connection.prepareStatement(
                        "SELECT * FROM employee WHERE empId=?"
                );
                ps.setString(1, empId);
                ResultSet rs = ps.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error during search!");
            }

        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error printing table!");
            }

        } else if (e.getSource() == update) {
            String empId = choiceEMP.getSelectedItem();
            if (empId == null || empId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID to update!");
                return;
            }
            setVisible(false);
            new UpdateEmployee(empId);

        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
