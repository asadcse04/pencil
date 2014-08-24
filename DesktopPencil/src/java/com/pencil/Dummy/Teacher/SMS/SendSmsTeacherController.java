/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Teacher.SMS;

import com.pencil.Dummy.Teacher.Teacher;
import com.pencil.Dummy.Teacher.TeacherService;
import com.pencil.Dummy.Teacher.TeacherServiceImpl;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author INSPIRON 5421
 */
@ManagedBean
@ViewScoped

/**
 *
 * @author jahangiralamdiu
 */
public class SendSmsTeacherController implements Serializable
{

    private Teacher teacher;

    private List<Teacher> teacharList;

    private List<Teacher> teachar_filter_list;

    private List<Teacher> selectedTeacher;  //the list of teacher after selection

    private TeacherDataModel teacher_data_model;
    

    private String message;
    
    private int smsBal;
    

    SendSms_Teacher_Service serviceDao = new SendSms_Teacher_ServiceImpl();

    TeacherService teacherService = new TeacherServiceImpl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();

    /**
     *
     */
    public SendSmsTeacherController()
    {
        this.teacharList = teacherService.teacherList();

        teacher_data_model = new TeacherDataModel(this.teacharList);
        
        this.smsBal=msgservice.getSmsCurrent_Ac_Balance(1);//schoolid
    }

    /**
     *
     * @return
     */
    public String sendSms_2_Teacher()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.sendSms(this.selectedTeacher, this.getMessage(),this.getSmsBal()))
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully send sms to the selected teachers."));
        }
        else 
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to send sms to the selected teachers."));
        }
        
        this.selectedTeacher.clear();
        
        this.message=null;
        
        return "/Dummy/Teacher/BulkSms/SendSmsTeacher";
    }

    /**
     *
     * @return
     */
    public Teacher getTeacher()
    {
        if (this.teacher == null)
        {
            this.teacher = new Teacher();
        }
        return this.teacher;
    }

    /**
     *
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return
     */
    public List<Teacher> getTeacharList() {
        return teacharList;
    }

    /**
     *
     * @param teacharList
     */
    public void setTeacharList(List<Teacher> teacharList) {
        this.teacharList = teacharList;
    }

    /**
     * @return the teachar_filter_list
     */
    public List<Teacher> getTeachar_filter_list() {
        return teachar_filter_list;
    }

    /**
     * @param teachar_filter_list the teachar_filter_list to set
     */
    public void setTeachar_filter_list(List<Teacher> teachar_filter_list) {
        this.teachar_filter_list = teachar_filter_list;
    }

    /**
     * @return the selectedTeacher
     */
    public List<Teacher> getSelectedTeacher() {
        return selectedTeacher;
    }

    /**
     * @param selectedTeacher the selectedTeacher to set
     */
    public void setSelectedTeacher(List<Teacher> selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    /**
     * @return the teacher_data_model
     */
    public TeacherDataModel getTeacher_data_model() {
        return teacher_data_model;
    }

    /**
     * @param teacher_data_model the teacher_data_model to set
     */
    public void setTeacher_data_model(TeacherDataModel teacher_data_model) {
        this.teacher_data_model = teacher_data_model;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * @return the smsBal
     */
    public int getSmsBal() {
        return smsBal;
    }

    /**
     * @param smsBal the smsBal to set
     */
    public void setSmsBal(int smsBal) {
        this.smsBal = smsBal;
    }
   
}
