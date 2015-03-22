/*********** Testing Main class methods **************
/********* Version 1.0 *****************************************/

/**
 * Using standart library
 */

import java.sql.*;

/**
 * This class connects to database and creating object 
 * from LunchDBConnect arguments(url,username,password)
 */

public class Main {

    public static void main(String[] argv) {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
        LunchDBConnect lunch = new LunchDBConnect("jdbc:postgresql://127.0.0.1:5432/lunch", "postgres", "postgres");
    }
}
