<%-- 
    Document   : UpdateAction
    Created on : May 12, 2022, 2:36:57 AM
    Author     : LENOVO
--%>

<%@page import="com.billing.web.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Contract Action</title>
    </head>
    <body>
       <%
           
        //    CustomerDAO.getConnection();
    //   String id = request.getParameter("");
           String contid = request.getParameter("id");
            String nid = request.getParameter("nationalid");
            String Dailno = request.getParameter("msisdn");
            String rb = request.getParameter("rateplan");

       int s = CustomerDAO.update(contid, nid, Dailno, rb);
       
if (s == 1) {
                out.print("Updated Successfully");
            } else {
                response.sendRedirect("error.jsp");
            }

        %>
    </body>
</html>
