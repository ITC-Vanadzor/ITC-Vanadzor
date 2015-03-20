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
        
        GetResponces getResponce = new GetResponces("jdbc:postgresql://localhost:5432/","postgres", "postgres"); 
        //System.out.println(getResponce.getSessionId("{\"username\": \"Karen\", \"password\": \"karen\"}"));
        //getResponce.responsePlacesList();
        //getResponce.responseAddOrder("{\"sessionId\":\"2\",\"placeId\":\"13\",\"productId\":\"2\",\"count\":\"4\"}");
        //getResponce.responseAddOrder("{\"sessionId\":\"2\",\"placeId\":\"14\",\"productId\":\"1\",\"count\":\"2\"}");
        
        //getResponce.responseOrdersByPerson("{\"placeId\":\"1\",\"loginId\":\"6\"}");
        //getResponce.responseOrdersByPlace("{\"placeId\":\"1\"}");
        //getResponce.responseProductsList("{\"placeId\":\"2\", \"inputStr\":\"ttv\"}");
        //getResponce.responseOrdersList("{\"sessionId\": \"2\"}");
        //getResponce.responseDeleteOrder("{\"sessionId\":\"2\",\"orderId\":\"14\"}");
        //getResponce.responseLogOut("{\"sessionId\": \"2\"}");
        //getResponce.responseGetDistributors();
        getResponce.responseBecomeDistributor("{\"sessionId\":\"2\",\"placeId\":\"14\"}");
    
    }
}
