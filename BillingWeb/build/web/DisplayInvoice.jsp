<%-- 
    Document   : DisplayInvoice
    Created on : May 16, 2022, 12:43:54 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .page{ background-color: #C4D4C0;
                margin: auto;
               
                border: 1px solid #ccc;
                padding: 30px;
                display: block;
                align-items: center;
                text-align: center
            }
        
        
    </style>
    <body class="page">
        <embed  src="Reports_1.pdf" type="application/pdf" height="500"
    width="800" />
        <embed  src="Reports_2.pdf" type="application/pdf" height="100%"
    width="100%" />
        <embed  src="Reports_3.pdf" type="application/pdf" height="100%"
    width="100%" />
        <embed  src="Reports_4.pdf" type="application/pdf" height="100%"
    width="100%" />
        <embed  src="Reports_5.pdf" type="application/pdf" height="100%"
    width="100%" />
        <embed  src="Reports_6.pdf" type="application/pdf" height="100%"
    width="100%" />
<!--    <div>
<iframe
    src="file:///D:/billing_invoices/Reports_1.pdf"
    frameBorder="0"
    scrolling="auto"
    height="100%"
    width="100%"
></iframe> </div> -->
    </body>
</html>
