package com.example.a16014753.p03_classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoForC347 extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Week> week;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        lv = this.findViewById(R.id.listViewWeek);
        week = new ArrayList<Week>();
        week.add(new Week("Week 1", "B"));
        week.add(new Week("Week 2", "C"));
        week.add(new Week("Week 3", "A"));

        aa = new WeekAdapter(this, R.layout.row, week);
        lv.setAdapter(aa);
    }
}
