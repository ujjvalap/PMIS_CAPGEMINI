
package com.tns.banking.services;

import com.tns.banking.database.DBConnection;
import com.tns.banking.model.*;

import java.sql.*;
import java.util.*;

public class BankingServiceImpl implements BankingService {

    private RuntimeException dbError(SQLException e) {
        return new RuntimeException("Database error: " + e.getMessage(), e);
    }

    // ---------------- CUSTOMER ----------------

    @Override
    public void addCustomer(Customer c) {
        String sql = "INSERT INTO customers VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, c.getCustomerID());
            ps.setString(2, c.getName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getContact());
            ps.executeUpdate();

            System.out.println("Customer saved in MySQL!");
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE customerID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getInt("customerID"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("contact")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("customerID"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("contact")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public void updateCustomer(Customer c) {
        String sql = "UPDATE customers SET name=?, address=?, contact=? "
                + "WHERE customerID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getContact());
            ps.setInt(4, c.getCustomerID());

            if (ps.executeUpdate() == 0) {
                throw new IllegalArgumentException("Customer not found.");
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE customerID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                throw new IllegalArgumentException("Customer not found.");
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    // ---------------- ACCOUNT ----------------

    @Override
    public void addAccount(Account a) {
        String sql = "INSERT INTO accounts "
                + "(accountID, customerID, type, balance) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, a.getAccountID());
            ps.setInt(2, a.getCustomerID());
            ps.setString(3, a.getType());
            ps.setDouble(4, a.getBalance());
            ps.executeUpdate();

            System.out.println("Account saved in MySQL!");
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Account findAccountById(int id) {
        String sql = "SELECT * FROM accounts WHERE accountID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Account(
                            rs.getInt("accountID"),
                            rs.getInt("customerID"),
                            rs.getString("type"),
                            rs.getDouble("balance")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Collection<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("accountID"),
                        rs.getInt("customerID"),
                        rs.getString("type"),
                        rs.getDouble("balance")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerID) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts WHERE customerID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerID);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Account(
                            rs.getInt("accountID"),
                            rs.getInt("customerID"),
                            rs.getString("type"),
                            rs.getDouble("balance")
                    ));
                }
                return list;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public void updateAccount(Account a) {
        String sql = "UPDATE accounts SET customerID=?, type=?, balance=? "
                + "WHERE accountID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, a.getCustomerID());
            ps.setString(2, a.getType());
            ps.setDouble(3, a.getBalance());
            ps.setInt(4, a.getAccountID());

            if (ps.executeUpdate() == 0) {
                throw new IllegalArgumentException("Account not found.");
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public void deleteAccount(int id) {
        String sql = "DELETE FROM accounts WHERE accountID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                throw new IllegalArgumentException("Account not found.");
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    // ---------------- TRANSACTIONS ----------------

    private int nextTransactionID(Connection con) throws SQLException {
        String sql = "SELECT COALESCE(MAX(transactionID), 0) + 1 FROM transactions";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }

    private void saveTransaction(
            Connection con, int accountID, String type, double amount)
            throws SQLException {

        String sql = "INSERT INTO transactions "
                + "(transactionID, accountID, type, amount, timestamp) "
                + "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nextTransactionID(con));
            ps.setInt(2, accountID);
            ps.setString(3, type);
            ps.setDouble(4, amount);
            ps.executeUpdate();
        }
    }

    @Override
    public void addTransaction(Transaction t) {
        String sql = "INSERT INTO transactions "
                + "(transactionID, accountID, type, amount, timestamp) "
                + "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, t.getTransactionID());
            ps.setInt(2, t.getAccountID());
            ps.setString(3, t.getType());
            ps.setDouble(4, t.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Transaction findTransactionById(int id) {
        String sql = "SELECT * FROM transactions WHERE transactionID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Transaction(
                            rs.getInt("transactionID"),
                            rs.getInt("accountID"),
                            rs.getString("type"),
                            rs.getDouble("amount")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Collection<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Transaction(
                        rs.getInt("transactionID"),
                        rs.getInt("accountID"),
                        rs.getString("type"),
                        rs.getDouble("amount")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int accountID) {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE accountID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accountID);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Transaction(
                            rs.getInt("transactionID"),
                            rs.getInt("accountID"),
                            rs.getString("type"),
                            rs.getDouble("amount")
                    ));
                }
                return list;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    // ---------------- BENEFICIARY ----------------

    @Override
    public void addBeneficiary(Beneficiary b) {
        String sql = "INSERT INTO beneficiaries "
                + "(beneficiaryID, customerID, name, accountNumber, bankDetails) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, b.getBeneficiaryID());
            ps.setInt(2, b.getCustomerID());
            ps.setString(3, b.getName());
            ps.setString(4, b.getAccountNumber());
            ps.setString(5, b.getBankDetails());
            ps.executeUpdate();

            System.out.println("Beneficiary saved in MySQL!");
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Beneficiary findBeneficiaryById(int id) {
        String sql = "SELECT * FROM beneficiaries WHERE beneficiaryID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Beneficiary(
                            rs.getInt("beneficiaryID"),
                            rs.getInt("customerID"),
                            rs.getString("name"),
                            rs.getString("accountNumber"),
                            rs.getString("bankDetails")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public Collection<Beneficiary> getAllBeneficiaries() {
        List<Beneficiary> list = new ArrayList<>();
        String sql = "SELECT * FROM beneficiaries";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Beneficiary(
                        rs.getInt("beneficiaryID"),
                        rs.getInt("customerID"),
                        rs.getString("name"),
                        rs.getString("accountNumber"),
                        rs.getString("bankDetails")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public List<Beneficiary> getBeneficiariesByCustomerId(int customerID) {
        List<Beneficiary> list = new ArrayList<>();
        String sql = "SELECT * FROM beneficiaries WHERE customerID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerID);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Beneficiary(
                            rs.getInt("beneficiaryID"),
                            rs.getInt("customerID"),
                            rs.getString("name"),
                            rs.getString("accountNumber"),
                            rs.getString("bankDetails")
                    ));
                }
                return list;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    // ---------------- BANKING OPERATIONS ----------------

    @Override
    public void deposit(int accountID, double amount) {
        validateAmount(amount);

        String sql = "UPDATE accounts SET balance = balance + ? WHERE accountID=?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, amount);
                ps.setInt(2, accountID);

                if (ps.executeUpdate() == 0) {
                    throw new IllegalArgumentException("Account not found.");
                }

                saveTransaction(con, accountID, "DEPOSIT", amount);
                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public void withdraw(int accountID, double amount) {
        validateAmount(amount);

        String sql = "UPDATE accounts SET balance = balance - ? "
                + "WHERE accountID=? AND balance >= ?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, amount);
                ps.setInt(2, accountID);
                ps.setDouble(3, amount);

                if (ps.executeUpdate() == 0) {
                    throw new IllegalArgumentException(
                            "Account not found or insufficient balance.");
                }

                saveTransaction(con, accountID, "WITHDRAW", amount);
                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    @Override
    public void transfer(int fromID, int toID, double amount) {
        validateAmount(amount);

        if (fromID == toID) {
            throw new IllegalArgumentException(
                    "Source and destination accounts must differ.");
        }

        String debit = "UPDATE accounts SET balance=balance-? "
                + "WHERE accountID=? AND balance>=?";
        String credit = "UPDATE accounts SET balance=balance+? WHERE accountID=?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try {
                try (PreparedStatement ps = con.prepareStatement(debit)) {
                    ps.setDouble(1, amount);
                    ps.setInt(2, fromID);
                    ps.setDouble(3, amount);

                    if (ps.executeUpdate() == 0) {
                        throw new IllegalArgumentException(
                                "Source account not found or insufficient balance.");
                    }
                }

                try (PreparedStatement ps = con.prepareStatement(credit)) {
                    ps.setDouble(1, amount);
                    ps.setInt(2, toID);

                    if (ps.executeUpdate() == 0) {
                        throw new IllegalArgumentException(
                                "Destination account not found.");
                    }
                }

                saveTransaction(con, fromID, "TRANSFER_OUT", amount);
                saveTransaction(con, toID, "TRANSFER_IN", amount);
                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw dbError(e);
        }
    }

    private void validateAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be a positive number.");
        }
    }
}
