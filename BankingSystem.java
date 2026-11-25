
package corejava;

import java.util.Scanner;

// BankAccount class
class BankAccount {

    // Common bank name
    static String bankName = "ABC Bank";

    // Account number cannot be changed
    final int accountNumber;

    // Individual account details
    String accountHolder;
    double balance;

    // Constructor
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

    // Method 2: Deposit amount with description
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

    // Display account details
    void displayDetails() {

        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display common bank name
        System.out.println("Bank: " + BankAccount.bankName);

        // First customer account
        System.out.print("Enter first account holder name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first account number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter first account balance: ");
        double balance1 = sc.nextDouble();

        BankAccount account1 =
                new BankAccount(name1, number1, balance1);

        sc.nextLine();

        // Second customer account
        System.out.print("\nEnter second account holder name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second account number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter second account balance: ");
        double balance2 = sc.nextDouble();

        BankAccount account2 =
                new BankAccount(name2, number2, balance2);

        // Display first account details
        System.out.println("\n" + "Account Details:");
        account1.displayDetails();

        // Deposit with transaction description
        System.out.print("\nEnter deposit amount for first account: ");
        double amount1 = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter transaction description: ");
        String description = sc.nextLine();

        account1.deposit(amount1, description);

        // Display second account details
        System.out.println("\nAccount Details:");
        account2.displayDetails();

        sc.close();
    }
}
