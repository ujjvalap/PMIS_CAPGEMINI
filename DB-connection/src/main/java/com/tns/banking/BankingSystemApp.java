package com.tns.banking;

import java.util.List;
import java.util.Scanner;

import com.tns.banking.entities.Account;
import com.tns.banking.entities.Beneficiary;
import com.tns.banking.entities.Customer;
import com.tns.banking.entities.Transaction;
import com.tns.banking.services.BankingService;
import com.tns.banking.services.BankingServiceImpl;

public class BankingSystemApp {

    public static void main(String[] args) {
        BankingService bankingService = new BankingServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Banking System");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id ");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all transactions of specific Account");
            System.out.println("8. List all beneficiaries of specific customer");
            System.out.println("9. Exit");
            System.out.println("Enter your choice : ");

            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    break;
                }
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer Details");
                    System.out.print("Customer Id : ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Address : ");
                    String address = scanner.nextLine();
                    System.out.print("Contact No. : ");
                    String contact = scanner.nextLine();

                    Customer customer = new Customer(customerId, name, address, contact);
                    bankingService.addCustomer(customer);
                    break;

                case 2:
                    System.out.println("Enter Account Details");
                    System.out.print("Account Id : ");
                    int accountId = scanner.nextInt();
                    System.out.print("Customer Id : ");
                    int accCustomerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Account Type Saving/ Current : ");
                    String accType = scanner.nextLine();
                    System.out.print("Balance : ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    Account account = new Account(accountId, accCustomerId, accType, balance);
                    bankingService.addAccount(account);
                    break;

                case 3:
                    System.out.println("Enter Beneficiary Details");
                    System.out.print("Customer Id : ");
                    int benCustomerId = scanner.nextInt();
                    System.out.print("Benefiary Id : ");
                    int beneficiaryId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Beneficiary Name : ");
                    String benName = scanner.nextLine();
                    System.out.print("Beneficiary Account No. : ");
                    String benAccNo = scanner.nextLine();
                    System.out.print("Beneficiary Bank details : ");
                    String bankDetails = scanner.nextLine();

                    Beneficiary beneficiary = new Beneficiary(beneficiaryId, benCustomerId, benName, benAccNo, bankDetails);
                    bankingService.addBeneficiary(beneficiary);
                    break;

                case 4:
                    System.out.println("Enter Transaction Details");
                    System.out.print("Account Id : ");
                    int transAccId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tyep (Deposit/Withdrawal : ");
                    String transType = scanner.nextLine();
                    System.out.print("Account Amount : ");
                    double transAmount = scanner.nextDouble();
                    scanner.nextLine();

                    Transaction transaction = new Transaction(transAccId, transType, transAmount);
                    bankingService.addTransaction(transaction);
                    break;

                case 5:
                    for (Customer c : bankingService.getAllCustomers()) {
                        System.out.println("Cutomer ID: " + c.getCustomerID() + ", Name: " + c.getName());
                    }
                    System.out.print("Customer Id : ");
                    int searchCustomerId = scanner.nextInt();
                    scanner.nextLine();
                    Customer foundCustomer = bankingService.findCustomerById(searchCustomerId);
                    if (foundCustomer != null) {
                        System.out.println("Customer: " + foundCustomer.getName());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    for (Account a : bankingService.getAllAccounts()) {
                        System.out.println("Account ID: " + a.getAccountID() + ", Customer ID : " + a.getCustomerID() + ", Balance: " + a.getBalance());
                    }
                    System.out.print("Customer Id : ");
                    int accSearchCustId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Accounts for Customer ID :" + accSearchCustId);
                    List<Account> customerAccounts = bankingService.getAccountsByCustomerId(accSearchCustId);
                    for (Account a : customerAccounts) {
                        System.out.println("Account ID: " + a.getAccountID() + ", Balance: " + a.getBalance());
                    }
                    break;

                case 7:
                    System.out.print("Account Id : ");
                    int searchAccId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Transactions for Account ID :" + searchAccId);
                    List<Transaction> accountTransactions = bankingService.getTransactionsByAccountId(searchAccId);
                    for (Transaction t : accountTransactions) {
                        System.out.println(t);
                    }
                    break;

                case 8:
                    for (Beneficiary b : bankingService.getAllBeneficiaries()) {
                        System.out.println("Beneficiary ID: " + b.getBeneficiaryID() + ", Name: " + b.getName());
                    }
                    System.out.println("-------------------------------------");
                    System.out.print("Customer Id : ");
                    int benSearchCustId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Beneficiaries for Customer ID :" + benSearchCustId);
                    List<Beneficiary> customerBeneficiaries = bankingService.getBeneficiariesByCustomerId(benSearchCustId);
                    for (Beneficiary b : customerBeneficiaries) {
                        System.out.println("Beneficiary ID: " + b.getBeneficiaryID() + ", Name: " + b.getName());
                    }
                    break;

                case 9:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please choose between 1 and 9.");
                    break;
            }
        }
        scanner.close();
    }
}
