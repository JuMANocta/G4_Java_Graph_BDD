package com.example;

import java.sql.Connection;
import java.sql.ResultSet;

public class BDmodel {
    Connection conn;
    BDmodel(Connection conn) {
        this.conn = conn;
    }

    public void insert(String nom, String prenom, String age, String sexe, String adresse, String codePostale, String ville) {
        String sql = "INSERT INTO personne (nom, prenom, age, sexe, adresse, codePostale, ville) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, age);
            pstmt.setString(4, sexe);
            pstmt.setString(5, adresse);
            pstmt.setString(6, codePostale);
            pstmt.setString(7, ville);
            pstmt.executeUpdate();
            System.out.println("Insertion réussie");
        } catch (Exception e) {
            System.out.println("Erreur d'insertion " + e.getMessage());
            //e.printStackTrace();
        }
    }
    public void select() {
        String sql = "SELECT * FROM personne";
        try {
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println(
                    rs.getString("nom") 
                    + " " + rs.getString("prenom") 
                    + " " + rs.getString("age") 
                    + " " + rs.getString("sexe") 
                    + " " + rs.getString("adresse") 
                    + " " + rs.getString("codePostale") 
                    + " " + rs.getString("ville"));
            }
        } catch (Exception e) {
            System.out.println("Erreur de selection " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
