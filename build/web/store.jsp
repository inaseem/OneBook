<%-- 
    Document   : store
    Created on : 15 Nov, 2018, 8:17:29 PM
    Author     : Naseem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<!DOCTYPE html>
<%
    if (request.getSession() != null) {
        if (request.getSession().getAttribute("usetId") == null) {
            response.sendRedirect("Login.jsp");
        }
    } else {
        response.sendRedirect("Login.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style>
            .item{
                margin: 1rem;
            }
        </style>
    </head>
    <body>
        <nav class="navbar">
            <a class="navbar-brand" href="#">Onebook</a>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </nav>
        <sql:setDataSource var="webappDataSource"
                           driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/onebook"
                           user="root" password="" />

        <sql:query dataSource="${webappDataSource}"
                   sql="select * from books" var="result" />
        <div class="d-flex flex-wrap order-md-4 order-sm-1">
            <c:forEach var="row" items="${result.rows}">
                <t:form action="/details">
                    <div class="item">
                        <div class="item-inner best-seller">
                            <div class="item-img">
                                <div class="item-img-info">
                                    <img src="${row.image}" data-src="https://books.google.com/books/content?id=iTGx-wkaY5gC&amp;printsec=frontcover&amp;img=1&amp;zoom=1&amp;source=gbs_api" width="100px" height="150"> </a>
                                    <div class="jtv-box-hover">
                                        <ul class="add-to-links">
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="item-info">
                                <div class="info-inner">
                                    <div class="item-title">
                                        <h6 class="ellipsis" style="font-size: 13px">
                                            <input type="hidden" name="productId" value="${row.id}"/>
                                            <input type="submit" value="${row.title}" class="btn btn-success"/>
                                        </h6>
                                    </div>
                                    <div class="item-content">
                                        <div>
                                            <p class="ellipsis" style="font-size: 13px">
                                                by ${row.author}</p>
                                        </div>
                                        <div class="rating" style="font-size: 13px">
                                            <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star-o"></i>                                            </div>
                                        <div class="item-price">
                                            <div class="price-box"><span class="regular-price"> <span class="price">₹${row.cost}</span> </span>
                                            </div>
                                        </div>
                                        <div class="action">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </t:form>
            </c:forEach>
        </div>

        <div class="jtv-top-banner" style="margin-top: 40px;margin-bottom: 20px">
            <div class="container row">
                <div class="jtv-cont-box col-sm-4" style="background-color: #FFFFFF;border: 1px solid hsla(0,0%,58%,.3)">
                    <h3 style="color: #343434">Free <br>
                        Shipping</h3>
                    <div class="jtv-line-bg" style="color: #343434"></div>
                    <p style="color: #646464;font-size: 15px">On first order and orders above ₹299. Easy payment options.</p>
                </div>
                <div class="jtv-cont-box2 col-sm-4" style="clear: none;background-color: #FFFFFF;border: 1px solid hsla(0,0%,58%,.3)">
                    <h3 style="color: #343434">Easy <br>
                        10 Day Returns</h3>
                    <div class="jtv-line-bg" style="color: #343434"></div>
                    <p style="color: #646464;font-size: 15px">If you're not satisfied with the book quality, return it and get full refund.</p>
                </div>
                <div class="jtv-cont-box3 col-sm-4" style="background-color: #FFFFFF;border: 1px solid hsla(0,0%,58%,.3)">
                    <h3 style="color: #343434">Cashback <br>
                        Info </h3>
                    <div class="jtv-line-bg" style="color: #343434"></div>
                    <p style="color: #646464;font-size: 15px">Additional 10% cashback on all orders credited to your OyeBooks Wallet.</p>
                </div>
            </div>
        </div>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
