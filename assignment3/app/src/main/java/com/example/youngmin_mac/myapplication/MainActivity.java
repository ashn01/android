package com.example.youngmin_mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<DataModel> list;
    private SQLManager sqlMan;
    private DataModelAdapter dma;
    private Button add,exit;
    private static final int REQ_CODE_ADD_DATA = 1;
    private static final int REQ_CODE_UPDATE_DELETE_DATA = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqlMan = new SQLManager(this);

        lv = findViewById(R.id.lv);
        list = sqlMan.viewAll();

        dma = new DataModelAdapter(this, list);
        lv.setAdapter(dma);

        add = findViewById(R.id.add);
        exit = findViewById(R.id.exit);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this, Main3Activity.class);
                DataModel d = list.get(i);
                it.putExtra("id",String.valueOf(d.getId()));
                startActivityForResult(it,REQ_CODE_UPDATE_DELETE_DATA);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,REQ_CODE_ADD_DATA);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        System.out.println("in");
        if(requestCode == REQ_CODE_ADD_DATA)
        {
            if(resultCode == RESULT_OK) {
                list = sqlMan.viewAll();
                dma = new DataModelAdapter(this, list);
                lv.setAdapter(dma);
                dma.notifyDataSetChanged();
                System.out.println("ininin");
            }
        }
        else if(requestCode == REQ_CODE_UPDATE_DELETE_DATA)
        {
            if(resultCode == RESULT_OK)
            {
                list = sqlMan.viewAll();
                dma = new DataModelAdapter(this, list);
                lv.setAdapter(dma);
                dma.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}
