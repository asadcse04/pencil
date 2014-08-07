/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Teacher.SMS;

import com.pencil.Connection.DB_Connection;
import com.pencil.Dummy.Teacher.Teacher;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author INSPIRON 5421
 */
public class SendSms_Teacher_ServiceImpl implements SendSms_Teacher_Service,Serializable
{

    /**
     *
     * @param selectedTchrArry
     * @param message
     * @return
     */
    @Override
    public boolean sendSms(List<Teacher> selectedTchrArry, String message)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        
        Connection cn = o.getSms_db_Connection();

        PreparedStatement prst = null;
        
        CallableStatement cs = null;
        
        SMS_Service service=new SMS_ServiceImpl();
        
        StringBuilder cntnoList=new StringBuilder();
        
        try
        {
            con.setAutoCommit(false);

            prst=con.prepareStatement("insert into teacher_sms_record values(null,?,?,?,now())");
            
            for(Teacher teacher : selectedTchrArry)
            {
                prst.setInt(1, teacher.getTeacherID());
            
                prst.setString(2,teacher.getContactNo());
            
                prst.setString(3,message);
            
                prst.addBatch();
                
                cntnoList.append(teacher.getContactNo());
                
                cntnoList.append(",");
            }
            
            if(cntnoList.length()>0)
            {
                cntnoList.setLength(cntnoList.length()-1);
                
                if(service.sendBulkSms(cntnoList,message)==200)
                {
                    int[] update = prst.executeBatch();
                    
                    cs = cn.prepareCall("{call smsCntManage(?,?)}");
            
                    cs.setInt(1,update.length);

                    cs.setInt(2,1);

                    cs.execute();

                    System.out.println("Number of sms send to the teacher:" + update.length);

                    con.commit();

                    return true;
                }
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
                if (prst != null)
                {
                    prst.close();
                }
                if (cs != null)
                {
                    cs.close();
                }
                if (con != null)
                {
                    con.close();
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex);
            }
            
            selectedTchrArry.clear();
            
            message=null;
        }
        return false;
    }
    
}
