package corejava;


import java.util.Scanner;

// ATM class
class ATMAccount {

    double balance = 10000.0;

    void withdraw(double amount) {

        try {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                    "Withdrawal amount must be positive."
                );
            }

            if (amount > balance) {
                throw new IllegalArgumentException(
                    "Insufficient balance."
                );
            }

            balance = balance - amount;

            System.out.println("Withdrawal successful: Rs. " + amount);
            System.out.println("Remaining balance: Rs. " + balance);

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println("Transaction process completed.");
            System.out.println();
        }
    }
}

// Main class
public class ATMWithdrawalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATMAccount account = new ATMAccount();

        System.out.println("Welcome to ATM");
        System.out.println("Initial Balance: Rs. " + account.balance);

        // First withdrawal
        System.out.print("\nEnter amount to withdraw: Rs. ");
        double amount1 = sc.nextDouble();
        account.withdraw(amount1);

        // Second withdrawal
        System.out.print("Enter amount to withdraw: Rs. ");
        double amount2 = sc.nextDouble();
        account.withdraw(amount2);

        // Third withdrawal
        System.out.print("Enter amount to withdraw: Rs. ");
        double amount3 = sc.nextDouble();
        account.withdraw(amount3);

        sc.close();
    }
}
