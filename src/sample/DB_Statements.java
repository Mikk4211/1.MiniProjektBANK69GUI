package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.sql.ResultSet;

/**
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
 *
 */
public class DB_Statements {


    /**
     * @param stmt variable for vores statement.
     */
    private static Statement stmt = null;

    /**
     * @param con varaible for vores database connector.
      */

    private static Connection con = DB_Connector.connect();

    //    Declare a result set
    private static ResultSet rs = null;




    //    Method to create a new Database
    public void createDB() {


        /**
         @param query der er forskellige queries vi bruger i vores program.
         * 1. "Create Database if not exists Bank2017DB" - Laver Databasen.
          * 2. "use Bank2017DB" - bruger databasen.
          * 3. "drop schema Bank2017DB" - Dropper databasen.
          * 4. "drop table kundeTable" - Dropper table kundeTable.
          * 5. "drop table kontoTable" - Dropper table kontoTable.
          * 6. "create table if not exists kontoTable" - Laver vores kontotable i SQL og indsætter datatyper og værdier. Kig i source code.
          * 7. "create table if not exists kundeTable" - Laver vores kundetable i SQL og indsætter datatyper og værdier. Kig i source code.
          * 8. "INSERT INTO kundeTable" - Indsætter nogle specifikke værdier ind i kundeTable.
          * 9. "INSERT INTO kontoTable" - Indsætter nogle specifikke værdier ind i kontoTable.
          * 10. Overfør metoden -
          * Inkluderer try & catch i alle metoderne, try udfører query'en og catch fanger SQLexception og udskriver istedet en fejlmelding i konsollen.
         */
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

    /**
     *
     */
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
                "('Mads', 'Nielsen', 123456, 1234, 'Vejnavn 2'), " +
                "('Mathias', 'Bruun', 234567, 1234, 'Vejnavn 3'), " +
                "('Mikkel', 'Bøgse', 345678, 1234, 'Vejnavn 4'), " +
                "('Johan', 'Stenboeg', 456789, 1234, 'Vejnavn 5')";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Nye testkunder oprettet---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Nye testkunder kunne ikke oprettes---");
            ex.printStackTrace();
        }
    }


    //    method to insert data
    public void insertTestKonto() {

        //    SQL statement - Indsætter data ind i kontotable, i kolonnerne, lonkonto, opsparing, lonrente, opsrente, lonOT, og opsOT
        String query = "insert into kontoTable " +
                "(lonkonto, opsparing, lonRente, opsrente, lonOT, opsOT) " +
                "values "+
                "(10000,50000,0,5,10,1000), " +
                "(13000, 54000, 0, 4, 5120,5200), " +
                "(1000000, 3700, 0, 5, 1233,2000), " +
                "(10, 30, 0, 1, 1233,2000), " +
                "(1234, 3700, 0, 2, 3500,2000), " +
                "(5000,1550,0,1,500,5000)";
        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Nye kontoer oprettet---");
        }

        //    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n---Nye kontoer kunne ikke oprettes.---");
            ex.printStackTrace();
        }
    }
    //    method to read data from table
    public void queryThisTable() {

        //    Selecter data fra kundetable.
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
    /*Methode til at overfører beløb fra din konto til anden konto.*/
    //char kontotype: 'l' for lønkonto, og 'o' for opsparing.
    public void overfor(int p_id, char kontotype, double belob, int kontonr  ){
        //
        String query = "select opsparing from kontotable where p_id = "+p_id+" ";
        //
        String kontotypen= "opsparing";
        //
        if (kontotype=='o'){
            //
            kontotypen = "opsparing";
        } else if(kontotype=='l'){
            //
            kontotypen = "lonkonto";
        }else{

            System.out.println("FEJL, forkert kontotype");
        }
        query = "select "+kontotypen+" from kontotable where p_id = "+p_id+" ";


        try{
            //create statement
            stmt = con.createStatement();

            //execute statement
            rs = stmt.executeQuery(query);

            double kontobelob =0.0;
            while(rs.next()) {
                kontobelob = rs.getInt(1);
            }
            System.out.println(kontobelob);
            //
            double restSum = kontobelob-belob;
            System.out.println(restSum);

            //
            String query2 = "UPDATE kontotable SET "+kontotypen +" = "+restSum +" where p_id = "+p_id+" ";

            try{
                //
                stmt=con.createStatement();
                //
                stmt.executeUpdate(query2);


                //IKKKE FÆRDIG!  ! !  !
                String query3 = "SELECT lonkonto FROM kontotable where p_id ="+p_id+" ";
                try {
                    stmt =con.createStatement();
                    rs= stmt.executeQuery(query3);
                    double modtagerKontoBelob = 0.0;
                    while (rs.next()) {
                        modtagerKontoBelob = rs.getInt(1);

                        double nySum = modtagerKontoBelob+belob;
                        System.out.println(nySum);

                        //String query4 = "UPDATE kontotable set lonkonto = "
                        String query4 = "UPDATE kontotable SET lonkonto = " +nySum +" where p_id = "+kontonr+" ";

                        try{
                            stmt =con.createStatement();
                            stmt.executeUpdate(query4);
                            System.out.println("Det lykkedes :D");


                        }
                        catch(SQLException ex4) {
                            ex4.printStackTrace();
                            System.out.println("HOV, det virkede sgu ikke med at flytte penge.");


                        }

                    }
                    System.out.println(modtagerKontoBelob);
                }catch (SQLException exs){
                    exs.printStackTrace();
                }



            }
            catch (SQLException ex){
                ex.printStackTrace();
                System.out.println("---Fejl i pengetræk---");

            }



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("---Fejl i Overførelse---");
        }


    }

    //Metoder til at hente værdier fra kontotable
    //Vælger lonkonto hvor p_id er 1
    public void lonkontoværdier(int p_id) {
        String query = "select lonkonto, lonRente, lonOT from kontotable WHERE p_id = " + p_id + " ";
        try {
            //Connection
            stmt = con.createStatement();
            //Execute query
            rs = stmt.executeQuery(query);
            System.out.println("lonkonto \t lonRente \t lonOT");
            while (rs.next()) {
                String lonkonto = rs.getString("lonkonto"); //returns p_id
                String lonRente = rs.getString("lonRente"); //returns p_id
                String lonOT = rs.getString("lonOT"); //returns p_id
                System.out.println("\t" + lonkonto + "\t\t" + lonRente + "\t\t\t" + lonOT);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void opsparingskontoværdier(int p_id) {
        String query = "select opsparing, opsRente, opsOT from kontotable WHERE p_id = " + p_id + " ";
        try {
            //Connection
            stmt = con.createStatement();
            //Execute query
            rs = stmt.executeQuery(query);
            System.out.println("opsparing \t opsRente \t opsOT");
            while (rs.next()) {
                String opsparing = rs.getString("opsparing"); //returns p_id
                String opsRente = rs.getString("opsRente"); //returns p_id
                String opsOT = rs.getString("opsOT"); //returns p_id
                System.out.println("\t" + opsparing + "\t\t" + opsRente + "\t\t\t" + opsOT);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}