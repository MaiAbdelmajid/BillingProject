package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database {
    public static final String DBUrl = "jdbc:postgresql://baniutyzlrcw7jmplijl-postgresql.services.clever-cloud.com:5432/baniutyzlrcw7jmplijl";
    public Connection con;
    PreparedStatement preparedStatement;
    Statement stmt;
    public database(String dbname, String user, String pass) throws SQLException {
        this.connect(dbname, user, pass);
    }
    private void connect(String dbname, String user, String pass) throws SQLException {
        this.con = DriverManager.getConnection(DBUrl + dbname, user, pass);
        this.stmt= this.con.createStatement();
        //instanceData = this;
    }

    public List<Integer> getUserMSISDNs(int userID) throws SQLException {
        preparedStatement = this.con.prepareStatement("select msisdn from bscs.contract where userid = ?");
        preparedStatement.setInt(1,userID);
        ResultSet rs = preparedStatement.executeQuery();
        List<Integer> MSISDNs = new ArrayList<>();

        while(rs.next()){
            MSISDNs.add(rs.getInt("msisdn"));
        }
        return MSISDNs;
    }

    public int getAddConsumedUnits(int msisdn, int serviceID) throws SQLException{
        preparedStatement = this.con.prepareStatement("select sum(duration) from rtx.consumption where source_msisdn = ? and service_id= ? and rate != '0';");
        preparedStatement.setInt(1,msisdn);
        preparedStatement.setInt(2,serviceID);
        ResultSet rs = preparedStatement.executeQuery();
        int totalExtraConsumed = 0;

        while(rs.next())
        {
            totalExtraConsumed = rs.getInt("sum");
        }
        return totalExtraConsumed;
    }

    public int getRatedAddUnits(int msisdn, int serviceID) throws SQLException{
        preparedStatement = this.con.prepareStatement("select sum(rate) from rtx.consumption where source_msisdn = ? and service_id= ?;");
        preparedStatement.setInt(1,msisdn);
        preparedStatement.setInt(2,serviceID);
        ResultSet rs = preparedStatement.executeQuery();
        int totalRate = 0;

        while(rs.next())
        {
            totalRate = rs.getInt("sum");
        }
        return totalRate;
    }
}
