package com.example.hp.tutorstudentportalapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileStudentActivity extends AppCompatActivity {
    TextView UserName, Email, Dept, nameId, passId, rollID;
    DatabaseReference databaseReference;
//    CircleImageView Profile_Img;
//    ImageView upLoad;
//    String std_profile;
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//    private Uri mImageUri;
//    private StorageTask mUploadTask;
    Student std;

//    private StorageReference mStorageRef;
//    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student);
        this.setTitle("profile Page student");

        std = new Student();


        UserName = (TextView) findViewById(R.id.username);
        Email = (TextView) findViewById(R.id.email);
        Dept = (TextView) findViewById(R.id.department);
        nameId = (TextView) findViewById(R.id.name);
        passId = (TextView) findViewById(R.id.password);
        rollID = (TextView) findViewById(R.id.roll);
//        Profile_Img = (CircleImageView) findViewById(R.id.profile);
//        upLoad = (ImageView) findViewById(R.id.edit);

//
//        mStorageRef = FirebaseStorage.getInstance().getReference("PROFILE_PICTURES");
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference("STUDENT");


//        upLoad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, PICK_IMAGE_REQUEST);
//
//                uploadFile();
//            }
//        });
    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
//                && data != null && data.getData() != null) {
//            mImageUri = data.getData();
//
//            Picasso.with(this).load(mImageUri).into(Profile_Img);
//        }
//    }


//    private String getFileExtension(Uri uri) {
//        ContentResolver cR = getContentResolver();
//        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        return mime.getExtensionFromMimeType(cR.getType(uri));
//    }


//    private void uploadFile() {
//        if (mImageUri != null) {
//
//            String key = std_profile.replace(".", ",");
//
//            StorageReference fileReference = mStorageRef.child(key
//                    + "." + getFileExtension(mImageUri));
//
//            mUploadTask = fileReference.putFile(mImageUri)
//
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            /*
//                            Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mProgressBar.setProgress(0);
//                                }
//                            }, 500);
//                             */
//
//                            Toast.makeText(ProfileStudentActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
//                            Upload upload = new Upload(std_profile.replace(".", ","),
//                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
//                            //String uploadId = mDatabaseRef.push().getKey();
//                            mDatabaseRef.child(std_profile.replace(".", ",")).child("Profile_Pic").setValue(upload);
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(ProfileStudentActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                            //mProgressBar.setProgress((int) progress);
//                        }
//                    });
//        } else {
//            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();

        final String key = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("STUDENT");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    std = dataSnapshot.child(key).getValue(Student.class);

                    if (std != null) {
                        Email.setText(std.getEmail());
                    }
                    if (std != null) {
                        UserName.setText(std.getName());
                        nameId.setText(std.getName());
                    }
                    if (std != null) {
                        Dept.setText(std.getDepartment());
                    }
                    if (std != null) {
                        passId.setText(std.getPassword());
                    }
                    if (std != null) {
                        rollID.setText(std.getRoll());
                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
