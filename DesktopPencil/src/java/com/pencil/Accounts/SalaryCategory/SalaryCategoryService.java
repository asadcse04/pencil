/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SalaryCategory;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface SalaryCategoryService {
     
    public boolean addSalaryCategory(SalaryCategory salaryCategory);
    
    public List<SalaryCategory> getAllSalaryCategory();


}
