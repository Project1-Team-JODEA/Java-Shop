/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import business.Vaccine;
/**
 *
 * @author alexs
 */
public class Patient {
    private int rid;
    private String ssn, fname, mname, lname, dob;
    private Vaccine vac1, vac2, vac3, vac4;
    
    //default constructor
    public Patient(){
        this.rid = -1;
        this.ssn = "";
        this.fname = "";
        this.mname = "";
        this.lname = "";
        this.dob = "";
        this.vac1 = null;
        this.vac2 = null;
        this.vac3 = null;
        this.vac4 = null;
    }
    
    //normal constructor.  All fields should be validated BEFORE calling this method.
    public Patient (int rid, String ssn, String fname, String mname, String lname, String dob, Vaccine vac1, Vaccine vac2, Vaccine vac3, Vaccine vac4){
        this.rid = rid;
        this.ssn = ssn;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.dob = dob;
        this.vac1 = vac1;
        this.vac2 = vac2;
        this.vac3 = vac3;
        this.vac4 = vac4;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Vaccine getVac1() {
        return vac1;
    }

    public void setVac1(Vaccine vac1) {
        this.vac1 = vac1;
    }

    public Vaccine getVac2() {
        return vac2;
    }

    public void setVac2(Vaccine vac2) {
        this.vac2 = vac2;
    }

    public Vaccine getVac3() {
        return vac3;
    }

    public void setVac3(Vaccine vac3) {
        this.vac3 = vac3;
    }

    public Vaccine getVac4() {
        return vac4;
    }

    public void setVac4(Vaccine vac4) {
        this.vac4 = vac4;
    }
}
