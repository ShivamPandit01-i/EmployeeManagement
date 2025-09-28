package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.Font.BOLD;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, temail, tsalary, tdesignation, taadhar;
    JDateChooser tdob;
    JLabel tempid;
    JButton addButton, backButton;
    JComboBox Boxeducation;

    AddEmployee() {
        getContentPane().setBackground(new Color(163, 255, 188));
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setFont(new Font("serif", BOLD, 25));
        heading.setBounds(250, 30, 400, 30);
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 150, 30);
        name.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 100, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        // Father's Name
        JLabel fnameLabel = new JLabel("Father's Name");
        fnameLabel.setBounds(400, 100, 150, 30);
        fnameLabel.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(fnameLabel);

        tfname = new JTextField();
        tfname.setBounds(600, 100, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        // DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 150, 150, 30);
        dob.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 150, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        // Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        // Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 200, 30);
        education.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(education);

        String items[] = {"BBA", "B.TECH", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTECH", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177, 252, 197));
        Boxeducation.setBounds(600, 300, 150, 30);
        add(Boxeducation);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        // Aadhar
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        // EmployeeId
        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // Buttons
        backButton = new JButton("BACK");
        backButton.setBounds(250, 550, 150, 40);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.addActionListener(this);
        add(backButton);

        addButton = new JButton("ADD");
        addButton.setBounds(450, 550, 150, 40);
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);
        addButton.addActionListener(this);
        add(addButton);

        setSize(900, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empid = tempid.getText();

            try {
                conn c = new conn();
                String query = "INSERT INTO employee VALUES('"
                        + name + "','"
                        + fname + "','"
                        + dob + "','"
                        + salary + "','"
                        + address + "','"
                        + phone + "','"
                        + email + "','"
                        + education + "','"
                        + designation + "','"
                        + aadhar + "','"
                        + empid + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_Class();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Main_Class(); // go back to main menu
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
