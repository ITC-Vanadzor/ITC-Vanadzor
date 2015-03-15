
import java.sql.*;
import lunchdbconnect.Lunch;

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
        Lunch lunch = new Lunch("jdbc:postgresql://127.0.0.1:5432/lunch", "postgres", "marine1990");
        lunch.getPlaces();
        System.out.println("*************" + lunch.getPlaces() + "**********");
        lunch.login("Sargis", "sargis");
        //System.out.println(lunch.login("Stepan", "stepan"));
        //System.out.println(lunch.deleteOrder(2, 12));
        //System.out.println(lunch.getOrderList(2));
        //System.out.println(lunch.getProducts(2, "ttv"));
        //System.out.println(lunch.addOrder(2, 1, 1, 6));
        //System.out.println(lunch.getDistributors());
        //System.out.println(lunch.becomeDistributors(15, 1));
        //System.out.println(lunch.getProducts(1));
        //System.out.println(lunch.getOrders(1, 3));
        //System.out.println(lunch.getOrders(1));
    }
}
