package parsing;

import database.classes.CdrDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

public class Parsing {

    static CdrDatabase db = CdrDatabase.getDB();
    public Connection con;
    public Statement stmt;
    public PreparedStatement preStmt;
    public String query;
    public ResultSet rs;

    public void parser() throws FileNotFoundException, SQLException {

        int index = 0;
        PreparedStatement stmt = con.prepareStatement("INSERT INTO cdr (diala,dialb,serviceid,startdate,starttime,duration,rpid,israting)" + " VALUES" + " (?,?,?,?,?,?,?,?)");
        Scanner sc = new Scanner(new File("D:\\BillingProject\\cdr.csv"));
        sc.useDelimiter(",");

        stmt.setBoolean(7, false);

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

            } else if (index == 3) {
                Date startdate = Date.valueOf(data);
                stmt.setDate(4, startdate);

            } else if (index == 4) {
                Time starttime = Time.valueOf(data);
                stmt.setTime(5, starttime);

            } else if (index == 5) {
                float duration = Float.parseFloat(data);
                stmt.setFloat(6, duration);

            } else if (index == 6) {
                int rpid = Integer.parseInt(data);
                stmt.setInt(7, rpid);
            }

            index++;
        }
stmt.executeUpdate();

        sc.close();
    }

}
