import java.util.*;

public class ATM1 
{ 
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);

        ATM a1 = new ATM(500000.0, 1234);  //created atm object named a1

        System.out.println("Welcome to The AMAN BANK ATM.");
        System.out.print("Please enter your PIN: ");

        int pin = sc.nextInt();

        if (pin != a1.getPin()) 
        {
            System.out.println("Invalid PIN. Exiting.");
            return;
        }

        System.out.println("Current balance:" + a1.getBalance() +" RS");

        while (true) 
        {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. View PIN");
            System.out.println("5. Exit");

            System.out.print("Please enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Please enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    a1.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Please enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    a1.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + a1.getBalance());
                    break;
                case 4:
                    System.out.println("Your pin is: "+a1.getPin());
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println();
        }
    }


    private double balance;
    private int pin;

    public ATM1(double balance, int pin) 
    {
        this.balance = balance;
        this.pin = pin;
    }

    public double getBalance()
    {
        return balance;
    }

    public int getPin() 
    {
        return pin;
    }

    public void withdraw(double amount) 
    {
        if (amount > balance) 
        {
            System.out.println("Insufficient funds.");
        }
        else 
        {
            balance -= amount;
            System.out.println("Withdrawal successful.Current balance is " + balance);
        }
    }

    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposit successful.Current balance is " + balance);
    }

    
}
