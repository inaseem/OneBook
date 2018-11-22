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
        }
        return mapping.findForward(SUCCESS);
    }

    private boolean isAdded(String userId, String productId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("insert into cart(productId,userId) values(?,?)");
            ps.setInt(2, Integer.parseInt(userId));
            ps.setInt(1, Integer.parseInt(productId));
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private Book getBook(Connection conn, String id) {
        try {
            PreparedStatement ps = conn.prepareStatement("select*from books where id=?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    private ArrayList<CartItem> getCartItems(String userId) {
        ArrayList<CartItem> items = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("select *,count(*) from cart where userId=? GROUP BY productId");
            ps.setInt(2, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new CartItem(rs.getInt(rs.getInt(4)), getBook(conn, String.valueOf(rs.getInt(2)))));
            }
        } catch (Exception e) {

        }
        return items;
    }
}
