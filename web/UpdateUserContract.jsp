<%-- 
    Document   : UpdateUserContract
    Created on : May 12, 2022, 2:33:15 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Contract</title>

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
           input {
  height: 20px;
  flex: 0 0 200px;
  margin-left: 10px;
}
label {
/*  display: flex;*/
  flex-direction: row;
  justify-content: flex-end;
   padding: 30px;
  text-align: right;
  width: 400px;
  line-height: 26px;
  margin-bottom: 50px;
}
        </style>
    </head>

    <style>.page{background-color: #C4D4C0;}</style>
    <body class="page">

        <form class= "center" action="UpdateAction.jsp">
                    
            <input type="hidden"  name="id" value="<%=request.getParameter("id")%>"
                   ><br><br>
            
            <h1>Update Customer Contract</h1>
            <label style=" font-size: 25px;">Contract ID </label>
            <input type="text"  value="<%=request.getParameter("id")%>"  disabled
                   ><br><br>
            
<!--            <label style=" font-size: 25px;">National ID </label>
            <input type="text" name="nationalid"
                   pattern = "[0-9]+"><br><br>-->
            
            <label style=" font-size: 25px;">Phone Number:</label>
            <input type="text" name="msisdn"
                   pattern = "[0-9]+"><br><br>

            <label style=" font-size: 25px;">Rate Plan:</label>
            <select name="rateplan">
                <option value="1">Ahlan 300</option>
                <option value="2">Ahlan 400</option>
             
            </select><br><br>
            <input type="submit" value="Submit">
        </form>

    </body>

</html>

