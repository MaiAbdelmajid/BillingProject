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
        .center{
        margin: auto;
                hight: 50%;
                width: 90%;
                border: 1px solid #ccc;
                padding: 30px;
                display: block;
                align-items: center;
                text-align: center
        }
                </style>
                </head>
           
                
    <body>
         
<div>
      <form class="center" action="AddStatus.jsp">
              
      <div>
          <h1>Add New Customer</h1>
      </div>
      <div>
        <span style=" font-size: 25px;"> National ID</span>
        <input id="customerid" type="int" placeholder="Enter id" required name="National ID"/><br><br>
      </div>
      <div >
        <span style=" font-size: 25px;">User name</span>
        <input  id="name" type="text" placeholder="Enter Name" required  name="User name"/><br><br>
        
      </div> 

<!--        <div >
        <span style=" font-size: 25px;">Age</span>
        <input  id="msisdn" type="text" placeholder="Enter MSISDN" required  name="MSISDN"/><br><br>
        
      </div> -->
        <div >
        <span style=" font-size: 25px;">Address</span>
        <input  id="address" type="text" placeholder="Enter address" required  name="Address"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 25px;">E-mail</span>
        <input  id="email" type="email" placeholder="Enter email" required  name="E-mail"/><br><br>
        
      </div> 
          
          <div >
        <span style=" font-size: 25px;">MSISDN</span>
        <input  id="msisdn"  type="int" placeholder="Enter msisdn" required  name="MSISDN"/><br><br>
        
      </div> 
          
<!--        <div >
        <span style=" font-size: 25px;">Profile ID</span>
        <input  id="profile_id"  type="text" placeholder="Enter Profile ID" required  name="Profile ID"/><br><br>
        
      </div> -->
        
        <div >
        <input  style=" font-size: 25px;"id="submit" class="sub"  type="submit" value="Submit">  
        </div>  
    </form>
  </div>
   
</body>

</html>
