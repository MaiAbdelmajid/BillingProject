<%-- 
    Document   : AdminForm
    Created on : Apr 30, 2022, 3:54:15 PM
    Author     : LENOVO
--%>

<%@page import="com.billing.web.CustomerDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String fnamevalue = request.getParameter("fname");
    String passvalue = request.getParameter("pass");

    if (!(fnamevalue == null)) {

        // Create cookies for first and pass.      
        Cookie c1 = new Cookie("firstname", fnamevalue);
        Cookie c2 = new Cookie("password", passvalue);

        // Set expiry date after 24 Hrs for both the cookies.
        c1.setMaxAge(60 * 60 * 24);
        c2.setMaxAge(60 * 60 * 24);

        // Add both the cookies in the response header.
        response.addCookie(c1);
        response.addCookie(c2);

        CustomerDAO.getConnection();
        int var = CustomerDAO.signin(fnamevalue, passvalue);
        if (var == 1) {
            response.sendRedirect("WelcomePage.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" name="description" content="HTML5structure"/>
        <title>Admin_Form</title>

        <style>
            .center {
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
            .row3{ padding: 10px;}
            .row6{padding: 10px;}
            .page{background-color: #C4D4C0}
        </style>

    </head>
    <body class="page">
        <form action="AdminForm.jsp">
            <section class = "center">


                <section class="row1">

                    <article class="col1">
                        <label for="">Name</label>
                    </article>
                    <article class="col2">
                        <input type="text" name="fname" method = "GET" required> 
                        <%--<%= request.getParameter("fname")%> written to show the value of cookie --%>
                    </article>
                </section>


                <section class="row3">

                    <article class="col1">
                        <label for="">Password</label>
                    </article>
                    <article class="col2">
                        <input type="password" id="pass1" name="pass" method = "GET" title="at least 8 or more characters" required >
                        <%--<%= request.getParameter("pass")%>--%>
                    </article>
                </section>

                <section class="row6">
                    <input type="submit" name="Submit"> 
                </section>
            </section>
        </section>
    </form>

</body>

</html>

