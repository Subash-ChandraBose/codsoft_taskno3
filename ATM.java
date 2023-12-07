import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
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
                    System.out.println("Thank you!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Current Balance: Rs." + userAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: Rs.");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful");
            System.out.println("Current Balaance: Rs."+userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: Rs.");
        double amount = scanner.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful");
            System.out.println("Current Balance: Rs." + userAccount.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public static void main(String[] args) {
        // Example usage
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.start();
    }
}

