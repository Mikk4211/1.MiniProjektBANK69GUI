package sample;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
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
        catch (SQLException ex) {
            System.out.println("\n ---statement did not execute (create database)---");
            ex.printStackTrace();
        }
    }

    /**
     * En Methode der sikre os at vi bruger den rigtige Database.
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
        catch (SQLException ex) {
            System.out.println("\n---Statement did not execute (Use database)---");
            ex.printStackTrace();
        }
    }


    /*En methode der dropper vores DB, så vi kan lave en ny, af samme navn. Denne bliver brugt når vi "resetter" bankens oplysninger*/
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

    /*Methode der dropper kundetable, bruges når vi "resetter" banken*/
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
    /*Methode der dropper kontotable, bruges når vi "resetter" banken*/
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

    /*En methode der opretter et kundetable, bruges når man klikker "Opret DB+Table"*/
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
        catch (SQLException ex) {
            System.out.println("\n---Statement did not execute (kontotable)---");
            ex.printStackTrace();
        }
    }

    /*Methode til at lave et kundetable,  bruges når man klikker "Opret DB+Table"*/
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


    /*Methode der indsætter ny kunde, i kunde table*/
    public void insertNyKunde(String tempFornavn, String tempEfternavn, int tempCprFirst, int tempnyCprLast, String tempAdr) {

        //    SQL statement
        String query = "INSERT INTO kundeTable " +
                "(fName, lName, cprFirst, cprLast,  address) VALUES ('" +
                tempFornavn + "', '" +
                tempEfternavn + "', " +
                tempCprFirst + ", " +
                tempnyCprLast + ", '" +
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
        catch (SQLException ex) {
            System.out.println("\n---Ny kunde kunne ikke oprettes.---");
            ex.printStackTrace();
        }
    }

    /*Methode til at insætte hans bank værdier, altså hans beløb osv.*/
    public void insertNyKundeBankVardier(double lonkonto, double opsparing, double lonrente, double opsrente, int lonot, int opsot) {
        //SQL statement
        String query = "INSERT INTO kontotable" +
                "(lonkonto, opsparing, lonRente, opsRente, lonOT, opsOT) VALUES (" +
                lonkonto + ", " +
                opsparing + ", " +
                lonrente + ", " +
                opsrente + ", " +
                lonot + ", " +
                opsot + ")";
        try {
            //create statementk
            stmt = con.createStatement();

            //execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Ny Konto oprettet---");
        }

        //    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n---Ny konto kunne ikke oprettes.---");
            ex.printStackTrace();
        }


    }

    /*Methode for at indsætte testværdier i kundetable*/
    public void insertTestKunder() {

        //    SQL statement
        String query = "insert into kundeTable " +
                "(fName, lName, cprFirst, cprLast, address) " +
                "values ('Benjamin', 'Ejrup', 111187, 1234, 'Slotsgade 9 2.tv'), " +
                "('Mads', 'Nielsen', 123456, 1234, 'HerogNuvej 5'), " +
                "('Mathias', 'Bruun', 234567, 1234, 'Vejnavn 3'), " +
                "('Mikkel', 'Bøgse', 345678, 1234, 'Vejnavn 4'), " +
                "('Johan', 'Stenbøgs', 456789, 1234, 'Vejnavn 5'), " +
                "('Johannes', 'Awesome', 4567129, 5343, 'Vejnavn 10')";

        try {

            //    create statement
            stmt = con.createStatement();

            //    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n---Nye testkunder oprettet---");
        }

        //    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n---Nye testkunder kunne ikke oprettes---");
            ex.printStackTrace();
        }
    }


    /*Methode for at indsætte testværdier i kontotable */
    public void insertTestKonto() {

        //    SQL statement - Indsætter data ind i kontotable, i kolonnerne, lonkonto, opsparing, lonrente, opsrente, lonOT, og opsOT
        String query = "insert into kontoTable " +
                "(lonkonto, opsparing, lonRente, opsrente, lonOT, opsOT) " +
                "values " +
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
        catch (SQLException ex) {
            System.out.println("\n---Nye kontoer kunne ikke oprettes.---");
            ex.printStackTrace();
        }
    }

    /*Methode til at læse fra kundetable*/
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
            while (rs.next()) {
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
        catch (SQLException ex) {
            System.out.println("\n---Statement did not execute (select query)---");
            ex.printStackTrace();
        }

    }

    /* Henter modtagers Start beløb fra SQL*/
    public double gettingModtagersStartbelob(int p_id) {
        String query = "SELECT lonkonto FROM bank2017db.kontotable where p_id =" + p_id + " ";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            int i = 1;
            while (rs.next()) {
                double modtagerbelob = rs.getDouble(1);
                return modtagerbelob;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    /* Henter Overtræks beløbet fra SQL */
    public int gettingOTbelob(char kontotypen, int p_id){
       String kontotype = "lonOT";
       if (kontotypen=='o') {
            kontotype = "opsOT";
       }else if(kontotypen=='l'){
           kontotype="lonOT";
       }else{
           System.out.println("---Fejl, forkert konto type---");
       }
        //Sql statement
       String query = "SELECT " +kontotype+" FROM bank2017db.kontotable WHERE p_id =" +p_id+ " ";

       //Prøver at køre det
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            int otVardi = 0;
            while(rs.next()) {
                otVardi = rs.getInt(1);
                System.out.println(otVardi);
            }
            return otVardi;

            //System.out.println("---Hentede overtræk værdien : "+ otVardi+"---");
        } catch (SQLException e) {
            System.out.println("---Fejl, kunne ikke hente overtræk værdien ---");
            e.printStackTrace();
        }
        return 0;
    }

    /*Methode til at overfører beløb fra din konto til anden konto.*/
    //char kontotype: 'l' for lønkonto, og 'o' for opsparing.
    public void overfor(int p_id, char kontotype, double belob, int kontonr) {
        //
        //Vores query til at vælge opsparingskonto efter hvilket p_id du indtaster
        String query = "select opsparing from kontotable where p_id = "+p_id+" ";
        //
        String kontotypen= "opsparing";
        //Hvis du har skrevet o
        if (kontotype=='o'){
            //Så er det opsparing den bruger
            kontotypen = "opsparing";
            // ellers hvis du har skrevet l
        } else if(kontotype=='l'){
            //Så bruger den lønkonto
            kontotypen = "lonkonto";
        } else {

            System.out.println("FEJL, forkert kontotype");
        }
        query = "select " + kontotypen + " from kontotable where p_id = " + p_id + " ";


        try {
            //create statement
            stmt = con.createStatement();

            //execute statement
            rs = stmt.executeQuery(query);

            double kontobelob = 0.0;
            while (rs.next()) {
                kontobelob = rs.getInt(1);
            }
            // Printline som printer kontobeløb. Før man har overført noget.
            System.out.println("Beløbet på afsenders konto før overførelse: " +kontobelob);
            // et variabel og en printline som tager den resterende sum og printer den.
            double restSum = kontobelob-belob;
            System.out.println("Beløbet på afsenders konto efter overførelse: "+restSum);

            if((belob-kontobelob)<=gettingOTbelob(kontotype,p_id) ) {
                //Metode som opdaterer SQL tabellen efter en overførsel har fundet sted.
                String query2 = "UPDATE kontotable SET " + kontotypen + " = " + restSum + " where p_id = " + p_id + " ";

                try {
                    //create statement
                    stmt = con.createStatement();
                    //execute statement
                    stmt.executeUpdate(query2);

                    //
                    String query3 = "SELECT lonkonto FROM bank2017db.kontotable where p_id =" + p_id + " ";
                    try {
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query3);

                        System.out.println("GETTING STARTER BELØB: " + gettingModtagersStartbelob(kontonr));
                        double nySum = gettingModtagersStartbelob(kontonr) + belob;
                        System.out.println("Den nye sum hos modtager er :" + nySum);

                        //SQL statement
                        String query4 = "UPDATE kontotable SET lonkonto = " + nySum + " where p_id = " + kontonr + " ";

                        try {
                            stmt = con.createStatement();
                            stmt.executeUpdate(query4);
                            System.out.println("--- Overførsel lykkes ---");
                        } catch (SQLException ex4) {
                            ex4.printStackTrace();
                            System.out.println("--- fejl, Modtager modtog ikke beløbet ---");
                        }

                    } catch (SQLException exs) {
                        exs.printStackTrace();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("---Fejl i pengetræk---");

                }
            } else{
                System.out.println("---Fejl, du kan ikke overføre så mange penge, pga. dit overtræk ikke er stort nok---");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("---Fejl i Overførelse---");
        }


    }


    //Metode til at vise beløb på lønkonto og opsparingskontoen samt renten og max overtræk for de 2 kontoer.
    //Metoden navngives samt der opsættes 3 variabler. p_id er konto'idet, så den rigtige person får vist sin konto.
    public String opsparingskontovaerdier(int p_id, String kontoRenteOT, String kontoType) {
        //Sql statement, der går ind i databasen og henter henholdsvis konto og opsparings beløb fra en selvvalgt p_id værdi.
        String query = "select lonkonto, opsparing, lonRente, opsRente, lonOT, opsOT from kontotable WHERE p_id = " + p_id + " ";
        //Deklarerer de forskellige variabler, til at være String.
        String lonkonto = " ";
        String lonRente = " ";
        String lonOT = " ";
        String opsparing = " ";
        String opsRente = " ";
        String opsOT = " ";
        //En try/catch blok der går prøver at hente værdierne fra databasen.
        try {
            //Connection
            stmt = con.createStatement();
            //Execute query
            rs = stmt.executeQuery(query);
            //Opsætter et whileloop.
            while (rs.next()) {
                //I databasen, mens der er en værdi efter den læste værdi, fortsætter den indtil der ikke er flere.
                //Derefter deklarereres værdierne.
                lonkonto = rs.getString("lonkonto"); //returns p_id
                lonRente = rs.getString("lonRente"); //returns p_id
                lonOT = rs.getString("lonOT"); //returns p_id
                opsparing = rs.getString("opsparing"); //returns p_id
                opsRente = rs.getString("opsRente"); //returns p_id
                opsOT = rs.getString("opsOT"); //returns p_id
            }
            //Først kontrolleres kontoType, om det er til lønkontoen eller opsparingskontoen.
            if (kontoType == "lonkonto") {
                //Hvis det andet argument er lonkonto, skal den retunere værdierne fra lonkonto.
                if (kontoRenteOT == "lonkonto") {
                    return lonkonto + " dkk.";
                    //Hvis det andet argument er lonRente, skal den retunere værdierne fra lonRente.
                } else if (kontoRenteOT == "lonRente") {
                    return lonRente + "%";
                    //Hvis  det andet argument er lonOT, skal den retunere værdierne for lonOT.
                } else if (kontoRenteOT == "lonOT") {
                    return lonOT + " dkk.";
                    //Hvis det andet argument ikke er et af de 3 over, er der sket en fejl og det retunerer den.
                } else {
                    return "fejl";
                }
                //Det samme som over, bare i forhold til opsparingskontoen.
            } else if (kontoType == "opsparingskonto") {
                if (kontoRenteOT == "opsparing") {
                    return opsparing + " dkk.";
                } else if (kontoRenteOT == "opsRente") {
                    return opsRente + "%";
                } else if (kontoRenteOT == "opsOT") {
                    return opsOT + " dkk.";
                } else {
                    return "fejl";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("---fejl, problemer med at vise beløb for konto");
        }
        return "fejl";
    }

    public String labels_kundeliste(int id) {
        //Sql statement, der går ind i databasen og henter henholdsvis konto og opsparings beløb fra en selvvalgt p_id værdi.
        String query = "select lName, fName, cprFirst, cprLast from kundetable WHERE id = " + id + " ";
        //Deklarerer de forskellige variabler, til at være String.
        String lName = " ";
        String fName = " ";
        String cprFirst = " ";
        String cprLast = " ";
        //En try/catch blok der går prøver at hente værdierne fra databasen.
        try {
            //Connection
            stmt = con.createStatement();
            //Execute query
            rs = stmt.executeQuery(query);
            //Opsætter et whileloop.
            while (rs.next()) {
                //I databasen, mens der er en værdi efter den læste værdi, fortsætter den indtil der ikke er flere.
                //Derefter deklarereres værdierne.
                fName = rs.getString("fName"); //returns p_id
                lName = rs.getString("lName"); //returns p_id
                cprFirst = rs.getString("cprFirst"); //returns p_id
                cprLast = rs.getString("cprLast"); //returns p_id
                if (id <= fName.length() + 1) {
                    return lName + ", " + fName + ": " + cprFirst + "-" + cprLast + ", p_id:  " + id;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("---fejl, problemer med at vise beløb for konto");
        }
        return " ";
    }


}


