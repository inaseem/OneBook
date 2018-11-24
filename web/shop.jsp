<%-- 
    Document   : shop
    Created on : 24 Nov, 2018, 9:51:42 PM
    Author     : Naseem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<!doctype html>
<html class="no-js" lang="zxx">
    <%
        if (request.getSession(false) == null) {
            response.sendRedirect("Login.jsp");
        } else {
            request.setAttribute("loggedIn", true);
        }
    %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="images/favicon.png" rel="icon" />
        <!--Title-->
        <title>Onebook - Shop</title>
        <!-- CSS -->
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Simple Line Icons -->
        <link rel="stylesheet" href="css/simple-line-icons.min.css">
        <!-- Themify Icons -->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- Main Style -->
        <link rel="stylesheet" href="css/colors.css">
        <link rel="stylesheet" href="css/style.css" class="main-style">

    </head>
    <!--Body Start-->

    <body data-res-from="1025">
        <sql:setDataSource var="webappDataSource"
                           driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/onebook"
                           user="root" password="" />

        <sql:query dataSource="${webappDataSource}"
                   sql="select * from books" var="result" />
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
                                            <c:if test="${loggedIn}">
                                                <li class="nav-item">Welcome <%= request.getSession().getAttribute("username")%></li>
                                                <li class="nav-item"><a href="#">Logout</a></li>
                                                </c:if>
                                                <c:if test="${!loggedIn}">
                                                <li class="nav-item"><a href="#">Login</a></li>
                                                <li> or</li>
                                                <li class="nav-item"><a href="#">Register</a></li>
                                                </c:if>
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
                                                        <li class="dropdown"><a href="index.jsp">Home</a></li>
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
                    <div class="page-title-wrap-inner section-bg-img" data-bg="images/page-title.jpg">
                        <div class="container">
                            <div class="row text-center">
                                <div class="col-md-12">
                                    <div class="page-title-inner">
                                        <h1 class="page-title mb-3">Shop</h1>
                                        <div id="breadcrumb" class="breadcrumb">
                                            <a href="index.jsp">Home</a>
                                            <span class="current">Shop</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- page-header -->
                <!-- Page Content -->
                <div class="content-wrapper pad-none">
                    <div class="content-inner">
                        <!-- Shop Section -->
                        <section id="shop-section" class="shop-section pad-bottom-100">
                            <!-- Screan Reader Text -->
                            <h2 class="screen-reader-text">Shop</h2>
                            <div class="container">
                                <!-- Row -->
                                <div class="row">
                                    <c:forEach var="row" items="${result.rows}">
                                        <!-- Col -->
                                        <div class="col-md-3">
                                            <!-- Product Wrap -->
                                            <div class="product-wrap mb-4 pb-2">
                                                <!--Product Inner-->
                                                <div class="product-inner">
                                                    <div class="product-thumb mb-4 relative">
                                                        <span class="onsale">Sale!</span>
                                                        <img src="${row.image}" class="img-fluid thumb" alt="product-img" style="width: 100%" />
                                                        <div class="product-button-wrap text-center">
                                                            <t:form action="/details">
                                                                <input type="hidden" name="productId" value="${row.id}"/>
                                                                <input type="submit" class="btn cart-btn mr-2 text-uppercase" value="Details"/>
                                                            </t:form>
                                                        </div>
                                                    </div>
                                                    <div class="product-details text-center">
                                                        <div class="product-title">
                                                            <h4 class="mb-1"><a href="#" class="product-name font-w-600">${row.title}</a></h4>
                                                        </div>
                                                        <span class="offer-price">by ${row.author}</span>
                                                        <div class="product-pricing mt-1">
                                                            <del><span class="normal-price">₹ ${row.cost-30}</span></del>
                                                            <span class="offer-price">₹ ${row.cost}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--Product Inner Ends-->
                                            </div>
                                            <!-- Product Wrap -->
                                        </div>
                                    </c:forEach>

                                </div>
                                <!-- Row -->
                            </div>
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
                        <!-- Col -->
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
        <!-- Appear Js -->
        <script src="js/jquery.appear.min.js"></script>
        <!-- Smart Resize Js -->
        <script src="js/smartresize.min.js"></script>
        <!-- Theme Custom Js -->
        <script src="js/custom.js"></script>
    </body>
</html>
