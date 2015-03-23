
/**
 *
 *
 */
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.util.*;
import org.json.simple.JSONValue;

public class GetResponses {

    public JSONParser parser = new JSONParser();

    public String sessionId;

    LunchDBConnect lunch;

    public GetResponses(String host, String user, String password) {
        lunch = new LunchDBConnect(host, user, password);
    }

    public ArrayList getSessionId(String loginPass) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Map<String, String> jsonObj = (Map<String, String>) parser.parse(loginPass);
            sessionId = lunch.login(jsonObj.get("username"), jsonObj.get("password")).toString();
            result.add(sessionId);
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error message");
            result.add("Error Code");
            return result;
        } catch (ParseException pe) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public ArrayList responsePlacesList() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            List<Places> placesList = new ArrayList<>();
            placesList = lunch.getPlaces();
            JSONArray jsonArr = new JSONArray();
            for (Places place : placesList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("placeId", place.id);
                jsonObj.put("placeName", place.placeName);
                jsonArr.add(jsonObj);
            }
            result.add(jsonArr.toString());
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public ArrayList responseOrdersList(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;

            List<Order> ordersList = new ArrayList<>();
            ordersList = lunch.getOrderList(Integer.parseInt((String) jsonObj.get("sessionId")));
            JSONArray jsonArr = new JSONArray();

            for (Order ord : ordersList) {
                JSONObject json = new JSONObject();
                json.put("placeId", ord.placeId);
                json.put("placeName", ord.placeName);
                json.put("productId", ord.productId);
                json.put("productName", ord.productName);
                json.put("count", ord.count);
                json.put("status", ord.status);
                jsonArr.add(jsonObj);
            }
            result.add(jsonArr.toString());
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public ArrayList responseOrdersByPerson(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<OrdersByPlaces> ordersList = new ArrayList<>();
            JSONArray jsonArr = new JSONArray();
            ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")), Integer.parseInt((String) jsonObj.get("loginId")));

            for (OrdersByPlaces order : ordersList) {
                JSONObject json = new JSONObject();
                json.put("userName", order.username);
                json.put("productName", order.productName);
                json.put("count", order.count);
                jsonArr.add(json);
            }
            result.add(jsonArr.toString());
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public ArrayList responseOrdersByPlace(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;

            List<OrdersByPlaces> ordersList = new ArrayList<>();
            JSONArray jsonArr = new JSONArray();
            ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")));

            for (OrdersByPlaces order : ordersList) {
                JSONObject json = new JSONObject();
                json.put("userName", order.username);
                json.put("productName", order.productName);
                json.put("count", order.count);
                jsonArr.add(json);
            }
            result.add(jsonArr.toString());
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public ArrayList responseProductsList(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<Products> productsList = new ArrayList<>();
            JSONArray jsonArr = new JSONArray();
            productsList = lunch.getProducts(Integer.parseInt((String) jsonObj.get("placeId")), (String) jsonObj.get("inputStr"));

            for (Products product : productsList) {
                JSONObject json = new JSONObject();
                json.put("productId", product.productId);
                json.put("productName", product.productName);
                jsonArr.add(json);
            }
            result.add(jsonArr.toString());
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public int responseDeleteOrder(String queryJson) {

        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println();

        boolean result = lunch.deleteOrder(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("orderId")));
        if (result) {
            return 200;
        } else {
            return 404;
        }
    }

    public int responseAddOrder(String queryJson) {

        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;

        int sessId = Integer.parseInt((String) jsonObj.get("sessionId"));
        int placeId = Integer.parseInt((String) jsonObj.get("placeId"));
        int productId = Integer.parseInt((String) jsonObj.get("productId"));
        int count = Integer.parseInt((String) jsonObj.get("count"));

        boolean result = lunch.addOrder(sessId, placeId, productId, count);
        if (result) {
            return 200;
        } else {
            return 404;
        }
    }

    public int responseLogOut(String queryJson) {

        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println();

        boolean result = lunch.logout(Integer.parseInt((String) jsonObj.get("sessionId")));
        if (result) {
            return 200;
        } else {
            return 404;
        }
    }

    public ArrayList responseGetDistributors() {
        ArrayList<String> result = new ArrayList<String>();
        try {
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
            result.add(jsonArr.toString());
            result.add("200");
            return result;
        } catch (RuntimeException re) {
            result.add("Error Code");
            result.add("Error message");
            return result;
        }
    }

    public ArrayList responseBecomeDistributor(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        Object obj = JSONValue.parse(queryJson);
        JSONObject jsonObj = (JSONObject) obj;
        boolean response = lunch.becomeDistributors(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("placeId")));

        if (response) {
            result.add("204");
            return result;
        } else {
            result.add("404");
            return result;
        }
    }

}