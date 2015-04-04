//package requestController;
/*
import database.Distributors;
import database.LunchDBConnect;
import database.Order;
import database.OrdersByPlaces;
import database.Places;
import database.Products;
*/
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.sql.*;
import java.util.*;

/*This class have a functions, who can get requests in format 
 *json and returned array list. Array list first element is a 
 *cade response and second element is a response body (or error message). 
 *This class used json parser librery, java util librery and librery from 
 *connectiong data base. 
 */
public class GetResponses {

    private JSONParser parser = new JSONParser();

    private int sessionId;

    LunchDBConnect lunch;

    private final int codeOk = 200;
    private final int codeNoContent = 204;
    private final int codeNotFound = 404;
    private final int codeUnauthorized = 401;
    private final int codeForbidden = 403;
    private final int codeConflict = 409;
    private final int codeInternalServer = 500;

    private final String errorMessageNotFound = "Not Found";
    private final String errorMessageUnauthorized = "Unauthorized";
    private final String errorMessageForbidden = "Forbidden";
    private final String errorMessageConflict = "Conflict";
    private final String errorMessageInternalServer = "Internal Server Error";

    public GetResponses(String host, String user, String password) {
        lunch = new LunchDBConnect(host, user, password);
    }

    public ResponseBodyCode getSessionId(String loginPass) {
        String login = "email";
        String pass = "password";
        try {
            Map<String, String> jsonObj = (Map<String, String>) parser.parse(loginPass);
            if ((jsonObj.get(login) != null) && (jsonObj.get(pass) != null)) {
                sessionId = lunch.login(jsonObj.get(login), jsonObj.get(pass));
                ResponseBodyCode result = new ResponseBodyCode(codeOk, Integer.toString(sessionId));
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
        } catch (ParseException pe) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responsePlacesList() {
        try {
            List<Places> placesList = new ArrayList<Places>();
            placesList = lunch.getPlaces();
            JSONArray jsonArr = new JSONArray();

            for (Places place : placesList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("placeId", place.getPlaceId());
                jsonObj.put("placeName", place.getPlaceName());
                jsonArr.add(jsonObj);
            }
            if (jsonArr != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, jsonArr.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseOrdersList(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            List<Order> ordersList = new ArrayList<Order>();
            ordersList = lunch.getOrderList(Integer.parseInt((String) jsonObj.get("sessionId")));
            JSONArray jsonArr = new JSONArray();

            for (Order ord : ordersList) {
                JSONObject json = new JSONObject();
                json.put("id", ord.getId() );
                json.put("placeId", ord.getPlaceId());
                json.put("placeName", ord.getPlaceName());
                json.put("productId", ord.getProductId());
                json.put("productName", ord.productName);
                json.put("count", ord.count);
                json.put("status", ord.status);
                jsonArr.add(jsonObj);
            }
            if (jsonArr != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, jsonArr.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseOrdersByPerson(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<OrdersByPlaces> ordersList = new ArrayList<OrdersByPlaces>();
            JSONArray jsonArr = new JSONArray();
            ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")), Integer.parseInt((String) jsonObj.get("loginId")));

            for (OrdersByPlaces order : ordersList) {
                JSONObject json = new JSONObject();
                json.put("userName", order.getEmail());
                json.put("productName", order.getProductName());
                json.put("count", order.getCount());
                jsonArr.add(json);
            }
            if (jsonArr != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, jsonArr.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseOrdersByPlace(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<OrdersByPlaces> ordersList = new ArrayList<OrdersByPlaces>();
            JSONArray jsonArr = new JSONArray();
            ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")));

            for (OrdersByPlaces order : ordersList) {
                JSONObject json = new JSONObject();
                json.put("email", order.getEmail());
                json.put("productName", order.getProductName());
                json.put("count", order.getCount());
                jsonArr.add(json);
            }
            if (jsonArr != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, jsonArr.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
    m        return result;
        }
    }

    public ResponseBodyCode responseProductsList(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<Products> productsList = new ArrayList<Products>();
            JSONArray jsonArr = new JSONArray();
            productsList = lunch.getProducts(Integer.parseInt((String) jsonObj.get("placeId")), (String) jsonObj.get("inputStr"));

            for (Products product : productsList) {
                JSONObject json = new JSONObject();
                json.put("productId", product.productId);
                json.put("productName", product.productName);
                jsonArr.add(json);
            }

            if (jsonArr != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, jsonArr.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseDeleteOrder(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            boolean response = lunch.deleteOrder(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("orderId")));
            if (response == true) {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseAddOrder(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            Integer sessId = Integer.parseInt((String) jsonObj.get("sessionId"));
            if (sessId == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            Integer placeId = Integer.parseInt((String) jsonObj.get("placeId"));
            if (placeId == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
            Integer productId = Integer.parseInt((String) jsonObj.get("productId"));
            if (productId == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
            Integer count = Integer.parseInt((String) jsonObj.get("count"));
            if (count == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
            String response = lunch.addOrder(sessId, placeId, productId, count);
            if (response != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseLogOut(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            boolean response = lunch.logout(Integer.parseInt((String) jsonObj.get("sessionId")));
            if (response == true) {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseGetDistributors() {
        try {
            List<Distributors> distributorsList = new ArrayList<Distributors>();
            distributorsList = lunch.getDistributors();
            JSONArray jsonArr = new JSONArray();

            for (Distributors distrib : distributorsList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("placeId", distrib.getPlaceId());
                jsonObj.put("placeName", distrib.getPlaceName());
                jsonObj.put("nameId", distrib.getEmailId());
                jsonObj.put("name", distrib.getEmail());
                jsonArr.add(jsonObj);
            }
            if (jsonArr != null) {
                ResponseBodyCode result = new ResponseBodyCode(codeOk, jsonArr.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

    public ResponseBodyCode responseBecomeDistributor(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("sessionId") == null) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            boolean response = lunch.becomeDistributors(Integer.parseInt((String) jsonObj.get("sessionId")), Integer.parseInt((String) jsonObj.get("placeId")));
            if (response == true) {
                ResponseBodyCode result = new ResponseBodyCode(codeNoContent, "");
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
                return result;
            }
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        }
    }

}
