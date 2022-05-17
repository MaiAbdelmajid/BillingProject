package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class WelcomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>  \n");
      out.write("<html>  \n");
      out.write("    <head>  \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">  \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <title>Welcome</title>  \n");
      out.write("        <style>  \n");
      out.write("            .page{background-color: #C4D5CB;}\n");
      out.write("            .center {\n");
      out.write("background-color: #C4D5CB;\n");
      out.write("                margin: auto;\n");
      out.write("                hight: 40%;\n");
      out.write("                width: 90%;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("/*                padding: 2px;*/\n");
      out.write("                display: block;\n");
      out.write("                align-items: center;\n");
      out.write("                text-align: center\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #add {\n");
      out.write("                padding: 15px 25px;\n");
      out.write("                font-size: 20px;\n");
      out.write("                text-align: center;\n");
      out.write("                cursor: pointer;\n");
      out.write("                outline: none;\n");
      out.write("                /*  color: #fff;*/\n");
      out.write("                /*  background-color: #04AA6D;*/\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 15px;\n");
      out.write("                box-shadow: 0 9px #999;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #add:hover {background-color: #3e8e41}\n");
      out.write("\n");
      out.write("            #add:active {\n");
      out.write("                background-color: #3e8e41;\n");
      out.write("                box-shadow: 0 5px #666;\n");
      out.write("                transform: translateY(4px);\n");
      out.write("            }\n");
      out.write("            .search-container{\n");
      out.write("                /*               float: right;*/\n");
      out.write("                padding: 5px 5px;\n");
      out.write("                margin-top: 3px;\n");
      out.write("                margin-right: 16px;\n");
      out.write("                /*  background: #ddd;*/\n");
      out.write("                font-size: 17px;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"page\">\n");
      out.write("\n");
      out.write("        <div class= center>\n");
      out.write("            <h1 class= title>Welcome</h1>\n");
      out.write("            <div class=\"search-container\">\n");
      out.write("                <form action=\"DisplayURatePlan.jsp\">\n");
      out.write("                    <input type=\"text\" placeholder=\"Enter phone..\" name=\"msisdn\">\n");
      out.write("                    <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"AddCustomer.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Add Customer\" /><br><br></form>\n");
      out.write("            <form action=\"CreateRatePlan.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Create New Rate Plan\"/><br><br></form>\n");
      out.write("                \n");
      out.write("            <form action=\"CreateServicePackage.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Create New Service Package\"/><br><br></form>\n");
      out.write("\n");
      out.write("            <form action=\"DisplayUser.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Display All Customers\"/><br><br></form>\n");
      out.write("            \n");
      out.write("                        <form action=\"DisplayAllRP.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Display All Rate Plan\"/><br><br></form>\n");
      out.write("                \n");
      out.write("            <form action=\"DisplayAllServicePKG.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Display All Service Packages\"/><br><br></form>\n");
      out.write("                \n");
      out.write("            <form action=\"DisplayInvoice.jsp\">\n");
      out.write("                <input id=\"add\" type=\"submit\" value=\"Display Invoices\"/><br><br></form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>  \n");
      out.write("</html>  \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
