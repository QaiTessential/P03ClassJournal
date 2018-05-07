package com.example.a16014753.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AddData extends AppCompatActivity {
    TextView tvWeek, buttonAdd;
    RadioGroup rGroup;
    RadioButton rButton;
    ArrayList<Week> week;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);


        Intent i = getIntent();
        final int weak = i.getIntExtra("week",0);
        final String weak1 = "Week " + String.valueOf(weak);

        rGroup = findViewById(R.id.radioGroup);
        buttonAdd = findViewById(R.id.buttonAdding);
        tvWeek = findViewById(R.id.tvWeek);

        tvWeek.setText("week " + String.valueOf(weak));

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rGroup.getCheckedRadioButtonId();
                rButton = findViewById(selectedButtonId);
                String radioValue = rButton.getText().toString();
                Week data = new Week(weak1, rButton.getText().toString());
                Intent i = getIntent();

                String[] parts = tvWeek.getText().toString().split(" ");
                String part1 = parts[1];
                int weekNumber = Integer.parseInt(part1);
               i.putExtra("newweek",data);
                setResult(RESULT_OK,i);
                finish();
            }
        });


    }
}
