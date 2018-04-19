package com.example.youngmin_mac.assignment4;

/**
 * Created by youngmin-mac on 2018. 4. 8..
 */

public class DataModel {
    private String city;
    private String name;
    private String sport;
    private String mvp;
    private String image;
    private int id;

    public DataModel(int id, String city, String name, String sport, String mvp, String image)
    {
        this.id = id;
        this.city = city;
        this.name = name;
        this.sport = sport;
        this.mvp = mvp;
        this.image = image;
    }
    public int getId(){ return id; }
    public String getCity()
    {
        return city;
    }
    public String getName()
    {
        return name;
    }
    public String getSport()
    {
        return sport;
    }
    public String getMvp()
    {
        return mvp;
    }
    public String getImage()
    {
        return image;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setSport(String sport)
    {
        this.sport = sport;
    }
    public void setMvp(String mvp)
    {
        this.mvp = mvp;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public void showDetails()
    {
        System.out.println("city : "+city+"\nname : "+name+"\nsport : "+sport+"\nmvp : "+mvp+"\nimage : "+image);
    }

}
