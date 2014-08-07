/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam;

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
 * @author Mahfuj
 */
public class ExamServiceImpl implements Serializable,ExamService
{

    @Override
    public boolean createExam(Exam exam)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("insert into exam values (null,?,?)");

            prst.setString(1, exam.getExamName());

            prst.setString(2, exam.getNote());

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
            try 
            {

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
    public boolean updateExam(Exam examObj)
    {
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update exam set ExamName=?, Note=? where Exam_ID=?");

            prst.setString(1, examObj.getExamName());

            prst.setString(2, examObj.getNote());

            prst.setInt(3, examObj.getExamID());
          
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

    /**
     *
     * @return
     */
    @Override
    public List<Exam> examList() 
    {
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        List<Exam> listExam=new ArrayList<Exam>();
        
       try {

            prst = con.prepareStatement("select * from exam");

            rs = prst.executeQuery();

            while (rs.next())
            {
                listExam.add(new Exam(rs.getInt("Exam_ID"), rs.getString("ExamName"),rs.getString("Note")));
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
        
        return listExam;
    }
    
}
