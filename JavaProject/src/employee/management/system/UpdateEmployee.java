package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfsalary, tfaddress, tfphone, tfemail, tfeducation, tfdesignation;
    JLabel lblname, lblfname, lbldob, lblEmpId;
    JButton updateBtn, backBtn;

    String empId;   // store employee id

    // ================= ORIGINAL CONSTRUCTOR (UNCHANGED LOGIC) =================
    UpdateEmployee() {

        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel lblNameLabel = new JLabel("Name");
        lblNameLabel.setBounds(50, 150, 150, 30);
        add(lblNameLabel);

        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel lblFnameLabel = new JLabel("Father's Name");
        lblFnameLabel.setBounds(400, 150, 150, 30);
        add(lblFnameLabel);

        lblfname = new JLabel();
        lblfname.setBounds(600, 150, 150, 30);
        add(lblfname);

        JLabel lblDobLabel = new JLabel("Date of Birth");
        lblDobLabel.setBounds(50, 200, 150, 30);
        add(lblDobLabel);

        lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setBounds(400, 200, 150, 30);
        add(lblSalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(50, 250, 150, 30);
        add(lblAddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(400, 250, 150, 30);
        add(lblPhone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 300, 150, 30);
        add(lblEmail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblEducation = new JLabel("Education");
        lblEducation.setBounds(400, 300, 150, 30);
        add(lblEducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);

        JLabel lblDesignation = new JLabel("Designation");
        lblDesignation.setBounds(50, 350, 150, 30);
        add(lblDesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        JLabel lblEmpIdLabel = new JLabel("Employee ID");
        lblEmpIdLabel.setBounds(400, 350, 150, 30);
        add(lblEmpIdLabel);

        lblEmpId = new JLabel();
        lblEmpId.setBounds(600, 350, 150, 30);
        add(lblEmpId);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(250, 500, 150, 40);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(450, 500, 150, 40);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ================= NEW CONSTRUCTOR (ERROR FIX) =================
    UpdateEmployee(String empId) {
        this();            // call original constructor
        this.empId = empId;
        loadEmployeeData(empId);
    }

    // ================= LOAD EMPLOYEE DATA =================
    private void loadEmployeeData(String empId) {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(
                    "SELECT * FROM employee WHERE empId='" + empId + "'"
            );

            if (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                lblEmpId.setText(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= BUTTON ACTIONS =================
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == updateBtn) {
            try {
                conn c = new conn();
                String query = "UPDATE employee SET salary=?, address=?, phone=?, email=?, education=?, designation=? WHERE empId=?";
                PreparedStatement ps = c.connection.prepareStatement(query);

                ps.setString(1, tfsalary.getText());
                ps.setString(2, tfaddress.getText());
                ps.setString(3, tfphone.getText());
                ps.setString(4, tfemail.getText());
                ps.setString(5, tfeducation.getText());
                ps.setString(6, tfdesignation.getText());
                ps.setString(7, empId);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
                setVisible(false);
                new Main_Class();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("101"); // testing
    }
}
