package com.nightowltechnology.asimyaz.nileconnect;

/**
 * Created by pc on 4/21/2017.
 */


public class Dining_firebase {

    private String img;
    private String header;
    private String header1;
    private String menu;
    private String time;
    private String Location;
    public Dining_firebase(String img, String header, String header1,String menu, String Location) {
        this.img = img;
        this.header = header;
        this.header1 = header1;
        this.menu = menu;
        this.Location = Location;
    }

    public Dining_firebase()
    {

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader1() {
        return header1;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }



}
