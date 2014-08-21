/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentAt_A_Glance;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author salim
 */
public class At_A_Glance implements Serializable
{   
    //---------------------------------------Student Basic Info---------------------------------------------------
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String contactNo;
    
    private String gender;
    
    private Date dob;
    
    private boolean status;
    
    private String imgPath;
    
    private String religion;
    
    private String bloodGroup;
    
    
     ///----------------------------------Student Address Info-------------------------------------------------------
    
    private String presentAddress;
    
    private String permanentAddress;
    
    //-------------------------------------Student GuardianInfo-----------------------------------------------------
    
    private String fatherName;
    
    private String fatherOccupation;
    
    
    private String motherName;
    
    private String motherOccupation;
    
    
    private String guardianName;
    
    private String guardianOccupation;
    
    private double guardianSalary;
    
    
    private String relation;
    
    private String guardianContactNo;
    
    private String guardianEmail;
   
    
       
    /////-----------------------------------Previous Exam Info------------------------------------------------------
    private int prev_Exam_ID;
    
    private String instituteName;
    
    private String eductn_board;
    
    private String group;
    
    private String p_examName;
    
    private String examRoll;
    
    private String examRegNo;
    
    private String grade;
    
    private String cgpa;
    
    private String passingYear;
    
    
    ///---------------------------------------Previous institute info---------------------------------------------------------
    private int prev_institute_ID;
    
    private String collegeName;
    
    private String academicYear; 
    
    private String prvs_className;
    
    private String prvs_deptName;
    
    private int prvs_classRoll;
    
    private String prvs_edu_board;
    
    
    //-------------------------------------Student Identification(fixed)-------------------------------------------------------------
    
    private int acyr;
    
    private String deptName;
    
    private String className;
    
    private String shiftName;
    
    private String sectionName;
    
    
    public At_A_Glance()
    {
        
    }

    public At_A_Glance(String studentID, String studentName, int studentRoll, String gender, String fatherName, String contactNo, int acyr, String className, String deptName, String shiftName, String sectionName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.gender = gender;
        this.fatherName = fatherName;
        this.contactNo = contactNo;
        this.acyr = acyr;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public double getGuardianSalary() {
        return guardianSalary;
    }

    public void setGuardianSalary(double guardianSalary) {
        this.guardianSalary = guardianSalary;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getGuardianContactNo() {
        return guardianContactNo;
    }

    public void setGuardianContactNo(String guardianContactNo) {
        this.guardianContactNo = guardianContactNo;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    public int getPrev_Exam_ID() {
        return prev_Exam_ID;
    }

    public void setPrev_Exam_ID(int prev_Exam_ID) {
        this.prev_Exam_ID = prev_Exam_ID;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getEductn_board() {
        return eductn_board;
    }

    public void setEductn_board(String eductn_board) {
        this.eductn_board = eductn_board;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getP_examName() {
        return p_examName;
    }

    public void setP_examName(String p_examName) {
        this.p_examName = p_examName;
    }

    public String getExamRoll() {
        return examRoll;
    }

    public void setExamRoll(String examRoll) {
        this.examRoll = examRoll;
    }

    public String getExamRegNo() {
        return examRegNo;
    }

    public void setExamRegNo(String examRegNo) {
        this.examRegNo = examRegNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public int getPrev_institute_ID() {
        return prev_institute_ID;
    }

    public void setPrev_institute_ID(int prev_institute_ID) {
        this.prev_institute_ID = prev_institute_ID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getPrvs_className() {
        return prvs_className;
    }

    public void setPrvs_className(String prvs_className) {
        this.prvs_className = prvs_className;
    }

    public String getPrvs_deptName() {
        return prvs_deptName;
    }

    public void setPrvs_deptName(String prvs_deptName) {
        this.prvs_deptName = prvs_deptName;
    }

    public int getPrvs_classRoll() {
        return prvs_classRoll;
    }

    public void setPrvs_classRoll(int prvs_classRoll) {
        this.prvs_classRoll = prvs_classRoll;
    }

    public String getPrvs_edu_board() {
        return prvs_edu_board;
    }

    public void setPrvs_edu_board(String prvs_edu_board) {
        this.prvs_edu_board = prvs_edu_board;
    }

    public int getAcyr() {
        return acyr;
    }

    public void setAcyr(int acyr) {
        this.acyr = acyr;
    }

    
}
