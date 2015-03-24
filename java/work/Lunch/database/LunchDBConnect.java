/*********** JAVA Project which working with Databases ***************
********* Version 1.0 *********************************************/


/**
 * Using standart libraries
 */

import java.sql.*;  
import java.util.*;

/**
@brief  Class to work with the database 
@detailed Connects to the database, when creating
 */
public class LunchDBConnect {
/**
@param st preparating to database request
@param rs saving request answer 
@param connection creating connection to database 
 */
    public Statement st = null;
    public ResultSet rs = null;
    public Connection connection = null;

/**
@brief Constructor
@param url full path to database for connect
@param user username for database
@param password password for user in  database
@throw DatabaseError if an error occurred, when connected to a database
*/

    public LunchDBConnect(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException error) {
            System.out.println("Connection failed: incorrect username or password");
            return;
        }
    }

/**
@brief Select from the database a list of places
@return  List of places or null if exception error 
@throw sqlexception error if an error occurred working with database
*/

    public ArrayList getPlaces() throws SQLException{
        ArrayList<Places> placesList = new ArrayList<Places>();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM place");
            if (rs==null) {
            throw new SQLException();}
            while(rs.next()) {
                Places place=new Places(rs.getInt("id"),rs.getString("place_name"));
                placesList.add(place);
            }
            return placesList;
    }

/**
@detailed This method gets login id with username and password and returns generated session id
@param username for logged in user
@param password for logged in user
@returns session id for current user, and 404 error, when throw 
@throw sqlexception error, when wrong username or password 
*/

    public String login(String username, String password) throws SQLException{
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO session(login_id) VALUES ((SELECT id FROM login WHERE username='" + username + "' AND password='" + password + "'))",Statement.RETURN_GENERATED_KEYS);
			rs=st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getString("session_id");
            } else {
                return "#404";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        	return "#500";
		}
    }

/**
@detailed This method gets session id and 
returns order list for current user
@param session_id generating, when gets login id
@returns order list or empty list or null
@throw sqlexception error, when wrong session id
*/

    public ArrayList getOrderList(int session_id) {
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_id,products_name,place_id,place_name,Orders.count, Orders.login_id,Orders.date,status FROM productsByPlaces,Orders,products, place WHERE unique_product_id=productsByPlaces.id AND place_id=place.id AND products_id=products.id AND Orders.date=CURRENT_DATE AND Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ")");
            while (rs.next()) {
                Order order = new Order(rs.getString("place_name"),rs.getInt("place_Id"),rs.getString("products_name"),rs.getInt("products_id"),rs.getInt("count"),rs.getString("date"),rs.getString("status"));
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException ex) {
            System.out.println("Select not failed.Session id not found");
            return null;
        }
    }

/**
@detailed This method gets session id and order id
and removes order for current user
@param session_id generating, when gets login id
@param order_id unique value of order 
@returns true, when successfully removed order or false, when not removed
@throw sqlexception error if an error occurred working with database
*/

    public String deleteOrder(int session_id, int order_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM Orders WHERE Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ") AND Orders.id=" + order_id + ";");
            return "#200";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "#404" ;
        }
    }

/**
@detailed This method gets place id and a few letters for product name
and returns product name list, which starting with that letters
@param place_id unique values of places
@param word part of letters for product name 
@returns products list or null, when sqlexception error
@throw sqlexception error if an error occurred working with database
*/

    public ArrayList getProducts(int place_id, String word) {
        ArrayList<Products> productsList = new ArrayList<Products>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_id, products_name FROM products,productsByPlaces WHERE productsByPlaces.place_id=" + place_id + " AND products_id=products.id AND products_name Like '" + word + "%'");
            while (rs.next()) {
                Products products = new Products(rs.getString("products_name"),rs.getInt("products_id"));
                productsList.add(products);
            }
            return productsList;
        } catch (SQLException ex) {
            return null;
        }
    }

/**
@detailed This method gets session id , place id , products id
and product count, and inserts its to order list
@param session_id unique value for current user
@param place_id unique values for places
@param products_id unique values for products 
@param count count of product
@returns true, when order added into database or false, when sqlexception
@throw sqlexception error if an error occurred working with database
*/

    public String addOrder(int session_id, int place_id, int products_id, int count) {
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Orders(login_id,unique_product_id,count,date,status) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + "),(SELECT id FROM productsByPlaces WHERE place_id=" + place_id + " AND products_id=" + products_id + ")," + count + ",CURRENT_DATE,'yes')",Statement.RETURN_GENERATED_KEYS);
            rs=st.getGeneratedKeys();
			if (rs.next()) {
                return rs.getString("id");
            } else {
                return "#404";
            }
        } catch (SQLException ex) {
            return "#500";
        }
    }

