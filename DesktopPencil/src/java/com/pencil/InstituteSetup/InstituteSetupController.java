/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.InstituteSetup;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Mastermind
 */
@ManagedBean
@ViewScoped
public class InstituteSetupController implements Serializable
{
    private InstituteSetup instituteSetup;
    
    private UploadedFile photoFile;
    
    private List<InstituteSetup> InstituteList;
    
    InstituteSetupService InstituteDao = new InstituteSetupServiceImpl();
   
    ImgUpLoad imgservice=new ImgUpload_Impl();
    
    public InstituteSetupController()
    {
         this.InstituteList = InstituteDao.instituteSetupList();
    }
    
    
  public void insertInstituteSetup()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
       if(photoFile != null)
        {
            this.instituteSetup.setImgPath(instituteSetup.getInstituteID()+"_"+photoFile.getFileName());
            
            if(InstituteDao.saveInstitute(this.instituteSetup))
            {
                imgservice.uploadImg("Header",instituteSetup.getInstituteID()+"_"+photoFile.getFileName(),photoFile);
                
                context.addMessage(null, new FacesMessage("Successful","Insert institute setup.")); 
            }
            else
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Institute setup failed...!",""));
            }
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select institute logo...!",""));
        }
        
    }
  
  public void editInstituteSetup()
    {
     if(this.photoFile.getFileName().equals(""))
        {
            if(InstituteDao.updateInstitute(instituteSetup))               
            {        
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update institute info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update institute info."));
            }
        }
        else
        {
            this.instituteSetup.setImgPath(instituteSetup.getInstituteID()+"_"+photoFile.getFileName());
            
            if(InstituteDao.updateInstitute(instituteSetup)) 
            {        
                imgservice.uploadImg("Header",instituteSetup.getInstituteID()+"_"+photoFile.getFileName(),photoFile);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update institute info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update institute info."));
            }
        }
    }
   
    public InstituteSetup getInstituteSetup()
    {
         if (this.instituteSetup == null) 
        {
            this.instituteSetup = new InstituteSetup();
        }

        return this.instituteSetup;
    }

    public void setInstituteSetup(InstituteSetup instituteSetup) {
        this.instituteSetup = instituteSetup;
    }

    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }

    public List<InstituteSetup> getInstituteList() {
        return InstituteList;
    }

    public void setInstituteList(List<InstituteSetup> InstituteList) {
        this.InstituteList = InstituteList;
    }

    public ImgUpLoad getImgservice() {
        return imgservice;
    }

    public void setImgservice(ImgUpLoad imgservice) {
        this.imgservice = imgservice;
    }

}
