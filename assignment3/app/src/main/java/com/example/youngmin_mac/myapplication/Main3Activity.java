package com.example.youngmin_mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    private EditText city,name,sport,mvp,stadium;
    private Button upd,del,exit;
    private SQLManager sqlMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i = getIntent();

        city = findViewById(R.id.cEdit);
        name = findViewById(R.id.nEdit);
        sport = findViewById(R.id.sEdit);
        mvp = findViewById(R.id.mEdit);
        stadium = findViewById(R.id.stEdit);

        upd = findViewById(R.id.update);
        del = findViewById(R.id.delete);
        exit = findViewById(R.id.exit);

        sqlMan = new SQLManager(this);

        DataModel d = sqlMan.getData(Integer.parseInt(i.getStringExtra("id")));
        if(d != null)
        {
            city.setText(d.getCity());
            name.setText(d.getName());
            sport.setText(d.getSport());
            mvp.setText(d.getMvp());
            stadium.setText(d.getStadium());
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
