<%-- 
    Document   : details
    Created on : 21 Nov, 2018, 12:04:51 PM
    Author     : Naseem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="t"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <%
            out.println(request.getSession().getAttribute("userId"));
            %>
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <center>
                    <img src="${book.getImage()}" class="img-responsive img-thumbnail">                
                </center>

                <div class="table-responsive">
                    <t:form action="/addToCart">
                    <table class="table">
                        <tbody>
                            <tr>
                                <td class="text-center">
                                    <input type="hidden" name="productId" value="${book.getId()}"/>
                                    <input type="submit" class="btn btn-success" value="Add To Cart">
                                </td>
                            </tr>

                        </tbody>
                    </table>
                    </t:form>
                </div>
            </div>
            <div class="col-lg-9 col-md-9">
                <div class="table-responsive">
                    <table class="table">
                        <tbody>

                            <tr>
                                <td class="text-success"><i class="fa fa-user"></i> Title</td>
                                <td>${book.getTitle()}</td>
                            </tr>
                            <tr>
                                <td class="text-success"><i class="fa fa-list-ol"></i> Cost</td>
                                <td>${book.getCost()}</td>
                            </tr>
                            <tr>
                                <td class="text-success"><i class="fa fa-book"></i> Author</td>
                                <td>${book.getAuthor()}</td>
                            </tr>
                            <tr>
                                <td class="text-success"><i class="fa fa-group"></i> ISBN</td>
                                <td>${book.getIsbn()}</td>
                            </tr>
                            <tr>
                                <td class="text-success"><i class="fa fa-calendar"></i> Description</td>
                                <td>${book.getDescription()}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </body>
</html>
