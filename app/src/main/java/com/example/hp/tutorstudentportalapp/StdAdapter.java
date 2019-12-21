package com.example.hp.tutorstudentportalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class StdAdapter extends BaseAdapter {

    private Context mContext;
    private DatabaseReference databaseReference;
    private ArrayList<String> mArrSchoolData;
    private ListViewItem listViewItem;

    public StdAdapter(Context context, ArrayList arrSchoolData, ListViewItem mlistitem) {
        super();
        mContext = context;
        mArrSchoolData = arrSchoolData;
        listViewItem = mlistitem;
    }

    public int getCount() {
        // return the number of records
//        if(mArrSchoolData.size()==0){
//            Toast.makeText(mContext,"Cann't Find Related Data in Database.",Toast.LENGTH_SHORT).show();
//        }
        return mArrSchoolData.size();
    }

    // getView method is called for each item of ListView
    public View getView(final int position, View view, final ViewGroup parent) {
        // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_studentlist, parent, false);


        // get the reference of textView and button
        TextView txtSchoolTitle = view.findViewById(R.id.stdRoll);
        txtSchoolTitle.setText(mArrSchoolData.get(position));

        final Spinner mark = view.findViewById(R.id.markID);
        mark.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                FetchCtMark fetchItem = new FetchCtMark(mArrSchoolData.get(position),mark.getSelectedItem().toString());
                databaseReference = FirebaseDatabase.getInstance().getReference("CTMARK").child(listViewItem.getDepartment()).child(listViewItem.getCtno());
                databaseReference.child(mArrSchoolData.get(position)).setValue(fetchItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }}