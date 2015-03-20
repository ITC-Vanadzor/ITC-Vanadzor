import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class BackEndTests {

    int status;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
            status = response.getStatusLine().getStatusCode();
            if (status == 200) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }
    };

    @Test
    public void testLoginResponse() throws Exception {
        try {
            HttpGet httpget = new HttpGet("http://192.168.33.64:8080/helloWorld-0.1-dev/hello?first_name=Hrach&last_name=Mkrtchyan");
            String responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        assertEquals(status, 200);
        //assertEquals(responseBody;"{}");
    }
}
