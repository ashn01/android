package com.example.youngmin_mac.ass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg,rg1;
    private Button hi,hello;
    private TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hi = findViewById(R.id.btHi);
        rg = findViewById(R.id.rg1);
        tv1 = findViewById(R.id.textView2);
        hello = findViewById(R.id.btHello);
        rg1 = findViewById(R.id.rg2);
        tv2 = findViewById(R.id.textView3);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i)
                {
                    case R.id.rbAlice:
                        Toast.makeText(getApplicationContext(),((RadioButton)findViewById(R.id.rbAlice)).getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbBob:
                        Toast.makeText(getApplicationContext(),((RadioButton)findViewById(R.id.rbBob)).getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbCarol:
                        Toast.makeText(getApplicationContext(),((RadioButton)findViewById(R.id.rbCarol)).getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rg.getCheckedRadioButtonId();
                switch(selectedId)
                {
                    case R.id.rbAlice:
                        tv1.setText("Hi "+((RadioButton)findViewById(R.id.rbAlice)).getText().toString());
                        break;
                    case R.id.rbBob:
                        tv1.setText("Hi "+((RadioButton)findViewById(R.id.rbBob)).getText().toString());
                        break;
                    case R.id.rbCarol:
                        tv1.setText("Hi "+((RadioButton)findViewById(R.id.rbCarol)).getText().toString());
                        break;
                }
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i)
                {
                    case R.id.rbDave:
                        Toast.makeText(getApplicationContext(),((RadioButton)findViewById(R.id.rbDave)).getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbEve:
                        Toast.makeText(getApplicationContext(),((RadioButton)findViewById(R.id.rbEve)).getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbFred:
                        Toast.makeText(getApplicationContext(),((RadioButton)findViewById(R.id.rbFred)).getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rg1.getCheckedRadioButtonId();
                switch(selectedId)
                {
                    case R.id.rbDave:
                        tv2.setText("Hello "+((RadioButton)findViewById(R.id.rbDave)).getText().toString());
                        break;
                    case R.id.rbEve:
                        tv2.setText("Hello "+((RadioButton)findViewById(R.id.rbEve)).getText().toString());
                        break;
                    case R.id.rbFred:
                        tv2.setText("Hello "+((RadioButton)findViewById(R.id.rbFred)).getText().toString());
                        break;
                }
            }
        });

    }
}
