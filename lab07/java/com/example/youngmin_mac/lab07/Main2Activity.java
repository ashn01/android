package com.example.youngmin_mac.lab07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ListView lvFront, lvBack;
    private ArrayAdapter<String> arad,arad2;
    private List<DataModel> G,Y;
    private SQLManager sqlMan;
    private DataModelAdapter dma,dma2;

    private String[] dummy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sqlMan = new SQLManager(this);

        lvFront = findViewById(R.id.lvFront);
        lvBack = findViewById(R.id.lvBack);

        G = sqlMan.viewAll("G");
        Y = sqlMan.viewAll("Y");

        dma = new DataModelAdapter(this, G);
        dma2 = new DataModelAdapter(this, Y);

        lvFront.setAdapter(dma);
        lvBack.setAdapter(dma2);

        lvFront.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                DataModel d = G.get(i);
                intent.putExtra("Line1", d.getLine()[0]);
                intent.putExtra("Line2", d.getLine()[1]);
                intent.putExtra("Line3", d.getLine()[2]);
                startActivity(intent);
            }
        });

        lvBack.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                DataModel d = Y.get(i);
                intent.putExtra("Line1", d.getLine()[0]);
                intent.putExtra("Line2", d.getLine()[1]);
                intent.putExtra("Line3", d.getLine()[2]);
                startActivity(intent);
            }
        });

    }
}
