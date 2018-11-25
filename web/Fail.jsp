<%-- 
    Document   : Fail
    Created on : 27 Oct, 2018, 7:29:46 PM
    Author     : Naseem
--%>

<%@page import="dit.DataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div id="notfound">
            <div class="notfound">
                <div class="notfound-404">
                    <h1>Oops!</h1>
                    <!--<h2>404 - The Page can't be found</h2>-->
                    <h2>
                        ${model.getMessage()}
                    </h2>
                </div>
                Go To <a href="/OneBook/Login.jsp">Home</a>
            </div>
        </div>
    </body>
</html>
