package com.example.a16014753.p03_classjournal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class WeekAdapter extends ArrayAdapter<Week> {
    private ArrayList<Week> week;
    private Context context;
    private TextView tvWeekNumber;
    private TextView tvGrade;

    public WeekAdapter(Context context, int resource, ArrayList<Week> objects){
        super(context, resource, objects);
        week = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvWeekNumber = (TextView)rowView.findViewById(R.id.textViewWeekTitle);
        tvGrade = (TextView)rowView.findViewById(R.id.textView3Grade);


        Week currentWeek = week.get(position);
        tvWeekNumber.setText(currentWeek.getWeekNumber() + " ");
        tvGrade.setText(currentWeek.getGrade() + " ");
        return rowView;
    }
}
