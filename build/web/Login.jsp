<%-- 
    Document   : Login
    Created on : 27 Oct, 2018, 6:09:44 PM
    Author     : Naseem
--%>

<%@page import="dit.DataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="images/favicon.png" rel="icon" />
        <!--Title-->
        <title>Onebook - Login</title>
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
        <!--<div class="container">-->
        <div class="container">
            <c:set var="hasError" value="${model.hasError()}"/>

            <div class="checkout-form-wrap" style="padding: 15px">
                <c:if test="${hasError}">
                    <div class="error-msg">
                        <i class="fa fa-times-circle"></i>
                        ${model.getMessage()}
                    </div>
                </c:if>
                <h3 class="mb-4">Login</h3>
                <!-- form inputs -->
                <t:form method="POST" action="/login">
                    <!-- row -->
                    <div class="row">
                        <!-- col -->
                        <div class="col-md-6">
                            <div class="checkout shop-checkout">
                                <!-- Contact Form -->
                                <div class="contact-form-4">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input id="username" class="form-control" name="username" placeholder="Username" type="text">
                                            </div>
                                            <div class="form-group">
                                                <input id="password" class="form-control" name="password" placeholder="Password" type="password">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- contact-form-7 -->
                            </div>
                        </div>
                    </div>
                    <div class="form-submit">
                        <input type="reset" value="Reset" class="btn btn-warning" name="reset" id="reset" />
                        <input type="submit" value="Login" class="btn btn-success" name="submit" id="submit" />
                    </div>
                    <label style="margin-top: 32px">Don't have an account? Register <a href="/OneBook/Register.jsp">Here</a></label>
                </t:form>
                <span class="clearfix"></span>
                <!-- Checkout Form -->
            </div>
        </div>
        <!--</div>-->

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!--<script src="js/main.js"></script>-->
    </body>
</html>
