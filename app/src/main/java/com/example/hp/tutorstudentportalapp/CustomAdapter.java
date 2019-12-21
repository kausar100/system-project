package com.example.hp.tutorstudentportalapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomAdapter extends ArrayAdapter<FetchItem> {

    private Activity context;
    private List<FetchItem> list;

    public CustomAdapter( Activity context1, List<FetchItem> list) {
        super(context1, R.layout.fetch_attendance, list);
        this.context = context1;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fetch_attendance, null, true);
        FetchItem fetchItem = list.get(position);

        TextView roll = view.findViewById(R.id.roll);
        TextView psab = view.findViewById(R.id.psorab);

        roll.setText(fetchItem.getRoll());
        if(fetchItem.getBool()){
            psab.setText("Presence");
        }
        else{
            psab.setText("Absence");
        }

        return view;
    }
}
