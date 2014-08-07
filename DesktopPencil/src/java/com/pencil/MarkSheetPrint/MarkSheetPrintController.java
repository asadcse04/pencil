/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.MarkSheetPrint;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author salim
 */
@ManagedBean
@ViewScoped
public class MarkSheetPrintController implements Serializable
{
   private MarkSheetPrint markSheetPrint;
   
   private List<MarkSheetPrint> studentInfoList;
   
   private List<MarkSheetPrint> student_Info_Filter_List;
   
   private List<MarkSheetPrint> mark_sheet_List;
   
   private List<MarkSheetPrint> total_GradeSheet_list;
   
   MarkSheetPrintService markSheetDao = new MarkSheetPrintServiceImpl();

    public MarkSheetPrintController()
    {
         this.studentInfoList = markSheetDao.student_Info_List();       
       
    }

    public void mark_Sheet(String StdID)
    { 
          
          this.mark_sheet_List = markSheetDao.mark_sheet_List(StdID);
         
    }
    
    public void total_grade(String stdId)
    {
        
        this.total_GradeSheet_list = markSheetDao.mark_sheet_finalGrade(stdId);
        
        this.markSheetPrint.setTotalMark(this.total_GradeSheet_list.get(0).getTotalMark());
        
        this.markSheetPrint.setCGPA(this.total_GradeSheet_list.get(0).getCGPA());
        
        this.markSheetPrint.setFinalGrade(this.total_GradeSheet_list.get(0).getFinalGrade());
        
        this.markSheetPrint.setStatus(this.total_GradeSheet_list.get(0).getStatus());
        
        this.markSheetPrint.setClassPosition(this.total_GradeSheet_list.get(0).getClassPosition());
        
        this.markSheetPrint.setShiftPosition(this.total_GradeSheet_list.get(0).getShiftPosition());
        
        this.markSheetPrint.setSectionPosition(this.total_GradeSheet_list.get(0).getSectionPosition());
        
//        System.out.println("total mark::::::"+this.total_GradeSheet_list.get(0).getTotalMark());
//        
//        System.out.println("total Cgpa::::::"+this.total_GradeSheet_list.get(0).getCGPA());
//         
//        System.out.println("total FinalGrade::::::"+this.total_GradeSheet_list.get(0).getFinalGrade());
//       
    
    }
    
    public MarkSheetPrint getMarkSheetPrint()
    {
         if(this.markSheetPrint==null)
        {
            this.markSheetPrint=new MarkSheetPrint();
        }
        return markSheetPrint;
    }

    public void setMarkSheetPrint(MarkSheetPrint markSheetPrint) {
        this.markSheetPrint = markSheetPrint;
    }

    public List<MarkSheetPrint> getStudentInfoList() {
        return studentInfoList;
    }

    public void setStudentInfoList(List<MarkSheetPrint> studentInfoList) {
        this.studentInfoList = studentInfoList;
    }

    public List<MarkSheetPrint> getStudent_Info_Filter_List() {
        return student_Info_Filter_List;
    }

    public void setStudent_Info_Filter_List(List<MarkSheetPrint> student_Info_Filter_List) {
        this.student_Info_Filter_List = student_Info_Filter_List;
    }

    public List<MarkSheetPrint> getMark_sheet_List() {
        return mark_sheet_List;
    }

    public void setMark_sheet_List(List<MarkSheetPrint> mark_sheet_List) {
        this.mark_sheet_List = mark_sheet_List;
    }

    public List<MarkSheetPrint> getTotal_GradeSheet_list() {
        return total_GradeSheet_list;
    }

    public void setTotal_GradeSheet_list(List<MarkSheetPrint> total_GradeSheet_list) {
        this.total_GradeSheet_list = total_GradeSheet_list;
    }

 
}
