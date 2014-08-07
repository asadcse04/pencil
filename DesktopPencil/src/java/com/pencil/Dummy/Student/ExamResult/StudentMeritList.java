/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult;

import java.io.Serializable;

/**
 *
 * @author Mastermind
 */
public class StudentMeritList implements Serializable
{
    //ID, StudentID, ExcnfID, TotalMark, TotalGpa, CGPA, FinalGrade
    
    private int id;
    
    private String studentID;
    
    private String studentName;
    
    private Double totalMark;
    
    private Double totalGpa;
    
    private Double CGPA;
    
    private String finalGrade;

    public StudentMeritList() 
    {
        
    }
    
    

    public StudentMeritList(String studentID, String studentName, Double totalMark, Double totalGpa, Double CGPA, String finalGrade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.totalMark = totalMark;
        this.totalGpa = totalGpa;
        this.CGPA = CGPA;
        this.finalGrade = finalGrade;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Double totalMark) {
        this.totalMark = totalMark;
    }

    public Double getTotalGpa() {
        return totalGpa;
    }

    public void setTotalGpa(Double totalGpa) {
        this.totalGpa = totalGpa;
    }

    public Double getCGPA() {
        return CGPA;
    }

    public void setCGPA(Double CGPA) {
        this.CGPA = CGPA;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }
    
    
    
}
