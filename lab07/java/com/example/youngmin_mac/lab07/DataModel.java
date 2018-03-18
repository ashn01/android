package com.example.youngmin_mac.lab07;

/**
 * Created by youngmin-mac on 2018. 3. 17..
 */

public class DataModel {
    private String[] line;
    private String Green;

    public DataModel()
    {
        line = new String[3];
    }
    public DataModel(String s1)
    {
        this();
        line[0] = s1;
    }
    public DataModel(String s1, String s2)
    {
        this(s1);
        line[1] = s2;
    }
    public DataModel(String s1,String s2,String s3, String G)
    {
        this(s1,s2);
        line[2] = s3;
        this.Green = G;
    }

    public String[] getLine()
    {
        return line;
    }

    public String getGreen()
    {
        return Green;
    }
}
