
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_db";
        String username = "root";
        String password = "root";

        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {

            System.out.println("MySQL connected successfully!");

            // Example query
            try (Statement stmt = con.createStatement()) {
                System.out.println("Connection is valid: " + con.isValid(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
