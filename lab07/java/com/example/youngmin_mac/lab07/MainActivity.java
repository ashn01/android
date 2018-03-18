package com.example.youngmin_mac.lab07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnAddG, btnAddY, btnView;
    private EditText[] etG, etY;
    private SQLManager sqlMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlMan = new SQLManager(this);
        btnAddG = findViewById(R.id.btnG);
        btnAddY = findViewById(R.id.btnY);
        btnView = findViewById(R.id.btnB);

        etG = new EditText[3];
        etG[0] = findViewById(R.id.editG1);
        etG[1] = findViewById(R.id.editG2);
        etG[2] = findViewById(R.id.editG3);

        etY = new EditText[3];
        etY[0] = findViewById(R.id.editY1);
        etY[1] = findViewById(R.id.editY2);
        etY[2] = findViewById(R.id.editY3);

        btnAddG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataModel d = new DataModel(etG[0].getText().toString(),
                        etG[1].getText().toString(),
                        etG[2].getText().toString(),"G");
                sqlMan.add(d);
                clearTextField(etG);
            }
        });

        btnAddY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataModel d = new DataModel(etY[0].getText().toString(),
                        etY[1].getText().toString(),
                        etY[2].getText().toString(),"Y");
                sqlMan.add(d);
                clearTextField(etY);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

    }

    private void clearTextField(EditText[] t)
    {
        for(int i=0;i<t.length;i++)
            t[i].setText("");
        t[0].requestFocus();
    }
}
