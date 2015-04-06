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
    int id = 83;
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
                .setPath("/lunch-1/login")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"email\": \"hrach@itc.com\", \"password\": \"hrach\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "{\"sessionId\":\""+id+"\"}");
    }

    @Test
    public void testResponseLogIn404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/login")
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
                .setPath("/lunch-1/getorderlist")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\": \"25\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "{\"count\":5,\"status\":\"yes\",\"placeId\":1,\"placeName\":\"Tashir\",\"productName\":\"ttvaser\",\"orderId\":26,\"productId\":3}");
    }

    @Test
    public void testResponseGetOrderList204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/getorderlist")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\""+id+"\"}", "UTF-8");
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
                .setPath("/lunch-1/getorderlist")
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
                .setPath("/lunch-1/getorderlist")
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
                .setPath("/lunch-1/getplaces")
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
                .setPath("/lunch-1/getplaces")
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
                .setPath("/lunch-1/getproducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"1\", \"inputStr\":\"pi\"}", "UTF-8");
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
                .setPath("/lunch-1/getproducts")
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
                .setPath("/lunch-1/addorder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\""+id+"\",\"placeId\":\"1\",\"productId\":\"1\",\"count\":\"1\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
		assertEquals(responseBody, "{\"orderId\":\"49\"}");
    }

    @Test
    public void testResponseAddOrder401() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/addorder")
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

   /* @Test
    public void testResponseAddOrder403() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/addorder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"{\"sessionId\":\""+id+"\",\"placeId\":\"2\",\"productId\":\"3\",\"count\":\"3\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 403);
    }*/

    @Test
    public void testResponseAddOrder404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/addorder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\""+id+"\",\"placeId\":\"100500\",\"productId\":\"3\",\"count\":\"3\"}", "UTF-8");
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
                .setPath("/lunch-1/deleteorder")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\""+id+"\",\"orderId\":\"48\"}", "UTF-8");
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
                .setPath("/lunch-1/deleteorder")
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

    /*@Test
    public void testResponseDeleteOrder403() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/deleteorder")
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
    }*/

    @Test
    public void testResponseDeleteOrder404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/deleteorder")
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
                .setPath("/lunch-1/getdistributors")
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
                .setPath("/lunch-1/getdistributors")
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
                .setPath("/lunch-1/becomedistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\""+id+"\",\"placeId\":\"4\"}", "UTF-8");
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
                .setPath("/lunch-1/becomedistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\"1\",\"placeId\":\"2\"}", "UTF-8");
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
                .setPath("/lunch-1/becomedistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":38}", "UTF-8");
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
                .setPath("/lunch-1/becomedistributor")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\":\""+id+"\",\"placeId\":\"4\"}", "UTF-8");
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
                .setPath("/lunch-1/getproducts")
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
                .setPath("/lunch-1/getproducts")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"6\"}", "UTF-8");
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
                .setPath("/lunch-1/getproducts")
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
    public void testResponseGetCustomers200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/getcustomers")
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
        assertEquals(responseBody, "[{\"userId\":1,\"userName\":\"Marine\"}]");
    }

    @Test
    public void testResponseGetCustomers204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/getcustomers")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"placeId\":\"6\"}", "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            responseBody = httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

	@Test
    public void testResponseGetCustomers404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("/lunch-1/getcustomers")
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
                .setPath("/lunch-1/getorders")
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
                .setPath("/lunch-1/getorders")
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
                .setPath("/lunch-1/logout")
                .build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity("{\"sessionId\": \""+id+"\"}", "UTF-8");
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
                .setPath("/lunch-1/logout")
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
