package com.example.hp.tutorstudentportalapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ExampleViewHolder> {
    private List<Teacher> mExampleList;

    public TeacherAdapter(List<Teacher> exampleList) {
        mExampleList = exampleList;
    }



    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public Button button;
        String text, key, user_id;

        public ExampleViewHolder(final View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            button = itemView.findViewById(R.id.sendrequest);
        }
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_request, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        final Teacher currentItem = mExampleList.get(position);

        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getEmail());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("STUDENT_REQUEST").child(currentItem.getUid()).child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                databaseReference.setValue(false);
                holder.button.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}