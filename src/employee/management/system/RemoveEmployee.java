package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete, back;
    JLabel textName, textPhone, textemail;

    RemoveEmployee() {
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empId"));
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

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelemail);

        textemail = new JLabel();
        textemail.setBounds(200, 200, 150, 30);
        add(textemail);

        // Default details load
        loadEmployeeDetails(choiceEMPID.getSelectedItem());

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

        // Delete icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80, 200, 200);
        add(img);

        // Background image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        setSize(1000, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadEmployeeDetails(String empId) {
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId ='" + empId + "'");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                conn c = new conn();
                String query = "delete from employee where empId='" + choiceEMPID.getSelectedItem() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
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
        new RemoveEmployee();
    }
}
