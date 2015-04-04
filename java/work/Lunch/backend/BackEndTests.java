import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class BackEndTests {

    String responseBody;
    int status;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        public String handleResponse(final HttpResponse response) throws IOException {
            status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        }
    };

    @Test
    public void testResponseLogIn200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/login")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"email\": \"karen@itc.com\", \"password\": \"karen\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "{\"sessionId\":\"50\"}");
    }

    @Test
    public void testResponseLogIn404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/login")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseGetOrderList200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrderList")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\": \"38\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "[{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":58,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":57,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":56,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":55,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":54,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":53,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":52,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":51,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":50,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":49,\"productId\":3},{\"count\":3,\"status\":\"yes\",\"placeId\":2,\"placeName\":\"Smile\",\"productName\":\"ttvaser\",\"orderId\":47,\"productId\":3}");
    }

    @Test
    public void testResponseGetOrderList204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrderList")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

    @Test
    public void testResponseGetOrderList401() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrderList")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"1\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 401);
    }

    @Test
    public void testResponseGetOrderList404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrderList")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }   

    @Test
    public void testResponseGetPlaces200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getPlaces")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "[{\"placeId\":1,\"placeName\":\"Tashir\"},{\"placeId\":2,\"placeName\":\"Smile\"},{\"placeId\":3,\"placeName\":\"Lav Tex\"},{\"placeId\":4,\"placeName\":\"Hamov Patar\"},{\"placeId\":5,\"placeName\":\"Tutto Pizza\"},{\"placeId\":6,\"placeName\":\"Bistro\"}]");
    }

    @Test
    public void testResponseGetPlaces404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getPlaces")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"A\":\"a\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseGetProducts200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"2\", \"inputStr\":\"ttv\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "[{\"productName\":\"ttvaser\",\"productId\":3}]");
    }

    @Test
    public void testResponseGetProducts404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"A\":\"a\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseAddOrder200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/addOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"38\",\"placeId\":\"2\",\"productId\":\"3\",\"count\":\"3\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
		assertEquals(responseBody, "{\"orderId\":\"59\"}");
    }

    @Test
    public void testResponseAddOrder401() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/addOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"{\"sessionId\":\"1\",\"placeId\":\"2\",\"productId\":\"3\",\"count\":\"3\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 401);
    }

    @Test
    public void testResponseAddOrder403() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/addOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"{\"sessionId\":\"1\",\"placeId\":\"2\",\"productId\":\"3\",\"count\":\"3\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 403);
    }

    @Test
    public void testResponseAddOrder404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/addOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"1\",\"placeId\":\"100500\",\"productId\":\"3\",\"count\":\"3\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseDeleteOrder204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/deleteOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"38\",\"orderId\":\"48\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

    @Test
    public void testResponseDeleteOrder401() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/deleteOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"1\",\"orderId\":\"48\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 401);
    }

    @Test
    public void testResponseDeleteOrder403() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/deleteOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"38\",\"orderId\":\"48\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 403);
    }

    @Test
    public void testResponseDeleteOrder404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/deleteOrder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"38\",\"orderId\":\"100500\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseGetDistributors200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getDistributors")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "[{\"placeId\":2,\"name\":\"Stepan\",\"placeName\":\"Smile\",\"nameId\":0}]");
    }

    @Test
    public void testResponseGetDistributors404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getDistributors")
				.setParameter("a", "A")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseBecomeDistributor204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/becomeDistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"40\",\"placeId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

    @Test
    public void testResponseBecomeDistributor401() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/becomeDistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"40\",\"placeId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 401);
    }

    @Test
    public void testResponseBecomeDistributor404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/becomeDistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":1}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseBecomeDistributor409() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/becomeDistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"40\",\"placeId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 409);
    }

    @Test
    public void testResponseGetProductsTODO200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
		assertEquals(responseBody, "[{\"count\":33,\"productName\":\"ttvaser\",\"productId\":3}]");
    }

    @Test
    public void testResponseGetProductsTODO204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"4\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

    @Test
    public void testResponseGetProductsTODO404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"-1\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseGetCostumers200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getCostumers")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "");
    }

    @Test
    public void testResponseGetCostumers204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getCustomers")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"2\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

	@Test
    public void testResponseGetCostumers404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getCostumers")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"Valod\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseGetOrders200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrders")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"2\",\"userId\":\"8\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
		assertEquals(responseBody, "");
    }

    @Test
    public void testResponseGetOrders404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrders")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"2\",\"userId\":\"100500\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

    @Test
    public void testResponseLogOut204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/logOut")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\": \"50\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

    @Test
    public void testResponseLogOut404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/logOut")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"a\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);

            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

}
