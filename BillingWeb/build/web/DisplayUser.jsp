<%-- 
    Document   : DisplayUser
    Created on : May 6, 2022, 9:45:46 PM
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
        <title>Display Customers</title>
    </head>
    <body> 
        <%
                Connection conn = CustomerDAO.conn;
            CustomerDAO.getConnection();
            //Connection conn = 
            PreparedStatement stat = null;
            ResultSet rs = null;

        %>
        <h2 align="center"><font><strong>Our Customers</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="009999">
                <td><b>National ID</b></td>
                <td><b>Customer Name</b></td>
                <td><b>Address</b></td>
                <td><b>Email</b></td>
                <td><b>MSISDN</b></td>
            </tr>
            <%        stat = conn.prepareStatement("SELECT * FROM bscs.users");

                rs = stat.executeQuery();
                while (rs.next()) {


            %>
            <tr bgcolor="#F1F6F4">

                <td><%=rs.getString("national_id")%></td>
                <td><%=rs.getString("username")%></td>
                <td><%=rs.getString("address")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("msisdn")%></td>

            </tr>

            <%
                }
            %>
        </table>
    </body>

</html>