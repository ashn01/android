package com.example.youngmin_mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private Button sub,exit;
    private EditText city,name,sport,mvp,stadium;
    private SQLManager sqlMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sub = findViewById(R.id.submit);
        exit = findViewById(R.id.exit);

        city = findViewById(R.id.cEdit);
        name = findViewById(R.id.nEdit);
        sport = findViewById(R.id.sEdit);
        mvp = findViewById(R.id.mEdit);
        stadium = findViewById(R.id.stEdit);

        sqlMan = new SQLManager(this);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!city.getText().toString().equals("")) {
                    DataModel d = new DataModel(0,city.getText().toString(),
                            name.getText().toString(),
                            sport.getText().toString(),
                            mvp.getText().toString(),
                            stadium.getText().toString());
                    sqlMan.add(d);

                    city.setText("");
                    name.setText("");
                    sport.setText("");
                    mvp.setText("");
                    stadium.setText("");
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {

    }
}
