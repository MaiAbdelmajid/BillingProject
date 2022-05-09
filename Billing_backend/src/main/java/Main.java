import Classes.database;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException, JRException {
        database.connectToDB();
        BillCycle.generateUsersBills();
    }

}
