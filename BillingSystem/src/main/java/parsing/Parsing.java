package parsing;

import com.opencsv.CSVReader;
import database.classes.DatabaseCon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

public class Parsing {
    
    static DatabaseCon db = DatabaseCon.getDB();
    public Connection con;
    public Statement stmt;
    public PreparedStatement preStmt;
    public String query;
    public ResultSet rs;
    
    public void parser() throws FileNotFoundException, SQLException, IOException {

//        int index = 0;
        PreparedStatement stmt = db.con.prepareStatement("INSERT INTO cdr (diala,dialb,serviceid,startdate,starttime,duration,rpid,israting,externalcharge)" + " VALUES" + " (?,?,?,?,?,?,?,?,?)");
//        Scanner sc = new Scanner(new File("D:\\BillingProject\\BillingProject\\cdr.csv"));
//        sc.useDelimiter(",");

        FileReader filereader = new FileReader("D:\\BillingProject\\BillingProject\\cdr.csv");
        
        CSVReader csvReader = new CSVReader(filereader);
        
        String[] nextRecord = csvReader.readNext();
        stmt.setString(1, nextRecord[0]);
        stmt.setString(2, nextRecord[1]);
        stmt.setInt(3, Integer.parseInt(nextRecord[2]));
        stmt.setDate(4, Date.valueOf(nextRecord[3]));
        stmt.setString(5, nextRecord[4]);
        stmt.setFloat(6, Float.parseFloat(nextRecord[5]));
        stmt.setInt(7, Integer.parseInt(nextRecord[6]));
        stmt.setBoolean(8, false);
        stmt.setFloat(9, Float.parseFloat(nextRecord[7]));

        stmt.executeUpdate();
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
        Parsing pars = new Parsing();
        System.out.println("parsing.Parsing.main()");
        pars.parser();
        
    }
}
