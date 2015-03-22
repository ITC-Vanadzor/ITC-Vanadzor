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

public class newRequest {

    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URI uri = new URIBuilder()
            .setScheme("http")
            .setHost("localhost")
            .setPath("/")
            //.setParameter("first_name", "Hrach")
            //.setParameter("last_name", "Mkrtchyan")
            .build();

        HttpGet httpGet = new HttpGet(uri);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int status = httpResponse.getStatusLine().getStatusCode();
    //  if (status==200) {
            HttpEntity httpEntity = httpResponse.getEntity();
            String responseBody = EntityUtils.toString(httpEntity);
    //  }
        System.out.println(status);
        System.out.println("Executing request " + httpGet.getRequestLine());
        System.out.println(responseBody);
        httpClient.close();
    }
}
