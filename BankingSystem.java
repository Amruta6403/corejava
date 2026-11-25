
package corejava;

// BankAccount class
class BankAccount {

    // Static variable: common for all customers
    static String bankName = "ABC Bank";

    // Final variable: account number cannot be changed
    final int accountNumber;

    // Instance variables: separate for every customer
    String accountHolder;
    double balance;

    // Constructor to initialize account details
    BankAccount(String accountHolder, int accountNumber, double balance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method 1: Deposit amount only
    void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance = balance + amount;

            System.out.println("Deposit Successful: " + amount);
            System.out.println("Balance: " + balance);
        }
    }

    // Method 2: Deposit amount with transaction description
    void deposit(double amount, String description) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance = balance + amount;

            System.out.println("Deposit Successful: " + amount);
            System.out.println("Transaction: " + description);
            System.out.println("Balance: " + balance);
        }
    }

    // Method to display account details
    void displayDetails() {

        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        // Creating first customer account
        BankAccount account1 =
                new BankAccount("Rahul", 1001, 5000.0);

        // Creating second customer account
        BankAccount account2 =
                new BankAccount("Amit", 1002, 3000.0);

        // Displaying common bank name
        System.out.println("Bank: " + BankAccount.bankName);

        System.out.println();

        // Displaying Rahul's account details
        account1.displayDetails();

        System.out.println();

        // Depositing money with transaction description
        account1.deposit(2000.0, "Salary Credit");

        System.out.println();

        // Displaying Amit's account details
        account2.displayDetails();
    }
}
