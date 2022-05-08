import Classes.Bill_info;
import Classes.User;
import Classes.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillCycle {

    public static Bill_info billCycle (String msisdn ) throws SQLException {
        Bill_info numberBill = new Bill_info();

        String [] rp = database.instDB.getRatePlanesInfo(msisdn);

        int extraVoice = database.instDB.getAddConsumedUnits( msisdn, 1);
        int ratedExtraVoice = database.instDB.getRatedAddUnits(msisdn, 1);

        int extraCrossVoice =database.instDB.getAddConsumedUnits(msisdn,2);
        int ratedExtraCross =database.instDB.getRatedAddUnits(msisdn,2);

        int extraSms =database.instDB.getAddConsumedUnits(msisdn,3);
        int ratedExtraSMS = database.instDB.getRatedAddUnits(msisdn,3);

        int extraData = database.instDB.getAddConsumedUnits(msisdn,4);
        int ratedExtraData =database.instDB.getRatedAddUnits(msisdn,4);

        int extraRoaming =database.instDB.getAddConsumedUnits(msisdn,5);
        int ratedExtraRoaming =database.instDB.getRatedAddUnits(msisdn,5);

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
    public static List<Bill_info> generateUserBill (int national_id) throws SQLException{
        List<Bill_info> BU= new ArrayList<>();
        List<String> userNumber = database.instDB.getUserMSISDNs(national_id);
        for (String msisdn : userNumber)
        {
            BU.add(BillCycle.billCycle(msisdn));
        }

          return BU ;

    }
    public static void generateUsersBills () throws SQLException {
         List<User> users = database.instDB.getUsers();
        for (User us :users)
        {
            BillCycle.generateUserBill(us.getNational_id());
        }

    }
}
