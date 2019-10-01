package com.nightowltechnology.asimyaz.nileconnect;

/**
 * Created by Baffa2 on 7/3/2017.
 */

public class MDirectory {

    public MDirectory()
    {

    }
    private String cropimg;
    //private String email;
    private String name;
    //private String post;
    private String roomnumber;
   // private String telephone;


    public MDirectory(String cropimg, String post, String name, String email, String roomnumber, String telephone) {
        this.cropimg = cropimg;
        //this.post = post;
        this.name = name;
        //this.email = email;
        this.roomnumber = roomnumber;
        //this.telephone = telephone;
    }

    public String getCropimg() {
        return cropimg;
    }

    public void setCropimg(String cropimg) {
        this.cropimg = cropimg;
    }

    /*public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }*/

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    /*public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


*/


}
