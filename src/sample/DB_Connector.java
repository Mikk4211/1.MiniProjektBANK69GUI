package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
 * @version 1.0
 * @since 11/30-17
 *
 * Denne Class bruges til at connecte IntelliJ med MySQL....
 *
 * Ved brug af en mysql Connector samt jdbc Driver er det muligt at hente samt sende information fra
 * IntelliJ til MySQL Workbench. Dette gøres muligt ved brug af Connection Class.
 *
 * Denne Class Javadoc er lavet af Benjamin E.
 */
public class DB_Connector {

    /**
     * @param con Deklarerer Connection class.
     * @param DRIVER Driver til JDBC.
     * @param url Lokal adresse for MySQL Database.
     * @param usr Bruger navn til MySQL Database.
     * @param pswrd Adgangskode til MySQL Database
     */
    private static Connection con = null;  // declare a connection
    private static final String DRIVER = "com.mysql.jdbc.Driver"; // JDBC driver
    private static String url = "jdbc:mysql://localhost:3306/Bank2017DB"; // the url = jdbc:dbms//host name:port#/db name
    private static String usr = "admin"; // user name
    private static String pswrd = "1234";// password


    /**
     * @return Ved brug af connect() metoden i Connection class, forsøger vi at:
     * 1. Connecte til MySQL JDBC
     * 2. Tjekker om MySQL JDBC Driver er registreret.
     * 3. Sender url, brugernavn og adgangskode.
     * 4. Giver besked tilbage om connection er succesful eller failed.
     */
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