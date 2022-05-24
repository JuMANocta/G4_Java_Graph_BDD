package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
    public static Connection DBConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "_test";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url+dbName, user, password);
            System.out.println("Connected to the database");
        } catch (Exception e) {
            System.out.println("Erreur de connexion BDD " + e.getMessage());
            //e.printStackTrace();
        }
        return conn;
    }
    public void test(){
        System.out.println("test");
    }
}

