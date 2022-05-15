<%-- 
    Document   : AddStatus
    Created on : May 5, 2022, 11:05:03 PM
    Author     : LENOVO
--%>

<%@page import="java.sql.Connection"%>

<%@page import="com.billing.web.CustomerDAO"%>
<%@page import="com.billing.web.CustomerBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Action</title>
    </head>
    <body>
        <%

            String nationalid = request.getParameter("National ID");
            String username = request.getParameter("User name");
            String address = request.getParameter("Address");
            String email = request.getParameter("E-mail");

            CustomerBean b = new CustomerBean();

            b.setId(Integer.parseInt(nationalid));
            b.setName(username);
            b.setAddress(address);
            b.setEmail(email);

         //   CustomerDAO.getConnection();

            int s = CustomerDAO.save(b);

            if (s == 1) {
                response.sendRedirect("AddContract.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

        %>
    </body>
</html>
