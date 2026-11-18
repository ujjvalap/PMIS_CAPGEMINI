package CG_Java_Training.Day5.Encapsulation;


class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful");
        } else {
            System.out.println("Invalid deposit amount"); 
            
            
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(5000);
        account.withdraw(1500);
        account.withdraw(5000);

        System.out.println("Balance: " + account.getBalance());
    }
}
