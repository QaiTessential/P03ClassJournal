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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);


        Intent i = getIntent();
        int week = i.getIntExtra("week",0);

        rGroup = findViewById(R.id.radioGroup);
        buttonAdd = findViewById(R.id.buttonAdding);
        tvWeek = findViewById(R.id.tvWeek);

        tvWeek.setText(String.valueOf(week));

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rGroup.getCheckedRadioButtonId();
                rButton = findViewById(selectedButtonId);
                String radioValue = rButton.getText().toString();
                Intent i = new Intent();

                int weekNumber = Integer.parseInt(tvWeek.getText().toString());
                i.putExtra("week", weekNumber);
                i.putExtra("grade",radioValue);
                setResult(RESULT_OK,i);
                finish();
            }
        });


    }
}
