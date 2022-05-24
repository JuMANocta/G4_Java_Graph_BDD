package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class BDmodel {
    Connection conn;
    Personne p;
    ArrayList<Personne> listePersonne = new ArrayList<Personne>();

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
    public ArrayList<Personne> selectArrayList() {
        String sql = "SELECT * FROM personne";
        try {
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                p = new Personne(rs.getString("nom"), rs.getString("prenom"), rs.getString("age"), rs.getString("sexe"), rs.getString("adresse"), rs.getString("codePostale"), rs.getString("ville"));
                listePersonne.add(p);
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
        return listePersonne;
    }
    public void select(){
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
    public ResultSet selectRS(){
        String sql = "SELECT * FROM personne";
        try {
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Erreur de selection " + e.getMessage());
            //e.printStackTrace();
        }
        return null;
    }
    public DefaultTableModel buildTableModel(ResultSet rs){
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel dtm = new DefaultTableModel();
            for (int column = 1; column <= columnCount; column++) {
                dtm.addColumn(metaData.getColumnName(column));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                dtm.addRow(row);
            }
            return dtm;
        } catch (Exception e) {
            System.out.println("Erreur de selection " + e.getMessage());
            //e.printStackTrace();
        }
        return null;
    }
}
