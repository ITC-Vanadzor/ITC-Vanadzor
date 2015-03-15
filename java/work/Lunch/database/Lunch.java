
import java.sql.*;
import java.util.*;

public class Lunch {

    String url;
    String user;
    String password;
    public Statement st = null;
    public ResultSet rs = null;
    public Connection connection = null;
    public int session_id;

    public Lunch(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return;
        }
        if (connection != null) {
            System.out.println("Connection made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public ResultSet getPlaces() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM place");
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("place_name"));

            }
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;

        }
//		return rs;
    }

    public String login(String username, String password) {
        System.out.println(password);

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT id FROM login WHERE username='" + username + "' AND password='" + password + "'");
            if (rs.next()) {
                int kk = rs.getInt("id");
                System.out.println(kk);
                st.executeUpdate("INSERT INTO session(login_id) VALUES ('" + kk + "')");
            }
            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getOrderList(int session_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select products_id,products_name,place_id,place_name,Orders.count, Orders.login_id,Orders.date,status from productsByPlaces,Orders,products, place where unique_product_id=productsByPlaces.id and place_id=place.id and products_id=products.id and  Orders.login_id=(select login_id from session where session_id=" + session_id + ")");
            while (rs.next()) {
                System.out.println(rs.getString("place_name"));
                System.out.println(rs.getString("products_name"));
            }
            return "1";

        } catch (SQLException ex) {
            System.out.println("Select fail");
            return "-1";
        }
        //	return rs;
    }

    public String deleteOrder(int session_id, int order_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM Orders WHERE Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ") and Orders.id=" + order_id + ";");
            return "1";
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Delete fail");

            return "-1";
        }
    }

    public String getProducts(int place_id, String word) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select products_id, products_name from products,productsByPlaces where productsByPlaces.place_id=" + place_id + " and products_id=products.id and products_name Like '" + word + "%'");
            while (rs.next()) {

                System.out.println(rs.getString("products_name"));

            }
            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String addOrder(int session_id, int place_id, int products_id, int count) {
        try {
            st = connection.createStatement();
            st.executeUpdate("insert into Orders(login_id,unique_product_id,count,date,status) values ((select login_id from session where session_id=" + session_id + "),(select id from productsByPlaces where place_id=" + place_id + " and products_id=" + products_id + ")," + count + ",'2015.03.01','yes')");

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getDistributors() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select username,delivery.login_id,place_name,delivery.place_id from login,place,delivery where delivery.login_id=login.id and delivery.place_id=place.id");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String becomeDistributors(int session_id, int place_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("insert INTO delivery(login_id,place_id,date) values ((select login_id from session where session_id=" + session_id + ")," + place_id + ",'2015.01.18')");

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getProducts(int place_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select products_name,products_id,sum(count) from products,Orders,productsByPlaces where productsByPlaces.products_id=products.id and Orders.unique_product_id=productsByPlaces.id and productsByPlaces.place_id=" + place_id + " group by products_name,products.id,productsByPlaces.id");
            while (rs.next()) {
                System.out.println(rs.getString("products_name"));
            }

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getOrders(int place_id, int login_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select products_name,sum(count),username from login,products,Orders,productsByPlaces where login.id=Orders.login_id and Orders.login_id=3 and productsByPlaces.products_id=products.id and Orders.unique_product_id=productsByPlaces.id and productsByPlaces.place_id=1 group by products_name,products.id,login.id");
            while (rs.next()) {
                System.out.println(rs.getString("products_name"));
            }

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getOrders(int place_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select products_name,sum(count),username from login,products,Orders,productsByPlaces where login.id=Orders.login_id and Orders.login_id=login_id and productsByPlaces.products_id=products.id and Orders.unique_product_id=productsByPlaces.id and productsByPlaces.place_id=1 group by products_name,products.id,login.id order by username");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }
}
