/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.user.AssignUserType;

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
public class AssignUserTypeServiceImpl implements AssignUserTypeService, Serializable {

    @Override
    public boolean addUserType(AssignUserType assignUserType) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into user values (?,?,?,null,?,?,?,?,?)");

            prst.setInt(1, assignUserType.getTeacherID());

            prst.setString(2, assignUserType.getTeacherName());

            prst.setString(3, assignUserType.getContactNo());

            prst.setString(4, assignUserType.getUserName());

            prst.setString(5, assignUserType.getPassword());

            prst.setString(6, assignUserType.getUserType());

            prst.setString(7, assignUserType.getUserTypeCode());

            prst.setString(8, assignUserType.getNote());

            prst.execute();

            prst.close();

            con.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {

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
        return false;
    }

    @Override
    public List<AssignUserType> userList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<AssignUserType> addList = new ArrayList<AssignUserType>();

        try {

            prst = con.prepareStatement("select t.TeacherID, t.TeacherName, t.Gender, tc.ContactNo from teacher t, teacher_contact_info tc\n"
                    + " where t.TeacherID=tc.TeacherID and t.TeacherID not in(select id from user)");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new AssignUserType(rs.getInt("TeacherID"), rs.getString("TeacherName"), rs.getString("Gender"), rs.getString("ContactNo")));
            }

            prst.close();

            con.close();

            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
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

        return addList;
    }

    @Override
    public List<AssignUserType> mobileList(AssignUserType mobileList) {
        DB_Connection db = new DB_Connection();

        Connection con = db.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<AssignUserType> mobile = new ArrayList<AssignUserType>();

        try {

            prst = con.prepareStatement("");

            rs = prst.executeQuery();

            while (rs.next()) {

                AssignUserType mob = new AssignUserType();

                mob.setContactNo(rs.getString(1));

                mobile.add(mob);

            }

            return mobile;

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

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

        return mobile;

    }

}
