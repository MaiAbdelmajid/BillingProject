package database.classes;

import Billing.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDatabase {

    public static final String DBUrl = "jdbc:postgresql://baniutyzlrcw7jmplijl-postgresql.services.clever-cloud.com:5432/baniutyzlrcw7jmplijl";
    public Connection con;
    PreparedStatement preparedStatement;
    Statement stmt;
    public static BillDatabase instDB;

    public BillDatabase(String dbname, String user, String pass) throws SQLException {
        this.connect(dbname, user, pass);
    }

    private void connect(String dbname, String user, String pass) throws SQLException {
        this.con = DriverManager.getConnection(DBUrl, user, pass);
        this.stmt = this.con.createStatement();
        instDB = this;
    }

    public static void connectToDB() throws SQLException {
        String DBname = "baniutyzlrcw7jmplijl";
        String username = "uh83protr0fpqyoascu1";
        String pass = "BhtKHCwXtApk6Kh3JVCS";
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            new BillDatabase(DBname, username, pass);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        }
    }

    public List<String> getUserMSISDNs(int userID) throws SQLException {
        preparedStatement = this.con.prepareStatement("select msisdn from bscs.contract where national_userid= ?");
        preparedStatement.setInt(1, userID);
        ResultSet rs = preparedStatement.executeQuery();
        List<String> MSISDNs = new ArrayList<>();

        while (rs.next()) {
            MSISDNs.add(rs.getString("msisdn"));
        }
        return MSISDNs;
    }

    public int getAddConsumedUnits(String msisdn, int serviceID) throws SQLException {
        preparedStatement = this.con.prepareStatement("select sum(duration) from rtx.consumption where source_msisdn = ? and service_id= ? and rate != '0';");
        preparedStatement.setString(1, msisdn);
        preparedStatement.setInt(2, serviceID);
        ResultSet rs = preparedStatement.executeQuery();
        int totalExtraConsumed = 0;

        while (rs.next()) {
            totalExtraConsumed = rs.getInt("sum");
        }
        return totalExtraConsumed;
    }

    public int getRatedAddUnits(String msisdn, int serviceID) throws SQLException {
        preparedStatement = this.con.prepareStatement("select sum(rate) from rtx.consumption where source_msisdn = ? and service_id= ?;");
        preparedStatement.setString(1, msisdn);
        preparedStatement.setInt(2, serviceID);
        ResultSet rs = preparedStatement.executeQuery();
        int totalRate = 0;

        while (rs.next()) {
            totalRate = rs.getInt("sum");
        }
        return totalRate;
    }

    public String[] getRatePlanesInfo(String msisdn) throws SQLException {
        preparedStatement = this.con.prepareStatement("select rp.commercial_name , rp.fee\n"
                + "from bscs.\"rateplanes\" as rp join bscs.contract as ct on rp.rateplane_id = ct.rateplane_id\n"
                + "where ct.msisdn = ? ;");
        preparedStatement.setString(1, msisdn);
        ResultSet rs = preparedStatement.executeQuery();
        String [] values = new String[2];
        while (rs.next()) {
            values[0] = rs.getString("commercial_name");
System.out.print(values[0]);
            values[1] = Integer.toString(rs.getInt("fee"));
System.out.print(values[1]);

        }
        return values;
    }

    public List<User> getUsers() throws SQLException {
        preparedStatement = this.con.prepareStatement("SELECT national_id,username, address, email, msisdn FROM bscs.users,bscs.contract where national_id=national_userid");
        ResultSet rs = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(rs.getInt("national_id"),
                    rs.getString("username"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("msisdn")
            ));
        }
        return users;
    }

    public User getUser (int national_id) throws SQLException {
        preparedStatement=this.con.prepareStatement("SELECT national_id,username, address, email, msisdn FROM bscs.users,bscs.contract where national_id=?");
        preparedStatement.setInt(1,national_id);
        ResultSet rs =preparedStatement.executeQuery();
        List<User> users =new ArrayList<>();
        while(rs.next())
        {  users.add(new User(rs.getInt("national_id"),
                rs.getString("username"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("msisdn")
        ));
        }
        return users.get(0);
    }
}
