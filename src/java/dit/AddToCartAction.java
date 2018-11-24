/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Naseem
 */
public class AddToCartAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static String SUCCESS = "success";
    private String error;

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (request.getSession() == null) {
            return mapping.findForward("login");
        }
        AddToCart bean = (AddToCart) form;
        String userId = request.getSession().getAttribute("userId").toString();
        request.setAttribute("id", bean.getProductId());
        request.setAttribute("userId", userId);
        if (!isAdded(userId, bean.getProductId())) {
            SUCCESS = "fail";
        } else {
            ArrayList<CartItem> items = getCartItems(userId);
            double total = 0;
            for (CartItem item : items) {
                total += item.getQuantity() * item.getBook().getCost();
            }
            Cart cart = new Cart(items, String.valueOf(total));
            request.setAttribute("cart", cart);
            request.setAttribute("error", error);
        }
        return mapping.findForward(SUCCESS);
    }

    private boolean isAdded(String userId, String productId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("insert into cart(productId,userId) values(?,?)");
            ps.setInt(1, Integer.parseInt(productId));
            ps.setInt(2, Integer.parseInt(userId));
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private Book getBook(ResultSet rs) {
        try {
            return new Book(rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
        } catch (Exception e) {
            error+=e.toString();
        }
        return null;
    }

    private ArrayList<CartItem> getCartItems(String userId) {
        ArrayList<CartItem> items = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("select *,COUNT(*) from cart,books WHERE books.id=cart.productId and cart.userId=? GROUP BY cart.productId");
            ps.setInt(1, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book=getBook(rs);
                error+=rs.getObject(4).toString()+rs.getObject(5).toString()+rs.getObject(6).toString()+rs.getObject(7).toString()+rs.getObject(8).toString()+rs.getObject(9).toString()+rs.getObject(10).toString();
                items.add(new CartItem(rs.getInt(11), book));
            }
        } catch (Exception e) {
            error+=e.toString();
        }
        return items;
    }
}
