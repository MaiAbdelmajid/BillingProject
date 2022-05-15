<%-- 
    Document   : DisplayAllServicePKG
    Created on : May 15, 2022, 12:38:18 AM
    Author     : LENOVO
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.billing.web.CustomerDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Customers</title>
    </head>
    <style>.page{background-color: #C4D4C0;}</style>
    <body class = "page"> 
        <%
            Connection conn = CustomerDAO.conn;
            PreparedStatement stat = null;
            ResultSet rs = null;

        %>
        <h2 align="center"><font><strong>Our Customers</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="009999">
                <td><b>Service Package ID</b></td>
                <td><b>Service Package Type</b></td>
                <td><b>Service Package Unit</b></td>

            </tr>
            <%        stat = conn.prepareStatement("SELECT * FROM bscs.service_package");

                rs = stat.executeQuery();
                while (rs.next()) {


            %>
            <tr bgcolor="#F1F6F4">

                <td><%=rs.getString("id")%></td>
                <td><%=rs.getString("type")%></td>
                <td><%=rs.getString("units")%></td>             
            </tr>

            <%
                }
            %>
        </table>
    </body>

</html>
