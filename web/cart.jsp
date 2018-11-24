<%-- 
    Document   : cart
    Created on : 22 Nov, 2018, 11:37:33 PM
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                    <tr>
                        <th style="width:50%">Product</th>
                        <th style="width:10%">Price</th>
                        <th style="width:8%">Quantity</th>
                        <th style="width:22%" class="text-center">Subtotal</th>
                        <th style="width:10%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart.getItems()}">
                        <c:set var="book" value="${item.getBook()}"/>
                        <tr>
                            <td data-th="Product">
                                <div class="row">
                                    <div class="col-md-3"><img src="${book.getImage()}" alt="..." class="img-responsive"/></div>
                                    <div class="col-sm-9">
                                        <h4 class="nomargin">${book.getTitle()}</h4>
                                        <p>${book.getAuthor()}</p>
                                    </div>
                                </div>
                            </td>
                            <td data-th="Price">${book.getCost()}</td>
                            <td data-th="Quantity">
                                ${item.getQuantity()}
                            </td>
                            <td data-th="Subtotal" class="text-center">${book.getCost()*item.getQuantity()}</td>
                            <td class="actions" data-th="">
                                <t:form action="/delete">
                                    <input type="hidden" value="${book.getId()}" name="productId"/>
                                    <button class="btn btn-danger btn-sm">Delete</button>								
                                </t:form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td><a href="store.jsp" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                        <td colspan="2" class="hidden-xs"></td>
                        <td class="hidden-xs text-center"><strong>Total ${cart.getTotal()}</strong></td>
                        <td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
