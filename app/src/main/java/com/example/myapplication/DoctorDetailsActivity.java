package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Feten mahmoudi","Cabinet Adress : Route matar km 13 Essghar, Sfax","Mobile No:26 304 478"},
                    {"Doctor Name : Selmi Marwen","Cabinet Adress : Av. 5 août, Sfax 3002","Mobile No:51 366 666"},
                    {"Doctor Name : Hammami Moncef","Cabinet Adress : Rue Akka،, Tunis","Mobile No:52 910 628"},
                    {"Doctor Name : Rami MEJDOUB","Cabinet Adress : Rte de Gabes, Sfax 3000","Mobile No:29 224 495"},
                    {"Doctor Name : Emna Ghorbel","Cabinet Adress : Rue Khaznadar, Sfax","Mobile No:98 783 023"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Jihene JELLAZI","Cabinet Adress : Le Bardo 2000 Tunis Tunisie","Mobile No:51282873"},
                    {"Doctor Name : Wafa SAID","Cabinet Adress : Centre médical jardins de carthage 2045 Tunis Tunisie","Mobile No:31564441"},
                    {"Doctor Name : Yosra BORNAZ","Cabinet Adress : Centre Urbain Nord 1082 Tunis Tunisie","Mobile No:25486058"},
                    {"Doctor Name : Briki HANA","Cabinet Adress : Cité El Ghazala 2083 Ariana Tunisie","Mobile No:20714141"},
                    {"Doctor Name : Fatma MAHJOUB","Cabinet Adress : El Menzah 5 2091 Ariana Tunisie","Mobile No:51605150"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Jammoussi Ghada","Cabinet Adress : Route de téniour km6","Mobile No: 74 847 212"},
                    {"Doctor Name : Bellassoued Anis","Cabinet Adress : Sakiet Ezzit","Mobile No:74 848 785"},
                    {"Doctor Name : Boudawara Abdessalem","Cabinet Adress : Sakiet Eddaier","Mobile No:74 891 700"},
                    {"Doctor Name : HAKMOUNI Omar","Cabinet Adress : Route Gremda Km 3","Mobile No:20 661 632"},
                    {"Doctor Name : ADhekra Ben Ayed","Cabinet Adress : route mahdia km 7","Mobile No:29 579 080"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name :  HICHEM DAOUD","Cabinet Adress : Rue de Habib Maazoun, Sfax 3000","Mobile No:98 410 072"},
                    {"Doctor Name : karra hamadi","Cabinet Adress : Rue de Mohamed Salah, Karray 3079","Mobile No: 74 419 055"},
                    {"Doctor Name : Abdeljalil GDOURA","Cabinet Adress : Boulevard 14 janvier Immeuble Ibn Khaldoun D1, Sfax 3027","Mobile No:70 032 279"},
                    {"Doctor Name : Koubaa Madiha","Cabinet Adress : Immeuble Olivia, Av. de Carthage, Sfax 3027","Mobile No:74 401 505"},
                    {"Doctor Name : Amal ABID TOUZANI","Cabinet Adress :  Kantaoui Medical Center","Mobile No:55 292 927"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Yamen MAAZOUN","Cabinet Adress : 40 RUE DU CAIRE, KM1 Rte de Tunis, Sfax","Mobile No: 74 216 666"},
                    {"Doctor Name : Hichem KHARRAT","Cabinet Adress : Rue ennasria,Sfax","Mobile No: 58 840 616"},
                    {"Doctor Name : Fetoui Ahmed","Cabinet Adress :Av du 14 Janvier Sfax 3027","Mobile No:74 417 900"},
                    {"Doctor Name : Drira Hanene","Cabinet Adress : Rte de Tunis, dar Attabib","Mobile No:74 231 499"},
                    {"Doctor Name : Ines BEN AMEUR SMAOUI","Cabinet Adress :  Route de Tunis km 2,5 Complexe médical DAR ATTABIB, Sfax","Mobile No:74 232 422"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewODTitle);
        btn = findViewById(R.id.buttonODBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));

            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c});
        ListView lst = findViewById(R.id.listViewOD);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][2]);
                startActivity(it);

            }
        });

    }
}