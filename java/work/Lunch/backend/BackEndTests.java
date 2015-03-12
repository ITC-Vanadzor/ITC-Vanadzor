import static org.junit.Assert.*;
import org.junit.Test;

public class BackEndTests {

	@Test
	public void testLoginResponse() {
        HttpRequest request = new HttpRequest();
        request.setBody(..)
            request.setheader(H, V)


		HttpResponse response = request.send(url)    

		assertEquals(response.login("student", "student2014"), "sessionIdid");
	}
}
