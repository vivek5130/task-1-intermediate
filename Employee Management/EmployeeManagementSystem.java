import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String designation;
    private String department;
    private double salary;

    public Employee(int id, String name, int age, String designation, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private static Map<Integer, Employee> employeeDatabase = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeDetails();
                    break;
                case 3:
                    updateEmployeeSalary();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    viewAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting Employee Management Application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 

        Employee newEmployee = new Employee(id, name, age, designation, department, salary);
        employeeDatabase.put(id, newEmployee);

        System.out.println("Employee added successfully.");
    }

    private static void viewEmployeeDetails() {
        System.out.print("Enter employee ID to view details: ");
        int id = scanner.nextInt();

        Employee employee = employeeDatabase.get(id);

        if (employee != null) {
            System.out.println("Employee details: " + employee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void updateEmployeeSalary() {
        System.out.print("Enter employee ID to update salary: ");
        int id = scanner.nextInt();

        Employee employee = employeeDatabase.get(id);

        if (employee != null) {
            System.out.print("Enter new salary: ");
            double newSalary = scanner.nextDouble();

            employee.setSalary(newSalary);

            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        Employee removedEmployee = employeeDatabase.remove(id);

        if (removedEmployee != null) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void viewAllEmployees() {
        if (employeeDatabase.isEmpty()) {
            System.out.println("No employees in the database.");
        } else {
            System.out.println("List of all employees:");
            for (Employee employee : employeeDatabase.values()) {
                System.out.println(employee);
            }
        }
    }
}
