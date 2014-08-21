/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentAt_A_Glance;

import java.util.List;

/**
 *
 * @author user
 */
public interface At_A_GlanceService 
{
    
    public List<At_A_Glance> getStudentAllinfo(String stdID);
    
}
