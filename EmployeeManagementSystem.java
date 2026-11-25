
package corejava;




// Parent class
class CompanyEmployee {

    String name;
    int id;
    double salary;

    CompanyEmployee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}

// Child class: Developer
class SoftwareDeveloper extends CompanyEmployee {

    double bonus;

    SoftwareDeveloper(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    double calculateSalary() {
        return salary + bonus;
    }

    void display() {
        System.out.println("Developer: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Child class: Manager
class CompanyManager extends CompanyEmployee {

    double allowance;

    CompanyManager(String name, int id, double salary, double allowance) {
        super(name, id, salary);
        this.allowance = allowance;
    }

    double calculateSalary() {
        return salary + allowance;
    }

    void display() {
        System.out.println("Manager: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        SoftwareDeveloper d =
                new SoftwareDeveloper("Rahul", 101, 50000, 15000);

        CompanyManager m =
                new CompanyManager("Amit", 102, 60000, 20000);

        d.display();

        System.out.println();

        m.display();
    }
}
