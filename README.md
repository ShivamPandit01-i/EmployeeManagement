# Employee Management System

A **Java Swing** based **Desktop Application** for managing employee information efficiently. This system provides a user-friendly interface to **add, view, update, and remove employees** while maintaining a MySQL database.

---

## 🔹 Features

- **User Authentication:**  
  Secure login system with username and password.

- **Add Employee:**  
  Enter employee details like Name, Father's Name, Date of Birth, Salary, Address, Phone, Email, Education, Designation, and Aadhar.  
  Auto-generated Employee ID ensures unique records.

- **View Employee:**  
  Display all employees in a table with search functionality by Employee ID.  
  Print option available for reports.

- **Update Employee:**  
  Update employee details safely using Employee ID.  
  Ensures null-safe input handling and error prevention.

- **Remove Employee:**  
  Delete employee records securely from the database.  
  Confirmations and real-time updates included.

- **Back/Navigation Buttons:**  
  Smooth navigation between modules for enhanced user experience.

---

## 🔹 Technologies Used

- **Java** (JDK 1.8+)
- **Swing** for GUI
- **MySQL** for database management
- **JDBC** for database connectivity
- **JDateChooser** for selecting employee DOB
- **net.proteanit.sql.DbUtils** for displaying database tables in GUI

---

## 🔹 Database Setup

1. Create a MySQL database named `employeemanagement`.
2. Create a table for employee data:

```sql
CREATE TABLE employee (
    name VARCHAR(50),
    fname VARCHAR(50),
    dob VARCHAR(20),
    salary VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(50),
    education VARCHAR(20),
    designation VARCHAR(30),
    aadhar VARCHAR(20),
    empId VARCHAR(10) PRIMARY KEY
);
