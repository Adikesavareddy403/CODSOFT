package Stringg;
import java.util.Scanner;

class BankAccount {
    private double balance;   // Balance = 0

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            System.out.println("Please Check Your Balance!");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("WELCOME TO ATM MENU:");
        System.out.println("Please Select Which Operation You Need To Perform!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice to proceed: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Thank you!");
                    System.out.println("Visit Again!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option among below.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Current balance: $" + balance);
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
        scanner.close();
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            if (account.withdraw(amount)) {
                System.out.println("Please take your cash.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
        scanner.close();
    }
}

public class atmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(0); // Initial balance of $0
        ATM atm = new ATM(userAccount);

        atm.run();
        System.out.println();
        
    }
        
}
