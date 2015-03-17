
import java.text.*;
import java.sql.*;
import java.util.*;

public class Lunch {

    String url;
    String user;
    String password;
    public Statement st = null;
    public ResultSet rs = null;
    //public ResultSet resultSessionId = null;
    public Connection connection = null;
    public int session_id;
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    //Date date = new Date();
    ArrayList<Places> placesList = new ArrayList<Places>();
    ArrayList<Order> orderList = new ArrayList<Order>();
    ArrayList<Products> productsList = new ArrayList<Products>();
    ArrayList<Distributors> distributorsList = new ArrayList<Distributors>();
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

    public ArrayList getPlaces() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM place");
            while(rs.next()) {
                Places place=new Places(rs.getInt("id"),rs.getString("place_name"));
                placesList.add(place);
            }
            return placesList;
        } catch (SQLException error) {
            return null;
        }
    }

    // AREG -> be attentive while implementing API according to the discussed / confirmed spec

    public int login(String username, String password) {
        try {(rs.getString("place_name"),
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO session(login_id) VALUES ((SELECT id FROM login WHERE username='" + username + "' AND password='" + password + "'))");
            rs = st.executeQuery("SELECT session_id FROM session WHERE login_id=(SELECT id FROM login WHERE username='" + username + "' AND password='" + password + "')");

            if (rs.next()) {
                return rs.getInt("session_id");
            }
        } catch (SQLException ex) {
            System.out.println("User not found");
        }
        return 404;
    }

    public Order getOrderList(int session_id) {
        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT products_id,products_name,place_id,place_name,Orders.count, Orders.login_id,Orders.date,status FROM productsByPlaces,Orders,products, place WHERE unique_product_id=productsByPlaces.id AND place_id=place.id AND products_id=products.id AND  Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ")");
            if (rs.next()) {
                Order order = new Order(rs.getString("place_name"),rs.getInt("place_Id"),rs.getString("products_name"),rs.getInt("products_id"),rs.getInt("count"),rs.getString("date"),rs.getString("status"));
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException ex) {
            System.out.println("Select not failed.Session id not found");
            return null;
        }
    }

    public boolean deleteOrder(int session_id, int order_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM Orders WHERE Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ") AND Orders.id=" + order_id + ";");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false ;
        }
    }

    public ArrayList getProducts(int place_id, String word) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_id, products_name FROM products,productsByPlaces WHERE productsByPlaces.place_id=" + place_id + " AND products_id=products.id AND products_name Like '" + word + "%'");
            while (rs.next()) {
                Products products = new Products(rs.getString("products_name"),rs.getInt("products_id"));
                productsList.add(products);
            }
            return productsList;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
                System.out.println(rs.getString("products_name"));

    public boolean addOrder(int session_id, int place_id, int products_id, int count) {
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Orders(login_id,unique_product_id,count,date,status) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + "),(SELECT id FROM productsByPlaces WHERE place_id=" + place_id + " AND products_id=" + products_id + ")," + count + ",'2015.13.05','yes')");

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ArrayList getDistributors() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT username,delivery.login_id,place_name,delivery.place_id FROM login,place,delivery WHERE delivery.login_id=login.id AND delivery.place_id=place.id");
            while (rs.next()) {
            Distributors distributor = new Distributors(rs.getString("username"),rs.getInt("login_id"),rs.getString("place_name"),rs.getInt("place_id"));
            distributorsList.add(distributor);
            }
            return distributorsList;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean becomeDistributors(int session_id, int place_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO delivery(login_id,place_id,date) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + ")," + place_id + ",'2015.01.18')");

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ArrayList getProducts(int place_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,products_id,SUM(count) FROM products,Orders,productsByPlaces WHERE productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,productsByPlaces.id");
            while (rs.next()) {
            Products products = new Products(rs.getString("products_name"), rs.getInt("products_id"), rs.getInt("count"));
            productsList.add(products);
            }
            return productsList;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String getOrders(int place_id, int login_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,sum(count),username FROM login,products,Orders,productsByPlaces WHERE login.id=Orders.login_id AND Orders.login_id=" + login_id + " AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,login.id");
            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public String getOrders(int place_id) {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,sum(count),username FROM login,products,Orders,productsByPlaces WHERE login.id=Orders.login_id AND Orders.login_id=login_id AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,login.id ORDER BY username");
            return "1";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "-1";
        }
    }

    public boolean logout(int session_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM session WHERE session_id=" + session_id);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Session id not found.Delete failed");
            return false;
        }
    }
}
