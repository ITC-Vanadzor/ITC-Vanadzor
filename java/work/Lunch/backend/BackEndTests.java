import static org.junit.Assert.*;
import org.junit.Test;

public class BackEndTests {

	@Test
	public void testLoginResponse() {
		HttpResponse response = new HttpResponse();
		assertEquals(response.login("student", "student2014"), "sessionId");
	}
}			
