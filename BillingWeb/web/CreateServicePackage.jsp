<%-- 
    Document   : CreateServicePackage
    Created on : May 14, 2022, 11:50:00 PM
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
      <form class="center" action="AddSPKGAction.jsp">
              
      <div>
          <h1>Create New Service Package</h1>
      </div>
          <div>

        <span style=" font-size: 25px;"> SP Type </span>
        <input id="customerid" type="text" placeholder="Enter spkg type" required name="type"/><br><br>
      </div>
          
      <div>
        <span style=" font-size: 25px;">Unit</span>
        <input  id="name" type="text" placeholder="Enter Unit" required  name="unit"/><br><br>        
      </div> 
          
        <div>
        <input  style=" font-size: 25px;"id="submit" class="sub"  type="submit" value="Submit">  
        </div>  
    </form>
  </div>
   
</body>

</html>
