package com.example.a16014753.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoForC347 extends AppCompatActivity {
Button email;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Week> week;
    Button web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        lv = this.findViewById(R.id.listViewWeek);
        web = (Button)findViewById(R.id.buttonInfo);
        week = new ArrayList<Week>();
        week.add(new Week("Week 1", "B"));
        week.add(new Week("Week 2", "C"));
        week.add(new Week("Week 3", "A"));

        aa = new WeekAdapter(this, R.layout.row, week);
        lv.setAdapter(aa);

        email = (Button) findViewById(R.id.buttonEmail);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent (Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,"Hi Faci, /n /n I am... /n Please see my remarks so far, thank you!");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent (Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(webIntent);
            }
        });
    }
}
