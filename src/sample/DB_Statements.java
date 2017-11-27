package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statements {


    //    Deklarere statement.
    private static Statement stmt = null;

    //    Deklarer variablet con
    private static Connection con = DB_Connector.connect();

    //    Deklarer Resultset.
    private static ResultSet rs = null;


    //    Metode til at oprette database.
    public void createDB() {



        //    SQL statement
        String query = "create database if not exists Bank2017DB";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n ---Bank2017DB Database was created---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n ---statement did not execute (create database)---");
            ex.printStackTrace();
        }
    }

    //    Metode til at bruge databasen.
    public void useDB() {

        //    SQL statement
        String query = "use Bank2017DB";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Using Bank2017DB---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Statement did not execute (Use database)---");
            ex.printStackTrace();
        }
    }


    //Drop Database
    public void dropDB() {

        //    SQL statement
        String query = "drop schema Bank2017DB";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n ---Bank2017DB Database dropped---");
        }

        //    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n ---statement did not execute (drop database)---");
            ex.printStackTrace();
        }
    }

    //    Metode til at oprette kundeTable.
    public void createKundeTable() {

        //    SQL statement - Laver et table der hedder kundeTable, og 6 columms, fName, lName, cprFirst, cprLast og adress.

        String query = "create table if not exists kundeTable(" +
                "id int not null auto_increment," +
                "fName varchar(28), " +
                "lName varchar(28), " +
                "cprFirst int(6), " +
                "cprLast int(4), " +
                "address varchar(28), " +
                "primary key(id)" +
                ")";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Kunde Table oprettet---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Statement did not execute (create table)---");
            ex.printStackTrace();
        }
    }

    //    Metode til at indsætte data i kundeTable.
    public void insertNyKunde(String tempFornavn, String tempEfternavn, int tempCprFirst, int tempnyCprLast, String tempAdr) {

        //    SQL statement
        String query = "INSERT INTO kundeTable " +
                "(fName, lName, cprFirst, cprLast,  address) VALUES ('" +
                tempFornavn  +"', '"+
                tempEfternavn +"', "+
                tempCprFirst +", "+
                tempnyCprLast +", '"+
                tempAdr +
                "')";
        try {

            //    Opret statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Ny kunde oprettet---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Ny kunde kunne ikke oprettes.---");
            ex.printStackTrace();
        }
    }

    //    metode til at læse data fra kundeTable.
    public void queryThisTable() {

        //    SQL statement
        String query = "select * from kundeTable";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            rs = stmt.executeQuery(query);
            System.out.println("\nid\t\tname\t\taddress\n___________________________________________");

            // return next row in the table while true
            while(rs.next()) {
                int id = rs.getInt(1);
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String address = rs.getString("address");
                String cpr = rs.getString("fname");
                System.out.println(id + "\t\t" + fName + " " + lName + "\t\t" + address + " cpr: " + cpr);
            }
            System.out.println("\n---Select query was executed---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Statement did not execute (select query)---");
            ex.printStackTrace();
        }
    }

}
