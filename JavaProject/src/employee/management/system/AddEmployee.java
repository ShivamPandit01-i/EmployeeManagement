package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfsalary, tfemail, tfphone;
    JButton submit, cancel;

    AddEmployee() {

        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE");
        heading.setBounds(300, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 100, 150, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 100, 200, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(50, 150, 150, 30);
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(200, 150, 200, 30);
        add(tffname);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(50, 200, 150, 30);
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 200, 200, 30);
        add(tfsalary);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 250, 150, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 250, 200, 30);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50, 300, 150, 30);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 300, 200, 30);
        add(tfphone);

        submit = new JButton("Submit");
        submit.setBounds(200, 360, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 360, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(700, 500);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            String name = tfname.getText();
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();


            if (name.equals("") || fname.equals("") || salary.equals("") ||
                    email.equals("") || phone.equals("")) {

                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }

            if (!salary.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Salary must be numeric");
                return;
            }

            try {
                conn c = new conn();

                String query =
                        "insert into employee(name, fname, salary, email, phone) values (?, ?, ?, ?, ?)";

                PreparedStatement ps = c.connection.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, fname);
                ps.setString(3, salary);
                ps.setString(4, email);
                ps.setString(5, phone);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database Error");
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
