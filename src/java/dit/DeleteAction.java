/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Naseem
 */
public class DeleteAction extends org.apache.struts.action.Action {

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
        DetailBean bean = (DetailBean) form;
        String productId = bean.getProductId();
        String userId = request.getSession().getAttribute("userId").toString();
        if (!deleted(productId, userId)) {
            SUCCESS = "fail";
        }
        return mapping.findForward(SUCCESS);
    }

    private boolean deleted(String productId, String userId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("delete from cart where productId=? and userId=?");
            ps.setInt(1, Integer.parseInt(productId));
            ps.setInt(2, Integer.parseInt(userId));
            if (ps.executeUpdate() > 0) {
                return true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
