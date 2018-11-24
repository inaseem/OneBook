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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Naseem
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static String SUCCESS = "success";
    private String id;

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
        LoginBean login = (LoginBean) form;
        DataModel model = new DataModel();
        if (isValid(login.getUsername(), login.getPwd(), model)) {
            SUCCESS = "loginSuccess";
            model.setMessage("Succesfully Logged In");
            model.hasError(false);
            HttpSession session=request.getSession(true);
            session.setAttribute("userId", id);
            session.setAttribute("username", login.getUsername());
        } else {
            model.hasError(true);
            SUCCESS = "loginFailed";
        }
        request.setAttribute("model", model);
        return mapping.findForward(SUCCESS);
    }

    private boolean isValid(String username, String password, DataModel model) {
        boolean isValid = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("select*from users where username=?");
            ps.setString(1, username);
            if (ps.execute()) {
                ResultSet rs = ps.getResultSet();
                if (rs.first()) {
                    String pwd = rs.getString(3);
                    if (pwd.equals(password)) {
                        isValid = true;
                        id=String.valueOf(rs.getInt(1));
                    }
                } else {
                    model.setMessage("Username Does Not Exist");
                    isValid = false;
                }
            } else {
                model.setMessage("Database Error Occured");
                isValid = false;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            model.setMessage(e.getMessage());
            isValid = false;
        }
        model.hasError(!isValid);
        return isValid;
    }
}
