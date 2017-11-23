package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {


    private static Connection con = null;  // declare a connection
    private static final String DRIVER = "com.mysql.jdbc.Driver"; // JDBC driver
    private static String url = "jdbc:mysql://localhost:3306/BankOf69Projekt"; // the url = jdbc:dbms//host name:port#/db name
    private static String usr = "admin"; // user name
    private static String pswrd = "1234";// password


    public static Connection connect() {
        System.out.println("\n--Connection to mySQL JDBC--");


        //Locate MySQL JDBC Driver
        try {
            Class.forName(DRIVER);
        }

        // Catch exceptions if JDBC is not found.
        catch (ClassNotFoundException ex) { //Class - som deklareres som ex
            ex.printStackTrace(); // ex variablen laver et object )printStackTrace
            System.out.println("\n--JDBC driver is missing--");

        }
        System.out.println("\n MySQL JDBC driver registered--");


        // Connect to MySQL DB. = URL, usrName, pswrd
        try {
            con = DriverManager.getConnection(url, usr, pswrd);
        }

        // Catch exceptions on connection error.
        catch(SQLException ex){ //Class - som deklareres som ex
            ex.printStackTrace();
            System.out.println("\n--Did not connect try again--");

        }
        // if connection successful
        if(con != null){
            System.out.println("\n--Connection successful--");
        }
        // if connection fails
        else{
            System.out.println("\n--Connection failed--");
        }
        return con;

    }


}