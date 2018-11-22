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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Naseem
 */
public class DetailAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        if(request.getSession()==null){
            return mapping.findForward("login");
        }
        DetailBean bean=(DetailBean)form;
        request.setAttribute("book", getBook(bean.getProductId()));
        return mapping.findForward(SUCCESS);
    }
    
    private Book getBook(String id){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook","root","");
            PreparedStatement ps=conn.prepareStatement("select*from books where id=?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
            ps.close();
            conn.close();
         }catch(Exception e){
             return null;
         }
         return null;
    }
}
