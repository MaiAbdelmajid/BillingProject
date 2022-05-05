<%-- 
    Document   : AddCustomer
    Created on : May 5, 2022, 2:07:34 AM
    Author     : LENOVO
--%>

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
        <span style=" font-size: 25px;"> Name</span>
        <input id="customerName" type="text" placeholder="Enter Name" required name="customerName"/><br><br>
      </div>
      <div >
        <span style=" font-size: 25px;">Email</span>
        <input  id="email" type="text" placeholder="Enter Email" required  name="Email"/><br><br>
        
      </div> 

        <div >
        <span style=" font-size: 25px;">MSISDN</span>
        <input  id="msisdn" type="text" placeholder="Enter MSISDN" required  name="MSISDN"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 25px;">IMSI</span>
        <input  id="imsi" type="text" placeholder="Enter IMSI" required  name="IMSI"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 25px;">Address</span>
        <input  id="address" type="text" placeholder="Enter Address" required  name="Address"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 25px;">Profile ID</span>
        <input  id="profile_id"  type="text" placeholder="Enter Profile ID" required  name="Profile ID"/><br><br>
        
      </div> 
        
        <div >
        <input  style=" font-size: 25px;"id="submit" class="sub"  type="submit" value="Submit">  
        </div>  
    </form>
  </div>
   
</body>
</html>
