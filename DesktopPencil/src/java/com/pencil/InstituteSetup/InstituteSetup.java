/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.InstituteSetup;

import java.io.Serializable;

/**
 *
 * @author Mastermind
 */
public class InstituteSetup  implements Serializable
{
    private int instituteID;

    private String instituteName;
    
    private String address;
    
    private String estb;
    
    private String contactNo;
    
    private String email;
    
    private String webSite;
    
    private String einNo;
    
    private String code;
    
    private String instituteType;
    
    private String educationArea;
    
    private String branchName;
    
    private String slogan;
    
    private String note;
    
    private String footerDisplay;
    
    private String imgPath;

    public InstituteSetup(int instituteID, String instituteName, String address, String estb, String contactNo, String email, String webSite, String einNo, String code, String instituteType, String educationArea, String branchName, String slogan, String note, String footerDisplay, String imgPath) {
        this.instituteID = instituteID;
        this.instituteName = instituteName;
        this.address = address;
        this.estb = estb;
        this.contactNo = contactNo;
        this.email = email;
        this.webSite = webSite;
        this.einNo = einNo;
        this.code = code;
        this.instituteType = instituteType;
        this.educationArea = educationArea;
        this.branchName = branchName;
        this.slogan = slogan;
        this.note = note;
        this.footerDisplay = footerDisplay;
        this.imgPath = imgPath;
    }

    public InstituteSetup() 
    {
        
    }

   public int getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(int instituteID) {
        this.instituteID = instituteID;
    }
    

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEstb() {
        return estb;
    }

    public void setEstb(String estb) {
        this.estb = estb;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEinNo() {
        return einNo;
    }

    public void setEinNo(String einNo) {
        this.einNo = einNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstituteType() {
        return instituteType;
    }

    public void setInstituteType(String instituteType) {
        this.instituteType = instituteType;
    }

    public String getEducationArea() {
        return educationArea;
    }

    public void setEducationArea(String educationArea) {
        this.educationArea = educationArea;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFooterDisplay() {
        return footerDisplay;
    }

    public void setFooterDisplay(String footerDisplay) {
        this.footerDisplay = footerDisplay;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }  
}
