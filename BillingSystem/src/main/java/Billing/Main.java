
package Billing;

import database.classes.BillDatabase;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

public class Main {        
    public static void main(String[] args) throws SQLException, FileNotFoundException, JRException {
        BillDatabase.connectToDB();
        BillCycle.generateUsersBills();
    }

}
