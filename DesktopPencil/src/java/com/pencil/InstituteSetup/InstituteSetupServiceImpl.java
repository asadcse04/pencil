/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.InstituteSetup;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mastermind
 */
public class InstituteSetupServiceImpl implements InstituteSetupService,Serializable
{

    @Override
    public boolean saveInstitute(InstituteSetup instituteSetup) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst;
        
        try
        {          
            prst = con.prepareStatement("insert into institute_setup values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
            prst.setString(1,instituteSetup.getInstituteName());
                 
            prst.setString(2,instituteSetup.getAddress());
            
            prst.setString(3,instituteSetup.getEstb());
            
            prst.setString(4,instituteSetup.getContactNo());
            
            prst.setString(5,instituteSetup.getEmail());
            
            prst.setString(6,instituteSetup.getWebSite());
            
            prst.setString(7,instituteSetup.getEinNo());
            
            prst.setString(8,instituteSetup.getCode());
            
            prst.setString(9,instituteSetup.getInstituteType());
            
            prst.setString(10,instituteSetup.getEducationArea());
            
            prst.setString(11,instituteSetup.getBranchName());
            
            prst.setString(12,instituteSetup.getSlogan());
             
            prst.setString(13,instituteSetup.getNote());
            
            prst.setString(14,instituteSetup.getFooterDisplay());
            
            prst.setString(15,instituteSetup.getImgPath());
            
            prst.execute();
            
            prst.close();

            con.close();
            
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return false;
    }

    @Override
    public boolean updateInstitute(InstituteSetup instituteSetupObj) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst;
        
         try
        {
            prst = con.prepareStatement("update institute_setup set InstituteName=?, Address=?, ESTB=?, ContactNo=?, Email=?, WebSite=?, EINNo=?, Code=?, InstituteType=?, EducationArea=?, BranchName=?, Slogan=?, Note=?, FooterDisplay=?, Logo=? where InstituteID=? ");
             
            prst.setString(1,instituteSetupObj.getInstituteName());
                 
            prst.setString(2,instituteSetupObj.getAddress());
            
            prst.setString(3,instituteSetupObj.getEstb());
            
            prst.setString(4,instituteSetupObj.getContactNo());
            
            prst.setString(5,instituteSetupObj.getEmail());
            
            prst.setString(6,instituteSetupObj.getWebSite());
            
            prst.setString(7,instituteSetupObj.getEinNo());
            
            prst.setString(8,instituteSetupObj.getCode());
            
            prst.setString(9,instituteSetupObj.getInstituteType());
            
            prst.setString(10,instituteSetupObj.getEducationArea());
            
            prst.setString(11,instituteSetupObj.getBranchName());
            
            prst.setString(12,instituteSetupObj.getSlogan());
             
            prst.setString(13,instituteSetupObj.getNote());
            
            prst.setString(14,instituteSetupObj.getFooterDisplay());
            
            prst.setString(15,instituteSetupObj.getImgPath());
            
            prst.setInt(16,instituteSetupObj.getInstituteID());
             
            prst.execute();
             
            prst.close();

            con.close();
             
            return true; 
             
           }
            catch(SQLException e)
           {
            System.out.println(e);
           }
          return false;
    }

    @Override
    public List<InstituteSetup> instituteSetupList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        List<InstituteSetup> instituteList=new ArrayList<InstituteSetup>();
         try
          {
            PreparedStatement prst = con.prepareStatement("select * from institute_setup ORDER BY InstituteID DESC LIMIT 1");
            
            ResultSet rs = prst.executeQuery();
            
            while(rs.next())
            {
                instituteList.add(new InstituteSetup(rs.getInt("InstituteID"), rs.getString("InstituteName"), rs.getString("Address"), rs.getString("ESTB"), rs.getString("ContactNo"), rs.getString("Email"), rs.getString("WebSite"), rs.getString("EINNo"), rs.getString("Code"), rs.getString("InstituteType"), rs.getString("EducationArea"), rs.getString("BranchName"), rs.getString("Slogan"), rs.getString("Note"), rs.getString("FooterDisplay"), rs.getString("Logo")));
            }

            rs.close();
            
            prst.close();
            
            con.close();
          } 
          catch (SQLException e)
          {

            System.out.println(e);
          }
        
         return instituteList;
    }   
}
