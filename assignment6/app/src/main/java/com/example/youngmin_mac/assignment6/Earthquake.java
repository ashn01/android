package com.example.youngmin_mac.assignment6;

/**
 * Created by youngmin-mac on 2018. 4. 17..
 */

public class Earthquake {
    String title;
    String time;
    String url;
    String[] coord = new String[3];

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public void setCoord(String coord[])
    {
        this.coord = coord;
    }
    public String getTitle()
    {
        return title;
    }
    public String getTime()
    {
        return time;
    }
    public String getUrl()
    {
        return url;
    }
    public String[] getCoord() {
        return coord;
    }
    public void displayDetails()
    {
        System.out.println(title +" \n"+time + " \n"+url);
    }

}
