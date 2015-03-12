import java.sql.*;
import java.util.Random;

public class Lunch {

  String url;
  String user;
  String password;
  public Statement st=null;
  public ResultSet rs=null;
  public Connection connection= null;
  public int session_id;

  public Lunch(String url, String user, String password) {
    this.url=url;
    this.user=user;
    this.password=password;
    try {
      connection= DriverManager.getConnection(url,user,password);
    } catch (SQLException e) {
      System.out.println("Connection Failed");
      return;
    }
    if (connection!=null) {
      System.out.println("Connection made it, take control your database now!");
    } else {
      System.out.println("Failed to make connection!");
    }
  }
  public ResultSet  getPlaces() {
    try {
      st=connection.createStatement();
      rs=st.executeQuery("SELECT * FROM place");
      while (rs.next()) {
        System.out.println(rs.getString("id"));
        System.out.println(rs.getString("place_name"));
      }
    } catch (SQLException ex) {
      System.out.println("Select fail");
    }
    return rs;
  }
  public int login(String username, String password) {
    Random rand = new Random();
    try {
      session_id=rand.nextInt(25000);
      System.out.println(session_id);
      st=connection.createStatement();
      rs=st.executeQuery("INSERT INTO session(login_id) VALUES (SELECT * FROM login WHERE username="+username+"AND password="+password));
      /*while (rs.next()) {
        if (rs.getString("username")==username && rs.getString("password")==password) {
        int login_id=Integer.parseInt(rs.getString("id"));
        ResultSet rs1=st.executeQuery("INSERT INTO session(login_id,session_id) VALUES ('"+login_id+"','"+session_id+"')");
        return session_id;
        }
      }*/
    } catch (SQLException ex) {
      System.out.println("insert fail");
    }
    return -1;
  }
}

