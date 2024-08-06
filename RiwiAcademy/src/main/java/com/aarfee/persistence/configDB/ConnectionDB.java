package com.aarfee.persistence.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection = null;

    public static Connection openConnection(){
        String URL = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
        String user = "root";
        String password = "tupassword";

        try {
            connection = DriverManager.getConnection(URL,user,password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
