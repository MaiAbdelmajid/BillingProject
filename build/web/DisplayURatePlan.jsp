<%-- 
    Document   : DisplayURatePlan
    Created on : May 12, 2022, 8:38:06 PM
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
        <h2 align="center"><font><strong>The Customer RatePlan Details</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="009999">
                <td><b>Phone No</b></td>
                <td><b>RB_ID</b></td>
                <td><b>RB_Name</b></td>
                <td><b>net_voice_service</b></td>
                <td><b>cross_voice_service</b></td>
                <td><b>data_service</b></td>
                <td><b>sms_service</b></td>  
                <td><b>international_voice</b></td>
                <td><b>free_units</b></td>
                <td><b>fee</b></td>
                <td><b>net_voice_price</b></td>
                <td><b>international_sms</b></td>
                <td><b>international_sms_price</b></td>
                <td><b>international_voice_price</b></td>
                <td><b>cross_voice_price</b></td>
                <td><b>data_price</b></td>
                <td><b>sms_price</b></td>
            </tr>
            <%                String phone = request.getParameter("msisdn");
                if (phone != null) {
                    stat = conn.prepareStatement("SELECT c.msisdn,r.* FROM bscs.contract as c,bscs.rateplanes as r where c.rateplane_id= r.rateplane_id and c.msisdn =?  ");
                    stat.setString(1, phone);
                    rs = stat.executeQuery();
                    while (rs.next()) {

            %>
            <tr bgcolor="#F1F6F4">

                <td><%=rs.getString("msisdn")%></td>
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
                }
            %>
        </table>
    </body>

</html>
