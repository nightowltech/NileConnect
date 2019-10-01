package com.nightowltechnology.asimyaz.nileconnect;

/**
 * Created by pc on 4/21/2017.
 */

public class CanteenList{

    public CanteenList()
    {

    }
    private String price;
    private String name;


    public CanteenList(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price_c) {
        this.price = price_c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
