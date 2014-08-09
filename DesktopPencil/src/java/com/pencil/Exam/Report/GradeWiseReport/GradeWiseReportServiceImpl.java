/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.GradeWiseReport;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riad
 */
public class GradeWiseReportServiceImpl implements GradeWiseReportService {


      public List<String> ExamNameList(){
      
        List<String> list=new ArrayList<String>();
      
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select ExamName from exam");

            rs = prst.executeQuery();

            while (rs.next()) {
                
                list.add(rs.getString(1));
            
            }

            return list;

        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
            try {

                if (rs != null) {

                    rs.close();

                }

                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return list;
     }
      
      
      public List<GradeWiseReport> totalGradeList(GradeWiseReport gradeWiseReport){
      
       List<GradeWiseReport> list=new ArrayList<GradeWiseReport>();
      
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("SELECT (SELECT COUNT(FinalGrade) FROM student_result_summary where EXCNFID in (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) TotalStudent, \n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='A+'\n" +
                                        "\n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Aplusgrade,\n" +
                                        "\n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='A'\n" +
                                        "\n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Agrade,\n" +
                                        "\n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='A-' \n" +
                                        "\n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Aminusgrade,\n" +
                                        "\n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='B' \n" +
                                        "\n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Bgrade,\n" +
                                        "\n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='C'\n" +
                                        " \n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Cgrade,\n" +
                                        "\n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='D' \n" +
                                        "\n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Dgrade,\n" +
                                        "\n" +
                                        "(SELECT COUNT(FinalGrade) FROM student_result_summary WHERE FinalGrade='F'\n" +
                                        " \n" +
                                        "AND EXCNFID IN (SELECT EXCNFID FROM EXAM_CONFIG WHERE ACYR=? AND EXAMID=(select Exam_ID from exam where ExamName=?))) Fgrade FROM DUAL;");

            
            
            prst.setInt(1, gradeWiseReport.getAcademicyear());
            prst.setString(2, gradeWiseReport.getExamname());
            
            prst.setInt(3, gradeWiseReport.getAcademicyear());
            prst.setString(4, gradeWiseReport.getExamname());
            
            prst.setInt(5, gradeWiseReport.getAcademicyear());
            prst.setString(6, gradeWiseReport.getExamname());
            
            prst.setInt(7, gradeWiseReport.getAcademicyear());
            prst.setString(8, gradeWiseReport.getExamname());
            
            prst.setInt(9, gradeWiseReport.getAcademicyear());
            prst.setString(10, gradeWiseReport.getExamname());
            
            prst.setInt(11, gradeWiseReport.getAcademicyear());
            prst.setString(12, gradeWiseReport.getExamname());
            
            prst.setInt(13, gradeWiseReport.getAcademicyear());
            prst.setString(14, gradeWiseReport.getExamname());
            
            prst.setInt(15, gradeWiseReport.getAcademicyear());
            prst.setString(16, gradeWiseReport.getExamname());
            
            
            rs = prst.executeQuery();

            while (rs.next()) {
                
                list.add(new GradeWiseReport(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
            
            }

            return list;

        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
            try {

                if (rs != null) {

                    rs.close();

                }

                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return list;   
          
      }

}
