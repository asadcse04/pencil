/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.InstitutePassFail;

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
public class InstituteReportServiceImpl implements InstituteReportService, Serializable {


    @Override
    public List<String> ExamNameList() {
        List<String> list = new ArrayList<String>();

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

        return list;
    }

    @Override
    public List<InstituteReport> totalPassFail(InstituteReport instituteWiseReport) {
        List<InstituteReport> pfList = new ArrayList<InstituteReport>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("SELECT S.SHIFTNAME, D.DEPARTMENTNAME, C.CLASSNAME, SC.SECTIONNAME, "
                    + " (SELECT COUNT(STATUS) FROM STUDENT_RESULT_SUMMARY WHERE STATUS='PASS' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =? ))) PASS, "
                    + " (SELECT COUNT(STATUS) FROM STUDENT_RESULT_SUMMARY WHERE STATUS='FAIL' AND STUDENTID IN(SELECT STUDENTID FROM STUDENT_IDENTIFICATION WHERE CLASSCONFIGID=CG.SCCONFIGID) AND EXCNFID=(SELECT EXCNFID FROM EXAM_CONFIG WHERE CLASSID=C.CLASSID AND ACYR=? AND EXAMID=(SELECT Exam_ID FROM exam WHERE ExamName =? ))) FAIL "
                    + " FROM SHIFT S, DEPARTMENT D, CLASS C, SECTION SC, CLASSCONFIG CG "
                    + " WHERE S.SHIFTID=CG.SHIFTID AND D.DEPARTMENTID=CG.DEPTID AND C.CLASSID=CG.CLASSID AND SC.SECTIONID=CG.SECTIONID "
                    + " ORDER BY SECTIONNAME, SHIFTNAME,DEPARTMENTNAME,CLASSNAME  ASC ");

            prst.setInt(1, instituteWiseReport.getAcYr());
            prst.setString(2, instituteWiseReport.getExamName());

            prst.setInt(3, instituteWiseReport.getAcYr());
            prst.setString(4, instituteWiseReport.getExamName());
            
            rs = prst.executeQuery();

            while (rs.next()) {
                int total;
                int passp;
                int failp;
                total = rs.getInt("PASS") + rs.getInt("FAIL");
                if (total == 0) {
                    passp = 0;
                    failp = 0;
                } else {
                    passp = rs.getInt("PASS") * 100 / total;
                    failp = rs.getInt("FAIL") * 100 / total;
                }

                pfList.add(new InstituteReport(rs.getString("CLASSNAME"), rs.getString("DEPARTMENTNAME"), rs.getString("SHIFTNAME"), rs.getString("SECTIONNAME"), (total), rs.getInt("FAIL"), (failp), rs.getInt("PASS"), (passp)));
            }
            return pfList;

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
        return pfList;
    }
}
