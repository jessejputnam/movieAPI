package com.jessejputnam.movieAPI.Util;

import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionUtil creates Singleton active connection to database.
 * 
 */

public class ConnectionUtil {
    private static String url = "jdbc:h2:./h2/db";
    private static String username = "sa";
    private static String password = "sa";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    /**
     * Create tables and seed genres to database
     * 
     */
    public static void setDatabase() {
        if (connection == null)
            getConnection();
        else {
            try {
                // Create SQL tables and seed genres if not present
                FileReader sqlReader = new FileReader("src/main/resources/data.sql");
                RunScript.execute(connection, sqlReader);
            } catch (SQLException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
