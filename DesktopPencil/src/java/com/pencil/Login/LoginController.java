/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login;

import com.pencil.SystemUser.SystemUser;
import java.io.Serializable;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@RequestScoped

public class LoginController implements Serializable {
    
    
    private SystemUser system_user;
    
    /**
     *
     */
    public static String AUTH_KEY="";
   
    /**
     * Creates a new instance of LoginController
     */
    public LoginController()
    {
        
    }

    /**
     *
     * @return
     */
    public String checkLogin()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        LoginDao dao=new LoginDaoImpl();
            
        boolean flag=dao.isLogin(this.getSystem_user());
         
        if(flag)     
        {       
            context.getExternalContext().getSessionMap().put("User_Name",this.getSystem_user().getUserName());
            
            context.getExternalContext().getSessionMap().put(AUTH_KEY,this.getSystem_user().getRole());
            
            this.system_user=null;
            
            return "/index?faces-redirect=true";   
        }
            
        else    
        {            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid System User.","")); 
        }
         
        return "Login";
    }
    
    /**
     *
     * @param event
     */
    public void isAdmin(ComponentSystemEvent event)
    {
	FacesContext fc = FacesContext.getCurrentInstance();
        
	if (!"Admin".equals(fc.getExternalContext().getSessionMap().get(LoginController.AUTH_KEY)))
        {
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
 
            nav.performNavigation("/ErrorPage.xhtml?faces-redirect=true");
	}		
    }

    /**
     * @return the system_user
     */
    public SystemUser getSystem_user()
    {
        if(this.system_user==null)
        {
            this.system_user=new SystemUser();
        }
        
        return this.system_user;
    }

    /**
     * @param system_user the system_user to set
     */
    public void setSystem_user(SystemUser system_user) {
        this.system_user = system_user;
    }
   
}
