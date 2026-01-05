package com.klu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class app {
 public static void main(String[] args) {

        // CREATE
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee e1 = new Employee("Alice", 60000, "Developer");
        Employee e2 = new Employee("Bob", 45000, "Tester");
        Employee e3 = new Employee("Charlie", 75000, "Manager");

        session.save(e1);
        session.save(e2);
        session.save(e3);

        tx.commit();
        session.close();
        System.out.println("Employees Inserted");

        // READ: Salary > 50,000
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list =
                session.createQuery(
                        "FROM Employee WHERE salary > 50000",
                        Employee.class).list();

        System.out.println("Employees with Salary > 50,000");
        for (Employee e : list) {
            System.out.println(e.getEmpName() + " " + e.getSalary());
        }

        // Average Salary
        Double avgSalary =
                session.createQuery(
                        "SELECT AVG(salary) FROM Employee",
                        Double.class).uniqueResult();

        System.out.println("Average Salary: " + avgSalary);

        session.close();
    }

}
