
package com.tns.banking.services;

import com.tns.banking.model.*;
import java.util.Collection;
import java.util.List;

public interface BankingService {

    // Create
    void addCustomer(Customer customer);
    void addAccount(Account account);
    void addTransaction(Transaction transaction);
    void addBeneficiary(Beneficiary beneficiary);

    // Read
    Customer findCustomerById(int customerID);
    Account findAccountById(int accountID);
    Transaction findTransactionById(int transactionID);
    Beneficiary findBeneficiaryById(int beneficiaryID);

    List<Account> getAccountsByCustomerId(int customerID);
    List<Transaction> getTransactionsByAccountId(int accountID);
    List<Beneficiary> getBeneficiariesByCustomerId(int customerID);

    Collection<Customer> getAllCustomers();
    Collection<Account> getAllAccounts();
    Collection<Transaction> getAllTransactions();
    Collection<Beneficiary> getAllBeneficiaries();

    // Update
    void updateCustomer(Customer customer);
    void updateAccount(Account account);

    // Delete
    void deleteCustomer(int customerID);
    void deleteAccount(int accountID);

    // Banking operations
    void deposit(int accountID, double amount);
    void withdraw(int accountID, double amount);
    void transfer(int fromAccountID, int toAccountID, double amount);
}
