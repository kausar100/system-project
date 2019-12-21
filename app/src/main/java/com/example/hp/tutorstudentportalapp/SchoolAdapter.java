package com.example.hp.tutorstudentportalapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class SchoolAdapter extends BaseAdapter {

    private Context mContext;
    private DatabaseReference databaseReference;
    private ArrayList<String> mArrSchoolData;
    private ListViewItem listViewItem;

    public SchoolAdapter(Context context, ArrayList arrSchoolData, ListViewItem mlistitem) {
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
        view = inflater.inflate(R.layout.activity_listview, parent, false);


        // get the reference of textView and button
        TextView txtSchoolTitle = view.findViewById(R.id.txtSchoolTitle);
        final Button present = view.findViewById(R.id.ps);
        final Button absent = view.findViewById(R.id.ab);

        // Set the title and button name
        txtSchoolTitle.setText(mArrSchoolData.get(position));


        // Click listener of button
        present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchItem fetchItem = new FetchItem(mArrSchoolData.get(position),true);
                databaseReference = FirebaseDatabase.getInstance().getReference("ATTENDANCE").child(listViewItem.getDepartment()).child(listViewItem.getSection());
                databaseReference.child(listViewItem.getDate()).child(mArrSchoolData.get(position)).setValue(fetchItem);
                present.setText("DONE");
            }
        });

        absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchItem fetchItem2 = new FetchItem(mArrSchoolData.get(position),false);
                databaseReference = FirebaseDatabase.getInstance().getReference("ATTENDANCE").child(listViewItem.getDepartment()).child(listViewItem.getSection());
                databaseReference.child(listViewItem.getDate()).child(mArrSchoolData.get(position)).setValue(fetchItem2);
                absent.setText("DONE");

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