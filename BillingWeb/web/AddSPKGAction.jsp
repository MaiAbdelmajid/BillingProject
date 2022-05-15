<%-- 
    Document   : SPKGAction
    Created on : May 15, 2022, 12:15:09 AM
    Author     : LENOVO
--%>

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

          //  String spid = request.getParameter("spkgid");            
            String sptype = request.getParameter("type");
            String spunit = request.getParameter("unit");
            
          int s =  CustomerDAO.CreateSPKG( sptype, spunit);
            if (s == 1) {
                out.println("Added Successfully!!");
                
            } else {
                
                response.sendRedirect("error.jsp");
            }

        %>
    </body>
</html>
