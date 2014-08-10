/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SalaryHead;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mamun
 */
public class SalaryHeadServiceImpl implements SalaryHeadService {
@Override
    public boolean addSalaryHead(SalaryHead salaryHead) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("insert into salary_head values (null, ?, ?, ?)");
            
            prst.setString(1, salaryHead.getSalaryHeadName());
            
            prst.setString(2, salaryHead.getNote());
            
            prst.setInt(3, salaryHead.getSalaryCategoryID());
   

            int add = prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
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
       
        return false;
    }

    @Override
    public List<SalaryHead> getAllSalaryHead() 
    {
        
       List <SalaryHead> salaryHeadList = new ArrayList<SalaryHead>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try 
        {
            prst = con.prepareStatement("select * from salary_head");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                salaryHeadList.add(new SalaryHead(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

            }

            return salaryHeadList;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally 
        {
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
       
       return salaryHeadList;
    }
    
    
    
}
