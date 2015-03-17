
import java.sql.*;

// AREG -> add Doxygen comments
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
        Lunch lunch = new Lunch("jdbc:postgresql://127.0.0.1:5432/lunch", "postgres", "postgres");
//        lunch.getPlaces();
  //      System.out.println("*************" + lunch.getPlaces() + "**********");
        //lunch.login("Sargis", "sargis");
        //System.out.println(lunch.login("Marine", "marine"));
        //System.out.println(lunch.deleteOrder(2, 12));
        System.out.println(lunch.getOrderList(1));
        //System.out.println(lunch.getProducts(2, "ttv"));
        //System.out.println(lunch.addOrder(2, 1, 1, 6));
        //System.out.println(lunch.getDistributors());
        //System.out.println(lunch.becomeDistributors(15, 1));
        //System.out.println(lunch.getProducts(1));
        //System.out.println(lunch.getOrders(1, 3));
        //System.out.println(lunch.getOrders(1));
        //System.out.println(lunch.logout(1));
    }
}
