/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login;



import com.pencil.SystemUser.SystemUser;
import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;

/**
 *
 * @author salim
 */
public class LoginDaoImpl implements LoginDao {

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean isLogin(SystemUser obj)
    {
       
        DB_Connection o=new DB_Connection();
        
        Connection con=o.getConnection();
        
        PreparedStatement pst=null;
        
        ResultSet rs=null;
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try
        {
         
            pst = con.prepareStatement("select UserID from system_user where UserName=? and Password=? and Role=? and Status=?");
            
            pst.setString(1,obj.getUserName());
            
            pst.setString(2,obj.getPassword());
            
            pst.setString(3,obj.getRole());
            
            pst.setBoolean(4,true);
            
            rs = pst.executeQuery();
            
            while(rs.next())   
            {
                context.getExternalContext().getSessionMap().put("UserID",rs.getInt(1));
                
                return true;
            }
        }
        
        catch(SQLException e)
        {
           System.out.println(e); 
        }
        finally
        {
            try
            {
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(pst!=null) 
                { 
                    pst.close(); 
                } 
                if(con!=null) 
                { 
                    con.close(); 
                } 
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
            System.out.println("Hello user:"+obj.getUserName());
            
            obj=null;  
        }
        
        return false;
    } 
}
