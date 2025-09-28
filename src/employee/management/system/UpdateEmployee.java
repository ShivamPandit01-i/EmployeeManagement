package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfeducation, tfsalary, tfaddress, tfphone, tfemail, tfdesignation;
    JLabel lblEmpId, lblname, lbldob;
    JButton add, back;
    String number;

    UpdateEmployee(String number) {
        this.number = number;
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel lblname1 = new JLabel("Name");
        lblname1.setBounds(50, 150, 150, 30);
        add(lblname1);

        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 150, 30);
        add(lblfname);

        JLabel lblfname1 = new JLabel();
        lblfname1.setBounds(600, 150, 150, 30);
        add(lblfname1);

        JLabel lbldob1 = new JLabel("Date of Birth");
        lbldob1.setBounds(50, 200, 150, 30);
        add(lbldob1);

        lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(400, 200, 150, 30);
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 150, 30);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 150, 30);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 150, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lbleducation = new JLabel("Education");
        lbleducation.setBounds(400, 300, 150, 30);
        add(lbleducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);

        JLabel lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50, 350, 150, 30);
        add(lbldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        JLabel lblempId = new JLabel("Employee ID");
        lblempId.setBounds(400, 350, 150, 30);
        add(lblempId);

        lblEmpId = new JLabel();
        lblEmpId.setBounds(600, 350, 150, 30);
        add(lblEmpId);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId='" + number + "'");
            while (resultSet.next()) {
                lblname.setText(resultSet.getString("name"));
                lblfname1.setText(resultSet.getString("fname"));
                lbldob.setText(resultSet.getString("dob"));
                tfsalary.setText(resultSet.getString("salary"));
                tfaddress.setText(resultSet.getString("address"));
                tfphone.setText(resultSet.getString("phone"));
                tfemail.setText(resultSet.getString("email"));
                tfeducation.setText(resultSet.getString("education"));
                tfdesignation.setText(resultSet.getString("designation"));
                lblEmpId.setText(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250, 500, 150, 40);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 500, 150, 40);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String fname = lblname.getText();
            String dob = lbldob.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();

            try {
                conn c = new conn();
                String query = "UPDATE employee SET name=?, dob=?, salary=?, address=?, phone=?, email=?, education=?, designation=? WHERE empId=?";
                PreparedStatement ps = c.connection.prepareStatement(query);

                ps.setString(1, fname);
                ps.setString(2, dob);
                ps.setString(3, salary);
                ps.setString(4, address);
                ps.setString(5, phone);
                ps.setString(6, email);
                ps.setString(7, education);
                ps.setString(8, designation);
                ps.setString(9, number);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully");
                setVisible(false);
                new Main_Class();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("1"); // test with empId = 1
    }
}
