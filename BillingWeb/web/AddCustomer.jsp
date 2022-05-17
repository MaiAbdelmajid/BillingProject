<%-- 
    Document   : AddCustomer
    Created on : May 5, 2022, 2:07:34 AM
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
   
    <style> 
.page{background-color: #C4D4C0;}
        .center{
            background-color: #C4D4C0;
        margin: auto;
                hight: 90%;
                width: 90%;
                border: 1px solid #ccc;
                padding: 30px;
                display: block;
                align-items: center;
                text-align: center
        }
                </style>
                </head>
                
    <body class = "page">
        
<div >
      <form class="center" action="AddStatus.jsp">
              
      <div>
          <h1>Add New Customer</h1>
      </div>
      <div>
        <span style=" font-size: 25px;"> Customer ID</span>
        <input id="customerid" type="int" placeholder="Enter id" required name="National ID"/><br><br>
      </div>
      <div >
        <span style=" font-size: 25px;">User name</span>
        <input  id="name" type="text" placeholder="Enter Name" required  name="User name"/><br><br>
        
      </div> 

        <div >
        <span style=" font-size: 25px;">Address</span>
        <input  id="address" type="text" placeholder="Enter address" required  name="Address"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 25px;">E-mail</span>
        <input  id="email" type="email" placeholder="Enter email" required  name="E-mail"/><br><br>
        
      </div> 

        <div >
        <input  style=" font-size: 25px;"id="submit" class="sub"  type="submit" value="Next">  
        </div>  
    </form>
  </div>
   
</body>

</html>
