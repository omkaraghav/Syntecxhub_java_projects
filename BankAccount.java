import java.util.Scanner;

public class BankAccount {
    private double balance;
    private int pin;

    public BankAccount(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        }
    }

    public void changePin(Scanner sc) {
        System.out.print("Enter Current PIN: ");
        int oldPin = sc.nextInt();

        if (oldPin == pin) {
            System.out.print("Enter New PIN: ");
            pin = sc.nextInt();
            System.out.println("PIN Changed Successfully.");
        } else {
            System.out.println("Incorrect Current PIN.");
        }
    }
}