<%-- 
    Document   : Login
    Created on : 27 Oct, 2018, 6:09:44 PM
    Author     : Naseem
--%>

<%@page import="dit.DataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
    DataModel model = (DataModel) request.getAttribute("model");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>One Book Login</title>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <!--<div class="container">-->
        <div class="container">
            <c:set var="hasError" value="${model.hasError()}"/>
            <c:if test="${hasError}">
                <div class="error-msg">
                <i class="fa fa-times-circle"></i>
                <%
                    if (model != null) {
                        if (model.hasError()) {
                            out.println(model.getMessage());
                        }
                    }
                %>
            </div>
            </c:if>
            <t:form method="POST" action="/login">
                <h2>student login form</h2>
                <div class="form-group">
                    <label for="address">Username :</label>
                    <input type="text" name="username" id="address" required/>
                </div>
                <div class="form-group">
                    <label for="address">Password :</label>
                    <input type="password" name="pwd" id="address" required/>
                </div>
                <div class="form-submit">
                    <input type="reset" value="Reset" class="submit" name="reset" id="reset" />
                    <input type="submit" value="Login" class="submit" name="submit" id="submit" />
                </div>
            </t:form>
            <center style="margin-top: 32px">
                <label>Don't have an account? Register <a href="/OneBook/Register.jsp">Here</a></label>
            </center>
        </div>
        <!--</div>-->

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!--<script src="js/main.js"></script>-->
    </body>
</html>
