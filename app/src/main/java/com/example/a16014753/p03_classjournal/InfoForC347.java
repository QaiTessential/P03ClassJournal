package com.example.a16014753.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoForC347 extends AppCompatActivity {

    int requestCodeForAdd = 1;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoForC347.this,
                        AddData.class);
                startActivityForResult(i,requestCodeForAdd);
            }
        });
    }
}
