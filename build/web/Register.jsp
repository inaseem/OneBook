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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>One Book Register</title>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <c:set var="hasError" value="${model.hasError()}"/>
            <c:if test="${hasError}">
                <div class="error-msg">
                    <i class="fa fa-times-circle"></i>
                    ${model.getMessage()}
                </div>
            </c:if>
            <t:form action="/register" method="POST">
                <h2>student registration form</h2>
                <div class="form-group">
                    <label for="address">Name :</label>
                    <input type="text" name="name" id="address" required/>
                </div>
                <div class="form-group">
                    <label for="address">Username :</label>
                    <input type="text" name="username" id="address" required/>
                </div>
                <div class="form-group">
                    <label for="address">Password :</label>
                    <input type="password" name="pwd" id="address" required/>
                </div>
                <div class="form-group">
                    <label for="address">Re-Enter Password :</label>
                    <input type="password" name="repwd" id="address" required/>
                </div>
                <div class="form-submit">
                    <input type="reset" value="Reset" class="submit" name="reset" id="reset" />
                    <input type="submit" value="Register" class="submit" name="submit" id="submit" />
                </div>
            </t:form>

            <center style="margin-top: 32px">
                <label>Already have an account! Login <a href="/OneBook/Login.jsp">Here</a></label>
            </center>
        </div>
    </body>
</html>
