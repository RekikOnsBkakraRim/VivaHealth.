package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticlesActivity extends AppCompatActivity {
    private String[][] health_details =
            {
                    {"Walking Daily","","","","Click More Details"},
                    {"Home Care of COVID-19","","","","Click More Details"},
                    {"Stop Smoking","","","","Click More Details"},
                    {"Healthy Gut","","","","Click More Details"}
            };
    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    Button btnBack;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);

        lst = findViewById(R.id.listViewOD);
        btnBack = findViewById(R.id.buttonODBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<health_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1" , health_details[i][0]);
            item.put("line2" , health_details[i][1]);
            item.put("line3" , health_details[i][2]);
            item.put("line4" , health_details[i][3]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines4,new String[]{"line1","line2","line3","line4"},
                new int[] {R.id.line_a, R.id.line_b,R.id.line_c,R.id.line_d});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthArticlesActivity.this,HealthArticlesDetailsActivity.class);
                it.putExtra("text1",health_details[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });

    }
}