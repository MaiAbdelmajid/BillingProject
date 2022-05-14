package database.classes;

import java.util.Date;

public class Cdr {

    private int cdr_id;
    private String diala;
    private String dialb;
    private int serviceid;
    private Date startdate;
    private String starttime;
    private float duration;
    private int rpid;
    private boolean israting;
private float externalcharge;

    public Cdr(int id, String diala, String dialb, int serviceid, Date startdate, String starttime, float duration, int rpid, boolean israting, float externalcharge) {
        this.cdr_id = id;
        this.diala = diala;
        this.dialb = dialb;
        this.serviceid = serviceid;
        this.startdate = startdate;
        this.starttime = starttime;
        this.duration = duration;
        this.rpid = rpid;
        this.israting = israting;
    }

    public int getCdr_id() {
        return cdr_id;
    }

    public void setCdr_id(int cdr_id) {
        this.cdr_id = cdr_id;
    }

    public String getDiala() {
        return diala;
    }

    public void setDiala(String diala) {
        this.diala = diala;
    }

    public boolean isIsrating() {
        return israting;
    }

    public void setIsrating(boolean israting) {
        this.israting = israting;
    }

    public String getDialb() {
        return dialb;
    }

    public void setDialb(String dialb) {
        this.dialb = dialb;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public float getExternalcharge() {
        return externalcharge;
    }

    public void setExternalcharge(float externalcharge) {
        this.externalcharge = externalcharge;
    }

}
