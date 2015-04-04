package com.itcvanadzor.lunch.database;

/**
 * ********* JAVA Project which working with Databases *************** ********
 * Version 1.0 ********************************************
 */
/**
 * Using standart libraries
 */
import java.sql.*;
import java.util.*;

/**
 * @brief Class to work with the database
 * @detailed Connects to the database, when creating
 */
public class LunchDBConnect {

    /**
     * @param st preparating to database request
     * @param rs saving2ssss request answer
     * @param connection creating connection to database
     */
    public Statement st = null;
    public ResultSet rs = null;
    public Connection connection = null;

    /**
     * @throws java.sql.SQLException
     * @brief Constructor
     * @param url full path to database for connect
     * @param user username for database
     * @param password password for user in database
     * @throw DatabaseError if an error occurred, when connected to a database
     */
    public LunchDBConnect(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    /**
     * @brief Select from the database a list of places
     * @return List of places
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if the placesList is empty
     */
//3**********
    public ArrayList getPlaces() throws Exception, SQLException {
        ArrayList<Places> placesList = new ArrayList<Places>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT * FROM place");
        while (rs.next()) {
            Places place = new Places(rs.getInt("id"), rs.getString("place_name"));
            placesList.add(place);
        }
        if (!(placesList.isEmpty())) {
            return placesList;
        } else {
            throw new Exception("List of places is empty");
        }
    }

    /**
     * @detailed This method gets login id with username and password and
     * returns generated session id
     * @param email for logged in user
     * @param password for logged in user
     * @returns session id for current user
     * @throw sqlexception error if an error occurred working with database
     * @throw sqlexception error, when wrong username or password
     */
    //*-********************1
    public int login(String email, String password) throws SQLException {
        st = connection.createStatement();
        if (st == null) {

            throw new SQLException();
        }
        st.executeUpdate("INSERT INTO session(login_id) VALUES ((SELECT id FROM login WHERE email='" + email + "' AND password='" + password + "'))", Statement.RETURN_GENERATED_KEYS);
        rs = st.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt("session_id");
        } else {
            throw new SQLException("Invalid username or password");
        }
    }

    /**
     * @detailed This method gets session id and returns order list for current
     * user
     * @param session_id generating, when gets login id
     * @returns order list
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error, if the orderList is empty
     */
//****************2
    public ArrayList getOrderList(int session_id) throws Exception, SQLException {
        ArrayList<Order> orderList = new ArrayList<Order>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT Orders.id,products_id,products_name,place_id,place_name,Orders.count, Orders.login_id,Orders.date,status FROM productsByPlaces,Orders,products, place WHERE unique_product_id=productsByPlaces.id AND place_id=place.id AND products_id=products.id AND Orders.date=CURRENT_DATE AND Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ")");
        while (rs.next()) {
            Order order = new Order(rs.getInt("id"), rs.getString("place_name"), rs.getInt("place_Id"), rs.getString("products_name"), rs.getInt("products_id"), rs.getInt("count"), rs.getString("date"), rs.getString("status"));
            orderList.add(order);
        }
        if (!(orderList.isEmpty())) {
            return orderList;
        } else {
            throw new Exception("List of order is empty");
        }
    }

    /**
     * @detailed This method gets session id and order id and removes order for
     * current user
     * @param session_id generating, when gets login id
     * @param order_id unique value of order
     * @returns true, when successfully removed order or false
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an invalid order id and order not removed
     */
//****************6
    public boolean deleteOrder(int session_id, int order_id) throws Exception, SQLException {
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        int deleteRowsCount = st.executeUpdate("DELETE FROM Orders WHERE Orders.login_id=(SELECT login_id FROM session WHERE session_id=" + session_id + ") AND Orders.id=" + order_id);
        if (deleteRowsCount != 0) {
            return true;
        } else {
            throw new Exception("Invalid order id");
        }
    }

    /**
     * @detailed This method gets place id and a few letters for product name
     * and returns product name list, which starting with that letters
     * @param place_id unique values of places
     * @param word part of letters for product name
     * @returns products list
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an products list is empty
     */
//***********************4
    public ArrayList getProducts(int place_id, String word) throws Exception, SQLException {
        ArrayList<Products> productsList = new ArrayList<Products>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT products_id, products_name FROM products,productsByPlaces WHERE productsByPlaces.place_id=" + place_id + " AND products_id=products.id AND products_name Like '" + word.toLowerCase() + "%'");
        while (rs.next()) {
            Products products = new Products(rs.getString("products_name"), rs.getInt("products_id"));
            productsList.add(products);
        }
        if (!(productsList.isEmpty())) {
            return productsList;
        } else {
            throw new Exception("List of products is empty");
        }
    }

    /**
     * @detailed This method gets session id , place id , products id and
     * product count, and inserts its to order list
     * @param session_id unique value for current user
     * @param place_id unique values for places
     * @param products_id unique values for products
     * @param count count of product
     * @returns true, when order added into database or false
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if this place doesn't have this product
     */
