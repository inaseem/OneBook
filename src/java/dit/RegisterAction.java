/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Naseem
 */
public class RegisterAction extends org.apache.struts.action.Action {

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
        RegisterBean register = (RegisterBean) form;
        DataModel model=new DataModel();
        if (register.getPwd().equals(register.getRepwd())) {
            if (isRegistered(register.getUsername(), register.getPwd(),model)) {
                SUCCESS = "registrationSuccess";
            } else {
                SUCCESS = "registrationFailed";
            }
        } else {
            model.hasError(true);
            model.setMessage("Password Do Not Match");
            SUCCESS = "registrationFailed";
        }
        request.setAttribute("model", model);
        return mapping.findForward(SUCCESS);
    }

    private boolean isRegistered(String username, String password,DataModel model) {
        boolean isRegistered = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps1 = conn.prepareStatement("select * from users where username=?");
            ps1.setString(1, username);
            if (ps1.execute()) {
                if (ps1.getResultSet().first()) {
                    isRegistered = false;
                    model.setMessage("Username Already Taken");
                } else {
                    isRegistered = insert(conn,username,password,model);
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            isRegistered = false;
        }
        model.hasError(!isRegistered);
        return isRegistered;
    }

    private boolean insert(Connection conn, String username, String password,DataModel model) {
        boolean inserted = false;
        try {
            PreparedStatement ps = conn.prepareStatement("insert into users(username,password) values(?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            int i=ps.executeUpdate();
            if(i>0){
                inserted=true;
            }else{
                inserted=false;
                model.setMessage("User registration ecountered an error.");
            }
        } catch (Exception e) {
            inserted=false;
            model.setMessage(e.getMessage());
        }
        return inserted;
    }
}
