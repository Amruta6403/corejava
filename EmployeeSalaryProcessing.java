
package corejava;


import java.util.Scanner;

// Abstract parent class
abstract class Employee {

    String name;
    int employeeId;

    // Constructor
    Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Abstract method
    abstract double calculateSalary();

    // Common method to display details
    void displayDetails() {
        System.out.println("Employee: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + calculateSalary());
    }

    // Final method
    final void displayPolicy() {
        System.out.println(
            "Company policy: Standard employment policy applies."
        );
    }
}

// Permanent Employee class
class PermanentEmployee extends Employee {

    double basicSalary;
    double bonus;

    // Constructor
    PermanentEmployee(String name, int employeeId,
                      double basicSalary, double bonus) {

        super(name, employeeId);

        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    // Salary = Basic Salary + Bonus
    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }
}

// Contract Employee class
class ContractEmployee extends Employee {

    double hoursWorked;
    double hourlyRate;

    // Constructor
    ContractEmployee(String name, int employeeId,
                     double hoursWorked, double hourlyRate) {

        super(name, employeeId);

        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Salary = Hours Worked * Hourly Rate
    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main class
public class EmployeeSalaryProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Permanent employee input
        System.out.println("Enter Permanent Employee Details");

        System.out.print("Enter Name: ");
        String pName = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int pId = sc.nextInt();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();

        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();

        PermanentEmployee p = new PermanentEmployee(
            pName, pId, basicSalary, bonus
        );

        sc.nextLine();

        // Contract employee input
        System.out.println("\nEnter Contract Employee Details");

        System.out.print("Enter Name: ");
        String cName = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int cId = sc.nextInt();

        System.out.print("Enter Hours Worked: ");
        double hoursWorked = sc.nextDouble();

        System.out.print("Enter Hourly Rate: ");
        double hourlyRate = sc.nextDouble();

        ContractEmployee c = new ContractEmployee(
            cName, cId, hoursWorked, hourlyRate
        );

        // Display permanent employee details
        System.out.println("\n");
        p.displayDetails();
        p.displayPolicy();

        // Display contract employee details
        System.out.println();

        c.displayDetails();
        c.displayPolicy();

        sc.close();
    }
}
