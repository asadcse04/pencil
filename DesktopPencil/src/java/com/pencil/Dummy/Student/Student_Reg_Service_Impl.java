/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
public class Student_Reg_Service_Impl implements Serializable,Student_Reg_Service
{

    /**
     *
     * @param stdReg
     * @param scCnf_ID
     * @return
     */
    @Override
    public boolean completeStudentReg(Student_Registration stdReg,int scCnf_ID)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        ResultSet rs=null;
        
        String studentID=null;
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try
        {
            prst = con.prepareStatement("SELECT max(CAST(StudentID  AS UNSIGNED)) as StudentID FROM student_basic_info");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                studentID=rs.getString("StudentID");
            }
            if(studentID==null)
            {
                studentID="10000";
            }
            
            stdReg.setStudentID(String.valueOf(Long.parseLong(studentID)+1));   
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
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
            } 
            catch(SQLException e) 
            { 
                System.out.println(e); 
            } 
        } 
        
        try
        {
            con.setAutoCommit(false);
            
            Long.parseLong(stdReg.getCntNo());
            
            Long.parseLong(stdReg.getGuardianContactNo());
            
            prst=con.prepareStatement("insert into student_basic_info values(?,?,?,?,?,?,?,?,?,?,null)");
            
            prst.setString(1,stdReg.getStudentID());
            
            prst.setString(2,stdReg.getStudentName());
            
            prst.setInt(3,stdReg.getStudentRoll());
            
            prst.setString(4,stdReg.getCntNo());
            
            prst.setString(5,stdReg.getGender());
            
            prst.setDate(6,new java.sql.Date(stdReg.getDob().getTime()));
            
            prst.setBoolean(7,true);
            
            prst.setString(8,stdReg.getImgPath());
            
            prst.setString(9,stdReg.getReligion());
            
            prst.setString(10,stdReg.getBloodGroup());
            
            //prst.setInt(11,Integer.parseInt(context.getExternalContext().getSessionMap().get("UserID").toString()));
            
            prst.execute();
            
            prst.close();
            
            
            prst=con.prepareStatement("insert into student_guardian_info values(null,?,?,?,?,?,?,?,?,?,?,?)");
            
            prst.setString(1,stdReg.getFatherName());
            
            prst.setString(2,stdReg.getMotherName());
            
            prst.setString(3,stdReg.getGuardianName());
            
            prst.setString(4,stdReg.getRelation());
            
            prst.setString(5,stdReg.getGuardianContactNo());
            
            prst.setString(6,stdReg.getStudentID());
            
            prst.setString(7,stdReg.getFatherOccupation());
            
            prst.setString(8,stdReg.getMotherOccupation());
            
            prst.setString(9,stdReg.getGuardianOccupation());
            
            prst.setDouble(10,stdReg.getGuardianSalary());
            
            prst.setString(11,stdReg.getGuardianEmail());
            
            prst.execute();
            
            prst.close();
            
            
            prst=con.prepareStatement("insert into student_address_detail values(null,?,?,?)");
            
            prst.setString(1,stdReg.getPresentAddress());
            
            prst.setString(2,stdReg.getPermanentAddress());
            
            prst.setString(3,stdReg.getStudentID());
            
            prst.execute();
            
            prst.close();
            
            
            prst=con.prepareStatement("insert into student_identification values(?,?)");
            
            prst.setInt(1,scCnf_ID);
            
            prst.setString(2,stdReg.getStudentID());
            
            prst.execute();
            
            
            con.commit();
            
            return true;  
                
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(NumberFormatException n)
        {
            System.out.println(n);
        }
        finally
        { 
            try
            {
                if(prst!=null) 
                { 
                    prst.close(); 
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
            
            stdReg=null;
        } 
        
        return false;
    }

    /**
     *
     * @param acyr
     * @param sc_class
     * @param sc_dept
     * @return
     */
    @Override
    public List<String> elective_SubjectList(int acyr,String sc_class,String sc_dept)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> sbjList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT sbj.subjectName FROM subjectconfig s,subject sbj"
                    + " where s.SubjectID=sbj.SubjectID and s.ClassID=(select ClassID from class where ClassName=?) and"
                    + " s.DeptID=(select DepartmentID from department where DepartmentName=?) and sbj.Status=? and s.AcYrID=?");
            
            prst.setString(1,sc_class);
            
            prst.setString(2,sc_dept);
            
            prst.setBoolean(3,true);
            
            prst.setInt(4,acyr);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                sbjList.add(rs.getString("sbj.subjectName"));
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
                if(prst!=null) 
                { 
                    prst.close(); 
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
            
            sc_class=null;
            
            sc_dept=null;
        } 

        return sbjList;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student_Registration> Student_cmplt_List()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        List<Student_Registration> student_List=new ArrayList<Student_Registration>();
        
        try
        {
            prst = con.prepareStatement("SELECT sb.StudentID,sb.StudentName, sb.StudentRoll, sb.CntNo, sb.Gender, sb.DOB, sb.Status, sb.ImgPath, sb.Religion,sb.BloodGroup,sa.Present_Address, sa.Permanent_Address,"
                    + "sg.FatherName,sg.FatherOccuptn,sg.MotherName,sg.MotherOccuptn,sg.GuardianName,sg.GuardianOccuptn,sg.GuardianIncome,sg.Relation,sg.ContactNo,sg.GuardianEmail,"
                    + "acyr.AcYrID,d.DepartmentName,c.ClassName,s.ShiftName,sctn.SectionName from student_basic_info sb,student_address_detail sa,student_guardian_info sg,classconfig scCnf,"
                    + "student_identification si,academic_year acyr,department d,class c,shift s,section sctn "
                    + "where sa.StudentID=sb.StudentID and sg.StudentID=sb.StudentID and si.StudentID=sb.StudentID and si.ClassConfigID=scCnf.ScConfigID and scCnf.AcYrID=acyr.AcYrID"
                    + " and scCnf.DeptID=d.DepartmentID and scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID order by sb.StudentID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                student_List.add(new Student_Registration(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),
                        
                        rs.getDate(6),rs.getBoolean(7),rs.getString(8),rs.getString(9),rs.getString(10),
                        
                        rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getDouble(19),rs.getString(20),
                        
                        rs.getString(21),rs.getString(22),rs.getInt(23),rs.getString(24),
                        
                        rs.getString(25),rs.getString(26),rs.getString(27)));
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            { 
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(prst!=null) 
                { 
                    prst.close(); 
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
        }
        return student_List;
    }
    
}
