//
//package com.tns.banking.database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//
//   // ....................Use Your DB Url..................
//    private static final String URL = "";
//   //...................Use Your DB UserNamw.....................
//    private static final String USER = "***";
//    //..............................Use  Your DB Password....................
//    private static final String PASSWORD = "***********";
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//}



package com.tns.banking.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory(".")
            .ignoreIfMissing()
            .load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(
                URL, USER, PASSWORD
        );

        System.out.println("Database connected successfully!");

        return connection;
    }
}
