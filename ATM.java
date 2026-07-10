import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private boolean loggedIn;

    public ATM(BankAccount account) {
        this.account = account;
        loggedIn = false;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (account.verifyPin(pin)) {
                loggedIn = true;
                System.out.println("\nLogin Successful");
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN");
                System.out.println("Attempts Left: " + attempts);
            }
        }

        if (!loggedIn) {
            System.out.println("Card Blocked.");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Balance Check");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 4:
                    account.changePin(sc);
                    break;

                case 5:
                    loggedIn = false;
                    System.out.println("Thank You For Using ATM.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (loggedIn);
    }
}