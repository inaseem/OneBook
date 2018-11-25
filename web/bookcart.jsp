<%-- 
    Document   : itemdetails
    Created on : 24 Nov, 2018, 11:28:50 PM
    Author     : Naseem
--%>

<%@page import="dit.Cart"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="dit.Book"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dit.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<%
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
%>
<%
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
%>
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="images/favicon.png" rel="icon" />
        <!--Title-->
        <title>Onebook - Shop Item</title>
        <!-- CSS -->
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Simple Line Icons -->
        <link rel="stylesheet" href="css/simple-line-icons.min.css">
        <!-- Themify Icons -->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">
        <!-- Main Style -->
        <link rel="stylesheet" href="css/colors.css">
        <link rel="stylesheet" href="css/style.css" class="main-style">
    </head>
    <!--Body Start-->

    <body data-res-from="1025">
        <!--Page Loader-->
        <!--Page Loader-->
        <div class="page-loader"></div>
        <!--Zmm Wrapper-->
        <div class="zmm-wrapper">
            <a href="#" class="zmm-close close"></a>
            <div class="zmm-inner bg-dark typo-white">
                <div class="text-center mobile-logo-part mb-4">
                    <a href="" class="img-before"><img src="images/onebook.png"/></a>
                </div>
                <div class="zmm-main-nav">
                </div>
            </div>
        </div>
        <!-- Main wrapper-->
        <div class="page-wrapper">
            <div class="page-wrapper-inner">
                <header>
                    <!--Mobile Header-->
                    <div class="mobile-header bg-dark typo-white">
                        <div class="mobile-header-inner">
                            <div class="sticky-outer">
                                <div class="sticky-head">
                                    <div class="basic-container clearfix">
                                        <ul class="nav mobile-header-items pull-left">
                                            <li class="nav-item"><a href="#" class="zmm-toggle img-before"><i class="fa fa-bars"></i></a></li>
                                        </ul>
                                        <ul class="nav mobile-header-items pull-center">
                                            <li>
                                                <a href="" class="img-before"><img src="images/onebook.png" class="img-fluid" alt="Logo" width="220" height="40"></a>
                                            </li>
                                        </ul>
                                        <ul class="nav mobile-header-items pull-right">
                                            <li class="nav-item"><a href="#" class="img-before overlay-search-switch"><i class="icon-magnifier icons"></i></a></li>
                                        </ul>
                                    </div>
                                    <!-- .basic-container -->
                                </div>
                                <!-- .sticky-head -->
                            </div>
                            <!-- .sticky-outer -->
                        </div>
                        <!-- .mobile-header-inner -->
                    </div>
                    <!-- .mobile-header -->
                    <!--Header-->
                    <div class="header-inner header-1">
                        <!--Topbar-->
                        <div class="topbar">
                            <div class="basic-container clearfix">
                                <ul class="nav topbar-items pull-left">
                                    <li class="nav-item">
                                        <ul class="nav header-info">
                                            <li class="nav-item">Phone: +91 7017416084</li>
                                            <li class="nav-item">E-mail:<a href="mailto:thisismenaseem@gmail.com"> thisismenaseem@gmail.com</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul class="nav topbar-items pull-right">
                                    <li class="nav-item">
                                        <ul class="nav header-info header-logins">
                                            <li class="nav-item">
                                                <c:if test="${!loggedIn}">
                                                    <a href="Login.jsp">Login</a>
                                                </c:if>
                                                <c:if test="${loggedIn}">
                                                    Welcome
                                                </c:if>
                                            </li>
                                            <li>
                                                <c:if test="${!loggedIn}">
                                                    or
                                                </c:if>
                                                <c:if test="${loggedIn}">
                                                    <%= request.getSession().getAttribute("username")%>
                                                </c:if>
                                            </li>
                                            <li class="nav-item">
                                                <c:if test="${!loggedIn}">
                                                    <a href="Register.jsp">Register</a>
                                                </c:if>
                                                <c:if test="${loggedIn}">
                                                    <t:form action="/logout"><input  type="submit" class="btn-link" value="Logout"/></t:form>
                                                </c:if>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--Topbar-->
                        <!--Sticky part-->
                        <div class="sticky-outer">
                            <div class="sticky-head">
                                <!--Navbar-->
                                <nav class="navbar nav-shadow bg-light">
                                    <div class="basic-container clearfix">
                                        <div class="navbar-inner">
                                            <!--Overlay Menu Switch-->
                                            <ul class="nav navbar-items pull-left">
                                                <li class="list-item">
                                                    <a href="" class="img-before"><img src="images/onebook.png" class="img-fluid" alt="Logo" width="220" height="40"></a>
                                                </li>
                                            </ul>
                                            <!-- Menu -->
                                            <ul class="nav navbar-items pull-right">
                                                <!--List Item-->
                                                <li class="list-item">
                                                    <ul class="nav navbar-main">
                                                        <li class="dropdown"><a href="">Home</a></li>
                                                        <li class="active dropdown"><a href="shop.jsp">Shop</a></li>
                                                        <li class="dropdown mini-cart-dropdown"><a href="bookcart.jsp" class="cart-contents"><i class="icon-bag icons"></i></a></li>
                                                    </ul>
                                                </li>
                                                <!--List Item-->
                                            </ul>
                                            <!-- Menu -->
                                        </div>
                                    </div>
                                </nav>
                            </div>
                            <!--sticky-head-->
                        </div>
                        <!--sticky-outer-->
                    </div>
                </header>
                <!-- header -->
                <!-- page-header -->
                <div class="page-title-wrap typo-white">
                    <div class="page-title-wrap-inner section-bg-img" data-bg="images/page-title.jpg" style="background-image: url(&quot;images/page-title.jpg&quot;);">
                        <div class="container">
                            <div class="row text-center">
                                <div class="col-md-12">
                                    <div class="page-title-inner">
                                        <h1 class="page-title mb-3">Cart</h1>
                                        <div id="breadcrumb" class="breadcrumb">
                                            <a href="">Home</a>
                                            <span class="current">Cart</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- header -->
        <!-- page-header -->

        <!-- page-header -->
        <!-- Page Content -->
        <div class="content-wrapper pad-none">
            <div class="content-inner">
                <!-- Shop Section -->
                <section id="shop-section" class="shop-section">
                    <!-- Screan Reader Text -->
                    <h2 class="screen-reader-text">Shop</h2>
                    <!-- Container -->
                    <div class="container">
                        <!-- row -->
                        <div class="row">
                            <!-- col -->
                            <div class="col-md-12">
                                <!-- shop -->
                                <div class="shop">
                                    <div class="shop-notices-wrapper"></div>
                                    <div class="shop-cart-form">
                                        <table class="shop_table shop_table_responsive cart shop-cart-form__contents w-100">
                                            <thead>
                                                <tr>
                                                    <th class="product-remove"></th>
                                                    <th class="product-thumbnail"></th>
                                                    <th class="product-name">Product</th>
                                                    <th class="product-price">Price</th>
                                                    <th class="product-quantity">Quantity</th>
                                                    <th class="product-subtotal">Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="item" items="${cart.getItems()}">
                                                    <c:set var="book" value="${item.getBook()}"/>
                                                    <tr class="shop-cart-form__cart-item cart_item">
                                                        <td class="product-remove">
                                                            <t:form action="/delete">
                                                                <input type="hidden" value="${book.getId()}" name="productId"/>
                                                                <input type="submit" class="btn btn-outline-danger" value="×">								
                                                            </t:form>
                                                        </td>
                                                        <td class="product-thumbnail">
                                                            <a href="">
                                                                <img src="${book.getImage()}" alt="" width="400" height="400">
                                                            </a>
                                                        </td>
                                                        <td class="product-name"> <a href="">${book.getTitle()}</a></td>
                                                        <td class="product-price"> <span class="shop-Price-amount amount">₹${book.getCost()}</span>
                                                        </td>
                                                        <td class="product-quantity"> <span class="shop-Price-amount amount">${item.getQuantity()}</span>
                                                        </td>
                                                        <td class="product-subtotal"> <span class="shop-Price-amount amount">₹${item.getQuantity()*book.getCost()}</span>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td colspan="6" class="actions">
                                                        <div class="coupon">
                                                            <input type="text" name="coupon_code" class="input-text mr-3" placeholder="Coupon code">
                                                            <button type="submit" class="button" name="apply_coupon">Apply coupon</button>
                                                            <button type="submit" class="button pull-right" name="update_cart">Update cart</button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="cart-collaterals pad-top-90">
                                        <div class="cart_totals ">
                                            <h2>Cart totals</h2>
                                            <table class="shop_table shop_table_responsive">
                                                <tbody>
                                                    <tr class="cart-subtotal">
                                                        <th>Subtotal</th>
                                                        <td><span class="shop-Price-amount amount">₹${cart.getTotal()}</span>
                                                        </td>
                                                    </tr>
                                                    <tr class="order-total">
                                                        <th>Total</th>
                                                        <td><strong><span class="shop-Price-amount amount">₹${cart.getTotal()}</span></strong></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <div class="wc-proceed-to-checkout"> <a href="" class="btn btn-default checkout-btn mt-4"> Proceed to checkout</a>
                                                <a href="shop.jsp" class="btn btn-warning mt-4"><i class="fa fa-angle-left"></i> Continue Shopping</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- col -->
                        </div>
                        <!-- row -->
                    </div>
                    <!-- container -->
                </section>
                <!-- Shop Section Ends -->
            </div>
        </div>
    </div>
    <!-- .page-wrapper-inner -->
