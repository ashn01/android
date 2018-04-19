package com.example.youngmin_mac.assignment5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static String earthquakeUrl = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=NOW-90days&limit=20&minmagnitude=6";
    private EarthquakeAdapter ead;
    private ListView lv;
    private List<Earthquake> list = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            list = new APITask().execute(earthquakeUrl).get();
            for(int i=0;i<list.size();i++)
                list.get(i).displayDetails();
        }catch(Exception e)
        {
            System.out.println(e);
            finish();
        }
        lv = findViewById(R.id.lv);
        ead = new EarthquakeAdapter(this,list);

        lv.setAdapter(ead);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Earthquake e = list.get(i);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(e.getUrl()));
                startActivity(browserIntent);
            }
        });
    }
}

