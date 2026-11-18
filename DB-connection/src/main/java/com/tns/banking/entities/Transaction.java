package com.tns.banking.entities;

import java.time.LocalDateTime;

public class Transaction {
    private static int idCounter = 1;

    private int transactionID;
    private int accountID;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction() {
        this.transactionID = idCounter++;
        this.timestamp = LocalDateTime.now();
    }

    public Transaction(int accountID, String type, double amount) {
        this.transactionID = idCounter++;
        this.accountID = accountID;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public Transaction(int transactionID, int accountID, String type, double amount, LocalDateTime timestamp) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Type: " + type + ", Amount: " + amount + ", Timestamp: " + timestamp;
    }
}
