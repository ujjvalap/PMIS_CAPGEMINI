package com.tns.banking.app;

import com.tns.banking.model.*;
import com.tns.banking.services.BankingService;
import com.tns.banking.services.BankingServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BankingSystemApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final BankingService service = new BankingServiceImpl();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer Money");
            System.out.println("7. Find Customer");
            System.out.println("8. Find Account");
            System.out.println("9. List All Customers");
            System.out.println("10. List All Accounts");
            System.out.println("11. View Account Transactions");
            System.out.println("12. View Customer Beneficiaries");
            System.out.println("13. Update Customer");
            System.out.println("14. Delete Account");
            System.out.println("15. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> addCustomer();
                    case 2 -> addAccount();
                    case 3 -> addBeneficiary();
                    case 4 -> deposit();
                    case 5 -> withdraw();
                    case 6 -> transfer();
                    case 7 -> findCustomer();
                    case 8 -> findAccount();
                    case 9 -> service.getAllCustomers()
                            .forEach(System.out::println);
                    case 10 -> service.getAllAccounts()
                            .forEach(System.out::println);
                    case 11 -> viewTransactions();
                    case 12 -> viewBeneficiaries();
                    case 13 -> updateCustomer();
                    case 14 -> deleteAccount();
                    case 15 -> {
                        running = false;
                        System.out.println("Thank you for using the Banking System.");
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }

            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }

        sc.close();
    }

    private static void addCustomer() {
        System.out.print("Customer ID: ");
        int id = readInt();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        service.addCustomer(new Customer(id, name, address, contact));
        System.out.println("Customer added successfully!");
    }

    private static void addAccount() {
        System.out.print("Account ID: ");
        int accountID = readInt();

        System.out.print("Customer ID: ");
        int customerID = readInt();

        System.out.print("Account type: ");
        String type = sc.nextLine();

        System.out.print("Opening balance: ");
        double balance = readDouble();

        service.addAccount(
                new Account(accountID, customerID, type, balance));

        System.out.println("Account added successfully!");
    }

    private static void addBeneficiary() {
        System.out.print("Beneficiary ID: ");
        int beneficiaryID = readInt();

        System.out.print("Customer ID: ");
        int customerID = readInt();

        System.out.print("Beneficiary name: ");
        String name = sc.nextLine();

        System.out.print("Beneficiary account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Bank details: ");
        String bankDetails = sc.nextLine();

        service.addBeneficiary(new Beneficiary(
                beneficiaryID, customerID, name, accountNumber, bankDetails));

        System.out.println("Beneficiary added successfully!");
    }

    private static void deposit() {
        System.out.print("Account ID: ");
        int accountID = readInt();

        System.out.print("Deposit amount: ");
        double amount = readDouble();

        service.deposit(accountID, amount);
        System.out.println("Deposit successful!");
        System.out.println(service.findAccountById(accountID));
    }

    private static void withdraw() {
        System.out.print("Account ID: ");
        int accountID = readInt();

        System.out.print("Withdrawal amount: ");
        double amount = readDouble();

        service.withdraw(accountID, amount);
        System.out.println("Withdrawal successful!");
        System.out.println(service.findAccountById(accountID));
    }

    private static void transfer() {
        System.out.print("From account ID: ");
        int fromID = readInt();

        System.out.print("To account ID: ");
        int toID = readInt();

        System.out.print("Transfer amount: ");
        double amount = readDouble();

        service.transfer(fromID, toID, amount);
        System.out.println("Transfer successful!");
    }

    private static void findCustomer() {
        System.out.print("Customer ID: ");
        int id = readInt();

        Customer customer = service.findCustomerById(id);

        if (customer == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.println(customer);
        }
    }

    private static void findAccount() {
        System.out.print("Account ID: ");
        int id = readInt();

        Account account = service.findAccountById(id);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println(account);
        }
    }

    private static void viewTransactions() {
        System.out.print("Account ID: ");
        int accountID = readInt();

        service.getTransactionsByAccountId(accountID)
                .forEach(System.out::println);
    }

    private static void viewBeneficiaries() {
        System.out.print("Customer ID: ");
        int customerID = readInt();

        service.getBeneficiariesByCustomerId(customerID)
                .forEach(System.out::println);
    }

    private static void updateCustomer() {
        System.out.print("Customer ID to update: ");
        int id = readInt();

        Customer existing = service.findCustomerById(id);

        if (existing == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("New name: ");
        String name = sc.nextLine();

        System.out.print("New address: ");
        String address = sc.nextLine();

        System.out.print("New contact: ");
        String contact = sc.nextLine();

        service.updateCustomer(new Customer(id, name, address, contact));
        System.out.println("Customer updated successfully!");
    }

    private static void deleteAccount() {
        System.out.print("Account ID to delete: ");
        int id = readInt();

        service.deleteAccount(id);
        System.out.println("Account deleted successfully!");
    }

    private static int readInt() {
        return Integer.parseInt(sc.nextLine().trim());
    }

    private static double readDouble() {
        return Double.parseDouble(sc.nextLine().trim());
    }
}
