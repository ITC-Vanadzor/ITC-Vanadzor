package com.itcvanadzor.lunch.controller.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.nio.charset.StandardCharsets;
import com.itcvanadzor.lunch.controller.functions.*;
import java.sql.*;
import org.postgresql.Driver;

public class GetOrders extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out=response.getOutputStream();
        ServletInputStream input=request.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        String str = null;
        StringBuilder sb = new StringBuilder(8192);
        while ((str = r.readLine()) != null) {
            sb.append(str);
        }
        String queryJson = sb.toString();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }
        GetResponses getResponse = new GetResponses("jdbc:postgresql://localhost:5432/lunchdb","postgres", "postgres");
        ResponseBodyCode result = getResponse.getOrders(queryJson);
        response.setStatus(result.getCode());
        out.print(result.getBody());
    }
}
