class BankAccount {
    String accountHolder;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    void displayDetails() {
        System.out.println("Bank Account Holder: " + accountHolder);
    }
}

class SavingAccount extends BankAccount {

    SavingAccount(String accountHolder) {
        super(accountHolder); // Calls parent constructor
    }

    @Override
    void displayDetails() {
        super.displayDetails(); // Calls parent method
        System.out.println("Account Type: Saving Account");
    }

    void displaySavingAccount() {
        System.out.println("This is a Saving Account");
    }
}

public class Main {
    public static void main(String[] args) {

        SavingAccount sa = new SavingAccount("Ujjwal");

        sa.displayDetails();
        sa.displaySavingAccount();
    }
}