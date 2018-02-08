package com.example.youngmin_mac.workshop3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        Intent it = getIntent();
        String str = it.getStringExtra("password");
        TextView tv = findViewById(R.id.textView);
        tv.setText("password is " + str);

        Button bt = findViewById(R.id.btHome);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
