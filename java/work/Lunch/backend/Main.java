//*********** Testing LunchDBConnect class methods ************

import java.sql.*;
import java.util.*;


/**
 * This class connects to database and creating object from LunchDBConnect
 * arguments(url,username,password)
 */
public class Main {

    public static void main(String[] args) { 
        //LunchDBConnect dbClass = new LunchDBConnect("jdbc:postgresql://localhost:5432/","postgres", "postgres");
        
        GetResponses getResponse = new GetResponses("jdbc:postgresql://localhost:5432/","postgres", "postgres"); 
        //System.out.println(getResponse.getSessionId("{\"username\": \"Karen\", \"password\": \"karen\"}"));
        //System.out.println(getResponse.responsePlacesList());
        //System.out.println(getResponse.responseAddOrder("{\"sessionId\":\"2\",\"placeId\":\"13\",\"productId\":\"2\",\"count\":\"4\"}"));
        //System.out.println(getResponse.responseAddOrder("{\"sessionId\":\"2\",\"placeId\":\"14\",\"productId\":\"1\",\"count\":\"2\"}"));
        
        //System.out.println(getResponse.responseOrdersByPerson("{\"placeId\":\"1\",\"loginId\":\"6\"}"));
        //System.out.println(getResponse.responseOrdersByPlace("{\"placeId\":\"1\"}"));
        //System.out.println(getResponse.responseProductsList("{\"placeId\":\"2\", \"inputStr\":\"ttv\"}"));
        //System.out.println(getResponse.responseOrdersList("{\"sessionId\": \"2\"}"));
        //System.out.println(getResponse.responseDeleteOrder("{\"sessionId\":\"2\",\"orderId\":\"14\"}"));
        //System.out.println(getResponse.responseLogOut("{\"sessionId\": \"2\"}"));
        //System.out.println(getResponse.responseGetDistributors());
        //System.out.println(getResponse.responseBecomeDistributor("{\"sessionId\":\"2\",\"placeId\":\"14\"}"));
    
    }
}
