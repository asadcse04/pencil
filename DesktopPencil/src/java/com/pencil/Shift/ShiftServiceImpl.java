/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Shift;

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
 * @author user
 */
public class ShiftServiceImpl implements ShiftService, Serializable {

    @Override
    public List<Shift> shiftList() {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<Shift> shiftList = new ArrayList<Shift>();

        try {

            prst = con.prepareStatement("select * from shift");

            rs = prst.executeQuery();

            while (rs.next())
            {
                shiftList.add(new Shift(rs.getInt("ShiftID"), rs.getString("ShiftName"), rs.getString("StartTime"), rs.getString("EndTime"), rs.getString("Note")));
            }

            prst.close();

            con.close();

            rs.close();

        }
        catch (SQLException e) 
        {
            System.out.println(e);
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

        return shiftList;
    }

    @Override
    public boolean createShift(Shift shft) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into shift values (null,?,?,?,?)");

            prst.setString(1, shft.getShiftName());

            prst.setString(2, shft.getStartTime());

            prst.setString(3, shft.getEndTime());

            prst.setString(4, shft.getNote());

            prst.execute();

            prst.close();

            con.close();

            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally 
        {
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
    public boolean updateShift(Shift shftObj) {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update shift set ShiftName=?, StartTime=?, EndTime=?, Note=?  where ShiftID=?");

            prst.setString(1, shftObj.getShiftName());

            prst.setString(2, shftObj.getStartTime());

            prst.setString(3, shftObj.getEndTime());

            prst.setString(4, shftObj.getNote());

            prst.setInt(5, shftObj.getShiftID());

            prst.execute();

            prst.close();

            con.close();

            return true;
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        finally 
        {
            try {

                if (prst != null)
                {
                    prst.close();
                }
                if (con != null) 
                {
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

}
