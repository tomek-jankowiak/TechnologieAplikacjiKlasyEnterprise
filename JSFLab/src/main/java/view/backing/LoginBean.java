/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tomek
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    public LoginBean() {
    }

    public String login() {
        if (isOracleLogin()) {
            return handleOracleLogin();
        }
        return username.equals(password) ? "success" : "failure";
    }
    
    public void activateLoginButton() {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }
        
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }
    
    private boolean isOracleLogin() {
        return "scott".equalsIgnoreCase(username)
                && "tiger".equalsIgnoreCase(password);
    }

    private String handleOracleLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        String errorMessage = ResourceBundle
                .getBundle("ApplicationMessages", context.getViewRoot().getLocale())
                .getString("error.oracle"); 
        context.addMessage(null, new FacesMessage(errorMessage));
        context.renderResponse();
        return "index";
    }
}
