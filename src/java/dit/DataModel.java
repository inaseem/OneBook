/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

/**
 *
 * @author Naseem
 */
public class DataModel {
    
    private String message;
    private RegisterBean registerBean;
    private LoginBean loginBean;
    private boolean hasError;

    public boolean hasError() {
        return hasError;
    }

    public void hasError(boolean hasError) {
        this.hasError = hasError;
    }
    

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public RegisterBean getRegisterBean() {
        return registerBean;
    }

    public void setRegisterBean(RegisterBean registerBean) {
        this.registerBean = registerBean;
    }
    
    
}
