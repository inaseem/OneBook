package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dit.Cart;
import java.sql.DriverManager;
import dit.Book;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import dit.CartItem;
import java.util.ArrayList;

public final class bookcart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_t_form_action;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_t_form_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_t_form_action.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

//    out.println(request.getSession().getAttribute("username").toString());
    if (request.getSession(false) == null) {
        response.sendRedirect("Login.jsp");
    } else {
        if (request.getSession(false).getAttribute("username") != null) {
            request.setAttribute("loggedIn", true);
        } else {
            request.setAttribute("loggedIn", false);
            response.sendRedirect("Login.jsp");
        }
    }

      out.write('\n');

    ArrayList<CartItem> items = new ArrayList<>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
        PreparedStatement ps = conn.prepareStatement("select *,COUNT(*) from cart,books WHERE books.id=cart.productId and cart.userId=? GROUP BY cart.productId");
        ps.setInt(1, Integer.parseInt(request.getSession().getAttribute("userId").toString()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book(rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            items.add(new CartItem(rs.getInt(11), book));
        }
        ps.close();
        conn.close();
        double total = 0;
        for (CartItem item : items) {
            total += item.getQuantity() * item.getBook().getCost();
        }
        Cart cart = new Cart(items, String.valueOf(total));
        request.setAttribute("cart", cart);
    } catch (Exception e) {

    } finally {

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
      out.write("        <title>Onebook - Shop Item</title>\n");
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
      out.write("        <!--Page Loader-->\n");
      out.write("        <!--Page Loader-->\n");
      out.write("        <div class=\"page-loader\"></div>\n");
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
      out.write("        <!-- Main wrapper-->\n");
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
      out.write("                                <ul class=\"nav topbar-items pull-right\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <ul class=\"nav header-info header-logins\">\n");
      out.write("                                            <li class=\"nav-item\">\n");
      out.write("                                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_3.setPageContext(_jspx_page_context);
      _jspx_th_c_if_3.setParent(null);
      _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedIn}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
      if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    ");
          out.print( request.getSession().getAttribute("username"));
          out.write("\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      out.write("\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"nav-item\">\n");
      out.write("                                                ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                ");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </li>\n");
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
      out.write("                                            <!-- Menu -->\n");
      out.write("                                            <ul class=\"nav navbar-items pull-right\">\n");
      out.write("                                                <!--List Item-->\n");
      out.write("                                                <li class=\"list-item\">\n");
      out.write("                                                    <ul class=\"nav navbar-main\">\n");
      out.write("                                                        <li class=\"dropdown\"><a href=\"\">Home</a></li>\n");
      out.write("                                                        <li class=\"active dropdown\"><a href=\"shop.jsp\">Shop</a></li>\n");
      out.write("                                                        <li class=\"dropdown mini-cart-dropdown\"><a href=\"bookcart.jsp\" class=\"cart-contents\"><i class=\"icon-bag icons\"></i></a></li>\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </li>\n");
      out.write("                                                <!--List Item-->\n");
      out.write("                                            </ul>\n");
      out.write("                                            <!-- Menu -->\n");
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
      out.write("                <div class=\"page-title-wrap typo-white\">\n");
      out.write("                    <div class=\"page-title-wrap-inner section-bg-img\" data-bg=\"images/page-title.jpg\" style=\"background-image: url(&quot;images/page-title.jpg&quot;);\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row text-center\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <div class=\"page-title-inner\">\n");
      out.write("                                        <h1 class=\"page-title mb-3\">Cart</h1>\n");
      out.write("                                        <div id=\"breadcrumb\" class=\"breadcrumb\">\n");
      out.write("                                            <a href=\"\">Home</a>\n");
      out.write("                                            <span class=\"current\">Cart</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- header -->\n");
      out.write("        <!-- page-header -->\n");
      out.write("\n");
      out.write("        <!-- page-header -->\n");
      out.write("        <!-- Page Content -->\n");
      out.write("        <div class=\"content-wrapper pad-none\">\n");
      out.write("            <div class=\"content-inner\">\n");
      out.write("                <!-- Shop Section -->\n");
      out.write("                <section id=\"shop-section\" class=\"shop-section\">\n");
      out.write("                    <!-- Screan Reader Text -->\n");
      out.write("                    <h2 class=\"screen-reader-text\">Shop</h2>\n");
      out.write("                    <!-- Container -->\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <!-- row -->\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <!-- col -->\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <!-- shop -->\n");
      out.write("                                <div class=\"shop\">\n");
      out.write("                                    <div class=\"shop-notices-wrapper\"></div>\n");
      out.write("                                    <div class=\"shop-cart-form\">\n");
      out.write("                                        <table class=\"shop_table shop_table_responsive cart shop-cart-form__contents w-100\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th class=\"product-remove\"></th>\n");
      out.write("                                                    <th class=\"product-thumbnail\"></th>\n");
      out.write("                                                    <th class=\"product-name\">Product</th>\n");
      out.write("                                                    <th class=\"product-price\">Price</th>\n");
      out.write("                                                    <th class=\"product-quantity\">Quantity</th>\n");
      out.write("                                                    <th class=\"product-subtotal\">Total</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td colspan=\"6\" class=\"actions\">\n");
      out.write("                                                        <div class=\"coupon\">\n");
      out.write("                                                            <input type=\"text\" name=\"coupon_code\" class=\"input-text mr-3\" placeholder=\"Coupon code\">\n");
      out.write("                                                            <button type=\"submit\" class=\"button\" name=\"apply_coupon\">Apply coupon</button>\n");
      out.write("                                                            <button type=\"submit\" class=\"button pull-right\" name=\"update_cart\">Update cart</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"cart-collaterals pad-top-90\">\n");
      out.write("                                        <div class=\"cart_totals \">\n");
      out.write("                                            <h2>Cart totals</h2>\n");
      out.write("                                            <table class=\"shop_table shop_table_responsive\">\n");
      out.write("                                                <tbody>\n");
      out.write("                                                    <tr class=\"cart-subtotal\">\n");
      out.write("                                                        <th>Subtotal</th>\n");
      out.write("                                                        <td><span class=\"shop-Price-amount amount\">₹");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getTotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr class=\"order-total\">\n");
      out.write("                                                        <th>Total</th>\n");
      out.write("                                                        <td><strong><span class=\"shop-Price-amount amount\">₹");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getTotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></strong></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                            <div class=\"wc-proceed-to-checkout\"> <a href=\"\" class=\"btn btn-default checkout-btn mt-4\"> Proceed to checkout</a>\n");
      out.write("                                                <a href=\"shop.jsp\" class=\"btn btn-warning mt-4\"><i class=\"fa fa-angle-left\"></i> Continue Shopping</a></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- col -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- row -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- container -->\n");
      out.write("                </section>\n");
      out.write("                <!-- Shop Section Ends -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- .page-wrapper-inner -->\n");
      out.write("</div>\n");
      out.write("<!--page-wrapper-->\n");
      out.write("<!--CTA Section-->\n");
      out.write("<div class=\"cta-section typo-white\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- CTA Wrap -->\n");
      out.write("        <div class=\"cta-wrapper cta-1 bg-theme pad-40 b-radius-10\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <h2 class=\"align-self-center mb-0\">Find The Book That Best Suits Your Soul</h2>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Row -->\n");
      out.write("        </div>\n");
      out.write("        <!-- CTA Wrap -->\n");
      out.write("    </div>\n");
      out.write("    <!-- Container -->\n");
      out.write("</div>\n");
      out.write("<!--CTA Section-->\n");
      out.write("\n");
      out.write("<!-- Footer -->\n");
      out.write("<footer id=\"footer\" class=\"footer footer-1 bg-dark\">\n");
      out.write("    <!--Footer Widgets Columns Posibilities 4-->\n");
      out.write("    <div class=\"footer-widgets\">\n");
      out.write("        <div class=\"footer-middle-wrap\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-6 widget text-widget\">\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <img src=\"images/onebook.png\" class=\"img-fluid mx-0 mb-4\" alt=\"logo\" width=\"186\" height=\"40\">\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Text -->\n");
      out.write("                        <div class=\"pr-5\">\n");
      out.write("                            <p>A book can take your soul places you have never been before.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Col -->\n");
      out.write("                    <div class=\"col-lg-6 widget contact-info-widget\">\n");
      out.write("                        <div class=\"widget-title\">\n");
      out.write("                            <!-- Title -->\n");
      out.write("                            <h3 class=\"title text-uppercase\">Contact Info</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contact-widget-info\">\n");
      out.write("                            <p class=\"pr-4\">Have questions, comments or just want to say hello:</p>\n");
      out.write("                            <p class=\"contact-address mb-3\">\n");
      out.write("                                <span class=\"fa icon-directions\"></span>\n");
      out.write("                                <span>South Civil Line Roorkee</span>\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"contact-phone mb-3\">\n");
      out.write("                                <span class=\"fa icon-screen-smartphone\"></span>\n");
      out.write("                                <span>+91 7017416084</span>\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"contact-email mb-3\">\n");
      out.write("                                <span class=\"fa icon-envelope\"></span>\n");
      out.write("                                <span>\n");
      out.write("                                    <a href=\"mailto:thisismenaseem@gmail.com\">thisismenaseem@gmail.com</a>\n");
      out.write("                                </span>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Col -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--Footer Copyright Columns Posibilities 4-->\n");
      out.write("    <div class=\"footer-copyright\">\n");
      out.write("        <div class=\"footer-bottom-wrap b-top py-4 typo-white\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <ul class=\"footer-bottom-items pull-left\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <div class=\"nav-item-inner\">\n");
      out.write("                                    © Copyright 2018 @ <a href=\"http://zozothemes.com/\" class=\"theme-color\">Zozothemes</a>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("<!-- Footer -->\n");
      out.write("<!-- jQuery Lib -->\n");
      out.write("<script src=\"js/jquery.min.js\"></script>\n");
      out.write("<!-- Popper Js Support for Bootstrap -->\n");
      out.write("<script src=\"js/popper.min.js\"></script>\n");
      out.write("<!-- Bootstrap Js -->\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("<!-- Easing Js -->\n");
      out.write("<script src=\"js/jquery.easing.min.js\"></script>\n");
      out.write("<!-- Validator Js -->\n");
      out.write("<script src=\"js/validator.min.js\"></script>\n");
      out.write("<!-- Carousel Js Code -->\n");
      out.write("<script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("<!-- Isotope Js -->\n");
      out.write("<script src=\"js/isotope.pkgd.min.js\"></script>\n");
      out.write("<!-- Magnific Popup Js -->\n");
      out.write("<script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("<!-- Appear Js -->\n");
      out.write("<script src=\"js/jquery.appear.min.js\"></script>\n");
      out.write("<!-- Smart Resize Js -->\n");
      out.write("<script src=\"js/smartresize.min.js\"></script>\n");
      out.write("<!-- Theme Custom Js -->\n");
      out.write("<script src=\"js/custom.js\"></script>\n");
      out.write("</body>\n");
      out.write("<!-- Body End -->\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!loggedIn}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    <a href=\"Login.jsp\">Login</a>\n");
        out.write("                                                ");
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedIn}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    Welcome\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!loggedIn}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    or\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!loggedIn}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    <a href=\"Register.jsp\">Register</a>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedIn}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    ");
        if (_jspx_meth_t_form_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_5, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_t_form_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:form
    org.apache.struts.taglib.html.FormTag _jspx_th_t_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_t_form_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_t_form_0.setPageContext(_jspx_page_context);
    _jspx_th_t_form_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_5);
    _jspx_th_t_form_0.setAction("/logout");
    int _jspx_eval_t_form_0 = _jspx_th_t_form_0.doStartTag();
    if (_jspx_eval_t_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input  type=\"submit\" class=\"btn-link\" value=\"Logout\"/>");
        int evalDoAfterBody = _jspx_th_t_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_form_action.reuse(_jspx_th_t_form_0);
      return true;
    }
    _jspx_tagPool_t_form_action.reuse(_jspx_th_t_form_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("item");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getItems()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    ");
          if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                    <tr class=\"shop-cart-form__cart-item cart_item\">\n");
          out.write("                                                        <td class=\"product-remove\">\n");
          out.write("                                                            ");
          if (_jspx_meth_t_form_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td class=\"product-thumbnail\">\n");
          out.write("                                                            <a href=\"\">\n");
          out.write("                                                                <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getImage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\" width=\"400\" height=\"400\">\n");
          out.write("                                                            </a>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td class=\"product-name\"> <a href=\"\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getTitle()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></td>\n");
          out.write("                                                        <td class=\"product-price\"> <span class=\"shop-Price-amount amount\">₹");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getCost()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td class=\"product-quantity\"> <span class=\"shop-Price-amount amount\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td class=\"product-subtotal\"> <span class=\"shop-Price-amount amount\">₹");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getQuantity()*book.getCost()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                                        </td>\n");
          out.write("                                                    </tr>\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_0.setVar("book");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getBook()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_t_form_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:form
    org.apache.struts.taglib.html.FormTag _jspx_th_t_form_1 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_t_form_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_t_form_1.setPageContext(_jspx_page_context);
    _jspx_th_t_form_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_t_form_1.setAction("/delete");
    int _jspx_eval_t_form_1 = _jspx_th_t_form_1.doStartTag();
    if (_jspx_eval_t_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                                <input type=\"hidden\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" name=\"productId\"/>\n");
        out.write("                                                                <input type=\"submit\" class=\"btn btn-outline-danger\" value=\"×\">\t\t\t\t\t\t\t\t\n");
        out.write("                                                            ");
        int evalDoAfterBody = _jspx_th_t_form_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_t_form_action.reuse(_jspx_th_t_form_1);
      return true;
    }
    _jspx_tagPool_t_form_action.reuse(_jspx_th_t_form_1);
    return false;
  }
}
