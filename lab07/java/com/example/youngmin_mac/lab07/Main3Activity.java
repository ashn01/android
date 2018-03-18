package com.example.youngmin_mac.lab07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent t = getIntent();
        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);

        t1.setText(t.getStringExtra("Line1"));
        t2.setText(t.getStringExtra("Line2"));
        t3.setText(t.getStringExtra("Line3"));
    }
}
