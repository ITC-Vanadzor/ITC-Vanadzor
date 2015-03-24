import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.util.*;
import org.json.simple.JSONValue;

/*This class have a functions, who can get requests in format 
 *json and returned array list. Array list first element is a 
 *cade response and second element is a response body (or error message). 
 *This class used json parser librery, java util librery and librery from 
 *connectiong data base. 
*/

public class GetResponses {

    private JSONParser parser = new JSONParser();

    private String sessionId;

    LunchDBConnect lunch;

    private final String codeOk = "200";
    private final String codeNoContent = "204";
    private final String codeNotFound = "404";
    private final String codeUnauthorized = "401";
    private final String codeForbidden = "403";
    private final String codeConflict = "409";
    private final String codeInternalServer = "500";

    private final String errorMessageNotFound = "Not Found";
    private final String errorMessageUnauthorized = "Unauthorized";
    private final String errorMessageForbidden = "Forbidden";
    private final String errorMessageConflict = "Conflict";
    private final String errorMessageInternalServer = "Internal Server Error";

    public GetResponses(String host, String user, String password) {
        lunch = new LunchDBConnect(host, user, password);
    }

    public ArrayList getSessionId(String loginPass) {
        ArrayList<String> result = new ArrayList<String>();
        String login = "email";
        String pass = "password";
        try {
            Map<String, String> jsonObj = (Map<String, String>) parser.parse(loginPass);
            if ((jsonObj.get(login) != null) && (jsonObj.get(pass) != null)) {
                sessionId = lunch.login(jsonObj.get(login), jsonObj.get(pass));
                result.add(codeOk);
                result.add(sessionId);
            } else {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
            }
            return result;
        } catch (ParseException pe) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        }
    }

    //Karen:401? 
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
            if (jsonArr != null) {
                result.add(codeOk);
                result.add(jsonArr.toString());
            } else {
                result.add(codeNoContent);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        }
    }

    public ArrayList responseOrdersList(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                result.add(codeUnauthorized);
                result.add(errorMessageUnauthorized);
                return result;
            }
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
            if (jsonArr != null) {
                result.add(codeOk);
                result.add(jsonArr.toString());
            } else {
                result.add(codeNoContent);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
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
            if (jsonArr != null) {
                result.add(codeOk);
                result.add(jsonArr.toString());
            } else {
                result.add(codeNoContent);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
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
            if (jsonArr != null) {
                result.add(codeOk);
                result.add(jsonArr.toString());
            } else {
                result.add(codeNoContent);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
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
            if (jsonArr != null) {
                result.add(codeOk);
                result.add(jsonArr.toString());
            } else {
                result.add(codeNoContent);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        }
    }

    //Karen:403?
    public ArrayList responseDeleteOrder(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                result.add(codeUnauthorized);
                result.add(errorMessageUnauthorized);
                return result;
            }
            boolean response = lunch.deleteOrder(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("orderId")));
            if (response == true) {
                result.add(codeNoContent);
            } else {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        }
    }

    //Karen:403?
    public ArrayList responseAddOrder(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                result.add(codeUnauthorized);
                result.add(errorMessageUnauthorized);
                return result;
            }
            int sessId = Integer.parseInt((String) jsonObj.get("sessionId"));
            if (sessId == null) {
                result.add(codeUnauthorized);
                result.add(errorMessageUnauthorized);
                return result;
            }
            int placeId = Integer.parseInt((String) jsonObj.get("placeId"));
            if (placeId == null) {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
                return result;
            }
            int productId = Integer.parseInt((String) jsonObj.get("productId"));
            if (productId == null) {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
                return result;
            }
            int count = Integer.parseInt((String) jsonObj.get("count"));
            if (count == null) {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
                return result;
            }
            boolean response = lunch.addOrder(sessId, placeId, productId, count);
            if (response == true) {
                result.add(codeNoContent);
            } else {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        }
    }

    public ArrayList responseLogOut(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                result.add(codeUnauthorized);
                result.add(errorMessageUnauthorized);
                return result;
            }
            boolean response = lunch.logout(Integer.parseInt((String) jsonObj.get("sessionId")));
            if (response == true) {
                result.add(codeNoContent);
            } else {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
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
            if (jsonArr != null) {
                result.add(codeOk);
                result.add(jsonArr.toString());
            } else {
                result.add(codeNoContent);
            }
            return result;
        } catch (RuntimeException re) {
            result.add(codeNotFound);
            result.add(errorMessageNotFound);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        }
    }

    public ArrayList responseBecomeDistributor(String queryJson) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                result.add(codeUnauthorized);
                result.add(errorMessageUnauthorized);
                return result;
            }
            boolean response = lunch.becomeDistributors(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("placeId")));
            if (response == true) {
                result.add(codeNoContent);
            } else {
                result.add(codeNotFound);
                result.add(errorMessageNotFound);
            }
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeInternalServer);
            result.add(errorMessageInternalServer);
            return result;
        } catch (/*TODO*/ex) {
            result.add(codeUnauthorized);
            result.add(errorMessageUnauthorized);
            return result;
        }
    }

}
