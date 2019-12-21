package com.example.hp.tutorstudentportalapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class StdCustomAdapter extends ArrayAdapter<FetchCtMark> {

    private Activity context;
    private List<FetchCtMark> list;

    public StdCustomAdapter( Activity context1, List<FetchCtMark> list) {
        super(context1, R.layout.fetch_ctmark, list);
        this.context = context1;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fetch_ctmark, null, true);
        FetchCtMark fetchItem = list.get(position);

        TextView roll = view.findViewById(R.id.roll);
        TextView mark = view.findViewById(R.id.mark);

        roll.setText(fetchItem.getRoll());
        if(fetchItem.getMark().equals("Choose a Mark")){
            mark.setText("Absent");
        }
        else{
            mark.setText(fetchItem.getMark());
        }
        return view;
    }
}
