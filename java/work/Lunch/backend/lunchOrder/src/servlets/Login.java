package examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.nio.charset.StandardCharsets;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out=response.getOutputStream();
        ServletInputStream input=request.getInputStream();

        BufferedReader r = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        String str = null;
        StringBuilder sb = new StringBuilder(8192);
        while ((str = r.readLine()) != null) {
            sb.append(str);
        }
        String login_pswd = sb.toString();
        GetResponses getResponse = new GetResponses("jdbc:postgresql://localhost:5432/","postgres", "postgres"); 
        String [] response_sId = getResponse.getSessionId(login_pswd);
        int status_code = Integer.parseInt(response_sId[0]);
        String session_id = response_sId[1];
        response.setStatus(status_code);
        out.print(session_id);
    }
}




