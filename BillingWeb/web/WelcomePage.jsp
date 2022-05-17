<%-- 
    Document   : WelcomePage
    Created on : Apr 29, 2022, 12:54:24 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Welcome</title>  
        <style>  
            .page{background-color: #C4D5CB;}
            .center {
background-color: #C4D5CB;
                margin: auto;
                hight: 40%;
                width: 90%;
                border: 1px solid #ccc;
/*                padding: 2px;*/
                display: block;
                align-items: center;
                text-align: center

            }


            #add {
                padding: 15px 25px;
                font-size: 20px;
                text-align: center;
                cursor: pointer;
                outline: none;
                /*  color: #fff;*/
                /*  background-color: #04AA6D;*/
                border: none;
                border-radius: 15px;
                box-shadow: 0 9px #999;
            }

            #add:hover {background-color: #3e8e41}

            #add:active {
                background-color: #3e8e41;
                box-shadow: 0 5px #666;
                transform: translateY(4px);
            }
            .search-container{
                /*               float: right;*/
                padding: 5px 5px;
                margin-top: 3px;
                margin-right: 16px;
                /*  background: #ddd;*/
                font-size: 17px;
                border: none;
                cursor: pointer;

            }

        </style>
    </head>
    <body class="page">

        <div class= center>
            <h1 class= title>Welcome</h1>
            <div class="search-container">
                <form action="DisplayURatePlan.jsp">
                    <input type="text" placeholder="Enter phone.." name="msisdn">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>


            <form action="AddCustomer.jsp">
                <input id="add" type="submit" value="Add Customer" /><br><br></form>
            <form action="CreateRatePlan.jsp">
                <input id="add" type="submit" value="Create New Rate Plan"/><br><br></form>
                
            <form action="CreateServicePackage.jsp">
                <input id="add" type="submit" value="Create New Service Package"/><br><br></form>

            <form action="DisplayUser.jsp">
                <input id="add" type="submit" value="Display All Customers"/><br><br></form>
            
                        <form action="DisplayAllRP.jsp">
                <input id="add" type="submit" value="Display All Rate Plan"/><br><br></form>
                
            <form action="DisplayAllServicePKG.jsp">
                <input id="add" type="submit" value="Display All Service Packages"/><br><br></form>
                
            <form action="DisplayInvoice.jsp">
                <input id="add" type="submit" value="Display Invoices"/><br><br></form>
        </div>

    </body>
</html>


</body>  
</html>  
