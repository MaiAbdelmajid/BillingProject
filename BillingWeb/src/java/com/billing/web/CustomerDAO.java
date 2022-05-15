/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billing.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CustomerDAO {

    public static Connection conn = null;
    static PreparedStatement stat = null;
    static ResultSet rs = null;

    public static void getConnection() {
        String url = "jdbc:postgresql://baniutyzlrcw7jmplijl-postgresql.services.clever-cloud.com:5432/baniutyzlrcw7jmplijl";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "uh83protr0fpqyoascu1", "BhtKHCwXtApk6Kh3JVCS");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection opencon() {
        return conn;
    }
       public static  void closecon() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int save(CustomerBean b) {
        try {
            conn.setAutoCommit(false);
            stat = conn.prepareStatement("INSERT INTO bscs.users (national_id,username,address,email)VALUES (?,?,?,?)");

            stat.setInt(1, b.getId());
            stat.setString(2, b.getName());
            stat.setString(3, b.getAddress());
            stat.setString(4, b.getEmail());
            int i = stat.executeUpdate();
            stat.getGeneratedKeys();
            if (i != 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int savecont(String contid, String nid, String phone, String rb) {

        try {
            stat = conn.prepareStatement("INSERT INTO bscs.contract (contractid,msisdn,rateplane_id,national_userid)VALUES (?,?,?,?)");

            stat.setInt(1, Integer.parseInt(contid));
            stat.setString(2, phone);
            stat.setInt(3, Integer.parseInt(rb));
            stat.setInt(4, Integer.parseInt(nid));

            int i = stat.executeUpdate();
            stat.getGeneratedKeys();
            if (i != 0) {
                conn.commit();
                conn.setAutoCommit(true);
                return 1;
            } else {
                conn.rollback();
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

   public static int craeteRP(CustomerBean b) {
        try {
           
            stat = conn.prepareStatement("INSERT INTO bscs.rateplanes (rateplane_id,commercial_name, net_voice_service, cross_voice_service, data_service, sms_service, international_voice, \n" +
"            free_units,fee, net_voice_price, international_sms, international_sms_price, international_voice_price, \n" +
"            cross_voice_price, data_price, sms_price)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stat.setInt(1, b.getRateplane_id());
            stat.setString(2, b.getCommercial_name());
            stat.setInt(3, b.getNet_voice_service());
            stat.setInt(4, b.getCross_voice_service());
            stat.setInt(5, b.getData_service());
            stat.setInt(6, b.getSms_service());
            stat.setInt(7, b.getInternational_voice());
            stat.setInt(8, b.getFree_units());
            stat.setInt(9, b.getFee());
            stat.setInt(10, b.getNet_voice_price());
            stat.setInt(11, b.getInternational_sms());
            stat.setInt(12, b.getInternational_sms_price());
            stat.setInt(13, b.getInternational_voice_price());
            stat.setInt(14, b.getCross_voice_price());
            stat.setInt(15, b.getData_price());
            stat.setInt(16, b.getSms_price());
  
            int i = stat.executeUpdate();
            stat.getGeneratedKeys();
            if (i != 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    } 
    
    public static int CreateSPKG(String Servicetypr, String Unit) {
        try {
         
            stat = conn.prepareStatement("INSERT INTO bscs.service_package (type, units)VALUES (?,?)");

          //  stat.setInt(1, id);
            stat.setString(1, Servicetypr);
            stat.setInt(2, Integer.parseInt(Unit));
            int i = stat.executeUpdate();
            stat.getGeneratedKeys();
            if (i != 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static int update(String contid, String nid, String phone, String rb) {

        try {
            stat = conn.prepareStatement("update bscs.contract set msisdn=?,rateplane_id=? where contractid=?");            
            stat.setString(1, phone);
            stat.setInt(2, Integer.parseInt(rb));
            stat.setInt(3, Integer.parseInt(contid));
         //   stat.setInt(4, Integer.parseInt(nid));

            int i = stat.executeUpdate();
            stat.getGeneratedKeys();

            if (i != 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int delete(CustomerBean b) throws SQLException {

        stat = conn.prepareStatement("delete from bscs.users where national_id=?");
        stat.setInt(1, b.getId());
        stat.executeUpdate();
        stat.getGeneratedKeys();
        if (rs != null) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int signin(String fnamevalue, String passvalue) throws ClassNotFoundException, SQLException {

        stat = conn.prepareStatement("select * from admininfo where admin_name=? and admin_pass=?");

        stat.setString(1, fnamevalue);
        stat.setString(2, passvalue);

        rs = stat.executeQuery();

        if (rs.next()) {

            String dbUser = rs.getString("admin_name");
            String dbPassword = rs.getString("admin_pass");
            System.out.println(dbUser);

            return 1;
        } else {

            return -1;

        }

    }
}
