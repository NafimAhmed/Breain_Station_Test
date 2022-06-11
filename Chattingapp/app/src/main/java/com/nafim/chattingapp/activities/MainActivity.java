package com.nafim.chattingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.utilities.Constrant;
import com.nafim.chattingapp.utilities.PreferenceManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    PreferenceManager preferenceManager;
    TextView textView;
    RoundedImageView imageProfile;
    ImageView imageSignedOut;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fabNewChat);
        imageSignedOut=findViewById(R.id.imageSignedOut);
        preferenceManager=new PreferenceManager(getApplicationContext());
        textView=findViewById(R.id.textname);
        imageProfile=findViewById(R.id.imageProfile);
        loadUserDetail();

    }

    private void loadUserDetail()
    {
        textView.setText(preferenceManager.getString(Constrant.KEY_NAME));
        byte[] bytes= Base64.decode(preferenceManager.getString(Constrant.KEY_IMAGE),Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        imageProfile.setImageBitmap(bitmap);
        getToken();
        imageSignedOut.setOnClickListener(new View.OnClickListener()

                                          {

                                              @Override
                                              public void onClick(View v) {
                                                  signOut();
                                              }
                                          }

        );


        fab.setOnClickListener(new View.OnClickListener()

                               {

                                   @Override
                                   public void onClick(View v) {

                                       Intent intent = new Intent(getApplicationContext(),User_Activity.class);
                                       //Intent intent = new Intent(getApplicationContext(),SignUppActivity.class);
                                       startActivity(intent);
                                       user_activity();
                                   }
                               }
        );



    }

    public void user_activity()
    {
        Intent intent = new Intent(getApplicationContext(),User_Activity.class);
        //Intent intent = new Intent(getApplicationContext(),SignUppActivity.class);
        startActivity(intent);
    }

    private void getToken()
    {
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
    }

    private void updateToken(String token)
    {
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        DocumentReference documentReference=database.collection(Constrant.KEY_COLLECTION_USER)
                .document(preferenceManager.getString(Constrant.KEY_USER_ID));
        documentReference.update(Constrant.KEY_FMC_TOKEN, token)
                //////////////////////////////////////////////////////////////////////////
                .addOnSuccessListener(
                        unused -> Toast.makeText(getApplicationContext(),"Token Update Successful",Toast.LENGTH_LONG)
                                .show())
                //////////////////////////////////////////////////////////////////////////
                .addOnFailureListener(
                        e -> Toast.makeText(getApplicationContext(),"Unable to Update Token",Toast.LENGTH_LONG)
                                .show());

    }

    private void signOut()
    {
        Toast.makeText(getApplicationContext(),"Signed Out",Toast.LENGTH_LONG).show();
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        DocumentReference documentReference=database.collection(Constrant.KEY_COLLECTION_USER).document(
          preferenceManager.getString(Constrant.KEY_USER_ID)
        );

        HashMap<String,Object> updates = new HashMap<>();
        updates.put(Constrant.KEY_FMC_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused ->{

                    preferenceManager.clear();
                    Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
                    startActivity(intent);
                    finish();
                }).addOnFailureListener(
                        e ->
                        Toast.makeText(getApplicationContext(),"Unable to signout",Toast.LENGTH_LONG)
                                .show());

    }



}