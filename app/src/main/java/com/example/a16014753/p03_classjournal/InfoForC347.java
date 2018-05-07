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

    int requestCodeAdd = 1;
    Button email;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Week> week;
    Button web, buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        buttonAdd = findViewById(R.id.buttonAdd);

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
                String message = "";
                for(int i = 0; i < week.size(); i++ ){
                    message = message +"\n"+ week.get(i).getWeekNumber() + ": DG: " + week.get(i).getGrade();
                }

                Intent email = new Intent (Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,"Hi Faci, \n \n I am... \n Please see my remarks so far, thank you!" +
                        "\n \n" + message

                );
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

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weekText = week.size()+1;
                Intent i = new Intent(InfoForC347.this,
                        AddData.class);
                i.putExtra("week", weekText);
                startActivityForResult(i,requestCodeAdd);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {
                if(requestCode == requestCodeAdd){
                    Week newweek = (Week) data.getSerializableExtra("newweek");
week.add(newweek);
                    aa.notifyDataSetChanged();
                }
            }
        }
    }

}
