<%-- 
    Document   : DeleteUser
    Created on : May 12, 2022, 7:27:01 PM
    Author     : LENOVO
--%>

<%@page import="com.billing.web.CustomerBean"%>
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
            String duser = request.getParameter("Delete");
            CustomerBean b = new CustomerBean();
    //     CustomerDAO.getConnection();
            int s = CustomerDAO.delete(b);
        if (s == 1) {
                out.println("Deleted Successfully!!");
            } else {
                response.sendRedirect("error.jsp");
            }
        
        %>
    </body>
</html>
