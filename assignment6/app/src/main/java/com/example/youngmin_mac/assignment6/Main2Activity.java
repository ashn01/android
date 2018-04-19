package com.example.youngmin_mac.assignment6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private EarthquakeAdapter ead;
    private ListView lv;
    private List<Earthquake> list = null;

    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent it=getIntent();

        if(!it.getStringExtra("number").equals(""))
            number = Integer.parseInt(it.getStringExtra("number"));
        else
            number = 1000;
        String earthquakeUrl = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2018-01-01&limit="+number+"&minmagnitude=6&orderby=time";

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
                String[] str = e.getCoord();
                Intent it = new Intent(Main2Activity.this, MapsActivity.class);
                it.putExtra("lat",str[0]);
                it.putExtra("lng",str[1]);
                it.putExtra("title",e.getTitle());
                it.putExtra("time",e.getTime());
                startActivity(it);
            }
        });
    }
}
