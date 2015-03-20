/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karen
 */
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.util.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.json.simple.JSONValue;

public class GetResponces {

    public JSONParser parser = new JSONParser();

    public String sessionId;

    LunchDBConnect lunch;

    public GetResponces(String host, String user, String password) {
        lunch = new LunchDBConnect(host, user, password);
    }

    public String getSessionId(String loginPass) {
        try {
            Map<String, String> jsonObj = (Map<String, String>) parser.parse(loginPass);
            sessionId = lunch.login(jsonObj.get("username"), jsonObj.get("password")).toString();
            return sessionId;
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
        return "";
    }

    public void responsePlacesList() {

        List<Places> placesList = new ArrayList<>();
        placesList = lunch.getPlaces();
        JSONArray jsonArr = new JSONArray();

        for (Places place : placesList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("placeId", place.id);
            jsonObj.put("placeName", place.placeName);
            jsonArr.add(jsonObj);
        }
        System.out.println(jsonArr);
    }

    public void responseOrdersList(String queryJson) {
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
                
        List<Order> ordersList = new ArrayList<>(); 
        ordersList = lunch.getOrderList(Integer.parseInt((String) jsonObj.get("sessionId")));
        JSONArray jsonArr = new JSONArray();
        
        for(Order ord : ordersList){
            JSONObject json = new JSONObject();
            json.put("placeId", ord.placeId);
            json.put("placeName", ord.placeName);
            json.put("productId", ord.productId);
            json.put("productName", ord.productName);
            json.put("count", ord.count);
            json.put("status", ord.status);
            jsonArr.add(jsonObj);
        }
        System.out.println(jsonArr);
    }
    
    public void responseOrdersByPerson(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        
        List<OrdersByPlaces> ordersList = new ArrayList<>();
        JSONArray jsonArr = new JSONArray();
        ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")), Integer.parseInt((String) jsonObj.get("loginId")));
        
        for(OrdersByPlaces order : ordersList){
            JSONObject json = new JSONObject();
            json.put("userName", order.username);
            json.put("productName", order.productName);
            json.put("count", order.count);
            jsonArr.add(json);
        }
        System.out.println(jsonArr);
    }
    
    public void responseOrdersByPlace(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        
        List<OrdersByPlaces> ordersList = new ArrayList<>();
        JSONArray jsonArr = new JSONArray();
        ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")));
        
        for(OrdersByPlaces order : ordersList){
            JSONObject json = new JSONObject();
            json.put("userName", order.username);
            json.put("productName", order.productName);
            json.put("count", order.count);
            jsonArr.add(json);
        }
        System.out.println(jsonArr);
    }
    
    public void responseProductsList(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        List<Products> productsList = new ArrayList<>();
        JSONArray jsonArr = new JSONArray();
        productsList = lunch.getProducts(Integer.parseInt((String) jsonObj.get("placeId")), (String) jsonObj.get("inputStr"));
        
        for(Products product : productsList){
            JSONObject json = new JSONObject();
            json.put("productId", product.productId);
            json.put("productName", product.productName);
            jsonArr.add(json);
        }
        System.out.println(jsonArr);
    }

    public void responseDeleteOrder(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println();
        
        boolean result = lunch.deleteOrder(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("orderId")));
        if(result){
            System.out.println("200");
        }else{
            System.out.println("404");
        }
    }

    public void responseAddOrder(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        
        int sessId = Integer.parseInt((String) jsonObj.get("sessionId"));
        int placeId = Integer.parseInt((String) jsonObj.get("placeId"));
        int productId = Integer.parseInt((String) jsonObj.get("productId"));
        int count = Integer.parseInt((String) jsonObj.get("count"));
        /*TODO
        boolean result = lunch.addOrder(sessId, placeId, productId, count);
        if(result){
            System.out.println("200");
        }else{
            System.out.println("404");
        }
        */
    }

    public void responseLogOut(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println();
        
        boolean result = lunch.logout(Integer.parseInt((String) jsonObj.get("sessionId")));
        if(result){
            System.out.println("200");
        }else{
            System.out.println("404");
        }
    }
    
    public void responseGetDistributors() {

        List<Distributors> distributorsList = new ArrayList<>();
        distributorsList = lunch.getDistributors();
        JSONArray jsonArr = new JSONArray();

        for (Distributors distrib : distributorsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("placeId", distrib.placeId);
            jsonObj.put("placeName", distrib.placeName);
            jsonObj.put("nameId", distrib.nameId);
            jsonObj.put("name", distrib.name);
            jsonArr.add(jsonObj);
        }
        System.out.println(jsonArr);
    }
    
    public void responseBecomeDistributor(String queryJson) {
        
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        boolean result = lunch.becomeDistributors(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("placeId")));
        
        if(result){
            System.out.println("200");
        }else{
            System.out.println("404");
        }
    }
    
}
