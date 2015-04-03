//package database

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

    public static void main(String[] argv) throws Exception {
        System.out.println("************PostgreSQL JDBC Driver Registered!");
        GetResponses lunch = new GetResponses("jdbc:postgresql://127.0.0.1:5432/lunchdb", "postgres", "postgres");
        System.out.println(lunch.getSessionId("{\"email\": \"Karen@gmail.com\", \"password\": \"karen\"}").getBody());
        //System.out.println(lunch.responsePlacesList().getBody());
        //System.out.println(lunch.responseAddOrder("{\"sessionId\":\"2\",\"placeId\":\"13\",\"productId\":\"2\",\"count\":\"4\"}").getBody());
        System.out.println("************Add Order");
        System.out.println(lunch.responseAddOrder("{\"sessionId\":\"50\",\"placeId\":\"2\",\"productId\":\"3\",\"count\":\"2\"}").getBody());
        System.out.println("************Order by Person WARNING");
        System.out.println(lunch.responseOrdersByPerson("{\"placeId\":\"1\",\"loginId\":\"6\"}").getBody());
        System.out.println("************Order by place ");
        System.out.println(lunch.responseOrdersByPlace("{\"placeId\":\"1\"}").getBody());
        System.out.println("************Products list");
        System.out.println(lunch.responseProductsList("{\"placeId\":\"2\", \"inputStr\":\"ttv\"}").getBody());
        System.out.println("************Orders list");
        System.out.println(lunch.responseOrdersList("{\"sessionId\": \"50\"}").getBody());
        System.out.println("************Delete order");
        System.out.println(lunch.responseDeleteOrder("{\"sessionId\":\"2\",\"orderId\":\"14\"}").getBody());
        System.out.println("************Logout");
        System.out.println(lunch.responseLogOut("{\"sessionId\": \"2\"}").getBody());
        System.out.println("************get Distributers");
        System.out.println(lunch.responseGetDistributors().getBody());
        System.out.println("************Become Distributers");
        System.out.println(lunch.responseBecomeDistributor("{\"sessionId\":\"2\",\"placeId\":\"14\"}").getBody());
    }
}
