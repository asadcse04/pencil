/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SmsStatus;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SHOHUG.SQ
 */
public class SmsStatusServiceImpl implements SmsStatusService, Serializable{

    @Override
    public SmsStutas statusList() {
        // List<SmsStutas> buildingList = new ArrayList<SmsStutas>();
        SmsStutas smsStatus = new SmsStutas();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            prst = con.prepareStatement("select AccountBalance, ActiveTo, Status from test.sms_manage where School_ID = 1");

            rs = prst.executeQuery();

            while (rs.next()) {

                smsStatus=new SmsStutas(rs.getInt(1), rs.getString(2), rs.getInt(3));

            }

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

        return smsStatus;
    }

    }
    

