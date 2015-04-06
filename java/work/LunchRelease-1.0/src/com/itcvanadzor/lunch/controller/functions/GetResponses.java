/**
 *  * ********* JAVA Project which working with controller *************** ********
 *  * Version 1.0 ********************************************
 */
package com.itcvanadzor.lunch.controller.functions;

import com.itcvanadzor.lunch.database.CostumersByPlace;
import com.itcvanadzor.lunch.database.Distributors;
import com.itcvanadzor.lunch.database.LunchDBConnect;
import com.itcvanadzor.lunch.database.Order;
import com.itcvanadzor.lunch.database.OrdersByCostumer;
import com.itcvanadzor.lunch.database.Places;
import com.itcvanadzor.lunch.database.Products;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.sql.*;
import java.util.*;

/* @detaioled This class have a functions, who can get requests in format 
 * json and returned array list. Array list first element is a 
 * cade response and second element is a response body (or error message). 
 * This class used json parser librery, java util librery and librery from 
 * connectiong data base. 
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
        try {
            lunch = new LunchDBConnect(host, user, password);
        } catch (SQLException se) {
            System.out.println(errorMessageInternalServer);
        }
    }

    public ResponseBodyCode getSessionId(String loginPass) {
        String login = "email";
        String pass = "password";
        try {
            Map<String, String> jsonObj = (Map<String, String>) parser.parse(loginPass);
            if ((jsonObj.get(login) != null) && (jsonObj.get(pass) != null)) {
                sessionId = lunch.login(jsonObj.get(login), jsonObj.get(pass));
                JSONObject json = new JSONObject();
                json.put("sessionId", Integer.toString(sessionId));
                ResponseBodyCode result = new ResponseBodyCode(codeOk, json.toString());
                return result;
            } else {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
        } catch (ParseException pe) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode getPlacesList() {
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode getOrdersList(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (!lunch.isSessionId(Integer.parseInt((String) jsonObj.get("sessionId")))) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            List<Order> ordersList = new ArrayList<Order>();
            ordersList = lunch.getOrderList(Integer.parseInt((String) jsonObj.get("sessionId")));
            JSONArray jsonArr = new JSONArray();

            for (Order ord : ordersList) {
                JSONObject json = new JSONObject();
                json.put("orderId", ord.getId());
                json.put("placeId", ord.getPlaceId());
                json.put("placeName", ord.getPlaceName());
                json.put("productId", ord.getProductId());
                json.put("productName", ord.getProductName());
                json.put("count", ord.getCount());
                json.put("status", ord.getStatus());
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode getOrders(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<OrdersByCostumer> ordersList = new ArrayList<OrdersByCostumer>();
            JSONArray jsonArr = new JSONArray();
            ordersList = lunch.getOrders(Integer.parseInt((String) jsonObj.get("placeId")), Integer.parseInt((String) jsonObj.get("userId")));

            for (OrdersByCostumer order : ordersList) {
                JSONObject json = new JSONObject();
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

    public ResponseBodyCode getCustomers(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<CostumersByPlace> ordersList = new ArrayList<CostumersByPlace>();
            JSONArray jsonArr = new JSONArray();
            ordersList = lunch.getCustomers(Integer.parseInt((String) jsonObj.get("placeId")));

            for (CostumersByPlace order : ordersList) {
                JSONObject json = new JSONObject();
                json.put("userId", order.getLoginId());
                json.put("userName", order.getUsername());
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode getProductsList(String queryJson) {
        int code =  0;

        try {
            ++code;
            Object obj = JSONValue.parse(queryJson);
            ++code;
            JSONObject jsonObj = (JSONObject) obj;
            ++code;
            List<Products> productsList = new ArrayList<Products>();
            ++code;
            JSONArray jsonArr = new JSONArray();
           ++code;
            productsList = lunch.getProducts(Integer.parseInt((String) jsonObj.get("placeId")), (String) jsonObj.get("inputStr"));
            ++code;
            for (Products product : productsList) {
                JSONObject json = new JSONObject();
                json.put("productId", product.getProductId());
                json.put("productName", product.getProductName());
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(code, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode getProductsAll(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            List<Products> productsList = new ArrayList<Products>();
            JSONArray jsonArr = new JSONArray();
            productsList = lunch.getProducts(Integer.parseInt((String) jsonObj.get("placeId")));

            for (Products product : productsList) {
                JSONObject json = new JSONObject();
                json.put("productId", product.getProductId());
                json.put("productName", product.getProductName());
                json.put("count", product.getCount());
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }
    
    public ResponseBodyCode deleteOrder(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (!lunch.isSessionId(Integer.parseInt((String) jsonObj.get("sessionId")))) {
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode addOrder(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (!lunch.isSessionId(Integer.parseInt((String) jsonObj.get("sessionId")))) {
                ResponseBodyCode result = new ResponseBodyCode(codeUnauthorized, errorMessageUnauthorized);
                return result;
            }
            int sessId = Integer.parseInt((String) jsonObj.get("sessionId"));
            Integer placeId = Integer.parseInt((String) jsonObj.get("placeId"));
            Integer productId = Integer.parseInt((String) jsonObj.get("productId"));
            Integer count = Integer.parseInt((String) jsonObj.get("count"));
            
            int response = lunch.addOrder(sessId, placeId, productId, count);
            JSONObject responseJson = new JSONObject();
            responseJson.put("orderId", Integer.toString(response));
            ResponseBodyCode result = new ResponseBodyCode(codeOk, responseJson.toString());
            return result;

        } catch (SQLException se) {
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode logOut(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (!lunch.isSessionId(Integer.parseInt((String) jsonObj.get("sessionId")))) {
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode getDistributors() {
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

    public ResponseBodyCode becomeDistributor(String queryJson) {
        try {
            Object obj = JSONValue.parse(queryJson);
            JSONObject jsonObj = (JSONObject) obj;
            if (!lunch.isSessionId(Integer.parseInt((String) jsonObj.get("sessionId")))) {
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
            ResponseBodyCode result = new ResponseBodyCode(codeInternalServer, errorMessageInternalServer);
            return result;
        } catch (Exception ex) {
            ResponseBodyCode result = new ResponseBodyCode(codeNotFound, errorMessageNotFound);
            return result;
        }
    }

}
