package com.example;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        BD.DBConnection();
        Form f = new Form();
        f.setVisible(true);
    }
}
