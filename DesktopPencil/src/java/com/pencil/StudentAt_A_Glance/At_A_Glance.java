/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentAt_A_Glance;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class At_A_Glance implements Serializable
{  
 //-------------Student Info ------------------
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String gender;
    
    private String fatherName;
    
    private String contactNo;
    
    private int academicYear;
    
    private String className;
    
    private String deptName;
    
    private String shiftName;
    
    private String sectionName;

  //-------------------Mark Sheet---------------------
    
    
    public At_A_Glance()
    {
        
    }

    public At_A_Glance(String studentID, String studentName, int studentRoll, String gender, String fatherName, String contactNo, int academicYear, String className, String deptName, String shiftName, String sectionName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.gender = gender;
        this.fatherName = fatherName;
        this.contactNo = contactNo;
        this.academicYear = academicYear;
        this.className = className;
        this.deptName = deptName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
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

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    
}
