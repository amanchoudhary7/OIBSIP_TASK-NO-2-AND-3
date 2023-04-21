import java.util.Scanner;

public class NewATM {

    public static void main(String[] args) {
        NewATM atm = new NewATM(123456, 1234, 500000.0);
        atm.start();
    }

    private int user_id;
    private int user_pin;
    private double balance;
    private Scanner scanner;

    public NewATM(int user_id, int user_pin, double balance) {
        this.user_id = user_id;
        this.user_pin = user_pin;
        this.balance = balance;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the AMAN BANK ATM");
        System.out.print("Enter User ID: ");
        int input_id = scanner.nextInt();
        System.out.print("Enter User PIN: ");
        int input_pin = scanner.nextInt();

        if (input_id == user_id && input_pin == user_pin) {
            System.out.println("Login Successful!");
            menu();
        } else {
            System.out.println("Invalid User ID or PIN. \n Try again ! \n");
            start();
        }
    }

    private void menu() {
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showTransactionsHistory();
                menu();
                break;
            case 2:
                withdraw();
                menu();
                break;
            case 3:
                deposit();
                menu();
                break;
            case 4:
                transfer();
                menu();
                break;
            case 5:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid choice.");
                menu();
                break;
        }
    }

    private void showTransactionsHistory() {
        System.out.println("Transactions History:");
        System.out.println("Available balance : RS" + balance);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: RS ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfull withdrawal of : RS " + amount + ". New balance: RS " + balance);
        } else {
            System.out.println("Insufficient funds. \n Try again ! \n");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Successfully deposited : RS " + amount + ". New balance: RS " + balance);
    }

    private void transfer() {
        System.out.print("Enter user ID to transfer to: ");
        int transfer_id = scanner.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully transferred : RS" + amount + " to user " + transfer_id + ". New balance: RS " + balance);
        } else {
            System.out.println("Insufficient funds. \n Try again ! \n ");
        }
    }
}