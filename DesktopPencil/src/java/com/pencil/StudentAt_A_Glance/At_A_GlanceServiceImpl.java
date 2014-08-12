/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.StudentAt_A_Glance;

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
public class At_A_GlanceServiceImpl implements At_A_GlanceService,Serializable
{
    @Override
    public List<At_A_Glance> getStudentAllinfo(String stdID) {

        List<At_A_Glance> stdInfolist = new ArrayList<At_A_Glance>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            String query = "SELECT sb.StudentID,sb.StudentName, sb.StudentRoll,sb.Gender,sg.FatherName,sg.ContactNo,acyr.AcYrID,"
                    + " c.ClassName,d.DepartmentName,s.ShiftName,sctn.SectionName"
                    + " from student_basic_info sb,student_guardian_info sg,classconfig scCnf,"
                    + " student_identification si,academic_year acyr,"
                    + " department d,class c,shift s,section sctn"
                    + " where sg.StudentID=sb.StudentID and si.StudentID=sb.StudentID and"
                    + " si.ClassConfigID=scCnf.ScConfigID and scCnf.AcYrID=acyr.AcYrID and"
                    + " scCnf.DeptID=d.DepartmentID and"
                    + " scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID and"
                    + " scCnf.SectionID=sctn.SectionID and sb.StudentID=?";

            prst = con.prepareStatement(query);

            prst.setString(1, stdID);

            rs = prst.executeQuery();

            while (rs.next()) {

                stdInfolist.add(new At_A_Glance(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                System.out.println("" + rs.getString(2));
            }

            
        }
        catch (SQLException e)
        {
            System.out.println("Can't Find Student ID ..."+e);
        } 
        finally 
        {
            try 
            {
                if (prst != null)
                {
                    prst.close();
                }

                if (con != null)
                {
                    con.close();
                }
            } 
            catch (SQLException sql) 
            {
                System.out.println(sql);
            }
        }

        return stdInfolist;
    }
}
