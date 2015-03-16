
import java.sql.*;
import java.util.*;

public class Lunch {

    String url;
    String user;
    String password;
    public Statement st = null;
    public ResultSet rs = null;
    public ResultSet resultSessionId=null;
    public Connection connection = null;
    public int session_id;

    public Lunch(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException error) {
            System.out.println("Connection failed: incorrect username or password");
            return;
        }
/*        if (connection != null) {
            System.out.println("Connection made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
*/
    }

    public ResultSet getPlaces() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM place");
            return rs;
        } catch (SQLException error) {
            System.out.println(error);
            return null;
        }
//		return rs;
    }
    // AREG -> be attentive while implementing API according to the discussed / confirmed spec
    public Integer login(String username, String password) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT id FROM login WHERE username='" + username + "' AND password='" + password + "'");
            if (rs.next()) {
                st.executeUpdate("INSERT INTO session(login_id) VALUES ('" +rs.getInt("id") + "')");
                resultSessionId=st.executeQuery("SELECT session_id FROM session WHERE login_id="+rs.getInt("id"));
            }
            if (resultSessionId.next()) {
              return resultSessionId.getInt("session_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return 404;  
        }
    }

    public ResultSet getOrderList(int session_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_id,products_name,place_id,place_name,Orders.count, Orders.login_id,Orders.date,status FROM productsByPlaces,Orders,products, place WHERE unique_product_id=productsByPlaces.id AND place_id=place.id AND products_id=products.id AND  Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ")");
            return rs;
        } catch (SQLException ex) {
            System.out.println("Select fail");
            return null;
        }
    }

    public String deleteOrder(int session_id, int order_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM Orders WHERE Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ") AND Orders.id=" + order_id + ";");
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
            rs = st.executeQuery("SELECT products_id, products_name FROM products,productsByPlaces WHERE productsByPlaces.place_id=" + place_id + " AND products_id=products.id AND products_name Like '" + word + "%'");
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
            st.executeUpdate("INSERT INTO Orders(login_id,unique_product_id,count,date,status) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + "),(SELECT id FROM productsByPlaces WHERE place_id=" + place_id + " AND products_id=" + products_id + ")," + count + ",'2015.03.01','yes')");

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getDistributors() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT username,delivery.login_id,place_name,delivery.place_id FROM login,place,delivery WHERE delivery.login_id=login.id AND delivery.place_id=place.id");
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
            st.executeUpdate("INSERT INTO delivery(login_id,place_id,date) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + ")," + place_id + ",'2015.01.18')");

            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getProducts(int place_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,products_id,SUM(count) FROM products,Orders,productsByPlaces WHERE productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,productsByPlaces.id");
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
            rs = st.executeQuery("SELECT products_name,sum(count),username FROM login,products,Orders,productsByPlaces WHERE login.id=Orders.login_id AND Orders.login_id="+login_id+" AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id="+place_id+" GROUP BY products_name,products.id,login.id");
            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getOrders(int place_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,sum(count),username FROM login,products,Orders,productsByPlaces WHERE login.id=Orders.login_id AND Orders.login_id=login_id AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id="+place_id+" GROUP BY products_name,products.id,login.id ORDER BY username");
            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }
}
