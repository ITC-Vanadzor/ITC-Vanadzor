import java.sql.*;

public class LunchDbConnect {

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
    Lunch lunch=new Lunch("jdbc:postgresql://127.0.0.1:5432/lunch","postgres", "marine1990");
    lunch.getPlaces();
    lunch.login("Marine","marine");
  }
}
