/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubFeeHead;

import com.pencil.Accounts.MonthConfig.MonthConfig;
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
public class SubFeeHeadServiceImpl implements SubFeeHeadService {

    @Override
    public boolean addSubFeeHead(SubFeeHead subFeeHead) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        try 
        {
            prst = con.prepareStatement("insert into student_sub_fee_head values (null, ?, ?)");
            
            prst.setString(1, subFeeHead.getSubFeeHeadName());
            
            prst.setString(2, subFeeHead.getNote());

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

    @Override
    public List<SubFeeHead> getAllSubFeeHead() {
        
        List <SubFeeHead> subFeeHeadList = new ArrayList<SubFeeHead>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from student_sub_fee_head");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
               subFeeHeadList.add(new SubFeeHead(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

            return subFeeHeadList;

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
       
       return subFeeHeadList;
    }
    
}
