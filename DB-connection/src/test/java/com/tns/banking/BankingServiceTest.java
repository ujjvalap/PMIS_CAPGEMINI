package com.tns.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tns.banking.entities.Account;
import com.tns.banking.entities.Beneficiary;
import com.tns.banking.entities.Customer;
import com.tns.banking.entities.Transaction;
import com.tns.banking.services.BankingService;
import com.tns.banking.services.BankingServiceImpl;

public class BankingServiceTest {

    private BankingService bankingService;

    @BeforeEach
    public void setUp() {
        bankingService = new BankingServiceImpl();
    }

    @Test
    public void testCustomerOperations() {
        Customer c1 = new Customer(1, "Aniket", "Pune", "7868678899");
        Customer c2 = new Customer(2, "Nikhil", "Mumbai", "7878330331");

        bankingService.addCustomer(c1);
        bankingService.addCustomer(c2);

        assertEquals(2, bankingService.getAllCustomers().size());
        assertEquals("Aniket", bankingService.findCustomerById(1).getName());
        assertEquals("Nikhil", bankingService.findCustomerById(2).getName());
    }

    @Test
    public void testAccountOperations() {
        Account a1 = new Account(101, 1, "Saving", 70000.0);
        Account a2 = new Account(102, 2, "Current", 80000.0);

        bankingService.addAccount(a1);
        bankingService.addAccount(a2);

        assertEquals(2, bankingService.getAllAccounts().size());
        Account found = bankingService.findAccountById(101);
        assertNotNull(found);
        assertEquals(70000.0, found.getBalance());

        List<Account> cust1Accounts = bankingService.getAccountsByCustomerId(1);
        assertEquals(1, cust1Accounts.size());
        assertEquals(101, cust1Accounts.get(0).getAccountID());
    }

    @Test
    public void testBeneficiaryOperations() {
        Beneficiary b1 = new Beneficiary(1001, 1, "Mahesh", "6722212", "SBI");
        bankingService.addBeneficiary(b1);

        assertEquals(1, bankingService.getAllBeneficiaries().size());
        Beneficiary found = bankingService.findBeneficiaryById(1001);
        assertNotNull(found);
        assertEquals("Mahesh", found.getName());

        List<Beneficiary> cust1Beneficiaries = bankingService.getBeneficiariesByCustomerId(1);
        assertEquals(1, cust1Beneficiaries.size());
        assertEquals("Mahesh", cust1Beneficiaries.get(0).getName());
    }

    @Test
    public void testDepositTransactionUpdatesBalance() {
        Account a1 = new Account(101, 1, "Saving", 70000.0);
        bankingService.addAccount(a1);

        Transaction deposit = new Transaction(101, "Deposit", 10000.0);
        bankingService.addTransaction(deposit);

        assertEquals(80000.0, bankingService.findAccountById(101).getBalance());
        List<Transaction> txList = bankingService.getTransactionsByAccountId(101);
        assertEquals(1, txList.size());
        assertEquals(10000.0, txList.get(0).getAmount());
    }

    @Test
    public void testWithdrawTransactionUpdatesBalance() {
        Account a1 = new Account(101, 1, "Saving", 70000.0);
        bankingService.addAccount(a1);

        Transaction withdraw = new Transaction(101, "Withdraw", 20000.0);
        bankingService.addTransaction(withdraw);

        assertEquals(50000.0, bankingService.findAccountById(101).getBalance());
    }
}
