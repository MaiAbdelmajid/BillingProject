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
    <style>.page{background-color: #C4D4C0;}</style>
    <body class="page"> 
        <%
                Connection conn = CustomerDAO.conn;
           // CustomerDAO.getConnection();
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
                <td><b>Cotract ID</b></td>
                <td><b>Dailable No</b></td>
                <td><b>RatePlan ID</b></td>             
                <td><b>Edit Contract</b></td>
                <td><b>Delete</b></td>
            </tr>
            <%        stat = conn.prepareStatement("SELECT national_id,username, address, email, contractid, msisdn, rateplane_id FROM bscs.users,bscs.contract where national_id=national_userid");

                rs = stat.executeQuery();
                while (rs.next()) {


            %>
            <tr bgcolor="#F1F6F4">

                <td><%=rs.getString("national_id")%></td>
                <td><%=rs.getString("username")%></td>
                <td><%=rs.getString("address")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("contractid")%></td>
                <td><%=rs.getString("msisdn")%></td> 
                <td><%=rs.getString("rateplane_id")%></td>
                <td><a href="UpdateUserContract.jsp?id=<%=rs.getString("contractid")%>">Edit</a></td>
                <td><a href="DeleteUser.jsp?id=${b.getId()}">Delete</a></td>
             
            </tr>

            <%
                }
            %>
        </table>
    </body>

</html>