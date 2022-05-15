<%-- 
    Document   : AddContractAction
    Created on : May 12, 2022, 12:25:53 AM
    Author     : LENOVO
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.billing.web.CustomerDAO"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--<jsp:include page="AddContract.jsp"></jsp:include>--%>
        <%  

            String contid = request.getParameter("contractid");            
            String nid = request.getParameter("nationalid");
            String Dailno = request.getParameter("msisdn");
            String rb = request.getParameter("rateplan");
          int s =  CustomerDAO.savecont(contid, nid, Dailno, rb);
            if (s == 1) {
                out.println("Added Successfully!!");
                
            } else {
                
                response.sendRedirect("error.jsp");
            }

        %>
    </body>
</html>
