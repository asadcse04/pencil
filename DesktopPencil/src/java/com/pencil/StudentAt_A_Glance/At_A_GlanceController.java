/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentAt_A_Glance;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class At_A_GlanceController implements Serializable
{   
 private At_A_Glance studentSearch;
  
  
 private List<At_A_Glance> studentlist;
 
 At_A_GlanceService at_a_glanceDao = new At_A_GlanceServiceImpl();
 

 public void viewStudentInfo()
 {   
     FacesContext context=FacesContext.getCurrentInstance();
      
     this.studentlist = at_a_glanceDao.getStudentAllinfo(this.studentSearch.getStudentID());
     
     if(this.studentlist.size()< 1)
     
     {      
     context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"This Student ID is not found.",""));
         
     this.studentSearch.setStudentName("");
     
     this.studentSearch.setGender("");
     
     this.studentSearch.setFatherName("");
     
     this.studentSearch.setContactNo("");
     
     this.studentSearch.setAcyr(0);
     
     this.studentSearch.setShiftName("");
     
     this.studentSearch.setClassName("");
     
     this.studentSearch.setSectionName("");
     
     this.studentSearch.setStudentRoll(0);
     
     this.studentSearch.setDeptName("");
        
     }   
     else
     {    
     this.studentSearch.setStudentName(this.studentlist.get(0).getStudentName());
     
     this.studentSearch.setGender(this.studentlist.get(0).getGender());
     
     this.studentSearch.setFatherName(this.studentlist.get(0).getFatherName());
     
     this.studentSearch.setContactNo(this.studentlist.get(0).getContactNo());
     
     this.studentSearch.setAcyr(this.studentlist.get(0).getAcyr());
     
     this.studentSearch.setShiftName(this.studentlist.get(0).getShiftName());
     
     this.studentSearch.setClassName(this.studentlist.get(0).getClassName());
     
     this.studentSearch.setSectionName(this.studentlist.get(0).getSectionName());
     
     this.studentSearch.setStudentRoll(this.studentlist.get(0).getStudentRoll());
     
     this.studentSearch.setDeptName(this.studentlist.get(0).getDeptName());  
    
         
     }
 
 }

    public At_A_Glance getStudentSearch()
    {
        if(this.studentSearch==null)
        {
            this.studentSearch=new At_A_Glance();
        }
        return studentSearch;
    }

    public void setStudentSearch(At_A_Glance studentSearch) {
        this.studentSearch = studentSearch;
    }

    public List<At_A_Glance> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(List<At_A_Glance> studentlist) {
        this.studentlist = studentlist;
    }
 
 

  
}
