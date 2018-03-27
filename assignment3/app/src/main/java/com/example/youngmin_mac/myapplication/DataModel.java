package com.example.youngmin_mac.myapplication;

/**
 * Created by youngmin-mac on 2018. 3. 24..
 */

public class DataModel {
    private String city;
    private String name;
    private String sport;
    private String mvp;
    private String stadium;
    private int id;

    public DataModel(int id, String city, String name, String sport, String mvp, String stadium)
    {
        this.id = id;
        this.city = city;
        this.name = name;
        this.sport = sport;
        this.mvp = mvp;
        this.stadium = stadium;
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
    public String getStadium()
    {
        return stadium;
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
    }public void setStadium(String stadium)
    {
        this.stadium = stadium;
    }

}
