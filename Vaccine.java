/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author alexs
 */
public class Vaccine {
    private String vid, date, manufacturer, lotnum, location, state, locatype, nurse;
    
    // default constructor
    public Vaccine(){
        this.vid = "";
        this.date = "";
        this.manufacturer = "";
        this.lotnum = "";
        this.location = "";
        this.state = "";
        this.locatype = "";
        this.nurse = "";
    }
    
    // normal constructor.  All fields should be validated BEFORE calling this method
    public Vaccine(String vid, String date, String manufacturer, String lotnum, String location, String state, String locatype, String nurse){
        this.vid = vid;
        this.date = date;
        this.manufacturer = manufacturer;
        this.lotnum = lotnum;
        this.location = location;
        this.state = state;
        this.locatype = locatype;
        this.nurse = nurse;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLotnum() {
        return lotnum;
    }

    public void setLotnum(String lotnum) {
        this.lotnum = lotnum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocatype() {
        return locatype;
    }

    public void setLocatype(String locatype) {
        this.locatype = locatype;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }
    
}
