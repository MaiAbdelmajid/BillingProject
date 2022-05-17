<%-- 
    Document   : DisplayAllRP
    Created on : May 14, 2022, 11:17:40 PM
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
            PreparedStatement stat = null;
            ResultSet rs = null;

        %>
        <h2 align="center"><font><strong>Our Customers</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="009999">
                <td><b>RatePlan ID</b></td>
                <td><b>Commercial Name</b></td>
                <td><b>Net_voice_service</b></td>
                <td><b>Cross_voice_service</b></td>
                <td><b>Data_service</b></td>
                <td><b>Sms_service</b></td>
                <td><b>International_voice</b></td>             
                <td><b>Free_units</b></td>
                <td><b>Fee</b></td>
                <td><b>Net_voice_price</b></td>
                <td><b>International_sms</b></td>
                <td><b>International_sms_price</b></td>
                <td><b>international_voice_price</b></td>
                <td><b>Cross_voice_price</b></td>
                <td><b>Data_price</b></td>
                <td><b>Sms_price</b></td>

            </tr>
            <%        stat = conn.prepareStatement("SELECT * FROM bscs.rateplanes ");

                rs = stat.executeQuery();
                while (rs.next()) {


            %>
            <tr bgcolor="#F1F6F4">
              
                <td><%=rs.getString("rateplane_id")%></td>
                <td><%=rs.getString("commercial_name")%></td>
                <td><%=rs.getString("net_voice_service")%></td>
                <td><%=rs.getString("cross_voice_service")%></td>
                <td><%=rs.getString("data_service")%></td>
                <td><%=rs.getString("sms_service")%></td>
                <td><%=rs.getString("international_voice")%></td> 
                <td><%=rs.getString("free_units")%></td>
                <td><%=rs.getString("fee")%></td>
                <td><%=rs.getString("net_voice_price")%></td>
                <td><%=rs.getString("international_sms")%></td>
                <td><%=rs.getString("international_sms_price")%></td>
                <td><%=rs.getString("international_voice_price")%></td>
                <td><%=rs.getString("cross_voice_price")%></td>
                <td><%=rs.getString("data_price")%></td>
                <td><%=rs.getString("sms_price")%></td>             
            </tr>

            <%
                }
            %>
        </table>
    </body>

</html>
