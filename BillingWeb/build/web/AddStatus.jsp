<%-- 
    Document   : AddStatus
    Created on : May 5, 2022, 2:39:54 AM
    Author     : LENOVO
--%>


<%@page import="com.billing.web.CustomerBean"%>
<%@page import="java.util.jar.Attributes.Name"%>
<%@page import="org.apache.tomcat.jni.Address"%>
<%@page import="java.lang.String"%>
<%@page import="com.billing.web.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CustomerAddStatus</title>
    </head>
    <body>
     <%   
       // create object from CustomerBean bec, i will use this object 
         CustomerBean b= new CustomerBean(); 
       // call function from class CustomerDAO  
       CustomerDAO.getConnection();
       int s = CustomerDAO.save(b);
       if (s == 1){out.println("Added Successfully!!");
           //out.println("Added Successfully!!");
       }
       else {out.println("Added Successfully!!");
   
    
     %>
        <h1>Added Successfully!!</h1>
    </body>
</html>
