package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dit.DataModel;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_t_form_method_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_t_form_method_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_t_form_method_action.release();
    _jspx_tagPool_c_if_test.release();
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

    if (request.getSession(false) != null) {
        if (request.getSession(false).getAttribute("username") != null) {
            response.sendRedirect("shop.jsp");
        }
    }

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html class=\"no-js\" lang=\"zxx\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"images/favicon.png\" rel=\"icon\" />\n");
      out.write("        <!--Title-->\n");
      out.write("        <title>Onebook - Login</title>\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("        <!-- Simple Line Icons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/simple-line-icons.min.css\">\n");
      out.write("        <!-- Themify Icons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/themify-icons.css\">\n");
      out.write("        <!-- Owl Carousel -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("        <!-- Magnific Popup -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("        <!-- Main Style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/colors.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" class=\"main-style\">\n");
      out.write("    </head>\n");
      out.write("    <!--Body Start-->\n");
      out.write("\n");
      out.write("    <body data-res-from=\"1025\">\n");
      out.write("        <!--<div class=\"container\">-->\n");
      out.write("\n");
      out.write("        <!--Zmm Wrapper-->\n");
      out.write("        <div class=\"zmm-wrapper\">\n");
      out.write("            <a href=\"#\" class=\"zmm-close close\"></a>\n");
      out.write("            <div class=\"zmm-inner bg-dark typo-white\">\n");
      out.write("                <div class=\"text-center mobile-logo-part mb-4\">\n");
      out.write("                    <a href=\"\" class=\"img-before\"><img src=\"images/onebook.png\"/></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"zmm-main-nav\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"page-wrapper\">\n");
      out.write("            <div class=\"page-wrapper-inner\">\n");
      out.write("                <header>\n");
      out.write("                    <!--Mobile Header-->\n");
      out.write("                    <div class=\"mobile-header bg-dark typo-white\">\n");
      out.write("                        <div class=\"mobile-header-inner\">\n");
      out.write("                            <div class=\"sticky-outer\">\n");
      out.write("                                <div class=\"sticky-head\">\n");
      out.write("                                    <div class=\"basic-container clearfix\">\n");
      out.write("                                        <ul class=\"nav mobile-header-items pull-left\">\n");
      out.write("                                            <li class=\"nav-item\"><a href=\"#\" class=\"zmm-toggle img-before\"><i class=\"fa fa-bars\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                        <ul class=\"nav mobile-header-items pull-center\">\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"\" class=\"img-before\"><img src=\"images/onebook.png\" class=\"img-fluid\" alt=\"Logo\" width=\"220\" height=\"40\"></a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                        <ul class=\"nav mobile-header-items pull-right\">\n");
      out.write("                                            <li class=\"nav-item\"><a href=\"#\" class=\"img-before overlay-search-switch\"><i class=\"icon-magnifier icons\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- .basic-container -->\n");
      out.write("                                </div>\n");
      out.write("                                <!-- .sticky-head -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- .sticky-outer -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- .mobile-header-inner -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- .mobile-header -->\n");
      out.write("                    <!--Header-->\n");
      out.write("                    <div class=\"header-inner header-1\">\n");
      out.write("                        <!--Topbar-->\n");
      out.write("                        <div class=\"topbar\">\n");
      out.write("                            <div class=\"basic-container clearfix\">\n");
      out.write("                                <ul class=\"nav topbar-items pull-left\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <ul class=\"nav header-info\">\n");
      out.write("                                            <li class=\"nav-item\">Phone: +91 7017416084</li>\n");
      out.write("                                            <li class=\"nav-item\">E-mail:<a href=\"mailto:thisismenaseem@gmail.com\"> thisismenaseem@gmail.com</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!--Topbar-->\n");
      out.write("                        <!--Sticky part-->\n");
      out.write("                        <div class=\"sticky-outer\">\n");
      out.write("                            <div class=\"sticky-head\">\n");
      out.write("                                <!--Navbar-->\n");
      out.write("                                <nav class=\"navbar nav-shadow bg-light\">\n");
      out.write("                                    <div class=\"basic-container clearfix\">\n");
      out.write("                                        <div class=\"navbar-inner\">\n");
      out.write("                                            <!--Overlay Menu Switch-->\n");
      out.write("                                            <ul class=\"nav navbar-items pull-left\">\n");
      out.write("                                                <li class=\"list-item\">\n");
      out.write("                                                    <a href=\"\" class=\"img-before\"><img src=\"images/onebook.png\" class=\"img-fluid\" alt=\"Logo\" width=\"220\" height=\"40\"></a>\n");
      out.write("                                                </li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("                            <!--sticky-head-->\n");
      out.write("                        </div>\n");
      out.write("                        <!--sticky-outer-->\n");
      out.write("                    </div>\n");
      out.write("                </header>\n");
      out.write("                <!-- header -->\n");
      out.write("                <!-- page-header -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"checkout-form-wrap\" style=\"padding: 15px\">\n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                <h3 class=\"mb-4\">Login</h3>\n");
      out.write("                <!-- form inputs -->\n");
      out.write("                ");
      if (_jspx_meth_t_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                <span class=\"clearfix\"></span>\n");
      out.write("                <!-- Checkout Form -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--CTA Section-->\n");
      out.write("        <div class=\"cta-section typo-white\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <!-- CTA Wrap -->\n");
      out.write("                <div class=\"cta-wrapper cta-1 bg-theme pad-40 b-radius-10\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"text-center\">\n");
      out.write("                                <h2 class=\"align-self-center mb-0\">Find The Book That Best Suits Your Soul</h2>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Row -->\n");
      out.write("                </div>\n");
      out.write("                <!-- CTA Wrap -->\n");
      out.write("            </div>\n");
      out.write("            <!-- Container -->\n");
      out.write("        </div>\n");
      out.write("        <!--CTA Section-->\n");
      out.write("        <!--</div>-->\n");
      out.write("        <footer id=\"footer\" class=\"footer footer-1 bg-dark\">\n");
      out.write("            <!--Footer Widgets Columns Posibilities 4-->\n");
      out.write("            <div class=\"footer-widgets\">\n");
      out.write("                <div class=\"footer-middle-wrap\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-6 widget text-widget\">\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <img src=\"images/onebook.png\" class=\"img-fluid mx-0 mb-4\" alt=\"logo\" width=\"186\" height=\"40\">\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Text -->\n");
      out.write("                                <div class=\"pr-5\">\n");
      out.write("                                    <p>A book can take your soul places you have never been before.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Col -->\n");
      out.write("                            <div class=\"col-lg-6 widget contact-info-widget\">\n");
      out.write("                                <div class=\"widget-title\">\n");
      out.write("                                    <!-- Title -->\n");
      out.write("                                    <h3 class=\"title text-uppercase\">Contact Info</h3>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"contact-widget-info\">\n");
      out.write("                                    <p class=\"pr-4\">Have questions, comments or just want to say hello:</p>\n");
      out.write("                                    <p class=\"contact-address mb-3\">\n");
      out.write("                                        <span class=\"fa icon-directions\"></span>\n");
      out.write("                                        <span>South Civil Line Roorkee</span>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p class=\"contact-phone mb-3\">\n");
      out.write("                                        <span class=\"fa icon-screen-smartphone\"></span>\n");
      out.write("                                        <span>+91 7017416084</span>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p class=\"contact-email mb-3\">\n");
      out.write("                                        <span class=\"fa icon-envelope\"></span>\n");
      out.write("                                        <span>\n");
      out.write("                                            <a href=\"mailto:thisismenaseem@gmail.com\">thisismenaseem@gmail.com</a>\n");
      out.write("                                        </span>\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Col -->\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--Footer Copyright Columns Posibilities 4-->\n");
      out.write("            <div class=\"footer-copyright\">\n");
      out.write("                <div class=\"footer-bottom-wrap b-top py-4 typo-white\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <ul class=\"footer-bottom-items pull-left\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <div class=\"nav-item-inner\">\n");
      out.write("                                            © Copyright 2018 @ <a href=\"http://zozothemes.com/\" class=\"theme-color\">Zozothemes</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <!-- JS -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <!-- Popper Js Support for Bootstrap -->\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <!-- Bootstrap Js -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Easing Js -->\n");
      out.write("        <script src=\"js/jquery.easing.min.js\"></script>\n");
      out.write("        <!-- Validator Js -->\n");
      out.write("        <script src=\"js/validator.min.js\"></script>\n");
      out.write("        <!-- Carousel Js Code -->\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <!-- Isotope Js -->\n");
      out.write("        <script src=\"js/isotope.pkgd.min.js\"></script>\n");
      out.write("        <!-- Magnific Popup Js -->\n");
      out.write("        <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <!-- Appear Js -->\n");
      out.write("        <script src=\"js/jquery.appear.min.js\"></script>\n");
      out.write("        <!-- Smart Resize Js -->\n");
      out.write("        <script src=\"js/smartresize.min.js\"></script>\n");
      out.write("        <!-- Theme Custom Js -->\n");
      out.write("        <script src=\"js/custom.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("hasError");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${model.hasError()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${hasError}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"error-msg\">\n");
        out.write("                        <i class=\"fa fa-times-circle\"></i>\n");
        out.write("                        ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${model.getMessage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_t_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:form
    org.apache.struts.taglib.html.FormTag _jspx_th_t_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_t_form_method_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_t_form_0.setPageContext(_jspx_page_context);
    _jspx_th_t_form_0.setParent(null);
    _jspx_th_t_form_0.setMethod("POST");
    _jspx_th_t_form_0.setAction("/login");
    int _jspx_eval_t_form_0 = _jspx_th_t_form_0.doStartTag();
    if (_jspx_eval_t_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <!-- row -->\n");
        out.write("                    <div class=\"row\">\n");
        out.write("                        <!-- col -->\n");
        out.write("                        <div class=\"col-md-6\">\n");
        out.write("                            <div class=\"checkout shop-checkout\">\n");
        out.write("                                <!-- Contact Form -->\n");
        out.write("                                <div class=\"contact-form-4\">\n");
        out.write("                                    <div class=\"row\">\n");
        out.write("                                        <div class=\"col-md-12\">\n");
        out.write("                                            <div class=\"form-group\">\n");
        out.write("                                                <input id=\"username\" class=\"form-control\" name=\"username\" placeholder=\"Username\" type=\"text\">\n");
        out.write("                                            </div>\n");
        out.write("                                            <div class=\"form-group\">\n");
        out.write("                                                <input id=\"password\" class=\"form-control\" name=\"pwd\" placeholder=\"Password\" type=\"password\">\n");
        out.write("                                            </div>\n");
        out.write("                                        </div>\n");
        out.write("                                    </div>\n");
        out.write("                                </div>\n");
        out.write("                                <!-- contact-form-7 -->\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                    <div class=\"form-submit\">\n");
        out.write("                        <input type=\"reset\" value=\"Reset\" class=\"btn btn-warning\" name=\"reset\" id=\"reset\" />\n");
        out.write("                        <input type=\"submit\" value=\"Login\" class=\"btn btn-success\" name=\"submit\" id=\"submit\" />\n");
        out.write("                    </div>\n");
        out.write("                    <label style=\"margin-top: 32px\">Don't have an account? Register <a href=\"/OneBook/Register.jsp\">Here</a></label>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_t_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_form_method_action.reuse(_jspx_th_t_form_0);
      return true;
    }
    _jspx_tagPool_t_form_method_action.reuse(_jspx_th_t_form_0);
    return false;
  }
}
