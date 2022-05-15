<%-- 
    Document   : CreateRatePlan
    Created on : May 14, 2022, 8:17:47 PM
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
            background-color: #C4D4C0;
        margin: auto;
                hight: 50%;
                width: 90%;
                border: 1px solid #ccc;
                padding: 30px;
                display: block;
                align-items: center;
                text-align: center
        }
        .page{background-color: #C4D4C0;}
                </style>
                </head>
                
    <body class="page">   
<div>
      <form class="center" action="AddRateplanAction.jsp">
              
      <div>
          <h1>Create New Rate Plan</h1>
      </div>
          <div>
        <span style=" font-size: 25px;"> RB_ID </span>
        <input id="customerid" type="int" placeholder="Enter id" required name="rpid"/><br><br>
      </div>
      <div>
        <span style=" font-size: 25px;"> RB_Name </span>
        <input id="customerid" type="text" placeholder="Enter id" required name="rpname"/><br><br>
      </div>
      <div >
        <span style=" font-size: 25px;">Net_Voice_Service</span>
        <input  id="name" type="text" placeholder="Enter Name" required  name="net_voice_service"/><br><br>
        
      </div> 

        <div >
        <span style=" font-size: 25px;">Cross_Voice_Service</span>
        <input  id="address" type="text" placeholder="Enter address" required  name="cross_voice_service"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 25px;">Data Service</span>
        <input  id="email" type="text" placeholder="Enter email" required  name="dataservice"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">sms_service</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="sms_service"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">international_voice</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="international_voice"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">free_units</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="free_units"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">fee</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="fee"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">net_voice_price</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="net_voice_price"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">international_sms</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="international_sms"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">international_sms_price</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="international_sms_price"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">international_voice_price</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="international_voice_price"/><br><br>
        
      </div> 
          
          <div >
        <span style=" font-size: 25px;">cross_voice_price</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="cross_voice_price"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">data_price</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="data_price"/><br><br>
        
      </div> 
          <div >
        <span style=" font-size: 25px;">sms_price</span>
        <input  id="email" type="int" placeholder="Enter email" required  name="sms_price"/><br><br>
        
      </div> 

        <div >
        <input  style=" font-size: 25px;"id="submit" class="sub"  type="submit" value="Submit">  
        </div>  
    </form>
  </div>
   
</body>

</html>
