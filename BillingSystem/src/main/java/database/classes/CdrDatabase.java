/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CdrDatabase {

    public Connection con;
    public Statement stmt;
    public PreparedStatement prestmt;
    public String query;
    public ResultSet rs;
    public static CdrDatabase db=new CdrDatabase();

    public CdrDatabase()
    {
        try {
            startConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startConnect() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tictactoe",
                    "postgres", "root");
            System.out.println("Connected to serverSocket db");
        } catch (Exception e) {
            System.out.println("javadb.JavaDB" +e);
        }

    }

    private void endConnection() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CdrDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public static void setDB()
    {
        try {
        } catch (Exception ex) {
            Logger.getLogger(CdrDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CdrDatabase getDB()
    {
        return db;
    }
}
