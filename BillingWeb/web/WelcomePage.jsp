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
            .center {

                margin: auto;
                hight: 50%;
                width: 90%;
                border: 1px solid #ccc;
                padding: 30px;
                display: block;
                align-items: center;
                text-align: center

            }


            #add {
                padding: 15px 25px;
                font-size: 24px;
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
                padding: 10px 10px;
                margin-top: 8px;
                margin-right: 16px;
                /*  background: #ddd;*/
                font-size: 17px;
                border: none;
                cursor: pointer;

            }

        </style>
    </head>
    <body>

        <div class= center>
            <h1 class= title>Welcome</h1>
            <div class="search-container">
                <form action="UserContract.jsp">
                    <input type="text" placeholder="Search.." name="searchkey">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>


            <form action="AddCustomer.jsp">
                <input id="add" type="submit" value="Add Customer" /><br><br></form>
            <form action="">
                <input id="add" type="submit" value="Add Profile"/><br><br></form>
            <!--        <form action="upload_cdr.jsp">
                        <input id="add" type="submit" value="Upload CDR"/><br><br></form>
            -->                    
            <form action="">
                <input id="add" type="submit" value="Display All Customers"/><br><br></form>
                <!--
            <form action="display_profiles.jsp">
                <input id="add" type="submit" value="Display All Profiles"/><br><br></form>
            <form action="display_services.jsp">
                <input id="add" type="submit" value="Display All Services"/><br><br></form>-->
            <form action="display_invoices.jsp">
                <input id="add" type="submit" value="Display Invoices"/><br><br></form>
        </div>

    </body>
</html>


</body>  
</html>  
