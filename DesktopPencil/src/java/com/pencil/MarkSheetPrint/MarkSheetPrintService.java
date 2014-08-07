/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.MarkSheetPrint;

import java.util.List;

/**
 *
 * @author salim
 */
public interface MarkSheetPrintService
{
     public List<MarkSheetPrint> student_Info_List();
     
     public List<MarkSheetPrint> mark_sheet_List(String studentID);
     
     public List<MarkSheetPrint>mark_sheet_finalGrade(String studentID);
}
