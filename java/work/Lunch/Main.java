import com.itcvanadzor.lunch.controller.*;
public class Main {

    public static void main(String[] args) {
        GetResponses lunch = new GetResponses("jdbc:postgresql://127.0.0.1:5432/lunchdb", "postgres", "postgres");
        System.out.println("************Get session id");
        System.out.println(lunch.getSessionId("{\"email\": \"karen@itc.com\", \"password\": \"karen\"}").getBody());
        System.out.println("************get places");
        System.out.println(lunch.getPlacesList().getBody());
        System.out.println("************Logout");
        System.out.println(lunch.logOut("{\"sessionId\": \"45\"}").getCode());
        System.out.println("************Become Distributers");
        System.out.println(lunch.becomeDistributor("{\"sessionId\":\"40\",\"placeId\":\"2\"}").getCode());
        System.out.println("************get Distributers");
        System.out.println(lunch.getDistributors().getBody());
        System.out.println("************Orders list");
        System.out.println(lunch.getOrdersList("{\"sessionId\": \"38\"}").getBody());
        System.out.println("************Delete order");
        System.out.println(lunch.deleteOrder("{\"sessionId\":\"38\",\"orderId\":\"48\"}").getCode());
        System.out.println("************Products list");
        System.out.println(lunch.getProductsList("{\"placeId\":\"2\", \"inputStr\":\"ttv\"}").getBody());
        System.out.println("************Products list All");
        System.out.println(lunch.getProductsAll("{\"placeId\":\"2\"}").getBody());
        System.out.println("************Add Order");
        System.out.println(lunch.addOrder("{\"sessionId\":\"38\",\"placeId\":\"2\",\"productId\":\"3\",\"count\":\"3\"}").getBody());
        System.out.println("************Get Customers");
        System.out.println(lunch.getCostumers("{\"placeId\":\"2\"}").getBody());
        System.out.println("************Get Orders");
        System.out.println(lunch.getOrders("{\"placeId\":\"2\",\"userId\":\"8\"}").getBody());
    }
}
