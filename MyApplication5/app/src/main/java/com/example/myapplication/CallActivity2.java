package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.ktx.Firebase;

public class CallActivity2 extends AppCompatActivity {

    /*var userName=""
    var friendUserName=""
    var isPeerConnected=false;


    var firebaseRef=Firebase.database.getReference("users")
    var isAudio=true;
    var isVideo=true;*/

    String username="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }
}