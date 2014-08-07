/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@SessionScoped
public class LogoutController {

    /**
     * Creates a new instance of LogoutController
     */
    public LogoutController() {
    }
    
    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/Login.xhtml?faces-redirect=true";
    }
}
