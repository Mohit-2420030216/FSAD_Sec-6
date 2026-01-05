package com.klu;
import javax.persistence.*;
@Entity
@Table(name = "employee")

public class Employee {
   @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int empId;

     private String empName;
     private double salary;
     private String designation;

     public Employee() {}

     public Employee(String empName, double salary, String designation) {
         this.empName = empName;
         this.salary = salary;
         this.designation = designation;
     }

     // Getters and Setters
     public int getEmpId() { return empId; }
     public void setEmpId(int empId) { this.empId = empId; }

     public String getEmpName() { return empName; }
     public void setEmpName(String empName) { this.empName = empName; }

     public double getSalary() { return salary; }
     public void setSalary(double salary) { this.salary = salary; }

     public String getDesignation() { return designation; }
     public void setDesignation(String designation) { this.designation = designation; }
 }

