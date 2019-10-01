package com.nightowltechnology.asimyaz.nileconnect;

/**
 * Created by pc on 4/22/2017.
 */

public class TimetableList {


    public TimetableList(String day, String name, String time, String venue) {
        this.day = day;
        this.name = name;
        this.time = time;
        this.venue = venue;
    }

    public TimetableList()
    {

    }
    private String day;
    private String name;
    private String time;
    private String venue;


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }




}