</div>
<!--page-wrapper-->
<!--CTA Section-->
<div class="cta-section typo-white">
    <div class="container">
        <!-- CTA Wrap -->
        <div class="cta-wrapper cta-1 bg-theme pad-40 b-radius-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="text-center">
                        <h2 class="align-self-center mb-0">Find The Book That Best Suits Your Soul</h2>
                    </div>
                </div>
            </div>
            <!-- Row -->
        </div>
        <!-- CTA Wrap -->
    </div>
    <!-- Container -->
</div>
<!--CTA Section-->

<!-- Footer -->
<footer id="footer" class="footer footer-1 bg-dark">
    <!--Footer Widgets Columns Posibilities 4-->
    <div class="footer-widgets">
        <div class="footer-middle-wrap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 widget text-widget">
                        <div class="mb-3">
                            <img src="images/onebook.png" class="img-fluid mx-0 mb-4" alt="logo" width="186" height="40">
                        </div>
                        <!-- Text -->
                        <div class="pr-5">
                            <p>A book can take your soul places you have never been before.</p>
                        </div>
                    </div>
                    <!-- Col -->
                    <div class="col-lg-6 widget contact-info-widget">
                        <div class="widget-title">
                            <!-- Title -->
                            <h3 class="title text-uppercase">Contact Info</h3>
                        </div>
                        <div class="contact-widget-info">
                            <p class="pr-4">Have questions, comments or just want to say hello:</p>
                            <p class="contact-address mb-3">
                                <span class="fa icon-directions"></span>
                                <span>South Civil Line Roorkee</span>
                            </p>
                            <p class="contact-phone mb-3">
                                <span class="fa icon-screen-smartphone"></span>
                                <span>+91 7017416084</span>
                            </p>
                            <p class="contact-email mb-3">
                                <span class="fa icon-envelope"></span>
                                <span>
                                    <a href="mailto:thisismenaseem@gmail.com">thisismenaseem@gmail.com</a>
                                </span>
                            </p>
                        </div>
                    </div>
                    <!-- Col -->
                </div>
            </div>
        </div>
    </div>
    <!--Footer Copyright Columns Posibilities 4-->
    <div class="footer-copyright">
        <div class="footer-bottom-wrap b-top py-4 typo-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="footer-bottom-items pull-left">
                            <li class="nav-item">
                                <div class="nav-item-inner">
                                    © Copyright 2018 @ <a href="http://zozothemes.com/" class="theme-color">Zozothemes</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer -->
<!-- jQuery Lib -->
<script src="js/jquery.min.js"></script>
<!-- Popper Js Support for Bootstrap -->
<script src="js/popper.min.js"></script>
<!-- Bootstrap Js -->
<script src="js/bootstrap.min.js"></script>
<!-- Easing Js -->
<script src="js/jquery.easing.min.js"></script>
<!-- Validator Js -->
<script src="js/validator.min.js"></script>
<!-- Carousel Js Code -->
<script src="js/owl.carousel.min.js"></script>
<!-- Isotope Js -->
<script src="js/isotope.pkgd.min.js"></script>
<!-- Magnific Popup Js -->
<script src="js/jquery.magnific-popup.min.js"></script>
<!-- Appear Js -->
<script src="js/jquery.appear.min.js"></script>
<!-- Smart Resize Js -->
<script src="js/smartresize.min.js"></script>
<!-- Theme Custom Js -->
<script src="js/custom.js"></script>
</body>
<!-- Body End -->

</html>
