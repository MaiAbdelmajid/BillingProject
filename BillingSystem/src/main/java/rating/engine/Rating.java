package rating.engine;

import rating.interfaces.ServiceInterface;
import rating.interfaces.ZoneType;
import database.classes.Cdr;
import database.classes.DatabaseCon;
import database.classes.Udr;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rating implements ServiceInterface, ZoneType {

    static DatabaseCon db = DatabaseCon.getDB();
    Connection con;
    PreparedStatement ps;
    ResultSet res;
    Cdr cdr;
    Udr udr = new Udr();

    public void applyRating() {
        try {
            PreparedStatement ps = db.con.prepareStatement("select * from public.cdr where israting=false");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                System.out.println("data");

                cdr = new Cdr(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getDate(5),
                        res.getString(6), res.getFloat(7), res.getInt(8), res.getBoolean(9) , res.getFloat(10));
//                System.out.println(Cdr.getServiceId()+"+++"+Cdr.getCdrId());
                switch (cdr.getServiceid()) {
                    case CALL:
                        cdr.setDuration((float) Math.ceil(cdr.getDuration() / 60));
                        rating(CALL);
                        setUDRTODB(cdr, udr.getContractid());
                        changeCDRIsRationg(cdr.getCdr_id());

                        break;
                    case SMS:
                        rating(SMS);
                        setUDRTODB(cdr, udr.getContractid());
                        changeCDRIsRationg(cdr.getCdr_id());
                        break;
                    case DATA:
                        cdr.setDuration((float) Math.ceil(cdr.getDuration() / 1024));
                        rating(DATA);
                        setUDRTODB(cdr, udr.getContractid());
                        changeCDRIsRationg(cdr.getCdr_id());
                        break;
                    default:
                        System.out.println("error - not exsit service id ");
                }

            }

        } catch (SQLException e) {
            System.out.println("error - at getting cdr from db : " + e);
        }
    }

    private void rating(int ServiceId) {
        int zone = whichOperator();
        System.out.println("zone" + zone);
        udr.setContractid(getContractId(cdr.getDiala()));
        int freeunits = getFreeUnits(udr.getContractid());

        float externalCost = getExternalCostFromDB(cdr.getRpid(), ServiceId, zone);

        if (freeunits == 0) {
            checkqouta(ServiceId, zone, cdr.getDuration(), externalCost);
        } else {
            // نخصم من الباقه وكمان نتاكد اننا نخصم لو مش مكافيه نزود الفلوس
            float remaingFU = (float) (freeunits - cdr.getDuration());
            if (remaingFU >= 0) {
                setFreeUnits(remaingFU, udr.getContractid());
                cdr.setExternalcharge(0);
                //هنا محتاجه نعرف  الزون هل كدا ينفع اعمل كذا فانكشن ابديت
            } else {
                setFreeUnits(0, udr.getContractid());
                checkqouta(ServiceId, zone, (-1 * remaingFU), externalCost);
            }
        }
    }

    private int whichOperator() {
        String dialB = cdr.getDialb();
        if (dialB.matches("\\d+")) {
            if (dialB.startsWith("002")) {
                char num = dialB.charAt(5);

                if (num == '0') {
                    return ONNET;
                } else {
                    return CROSSNET;
                }
            } else {
                return INTERNATIONAL;
            }
        }
        return DATAZONE;
    }

    private int getContractId(String msisdn) {
        try {
            ps = db.con.prepareStatement("select contractid from bscs.contract where msisdn=? ");
            ps.setString(1, msisdn);
            res = ps.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rating.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private float getExternalCostFromDB(int RatePlan, int ServiceId, int zoneId) {
        try {
            String[][] arr = {
                {"net_voice_price", "cross_voice_price", "international_voice_price"},
                {"sms_price", "sms_price", "international_sms_price"},
                {"data_price", "data_price", "data_price"}
            };

            ps = db.con.prepareStatement("select " + arr[ServiceId - 1][zoneId - 1] + " from bscs.rateplanes where rateplane_id=?");
            ps.setInt(1, RatePlan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            System.out.println("error - at getting ExternalCost from db : " + e);
        }
        return 0;

    }

    private int getFreeUnits(int id) {
        try {
            ps = db.con.prepareStatement("select free_units from rtx.consumption where contractid =?");
            ps.setInt(1, id);
            res = ps.executeQuery();
            return res.getInt(1);
        } catch (Exception e) {
        }
        return 0;
    }
private void setFreeUnits(float bucketConsumption, int contractid) {
        System.out.println(bucketConsumption);
        try {
            PreparedStatement ps = db.con.prepareStatement("update rtx.consumption set free_units=? where contractid=?");
            ps.setInt(1, (int) bucketConsumption);
            ps.setInt(2, contractid);
            int done = ps.executeUpdate();
            System.out.println("setFUB "+done);
        } catch (SQLException ex) {
            Logger.getLogger(Rating.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int getqouta(int contractid, int ServiceId, int zoneId) {

        try {
            String[][] arr = {
                {"net_voice_service", "cross_voice_service", "international_voice_service"},
                {"sms_service", "sms_service", "international_sms_service"},
                {"data_service", "data_service", "data_service"}
            };

            ps = db.con.prepareStatement("select " + arr[ServiceId - 1][zoneId - 1] + " from rtx.consumption where contractid=?");
            ps.setInt(1, contractid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("error - at getting ExternalCost from db : " + e);
        }
        return 0;
    }

    private void setqouta(float consumption, int contractid, int ServiceId, int zoneId) {
        try {
            String[][] arr = {
                {"net_voice_service", "cross_voice_service", "international_voice_service"},
                {"sms_service", "sms_service", "international_sms_service"},
                {"data_service", "data_service", "data_service"}
            };

            PreparedStatement ps = db.con.prepareStatement("update rtx.consumption set " + arr[ServiceId - 1][zoneId - 1] + "= ? where contractid=?");
            ps.setInt(1, (int) consumption);
            ps.setInt(2, contractid);
            int done = ps.executeUpdate();
            System.out.println("set FU Con " + done);

        } catch (SQLException e) {
            System.out.println("error - at setFreeUnitFromContract from db : " + e);
        }
    }

    private void checkqouta(int serviceId, int zone, float consumption, float externalCost) {
        System.out.println("consumption " + consumption);
        int qouta = getqouta(udr.getContractid(), serviceId, zone);
        //System.out.println("fuFromBucket"+fuFromBucket);
        if (qouta == 0) {
            // يبقي هنسيب الاسهتلاك عادي زي ما هو 
            float consumptionLE = (consumption * externalCost) / 100;
            cdr.setExternalcharge(consumptionLE);

        } else {
            // نخصم من الباقه الاضافيه  وكمان نتاكد اننا نخصم لو مش مكافيه نزود الفلوس
            float remaingqouta = (float) (qouta - consumption);
            System.out.println("remaingBFU " + remaingqouta);
            // System.out.println("-Math.ceil(cdr.getConsumption()/60)"+Math.ceil(cdr.getConsumption()/60));
            if (remaingqouta >= 0) {
                setqouta(remaingqouta, udr.getContractid(), serviceId, zone);
                cdr.setExternalcharge(0);
            } else {
                setqouta(0, udr.getContractid(), serviceId, zone);
                cdr.setExternalcharge((-1 * remaingqouta * externalCost) / 100);
                System.out.println("ExternelCharge " + cdr.getExternalcharge());
            }
        }
    }
 private void setUDRTODB(Cdr uploadCDR, int contractid) {
        try {

            PreparedStatement ps = db.con.prepareStatement("insert into rtx.udr (diala,dialb,serviceid,startdate,starttime,duration,rpid,cost,contractid)"
                    + "                                                  values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, uploadCDR.getDiala());
            ps.setString(2, uploadCDR.getDialb());
            ps.setInt(3, uploadCDR.getServiceid());
            ps.setDate(4, (Date) uploadCDR.getStartdate());
            ps.setString(5, uploadCDR.getStarttime());
            ps.setFloat(6, uploadCDR.getDuration());
            ps.setInt(7, uploadCDR.getRpid());
            ps.setFloat(8, uploadCDR.getExternalcharge());
            ps.setInt(9, contractid);
            int done = ps.executeUpdate();
            System.out.println("udr "+done);
        } catch (SQLException e) {
            System.out.println("error - at setting udr to db : " + e);
        }
    }

    private void changeCDRIsRationg(int cdrId) {
        try {
            PreparedStatement ps = db.con.prepareStatement("update public.cdr set israting=true where cdr_id=? ");
            ps.setInt(1, cdrId);
            int done = ps.executeUpdate();
            System.out.println("cdr State " + done);
        } catch (SQLException ex) {
            Logger.getLogger(Rating.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Start rating");
            Rating rating = new Rating();
            rating.applyRating();

        } catch (Exception e) {
            Logger.getLogger(Rating.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("error - rating connection to db : " + e);
        }
    }
}
