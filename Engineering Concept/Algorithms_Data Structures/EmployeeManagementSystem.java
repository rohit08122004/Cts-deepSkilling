import java.util.Scanner;

public class EmployeeManagementSystem {

    // Employee class
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String toString() {
            return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
        }
    }

    // Manager class using array to store employees
    static class EmployeeManager {
        private Employee[] employees;
        private int count;

        public EmployeeManager(int size) {
            employees = new Employee[size];
            count = 0;
        }

        // Add employee
        public void addEmployee(Employee emp) {
            if (count >= employees.length) {
                System.out.println("Employee list is full.");
                return;
            }
            employees[count++] = emp;
            System.out.println("Employee added successfully.");
        }

        // Search by employee ID
        public Employee searchEmployee(int id) {
            for (int i = 0; i < count; i++) {
                if (employees[i].employeeId == id) {
                    return employees[i];
                }
            }
            return null;
        }

        // Traverse and display all employees
        public void traverseEmployees() {
            if (count == 0) {
                System.out.println("No employees to display.");
                return;
            }
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }

        // Delete employee by ID
        public void deleteEmployee(int id) {
            for (int i = 0; i < count; i++) {
                if (employees[i].employeeId == id) {
                    for (int j = i; j < count - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[--count] = null;
                    System.out.println("Employee deleted successfully.");
                    return;
                }
            }
            System.out.println("Employee not found.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager(100); // Max 100 employees
        boolean running = true;

        while (running) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    manager.addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee found = manager.searchEmployee(searchId);
                    System.out.println(found != null ? found : "Employee not found.");
                    break;

                case 3:
                    System.out.println("All Employees:");
                    manager.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteEmployee(deleteId);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Employee Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