/**
@brief This method returns distributors list
@returns distributors list or null if sqlexception error 
@throw sqlexception error if an error occurred working with database
*/

    public ArrayList getDistributors() {
        ArrayList<Distributors> distributorsList = new ArrayList<Distributors>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT username,delivery.login_id,place_name,delivery.place_id FROM login,place,delivery WHERE delivery.login_id=login.id AND delivery.place_id=place.id AND delivery.date=CURRENT_DATE");
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

/**
@detailed This method gets session id, place id 
and inserts into delivery list current username
@param session_id unique value for current user
@param place_id unique values for places
@returns true, when successfully inserted order or false, when not inserted 
@throw sqlexception error if an error occurred working with database
*/

    public String becomeDistributors(int session_id, int place_id) {
        try {
            st = connection.createStatement();
			rs = st.executeQuery("SELECT id FROM delivery WHERE date=CURRENT_DATE AND place_id="+place_id);
			if(rs.next()) {
            	st.executeUpdate("INSERT INTO delivery(login_id,place_id,date) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + ")," + place_id + ",CURRENT_DATE)");
        	    return "#200";
			} else {
				throw new Exception();
			}
        } catch (Exception ex) {
            return "#409";
        }
	}  

/**
@detailed This method  gets place id and
returns overall count of orders by product name and product id
@param place_id unique values for places
@returns Products list or sqlexception error
@throw sqlexception error if an error occurred working with database
*/

    public ArrayList getProducts(int place_id) {
        ArrayList<Products> productsList = new ArrayList<Products>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,products_id,SUM(count) FROM products,Orders,productsByPlaces WHERE Orders.date=CURRENT_DATE AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,productsByPlaces.id");
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

/**
@detailed This method gets place id and login id
and returns orders for the current user at current day
@param place_id unique values of places
@param login_id unique value for current user
@returns orders by places list or null, when sqlexception error
@throw sqlexception error if an error occurred working with database
*/

    public ArrayList getOrders(int place_id, int login_id) {
        ArrayList<OrdersByPlaces> ordersByPlacesList = new ArrayList<OrdersByPlaces>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,sum(count),username FROM login,products,Orders,productsByPlaces WHERE Orders.date=CURRENT_DATE AND login.id=Orders.login_id AND Orders.login_id=" + login_id + " AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,login.id");
            while(rs.next()) {
                OrdersByPlaces orderByPlaces = new OrdersByPlaces(rs.getString("products_name"),rs.getInt("count"),rs.getString("username"));
                ordersByPlacesList.add(orderByPlaces);
            }
            return ordersByPlacesList;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

/**
@detailed This method gets place id and 
returns overall count of orders by product name and product id
for all users at current day
@param place_id unique values of places
@returns Products by places list or null, when sqlexception error
@throw sqlexception error if an error occurred working with database
*/

    public ArrayList getOrders(int place_id) {
        ArrayList<OrdersByPlaces> ordersByPlacesList = new ArrayList<OrdersByPlaces>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT products_name,sum(count),username FROM login,products,Orders,productsByPlaces WHERE Orders.date=CURRENT_DATE AND login.id=Orders.login_id AND Orders.login_id=login_id AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,login.id ORDER BY username");
            while(rs.next()) {
                OrdersByPlaces orderByPlaces = new OrdersByPlaces(rs.getString("products_name"),rs.getInt("count"),rs.getString("username"));
                ordersByPlacesList.add(orderByPlaces);
            }
            return ordersByPlacesList;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

/**
@detailed This method gets session id and
removes it from database (log outing)
@param session_id unique value for current user
@returns true, when session removed in database or false, when not removed
@throw sqlexception error if an error occurred working with database
*/

    public String logout(int session_id) {
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE FROM session WHERE session_id=" + session_id);
            return "#200";
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Session id not found.Delete failed");
            return "#404";
        }
    }
	public String isSessionId(int session_id) {
        try {
            st = connection.createStatement();
            rs=st.executeQuery("SELECT session_id FROM session WHERE session_id=" + session_id);
			if(rs.next()) {
            	return "#200";
			} else {
                return "#404";
            }
        } catch (SQLException ex) {
            //System.out.println("Session id not found.");
            return "#500";
        }
	
	}

}
