package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.billing.web.CustomerDAO;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class AdminForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" name=\"description\" content=\"HTML5structure\"/>\n");
      out.write("        <title>Admin_Form</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .center {\n");
      out.write("background-color: #C4D4C0;\n");
      out.write("                margin: auto;\n");
      out.write("                hight: 50%;\n");
      out.write("                width: 90%;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                padding: 30px;\n");
      out.write("                display: block;\n");
      out.write("                align-items: center;\n");
      out.write("                text-align: center\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .row3{ padding: 10px;}\n");
      out.write("            .row6{padding: 10px;}\n");
      out.write("            .page{background-color: #C4D4C0}\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"page\">\n");
      out.write("        <form action=\"AdminForm.jsp\">\n");
      out.write("            <section class = \"center\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <section class=\"row1\">\n");
      out.write("\n");
      out.write("                    <article class=\"col1\">\n");
      out.write("                        <label for=\"\">Name</label>\n");
      out.write("                    </article>\n");
      out.write("                    <article class=\"col2\">\n");
      out.write("                        <input type=\"text\" name=\"fname\" method = \"GET\" required> \n");
      out.write("                        ");
      out.write("\n");
      out.write("                    </article>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <section class=\"row3\">\n");
      out.write("\n");
      out.write("                    <article class=\"col1\">\n");
      out.write("                        <label for=\"\">Password</label>\n");
      out.write("                    </article>\n");
      out.write("                    <article class=\"col2\">\n");
      out.write("                        <input type=\"password\" id=\"pass1\" name=\"pass\" method = \"GET\" title=\"at least 8 or more characters\" required >\n");
      out.write("                        ");
      out.write("\n");
      out.write("                    </article>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("                <section class=\"row6\">\n");
      out.write("                    <input type=\"submit\" name=\"Submit\"> \n");
      out.write("                </section>\n");
      out.write("            </section>\n");
      out.write("        </section>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
