package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statements {


    //    Declare a Statement
    private static Statement stmt = null;

    //    Declare & create a connection
    private static Connection con = DB_Connector.connect();

    //    Declare a result set
    private static ResultSet rs = null;


    //    Method to create a new Database
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

    //    method to use a database
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

    public void dropTableKundeTable() {

        //    SQL statement
        String query = "drop table kundeTable";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n ---kundetable table dropped---");
        }


        //    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n ---statement did not execute (drop database)---");
            ex.printStackTrace();
        }
    }
    public void dropTableKontoTable() {

        //    SQL statement
        String query = "drop table kontoTable";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n ---kontotable table dropped---");
        }

        //    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n ---statement did not execute (drop database)---");
            ex.printStackTrace();
        }
    }
    //    method to create a konto table
    public void createKontoTable() {

        //    SQL statement
        String query = "create table if not exists kontoTable(" +
                "p_id int not null auto_increment," +
                "lonkonto DOUBLE, " +
                "opsparing DOUBLE, " +
                "lonRente DOUBLE, " +
                "opsRente DOUBLE, " +
                "lonOT INT, " +
                "opsOT INT, " +
                "primary key(p_id)" +
                ")";
        try {

            //create statement
            stmt = con.createStatement();

            //execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Konto Table oprettet---");
        }

        //handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Statement did not execute (kontotable)---");
            ex.printStackTrace();
        }
    }

    //method to create a table
    public void createKundeTable() {

        //SQL statement
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

            //create statement
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


    //    method to insert data
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

            //    create statement
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

    //    method to insert data
    public void insertTestKunder() {

        //    SQL statement
        String query = "insert into kundeTable " +
                "(fName, lName, cprFirst, cprLast, address) " +
                "values ('Benjamin', 'Ejrup', 111187, 1234, 'Slotsgade 9 2.tv'), " +
                "('Benjamin', 'Ejrup', 111187, 1234, 'Vejnavn 1'), " +
                "('Mads', 'Nielsen', 123456, 1234, 'Vejnavn 2'), " +
                "('Mathias', 'Bruun', 234567, 1234, 'Vejnavn 3'), " +
                "('Mikkel', 'Bøgse', 345678, 1234, 'Vejnavn 4'), " +
                "('Johan', 'Stenboeg', 456789, 1234, 'Vejnavn 5')";
        try {

            //    create statement
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

    //    method to read data from table
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