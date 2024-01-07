package Demo;

import java.util.Scanner;

// BankAccount class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

// ATM class representing the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + userAccount.getBalance());
    }

    private void deposit(double amount) {
        userAccount.deposit(amount);
    }

    private void withdraw(double amount) {
        userAccount.withdraw(amount);
    }
}
 class Main {
    public static void main(String[] args) {
        // Initialize user's bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Initialize ATM with the user's bank account
        ATM atm = new ATM(userAccount);

        // ATM menu loop
        while (true) {
            atm.displayMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            atm.processOption(choice);
        }
    }
}