package com.example.youngmin_mac.assignment5;

/**
 * Created by youngmin-mac on 2018. 4. 11..
 */

public class Earthquake {
    String title;
    String time;
    String url;

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
    public void displayDetails()
    {
        System.out.println(title +" \n"+time + " \n"+url);
    }

}
