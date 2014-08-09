/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.MonthConfig;

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
public class MonthConfigServiceImpl implements MonthConfigService {

    @Override
    public boolean addMonth(MonthConfig monthConfig) 
    {
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        try 
        {
            prst = con.prepareStatement("insert into monthconfig values (null, ?, ?, ?, ?, ?, ?, ?)");
            
            prst.setString(1, monthConfig.getMonthName());
            
            prst.setString(2, monthConfig.getDisplayName());
            
            prst.setDate(3, new java.sql.Date(monthConfig.getStartDate().getTime()));
            
            prst.setDate(4, new java.sql.Date(monthConfig.getEndDate().getTime()));
            
            prst.setDate(5, new java.sql.Date(monthConfig.getPenaltyStart().getTime()));
            
            prst.setBoolean(6, monthConfig.isPenaltyStatus());
            
            prst.setInt(7, monthConfig.getAcademicYear());


            int add = prst.executeUpdate();

            return true;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally 
        {
            try 
            {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {

                System.out.println(e);
            }
        } 
               
    return false;
    
    }
    
    public boolean updateMonth(MonthConfig monthConfig)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        try{
            prst=con.prepareStatement("update monthconfig set MonthName=?, DisplayName=?, StartDate=?, EndDate=?, PenaltyStart=?, PenaltySttus=?, AcYrID=? where MonthID=?");
            
            prst.setString(1, monthConfig.getMonthName());
            
            prst.setString(2, monthConfig.getDisplayName());
            
            prst.setDate(3, new java.sql.Date(monthConfig.getStartDate().getTime()));
            
            prst.setDate(4, new java.sql.Date(monthConfig.getEndDate().getTime()));
            
            prst.setDate(5, new java.sql.Date(monthConfig.getPenaltyStart().getTime()));
            
            prst.setBoolean(6, monthConfig.isPenaltyStatus());
            
            prst.setInt(7, monthConfig.getAcademicYear());
            
            prst.setInt(8, monthConfig.getMonthConfigID());
            
            int ad=prst.executeUpdate();
            
            return true;
            
            }
        
         catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        finally{
            
             try 
            {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {

                System.out.println(e);
            }
            
        }
        
        return false;
    }

    @Override
    public List<MonthConfig> getMonthConfigList() 
    {
       List <MonthConfig> monthConfigList = new ArrayList<MonthConfig>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from MonthConfig");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                MonthConfig monthConfig = new MonthConfig();
                
                monthConfig.setMonthConfigID(rs.getInt("MonthID"));
                
                monthConfig.setMonthName(rs.getString("MonthName"));
                
                monthConfig.setDisplayName(rs.getString("DisplayName"));
                
                monthConfig.setStartDate(rs.getDate("StartDate"));
                
                monthConfig.setEndDate(rs.getDate("EndDate"));
                
                monthConfig.setPenaltyStart(rs.getDate("PenaltyStart"));
                
                monthConfig.setAcademicYear(rs.getInt("AcYrID"));
                
                monthConfigList.add(monthConfig);

            }

            return monthConfigList;

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
       
       return monthConfigList;
    }
    
}
