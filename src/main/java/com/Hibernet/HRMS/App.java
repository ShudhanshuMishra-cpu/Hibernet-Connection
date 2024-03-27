package com.Hibernet.HRMS;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Hibernet.HRMS.Employee;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpUnit");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Press 1 to add data or 2 to delete data:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // Adding data
                System.out.println("Enter employee ID:");
                int id = sc.nextInt();
                sc.nextLine(); // Consume newline character
                System.out.println("Enter employee name:");
                String name = sc.nextLine();
                Employee employee = new Employee(id, name);

                em.getTransaction().begin();
                em.persist(employee);
                em.getTransaction().commit();

                System.out.println("Employee added successfully");
                break;
            case 2:
                // Deleting data
                System.out.println("Enter the ID of the employee to delete:");
                int deleteId = sc.nextInt();

                em.getTransaction().begin();
                Employee empToDelete = em.find(Employee.class, deleteId);

                if (empToDelete != null) {
                    em.remove(empToDelete);
                    System.out.println("Employee with ID " + deleteId + " deleted successfully");
                } else {
                    System.out.println("Employee not found with ID " + deleteId);
                }

                em.getTransaction().commit();
                break;
            default:
                System.out.println("Invalid choice");
        }

        em.close();
        emf.close();
        sc.close();
    }
}
