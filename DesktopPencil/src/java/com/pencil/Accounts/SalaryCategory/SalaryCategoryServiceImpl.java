/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SalaryCategory;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riad
 */
public class SalaryCategoryServiceImpl implements SalaryCategoryService{
    
    public boolean addSalaryCategory(SalaryCategory salaryCategory) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into salary_category values (null, ?, ?)");
            
            prst.setString(1, salaryCategory.getCategoryName());
            
            prst.setString(2, salaryCategory.getNote());

            int add = prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        finally {
            try {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            
            catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return false;
    }

    
    public List<SalaryCategory> getAllSalaryCategory() 
    {
     List <SalaryCategory> salaryCategoryList = new ArrayList<SalaryCategory>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from salary_category");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                salaryCategoryList.add(new SalaryCategory(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

            return salaryCategoryList;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                
                if (rs != null) {

                    rs.close();

                }
                
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }
       
       return salaryCategoryList;
    }   
    
    
}
