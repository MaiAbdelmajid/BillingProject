
package Billing;

import database.classes.BillDatabase;
import java.io.FileNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;

public class BillCycle {
    
    public static BillInfo billCycle (String msisdn ) throws SQLException {
        BillInfo numberBill = new BillInfo();

        String [] rp = BillDatabase.instDB.getRatePlanesInfo(msisdn);

        int extraVoice = BillDatabase.instDB.getAddConsumedUnits( msisdn, 1);
        int ratedExtraVoice = BillDatabase.instDB.getRatedAddUnits(msisdn, 1);

        int extraCrossVoice =BillDatabase.instDB.getAddConsumedUnits(msisdn,2);
        int ratedExtraCross =BillDatabase.instDB.getRatedAddUnits(msisdn,2);

        int extraSms =BillDatabase.instDB.getAddConsumedUnits(msisdn,3);
        int ratedExtraSMS = BillDatabase.instDB.getRatedAddUnits(msisdn,3);

        int extraData = BillDatabase.instDB.getAddConsumedUnits(msisdn,4);
        int ratedExtraData =BillDatabase.instDB.getRatedAddUnits(msisdn,4);

        int extraRoaming =BillDatabase.instDB.getAddConsumedUnits(msisdn,5);
        int ratedExtraRoaming =BillDatabase.instDB.getRatedAddUnits(msisdn,5);

        int extraFees = (ratedExtraVoice + ratedExtraCross+ratedExtraSMS+ratedExtraData+ratedExtraRoaming)/100 ;
        int billFees = Integer.parseInt(rp[1]) + extraFees;

        numberBill.setMsisdn(msisdn);
        numberBill.setRateplane(rp[0]);
        numberBill.setMonthlyFees(Integer.parseInt(rp[1]));

        numberBill.setExtraConsumedVoice(extraVoice);
        numberBill.setRatedExtraVoice(ratedExtraVoice);

        numberBill.setExtraConsumedCross(extraCrossVoice);
        numberBill.setRatedExtraCross(ratedExtraCross);

        numberBill.setExtraConsumedData(extraData);
        numberBill.setRatedExtraData(ratedExtraData);

        numberBill.setExtraConsumedSMS(extraSms);
        numberBill.setRatedExtraSMS(ratedExtraSMS);

        numberBill.setExtraConsumedRoaming(extraRoaming);
        numberBill.setRatedExtraRoaming(ratedExtraRoaming);

        numberBill.setExtraFees(extraFees);
        numberBill.setTotalFees(billFees);

        return numberBill;
    }
    public static List<BillInfo> generateUserBill (int national_id) throws SQLException, FileNotFoundException, JRException{
        List<BillInfo> BU= new ArrayList<>();
        List<String> userNumber = BillDatabase.instDB.getUserMSISDNs(national_id);
        for (String msisdn : userNumber)
        {
            BU.add(BillCycle.billCycle(msisdn));
        }
        User user=BillDatabase.instDB.getUser(national_id);
        String fileName = "Reports_"+national_id+".pdf";
        BillGenerator.generate(BU,user,fileName);
          return BU ;

    }
    public static void generateUsersBills () throws SQLException, FileNotFoundException, JRException {
         List<User> users = BillDatabase.instDB.getUsers();
        for (User us :users)
        {
            BillCycle.generateUserBill(us.getNational_id());
        }

    }
}

