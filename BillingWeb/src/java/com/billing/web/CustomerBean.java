/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billing.web;

/**
 *
 * @author LENOVO
 */
public class CustomerBean {
    private int id, contractid;
    private String name, address, email;
  //  private String  gender, country;
   
    private int rateplane_id, net_voice_service, cross_voice_service, data_service, sms_service, international_voice, 
            free_units,fee, net_voice_price, international_sms, international_sms_price, international_voice_price, 
            cross_voice_price, data_price, sms_price;
        private String commercial_name;

    public int getRateplane_id() {
        return rateplane_id;
    }

    public void setRateplane_id(int rateplane_id) {
        this.rateplane_id = rateplane_id;
    }

    public int getNet_voice_service() {
        return net_voice_service;
    }

    public void setNet_voice_service(int net_voice_service) {
        this.net_voice_service = net_voice_service;
    }

    public int getCross_voice_service() {
        return cross_voice_service;
    }

    public void setCross_voice_service(int cross_voice_service) {
        this.cross_voice_service = cross_voice_service;
    }

    public int getData_service() {
        return data_service;
    }

    public void setData_service(int data_service) {
        this.data_service = data_service;
    }

    public int getSms_service() {
        return sms_service;
    }

    public void setSms_service(int sms_service) {
        this.sms_service = sms_service;
    }

    public int getInternational_voice() {
        return international_voice;
    }

    public void setInternational_voice(int international_voice) {
        this.international_voice = international_voice;
    }

    public int getFree_units() {
        return free_units;
    }

    public void setFree_units(int free_units) {
        this.free_units = free_units;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getNet_voice_price() {
        return net_voice_price;
    }

    public void setNet_voice_price(int net_voice_price) {
        this.net_voice_price = net_voice_price;
    }

    public int getInternational_sms() {
        return international_sms;
    }

    public void setInternational_sms(int international_sms) {
        this.international_sms = international_sms;
    }

    public int getInternational_sms_price() {
        return international_sms_price;
    }

    public void setInternational_sms_price(int international_sms_price) {
        this.international_sms_price = international_sms_price;
    }

    public int getInternational_voice_price() {
        return international_voice_price;
    }

    public void setInternational_voice_price(int international_voice_price) {
        this.international_voice_price = international_voice_price;
    }

    public int getCross_voice_price() {
        return cross_voice_price;
    }

    public void setCross_voice_price(int cross_voice_price) {
        this.cross_voice_price = cross_voice_price;
    }

    public int getData_price() {
        return data_price;
    }

    public void setData_price(int data_price) {
        this.data_price = data_price;
    }

    public int getSms_price() {
        return sms_price;
    }

    public void setSms_price(int sms_price) {
        this.sms_price = sms_price;
    }

    public String getCommercial_name() {
        return commercial_name;
    }

    public void setCommercial_name(String commercial_name) {
        this.commercial_name = commercial_name;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int age) {
        this.contractid = contractid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
