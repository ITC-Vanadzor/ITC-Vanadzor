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

public class ClientWithResponseHandler {

    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            /*URI uri = new URIBuilder()
            .setScheme("http")
            .setHost("192.168.33.89:8080")
            .setPath("/helloWorld-0.1-dev/hello")
            .setParameter("first_name", "Hrach")
            .setParameter("last_name", "Mkrtchyan")
            .build();*/

            HttpGet httpget = new HttpGet("http://192.168.33.64:8080/helloWorld-0.1-dev/hello?first_name=Hrach&last_name=Mkrtchyan");
            //HttpGet httpgetnew = new HttpGet(uri);
            System.out.println("Executing request " + httpget.getRequestLine());
            //System.out.println("Executing request " + httpgetnew.getRequestLine());

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    System.out.println(status);
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }

}
