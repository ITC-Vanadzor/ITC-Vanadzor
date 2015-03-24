import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
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
                .setParameter("name", "Hrach")
                .setParameter("password", "231996")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "");
    }

    @Test
    public void testResponseLogIn404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/login")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId","id")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "{}");
    }

    @Test
    public void testResponseGetOrderList204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getOrderList")
                .setParameter("sessionId","id")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId","invalidId")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "");
    }

    @Test
    public void testResponseGetPlaces404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getPlaces")
                .setParameter("a", "A")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        assertEquals(responseBody, "");
    }

    @Test
    public void testResponseGetProducts404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .setParameter("a", "A")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
				.setParameter("sessionId", "id")
                .setParameter("place", "Valod")
				.setParameter("product", "qyabab")
				.setParameter("count", 2)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
		assertEquals(responseBody, "OrderId");
    }

    @Test
    public void testResponseAddOrder401() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/addOrder")
                .setParameter("place", "Valod")
                .setParameter("product", "qyabab")
                .setParameter("count", 2)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
				.setParameter("sessionId", "id")
                .setParameter("place", "Tashir")
                .setParameter("product", "pizza")
                .setParameter("count", 2)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
				.setParameter("sessionId", "id")
                .setParameter("place", "Valod")
                .setParameter("product", "grich")
                .setParameter("count", 2)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "id")
                .setParameter("orderId", 1)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "invalidId")
                .setParameter("orderId", 1)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "id")
                .setParameter("orderId", 2)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "id")
                .setParameter("orderId", 100500)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
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
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
				.setParameter("sessionId", "id")
				.setParameter("place", "Valod")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "invalidId")
				.setParameter("place", "Valod")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "id")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "id")
				.setParameter("place", "Tashir")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 409);
    }

    @Test
    public void testResponseGetProducts200() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .setParameter("place", "Valod")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
		assertEquals(responseBody, "");
    }

    @Test
    public void testResponseGetProducts204() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .setParameter("place", "Tashir")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 204);
    }

    @Test
    public void testResponseGetProducts404() throws Exception {
        try {
            URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("192.168.33.64:8080")
                .setPath("lunchOrder-1/getProducts")
                .setParameter("place", "")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("place", "Valod")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("place", "Tashir")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("place", "0")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("place", "Valod")
				.setParameter("userId", 1)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("place", "Tashir")
				.setParameter("userId", 100500)
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sessionId", "id")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
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
                .setParameter("sesssionId", "invalidId")
                .build();
            HttpGet httpget = new HttpGet(uri);
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 404);
    }

}
