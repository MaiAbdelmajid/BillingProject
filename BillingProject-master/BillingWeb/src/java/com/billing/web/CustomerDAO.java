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
    //  function save the customers into DB ()

    public static int save(CustomerBean b) throws SQLException {

        stat = conn.prepareStatement("INSERT INTO bscs.users (national_id,username,address,email,msisdn)VALUES (?,?,?,?,?)");

        stat.setInt(1, b.getId());
        stat.setString(2, b.getName());     
        stat.setString(3, b.getAddress());
        stat.setString(4, b.getEmail());
        stat.setInt(5, b.getmsisdn());
    
     int i= stat.executeUpdate();
        stat.getGeneratedKeys();
        if (i != 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int update(CustomerBean b) throws SQLException {

        stat = conn.prepareStatement("update bscs.users set username=? address=? address=? email=? msisdn=? where national_id=?");
        stat.setInt(1, b.getId());
        stat.setString(2, b.getName());     
        stat.setString(3, b.getAddress());
        stat.setString(4, b.getEmail());
        stat.setInt(5, b.getmsisdn());
       int i = stat.executeUpdate();
        stat.getGeneratedKeys();
        
        
        if (i != 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int delete(CustomerBean b) throws SQLException {

        stat = conn.prepareStatement("delete from users where national_id=?");
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

    }}


