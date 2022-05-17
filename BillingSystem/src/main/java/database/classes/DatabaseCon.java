package database.classes;

import static database.classes.BillDatabase.DBUrl;
import static database.classes.BillDatabase.instDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCon {

    public Connection con;
    public Statement stmt;
    public PreparedStatement prestmt;
    public String query;
    public ResultSet rs;
    public static void main(String[] args) {
    }
 static DatabaseCon db = new DatabaseCon();

    public DatabaseCon() {
        try {
            startConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static final String url = "jdbc:postgresql://baniutyzlrcw7jmplijl-postgresql.services.clever-cloud.com:5432/baniutyzlrcw7jmplijl";
    String DBname = "baniutyzlrcw7jmplijl";
    String username = "uh83protr0fpqyoascu1";
    String pass = "BhtKHCwXtApk6Kh3JVCS";

    private void startConnect() throws Exception {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, pass);
            System.out.println("Connection is made successfully");

        } catch (Exception ex) {

            System.out.println("webDatabase.WebDataBase.connect()error");
            ex.printStackTrace();
        }
    }

    private void endConnection() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setDB() {
        try {
        } catch (Exception ex) {
            Logger.getLogger(DatabaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DatabaseCon getDB() {
        return db;
    }
}
