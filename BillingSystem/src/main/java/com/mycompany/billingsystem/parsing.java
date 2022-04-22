package com.mycompany.billingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

public class parsing {

    public Connection con;
    public Statement stmt;
    public PreparedStatement preStmt;
    public ResultSet rs;

    public Connection dbConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cdr",
                    "postgres", "bill");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("connection problem");
        }
        return con;
    }

    public void parser() throws FileNotFoundException, SQLException {

        PreparedStatement stmt = con.prepareStatement("INSERT INTO cdr (diala,dialb,serviceid,startdate,starttime,duration,rpid,spid)" + " VALUES" + " (?,?,?,?,?,?,?,?)");
        Scanner sc = new Scanner(new File("D:\\BillingProject\\cdr.csv"));
        sc.useDelimiter(",");
        int index = 0;

        while (sc.hasNext()) {
            String data = sc.next();
            if (index == 0) {
                String diala = data;
                stmt.setString(1, diala);
                System.out.println(diala);

            } else if (index == 1) {
                String dialb = data;
                stmt.setString(2, dialb);
                System.out.println(dialb);

            } else if (index == 2) {
                int serviceid = Integer.parseInt(data);
                stmt.setInt(3, serviceid);
                System.out.println(serviceid);

            } else if (index == 4) {
                Date startdate = Date.valueOf(data);
                stmt.setDate(5, startdate);

            } else if (index == 5) {
                Time starttime = Time.valueOf(data);
                stmt.setTime(6, starttime);

            } else if (index == 3) {
                float duration = Float.parseFloat(data);
                stmt.setFloat(4, duration);

            } else if (index == 6) {
                float rpid = Float.parseFloat(data);
                stmt.setFloat(7, rpid);

            } else if (index == 7) {
                float spid = Float.parseFloat(data);
                stmt.setFloat(7, spid);

            }
            index++;
        }
        sc.close();
    }

    public void endConnection() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
        }
    }

}
