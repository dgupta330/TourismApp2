package com.dgproduction.erdeepak_kumar.tourismapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Er.Deepak_kumar on 16-03-2018.
 */

public class Places implements Serializable {
    String name;
    String place;
    String type;
    String description;
    String location;
    String url1="http://goo.gl/gEgYUd",url2="http://goo.gl/gEgYUd",url3="http://goo.gl/gEgYUd";
    ArrayList<Guide>guides=new ArrayList<>(3);

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }


    public Places()
    {}

    public Places(String name, String place, String type, String description, String location,String url1,String url2,String url3) {
        this.name = name;
        this.place = place;
        this.type = type;
        this.description = description;
        this.location = location;
        this.url1="http://goo.gl/gEgYUd";
        this.url2=url2;
        this.url3=url3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
