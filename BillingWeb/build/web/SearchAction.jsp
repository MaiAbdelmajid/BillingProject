<%-- 
    Document   : SearchAction
    Created on : May 12, 2022, 8:24:51 PM
    Author     : LENOVO
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.billing.web.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%
         Connection conn = CustomerDAO.conn;
      //      CustomerDAO.getConnection();
            //Connection conn = 
            PreparedStatement stat = null;
            ResultSet rs = null;
            
            
        String phone = request.getParameter("msisdn");
        if (phone != null && phone.length() == 12 ) {
            CustomerDAO.getConnection();
            
    stat = conn.prepareStatement("SELECT c.msisdn,r.* FROM bscs.contract as c,bscs.rateplan as r where c.rateplane_id= r.rateplane_id");

                rs = stat.executeQuery();
                while (rs.next()) {
                    
                    
                    
                    
                }
                }
        %>
    </body>
</html>