//***********************5
    public int  addOrder(int session_id, int place_id, int products_id, int count) throws Exception, SQLException {
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        st.executeUpdate("INSERT INTO Orders(login_id,unique_product_id,count,date,status) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + "),(SELECT id FROM productsByPlaces WHERE place_id=" + place_id + " AND products_id=" + products_id + ")," + count + ",CURRENT_DATE,'yes')", Statement.RETURN_GENERATED_KEYS);
        rs = st.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt("id");
        } else {
            throw new Exception("This place doesn't have this product");
        }
    }

    /**
     * @brief This method returns distributors list
     * @returns distributors list
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an distributors list is empty
     */
    // **************************7
    public ArrayList getDistributors() throws Exception, SQLException {
        ArrayList<Distributors> distributorsList = new ArrayList<Distributors>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT username,delivery.login_id,place_name,delivery.place_id FROM login,place,delivery WHERE delivery.login_id=login.id AND delivery.place_id=place.id AND delivery.date=CURRENT_DATE");
        while (rs.next()) {
            Distributors distributor = new Distributors(rs.getString("username"), rs.getInt("login_id"), rs.getString("place_name"), rs.getInt("place_id"));
            distributorsList.add(distributor);
        }
        if (!(distributorsList.isEmpty())) {
            return distributorsList;
        } else {
            throw new Exception("List of deistributors is empty");
        }
    }

    /**
     * @detailed This method gets session id, place id and inserts into delivery
     * list current username
     * @param session_id unique value for current user
     * @param place_id unique values for places
     * @returns true, when successfully inserted order
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an insert into delivery failed
     * @throw exception error if an there are people going to this place
     */
    //*************************************8
    public boolean becomeDistributors(int session_id, int place_id) throws Exception, SQLException {
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT id FROM delivery WHERE date=CURRENT_DATE AND place_id=" + place_id);
        if (!rs.next()) {
            int insertRowCount = st.executeUpdate("INSERT INTO delivery(login_id,place_id,date) VALUES ((SELECT login_id FROM session WHERE session_id=" + session_id + ")," + place_id + ",CURRENT_DATE)");
            if (insertRowCount != 0) {
                return true;
            } else {
                throw new Exception("Insert into delivery failed");
            }
        } else {
            throw new Exception("There are people going to this place");
        }
    }

    /**
     * @detailed This method gets place id and returns overall count of orders
     * by product name and product id
     * @param place_id unique values for places
     * @returns Products list
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an products list is empty
     */
    //*******************9
    public ArrayList getProducts(int place_id) throws Exception, SQLException {
        ArrayList<Products> productsList = new ArrayList<Products>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT products_name,products_id,SUM(count) FROM products,Orders,productsByPlaces WHERE Orders.date=CURRENT_DATE AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,productsByPlaces.id");
        while (rs.next()) {
            Products products = new Products(rs.getString("products_name"), rs.getInt("products_id"), rs.getInt("sum"));
            productsList.add(products);
        }
        if (!(productsList.isEmpty())) {
            return productsList;
        } else {
            throw new Exception("List of products is empty");
        }
    }

    /**
     * @detailed This method gets place id and login id and returns orders for
     * the current user at current day
     * @param place_id unique values of places
     * @param login_id unique value for current user
     * @returns orders by places list
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an orders by places list is empty
     */
    //*********************11
    public ArrayList getOrders(int place_id, int login_id) throws Exception, SQLException {
        ArrayList<OrdersByCostumer> ordersByCostumerList = new ArrayList<OrdersByCostumer>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT products_name,sum(count) FROM products,Orders,productsByPlaces,login WHERE Orders.date=CURRENT_DATE AND login.id=Orders.login_id AND Orders.login_id=" + login_id + " AND productsByPlaces.products_id=products.id AND Orders.unique_product_id=productsByPlaces.id AND productsByPlaces.place_id=" + place_id + " GROUP BY products_name,products.id,login.id");
        while (rs.next()) {
            OrdersByCostumer orderByCostumer = new OrdersByCostumer(rs.getString("products_name"), rs.getInt("sum"));
            ordersByCostumerList.add(orderByCostumer);
        }
        if (!(ordersByCostumerList.isEmpty())) {
            return ordersByCostumerList;
        } else {
            throw new Exception("List of order by places is empty");
        }
    }

    /**
     * @detailed This method gets place id and returns overall count of orders
     * by product name and product id for all users at current day
     * @param place_id unique values of places
     * @returns Products by places list
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if an orders by places list is empty
     */
    //****************10
    public ArrayList getCostumers(int place_id) throws Exception {
        ArrayList<CostumersByPlace> costumersByPlaceList = new ArrayList<CostumersByPlace>();
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("select Orders.login_id,login.username  from Orders,login,productsByPlaces where unique_product_id=productsByPlaces.id and productsByPlaces.place_id=" + place_id + " AND date=CURRENT_DATE and Orders.login_id=login.id Group by login_id,login.id");
        while (rs.next()) {
            CostumersByPlace costumersByPlace = new CostumersByPlace(rs.getInt("login_id"), rs.getString("username"));
            costumersByPlaceList.add(costumersByPlace);
        }
        if (!(costumersByPlaceList.isEmpty())) {
            return costumersByPlaceList;
        } else {
            throw new Exception("List of order by places is empty");
        }
    }

    /**
     * @detailed This method gets session id and removes it from database (log
     * outing)
     * @param session_id unique value for current user
     * @returns true, when session removed in database
     * @throw sqlexception error if an error occurred working with database
     * @throw exception error if session id not found ant delete failed
     */
//**********************12
    public boolean logout(int session_id) throws Exception, SQLException {
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        int deleteRowsCount = st.executeUpdate("DELETE FROM session WHERE session_id=" + session_id);
        if (deleteRowsCount != 0) {
            return true;
        } else {
            throw new Exception("Session id not found.Delete failed");
        }
    }

    public boolean isSessionId(int session_id) throws Exception, SQLException {
        st = connection.createStatement();
        if (st == null) {
            throw new SQLException();
        }
        rs = st.executeQuery("SELECT session_id FROM session WHERE session_id=" + session_id);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
}
