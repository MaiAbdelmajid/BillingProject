<%-- 
    Document   : AddRateplanAction
    Created on : May 14, 2022, 8:58:58 PM
    Author     : LENOVO
--%>

<%@page import="com.billing.web.CustomerDAO"%>
<%@page import="com.billing.web.CustomerBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style> .page{background-color: #C4D4C0;}</style>
    <body class="page">
         <%

            String rp_id = request.getParameter("rpid");
            String name = request.getParameter("rpname");
            String Net_voice_service = request.getParameter("net_voice_service");
            String Cross_voice_service = request.getParameter("cross_voice_service");
            String Data_service = request.getParameter("dataservice");
            String Sms_service = request.getParameter("sms_service");
            String International_voice = request.getParameter("international_voice");
            String Free_units = request.getParameter("free_units");
            String Fee = request.getParameter("fee");
            String Net_voice_price = request.getParameter("net_voice_price");
            String International_sms = request.getParameter("international_sms");
            String International_sms_price = request.getParameter("international_sms_price");
            String international_voice_price = request.getParameter("international_voice_price");
            String Cross_voice_price = request.getParameter("cross_voice_price");
            String Data_price = request.getParameter("data_price");
            String Sms_price = request.getParameter("sms_price");

            CustomerBean b = new CustomerBean();
            
            b.setRateplane_id(Integer.parseInt(rp_id));
            b.setCommercial_name(name);
            b.setNet_voice_service(Integer.parseInt(Net_voice_service));
            b.setCross_voice_service(Integer.parseInt(Cross_voice_service));
            b.setData_service(Integer.parseInt(Data_service));
            b.setSms_service(Integer.parseInt(Sms_service));
            b.setInternational_voice(Integer.parseInt(International_voice));
            b.setFree_units(Integer.parseInt(Free_units));
            b.setFee(Integer.parseInt(Fee));
            b.setNet_voice_price(Integer.parseInt(Net_voice_price));
            b.setInternational_sms(Integer.parseInt(International_sms));
            b.setInternational_sms_price(Integer.parseInt(International_sms_price));           
            b.setInternational_voice_price(Integer.parseInt(international_voice_price));
            b.setCross_voice_price(Integer.parseInt(Cross_voice_price));
            b.setData_price(Integer.parseInt(Data_price));
            b.setSms_price(Integer.parseInt(Sms_price));


           

            int s = CustomerDAO.craeteRP(b);

            if (s == 1) {
                out.print("Added successfully !!");
            } else {
                response.sendRedirect("error.jsp");
            }

        %>
    </body>
</html>
