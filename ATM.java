import java.util.Scanner;

public class ATM {
    // Variables to store user balance and PIN
    private double balance;
    private int userPIN;

    // Constructor
    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.userPIN = pin;
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Main ATM operation loop
    public void startATM() {
        Scanner scanner = new Scanner(System.in);

        // Asking user for PIN validation
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPIN = scanner.nextInt();

        if (enteredPIN != userPIN) {
            System.out.println("Invalid PIN. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

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
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return; // Exit the loop and terminate the program
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    // Main method to run the ATM
    public static void main(String[] args) {
        // Create an instance of the ATM with an initial balance and PIN
        ATM atm = new ATM(1000.0, 1234); // Initial balance $1000 and PIN 1234
        atm.startATM();
    }
}
