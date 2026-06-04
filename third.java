import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {

    static void withdraw(double balance, double amount)
            throws InsufficientFundsException {

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds for withdrawal.");
        }

        balance -= amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Updated Balance = " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            withdraw(balance, amount);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
