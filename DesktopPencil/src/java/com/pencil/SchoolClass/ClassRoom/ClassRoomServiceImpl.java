/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass.ClassRoom;

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
public class ClassRoomServiceImpl  implements ClassRoomService,Serializable
{

     @Override
    public boolean createClassRoom(ClassRoom classRm) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        
        PreparedStatement prst = null;

        
         try {

            prst = con.prepareStatement("insert into classroom values (null,?,?,?,?,?)");

            prst.setString(1, classRm.getRoomNo());

            prst.setString(2, classRm.getLocation());
            
            prst.setString(3, classRm.getNote());
            
            prst.setInt(4, classRm.getRoomCapacity());
            
            prst.setInt(5, classRm.getExamCapacity());

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

    @Override
    public boolean updateClassRoom(ClassRoom classRm)
    {
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
   
        
       try {

            prst = con.prepareStatement("update classroom set RoomNo=?, Location=?, Note=?, RoomCapacity=?, ExamCapacity=? where RoomID=?");

            prst.setString(1, classRm.getRoomNo());

            prst.setString(2, classRm.getLocation());
            
            prst.setString(3, classRm.getNote());
            
            prst.setInt(4, classRm.getRoomCapacity());
            
            prst.setInt(5, classRm.getExamCapacity());
            
            prst.setInt(6, classRm.getRoomID());

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


   @Override
    public List<ClassRoom> classRoomList() 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        List<ClassRoom> classroomList = new ArrayList<ClassRoom>();
         
        try {

            prst = con.prepareStatement("select * from classroom");

            rs = prst.executeQuery();
            
            while (rs.next())
            {                
                classroomList.add(new ClassRoom(rs.getInt("RoomID"), rs.getString("RoomNo"), rs.getString("Location"),rs.getString("Note"),rs.getInt("RoomCapacity"),rs.getInt("ExamCapacity")));
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
                if(rs!=null)
                {
                    rs.close();
                }
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

        return classroomList;
       
    }
    
}
