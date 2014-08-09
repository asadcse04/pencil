/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.InstituteGrade;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public class GradeReportServiceImpl implements GradeReportService, Serializable {

    @Override
    public List<GradeReport> gradeList(GradeReport gradeReport) {

        List<GradeReport> gradeList = new ArrayList<GradeReport>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            prst = con.prepareStatement("SELECT S.SHIFTNAME, D.DEPARTMENTNAME, C.CLASSNAME, SC.SECTIONNAME,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE='A+' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =? ))) A_PLUS,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE ='A' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =?  ))) A,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE ='A-' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =?  ))) A_MINUS,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE ='B' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =?  ))) B,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE ='C' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =?  ))) C,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE ='D' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =?  ))) D,\n"
                    + "(SELECT COUNT(FINALGRADE) FROM STUDENT_RESULT_SUMMARY WHERE FINALGRADE ='F' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) \n"
                    + "AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =?  ))) F\n"
                    + "FROM SHIFT S, DEPARTMENT D, CLASS C, SECTION SC, CLASSCONFIG CG\n"
                    + "WHERE S.SHIFTID=CG.SHIFTID AND D.DEPARTMENTID=CG.DEPTID AND C.CLASSID=CG.CLASSID AND SC.SECTIONID=CG.SECTIONID\n"
                    + "ORDER BY SECTIONNAME, SHIFTNAME,DEPARTMENTNAME,CLASSNAME  ASC");

            prst.setInt(1, gradeReport.getAcYr());

            prst.setString(2, gradeReport.getExamName());

            prst.setInt(3, gradeReport.getAcYr());

            prst.setString(4, gradeReport.getExamName());

            prst.setInt(5, gradeReport.getAcYr());

            prst.setString(6, gradeReport.getExamName());

            prst.setInt(7, gradeReport.getAcYr());

            prst.setString(8, gradeReport.getExamName());

            prst.setInt(9, gradeReport.getAcYr());

            prst.setString(10, gradeReport.getExamName());

            prst.setInt(11, gradeReport.getAcYr());

            prst.setString(12, gradeReport.getExamName());

            prst.setInt(13, gradeReport.getAcYr());

            prst.setString(14, gradeReport.getExamName());

            rs = prst.executeQuery();

            while (rs.next()) {

                gradeList.add(new GradeReport(rs.getString("CLASSNAME"), rs.getString("DEPARTMENTNAME"), rs.getString("SHIFTNAME"), rs.getString("SECTIONNAME"), (rs.getInt("A_PLUS") + rs.getInt("A") + rs.getInt("A_MINUS") + rs.getInt("B") + rs.getInt("C") + rs.getInt("D") + rs.getInt("F")), rs.getInt("A_PLUS"), rs.getInt("A"), rs.getInt("A_MINUS"), rs.getInt("B"), rs.getInt("C"), rs.getInt("D"), rs.getInt("F")));
            }
            return gradeList;

        } catch (SQLException ex) {

            System.out.println(ex);
        } finally {
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
        return gradeList;
    }
}
