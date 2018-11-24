<%-- 
    Document   : Register
    Created on : 27 Oct, 2018, 6:48:53 PM
    Author     : Naseem
--%>

<%@page import="dit.DataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="images/favicon.png" rel="icon" />
        <!--Title-->
        <title>Onebook - Register</title>
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

        <div class="container">
            <c:set var="hasError" value="${model.hasError()}"/>
            <div class="checkout-form-wrap" style="padding: 15px">
                <c:if test="${hasError}">
                    <div class="error-msg">
                        <i class="fa fa-times-circle"></i>
                        ${model.getMessage()}
                    </div>
                </c:if>
                <h3 class="mb-4">Register</h3>
                <!-- form inputs -->
                <t:form method="POST" action="/register">
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
                                                <input type="text" class="form-control" name="name" placeholder="Name" required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="username" class="form-control" placeholder="Username" required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control" name="pwd" placeholder="Password" required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control" name="repwd" placeholder="Re-Enter Password" required/>
                                            </div>
                                            <div class="form-submit">
                                                <input type="reset" value="Reset" class="btn btn-warning" name="reset" id="reset" />
                                                <input type="submit" value="Register" class="btn btn-success" name="submit" id="submit" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- contact-form-7 -->
                            </div>
                        </div>
                    </div>
                    <label style="margin-top: 32px">Already have an account! Login <a href="/OneBook/Login.jsp">Here</a></label>
                </t:form>
                <span class="clearfix"></span>
                <!-- Checkout Form -->
            </div>
        </div>
    </body>
</html>
