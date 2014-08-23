/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped

/**
 *
 * @author salim
 */
public class LoginController implements Serializable {

    String username, password;
    
    String user;

    String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    private String requestedURI;

    @PostConstruct
    public void init() 
    {
        requestedURI = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);

        if (requestedURI == null) 
        {
            requestedURI = "ErrorPage.xhtml";
        }

    }

    public void login() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try 
        {
            request.login(this.username, this.password);
            this.user = request.getUserPrincipal().getName();
            HttpSession s = request.getSession();
            s.setAttribute("user", this.user);
            System.out.println("hello use,,,,,,,,,,,,,,,,,,,,,,,,,,");

        } 
        catch (ServletException e) 
        {
            context.addMessage(null, new FacesMessage("Login failed."));

        }

        try 
        {

            if (this.roleName.equals("Admin")) {

                requestedURI = "admin/index.xhtml";

            }

            if (this.roleName.equals("Teacher")) {

                requestedURI = "teacher/index.xhtml";

            }

            if (this.roleName.equals("Student")) {

                requestedURI = "student/index.xhtml";

            }

            context.getExternalContext().redirect(requestedURI);

        } 
        catch (IOException ex)
        {
            System.out.println(ex);
        }

    }

    public String logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try
        {
            request.logout();
            
           return "/Login?faces-redirect=true";
           
        } 
        catch (ServletException e)
        {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
      return "/Login?faces-redirect=true";
    }

}
