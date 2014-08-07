/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamConfig;

import com.pencil.Connection.DB_Connection;
import com.pencil.DefaultMark.DefaultMarkDivision;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apple
 */
public class ExamConfigService_Impl implements Serializable,ExamConfigService
{

    /**
     *
     * @param exc
     * @return
     */
    @Override
    public boolean insertExamConfig(ExamConfig exc) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        try
        {
            con.setAutoCommit(false);
            
            prst = con.prepareStatement("insert into exam_config values(null,?,(SELECT ClassID FROM class where ClassName=?),(select Exam_ID from exam where ExamName=?))");
            
            prst.setInt(1,exc.getAcyrID());
            
            prst.setString(2,exc.getClassName());
            
            prst.setString(3,exc.getExamName());
           
            prst.execute();
           
            con.commit();
            
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
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
            
            exc=null;
        }
        
        return false;
    }  

    /**
     *
     * @return
     */
    @Override
    public List<ExamConfig> examConfigList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<ExamConfig> configlist=new ArrayList<ExamConfig>();
        
        try
        {
  
            prst = con.prepareStatement("SELECT ec.ExCnfID,ec.AcYr,c.ClassName,e.ExamName FROM pencildb.exam_config ec,class c,exam e"
                    + " where ec.ClassID=c.ClassID and ec.ExamID=e.Exam_ID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                configlist.add(new ExamConfig(rs.getInt("ec.ExCnfID"),rs.getInt("ec.AcYr"),rs.getString("c.ClassName"),rs.getString("e.ExamName")));  
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
        }

        return configlist;
    }

    /**
     *
     * @param acyr
     * @param className
     * @return
     */
    @Override
    public List<String> examSubjectConfig(int acyr,String className) 
    {
        DB_Connection db=new DB_Connection(); 
       
        Connection cn=db.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> sbjlist=new ArrayList<String>();
        
        try
        {
            prst=cn.prepareStatement("SELECT distinct s.SubjectName FROM subjectconfig sc,subject s where sc.AcYrID=? and sc.ClassID=(select ClassID from class where ClassName=?) and sc.SubjectID=s.SubjectID");
            
            prst.setInt(1,acyr);
            
            prst.setString(2,className);
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                sbjlist.add(rs.getString("s.SubjectName"));
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
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
        }
        
        return sbjlist;
    }

    /**
     *
     * @param subject
     * @param sbjmarkList
     * @param excnf_id
     * @return
     */
    @Override
    public boolean exam_Subject_Mark_distribution(List<String> subject, List<DefaultMarkDivision> sbjmarkList, int excnf_id)
    {
        DB_Connection db=new DB_Connection(); 
       
        Connection cn=db.getConnection();
        
        PreparedStatement prst=null;
        
        PreparedStatement pt=null;
        
        try
        {
            prst=cn.prepareStatement("insert into exam_subject_config values(null,?,(select SubjectID from subject where SubjectName=?))");
            
            prst.setInt(1,excnf_id);
            
            
            pt=cn.prepareStatement("insert into exam_mark_division values(null,(select max(ExmSbj_ID) from exam_subject_config),?,?,?,?)");
        
            for (int i = 0; i < subject.size(); i++) 
            {
                prst.setString(2,subject.get(i));
                
                prst.execute();
                
                for(int j=0;j<sbjmarkList.size();j++)
                {
                    pt.setInt(1,sbjmarkList.get(j).getDmdId());
                    
                    pt.setDouble(2,sbjmarkList.get(j).getTotalMark());
                    
                    pt.setDouble(3,sbjmarkList.get(j).getAcceptance());
                    
                    pt.setDouble(4,sbjmarkList.get(j).getPassMark());
                    
                    pt.execute();
                }
            }
            
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(prst!=null)
                {
                    prst.close();
                }
                if(pt!=null)
                {
                    pt.close();
                }
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            
            subject.clear();
            
            sbjmarkList.clear();
        }
      
        return false;
    }
    
}
