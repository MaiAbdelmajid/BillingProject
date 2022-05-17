
package Billing;


public class User {
    private int national_id;
    private String username;
    private  String address;
    private String email;
    private String msisdn;


  public User()
  {   this.national_id =0;
      this.username =null;
      this.address= null;
      this.email=null;
      this.msisdn= null;
  }
  public User(int n_id, String uname, String address, String mail, String msisdn)
  {
      this.national_id=n_id;
      this.username=uname;
      this.address=address;
      this.email=mail;
      this.msisdn=msisdn;
  }

    public int getNational_id() {
        return national_id;
    }

    public void setNational_id(int national_id) {
        this.national_id = national_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
