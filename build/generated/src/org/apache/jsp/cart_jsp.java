package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <table id=\"cart\" class=\"table table-hover table-condensed\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th style=\"width:50%\">Product</th>\n");
      out.write("                        <th style=\"width:10%\">Price</th>\n");
      out.write("                        <th style=\"width:8%\">Quantity</th>\n");
      out.write("                        <th style=\"width:22%\" class=\"text-center\">Subtotal</th>\n");
      out.write("                        <th style=\"width:10%\"></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td data-th=\"Product\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-2 hidden-xs\"><img src=\"http://placehold.it/100x100\" alt=\"...\" class=\"img-responsive\"/></div>\n");
      out.write("                                <div class=\"col-sm-10\">\n");
      out.write("                                    <h4 class=\"nomargin\">Product 1</h4>\n");
      out.write("                                    <p>Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor sit amet.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td data-th=\"Price\">$1.99</td>\n");
      out.write("                        <td data-th=\"Quantity\">\n");
      out.write("                            <input type=\"number\" class=\"form-control text-center\" value=\"1\">\n");
      out.write("                        </td>\n");
      out.write("                        <td data-th=\"Subtotal\" class=\"text-center\">1.99</td>\n");
      out.write("                        <td class=\"actions\" data-th=\"\">\n");
      out.write("                            <button class=\"btn btn-info btn-sm\"><i class=\"fa fa-refresh\"></i></button>\n");
      out.write("                            <button class=\"btn btn-danger btn-sm\"><i class=\"fa fa-trash-o\"></i></button>\t\t\t\t\t\t\t\t\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot>\n");
      out.write("                    <tr class=\"visible-xs\">\n");
      out.write("                        <td class=\"text-center\"><strong>Total 1.99</strong></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><a href=\"#\" class=\"btn btn-warning\"><i class=\"fa fa-angle-left\"></i> Continue Shopping</a></td>\n");
      out.write("                        <td colspan=\"2\" class=\"hidden-xs\"></td>\n");
      out.write("                        <td class=\"hidden-xs text-center\"><strong>Total $1.99</strong></td>\n");
      out.write("                        <td><a href=\"#\" class=\"btn btn-success btn-block\">Checkout <i class=\"fa fa-angle-right\"></i></a></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
