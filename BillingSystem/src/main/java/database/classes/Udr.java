package database.classes;

import java.util.Date;

public class Udr {

    private int udr_id;
    private String diala;
    private String dialb;
    private int serviceid;
    private Date startdate;
    private String starttime;
    private float duration;
    private int rpid;
    private float cost;
    private int contractid;

    public Udr() {
    }

    public Udr(int udr_id, String diala, String dialb, int serviceid, Date startdate, String starttime, float duration, int rpid, float cost, int contractid) {
        this.udr_id = udr_id;
        this.diala = diala;
        this.dialb = dialb;
        this.serviceid = serviceid;
        this.startdate = startdate;
        this.starttime = starttime;
        this.duration = duration;
        this.rpid = rpid;
        this.cost = cost;
        this.contractid = contractid;
    }

    public int getId() {
        return udr_id;
    }

    public void setId(int id) {
        this.udr_id = id;
    }

    public String getDiala() {
        return diala;
    }

    public void setDiala(String diala) {
        this.diala = diala;
    }

    public float getcost() {
        return cost;
    }

    public void setcost(float cost) {
        this.cost = cost;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

}
