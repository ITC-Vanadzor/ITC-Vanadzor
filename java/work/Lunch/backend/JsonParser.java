import org.json.simple.*;

public class JsonParser{
   public static void main(String[] args) 
   {
      JSONObject obj = new JSONObject();

      obj.put("login", "username");
      obj.put("password", "userpassword");

      System.out.println(obj);
   }
}
