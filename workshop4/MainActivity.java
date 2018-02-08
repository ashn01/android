package com.example.youngmin_mac.workshop4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lvFront, lvBack;
    private String[] alphabet1 = new String[13];
    private String[] alphabet2 = new String[13];
    private ArrayAdapter<String> arad,arad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvFront = findViewById(R.id.lvFront);
        lvBack = findViewById(R.id.lvBack);
        for(int i=0;i<13;i++)
        {
            alphabet1[i] = String.valueOf((char)(i+65));
            alphabet2[i] = String.valueOf((char)(i+78));
        }
        arad = new ArrayAdapter<String>(this, R.layout.lv_row,R.id.textView2,alphabet1);
        arad2 = new ArrayAdapter<String>(this, R.layout.lv_row2,R.id.textView2,alphabet2);

        lvFront.setAdapter(arad);
        lvBack.setAdapter(arad2);
    }
}
