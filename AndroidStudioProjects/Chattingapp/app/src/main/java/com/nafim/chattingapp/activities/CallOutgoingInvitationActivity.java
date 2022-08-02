package com.nafim.chattingapp.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.reflect.TypeToken;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.models.CallUser;
import com.nafim.chattingapp.network.CallApiClient;
import com.nafim.chattingapp.network.CallApiService;
import com.nafim.chattingapp.utilities.CallConstants;
import com.nafim.chattingapp.utilities.CallPreferenceManager;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallOutgoingInvitationActivity extends AppCompatActivity {

    private CallPreferenceManager preferenceManager;
    private String invitaterToken=null;
    String meetingRoom=null;
    String meetingType=null;

    int rejectionCount=0;
    int totalReceivers=0;

    TextView textFirstChar,textUsername,textEmail;

    //ArrayList<User> receivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_outgoing_invitation);

        preferenceManager = new CallPreferenceManager(getApplicationContext());


        ////////////////////////////////////////////////////////////
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>(){

            @Override
            public void onComplete(@NonNull Task<String> task) {
                if(task.isSuccessful() && task.getResult()!=null)
                {
                    invitaterToken= task.getResult();
                    Toast.makeText(getApplicationContext(),invitaterToken,Toast.LENGTH_LONG).show();

                }

            }
        });

        ////////////////////////////////////////////////



        ImageView imageMeetingType=findViewById(R.id.imageMeetingType);
        meetingType=getIntent().getStringExtra("type");

        if(meetingType!=null)
        {
            if(meetingType.equals("video"))
            {
                imageMeetingType.setImageResource(R.drawable.ic_round_videocam_24);
            }
            else{
                imageMeetingType.setImageResource(R.drawable.ic_baseline_call_24);
            }
        }



        textFirstChar=findViewById(R.id.textFirstChar);
        textUsername=findViewById(R.id.textUserName);
        textEmail=findViewById(R.id.textEmail);

        CallUser user= (CallUser) getIntent()
                .getSerializableExtra("user");//Extra("user");

        if(user != null)
        {
            textFirstChar.setText(user.firstName.substring(0,1));
            textUsername.setText(user.firstName+" "+user.lastName);
            textEmail.setText(user.email);
        }

        ImageView imageStopInvitation=findViewById(R.id.imageStopInvitation);
        imageStopInvitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getIntent().getBooleanExtra("isMultiple",false))
                {
                    Type type=new TypeToken<ArrayList<CallUser>>(){}.getType();
                    ArrayList<CallUser> receivers=new Gson()
                            .fromJson(getIntent()
                                    .getStringExtra("selecteUses"),type);
                    cancellInvitation(null, receivers);

                }
                else {

                    if(user != null)
                    {
                        cancellInvitation(user.token,null);
                    }

                }

                //onBackPressed();
            }
        });

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>(){

            @Override
            public void onComplete(@NonNull Task<String> task) {
                if(task.isSuccessful() && task.getResult()!=null)
                {
                    invitaterToken= task.getResult();

                    if(meetingType!=null)
                    {
                        if(getIntent().getBooleanExtra("isMultiple",false))
                        {
                            Type type=new TypeToken<ArrayList<CallUser>>(){}.getType();
                            ArrayList<CallUser> receivers=new Gson()
                                    .fromJson(getIntent()
                                            .getStringExtra("selecteUses"),type);

                            if(receivers!=null)
                            {
                                totalReceivers=receivers.size();

                            }


                            initiateMeeting(meetingType,null, receivers);
                        }
                        else{
                            if(user!=null)
                            {
                                totalReceivers=1;
                                initiateMeeting(meetingType,user.token,null);
                            }

                        }
                    }



                }

            }
        });


       /* if(meetingType!=null && user!=null)
        {
           // initiateMeeting(meetingType,user.token);
            initiateMeeting(meetingType,user.token,receivers);
        }*/



    }

    private void initiateMeeting(String meetingType, String receiversToken, ArrayList<CallUser> receivers)
    {
        try{

            JSONArray tokens=new JSONArray();


            if(receiversToken!=null)
            {
                tokens.put(receiversToken);

            }
            if(receivers!=null && receivers.size()>0)
            {
                StringBuilder userName=new StringBuilder();
                for(int i=0;i<receivers.size();i++)
                {
                    tokens.put(receivers.get(i).token);
                    userName.append(receivers.get(i).firstName).append(" ").append(receivers.get(i).lastName);
                }
                textFirstChar.setVisibility(View.GONE);
                textEmail.setVisibility(View.GONE);
                textUsername.setText(userName.toString());



            }



            JSONObject body=new JSONObject();
            JSONObject data=new JSONObject();

            data.put(CallConstants.REMOTE_MSG_TYPE, CallConstants.REMOTE_MSG_INVITATION);
            data.put(CallConstants.REMOTE_MSG_MEETING_TYPE,meetingType);
            data.put(CallConstants.KEY_FIRST_NAME,preferenceManager.getString(CallConstants.KEY_FIRST_NAME));
            data.put(CallConstants.KEY_LAST_NAME,preferenceManager.getString(CallConstants.KEY_LAST_NAME));
            data.put(CallConstants.KEY_EMAIL,preferenceManager.getString(CallConstants.KEY_EMAIL));
            data.put(CallConstants.REMOTE_MSG_INVITER_TOKEN,invitaterToken);

            meetingRoom=preferenceManager
                    .getString(CallConstants.KEY_USER_ID)+" "+ UUID
                    .randomUUID().toString().substring(0,5);
            data.put(CallConstants.REMOTE_MSG_MEETING_ROOM,meetingRoom);

            body.put(CallConstants.REMOTE_MSG_DATA,data);
            body.put(CallConstants.REMOTE_MSG_REGISTRATION_IDS,tokens);

            sendRemoteMessage(body.toString(), CallConstants.REMOTE_MSG_INVITATION);


        }catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            finish();


        }

    }

    private void sendRemoteMessage(String remoteMessageBody, String type)
    {
        CallApiClient.getClient()
                .create(CallApiService.class)
                .sendRemoteMessage(CallConstants.getRemoteMessageHeaders(),remoteMessageBody)
                .enqueue(new Callback<String>(){

                    @Override
                    public void onResponse(@NonNull Call<String> call,@NonNull Response<String> response) {

                        if (response.isSuccessful())
                        {
                            if(type.equals(CallConstants.REMOTE_MSG_INVITATION))
                            {
                                Toast.makeText(getApplicationContext(),"Invitation Send Successfully",Toast.LENGTH_LONG).show();

                                try {

                                    URL serverURL=new URL("https://meet.jit.si");
                                    JitsiMeetConferenceOptions conferenceOptions
                                            = new JitsiMeetConferenceOptions.Builder()
                                            .setServerURL(serverURL)
                                            .setWelcomePageEnabled(false)
                                            .setRoom(getIntent().getStringExtra(CallConstants.REMOTE_MSG_MEETING_ROOM))
                                            .build();
                                    JitsiMeetActivity.launch(CallOutgoingInvitationActivity.this,conferenceOptions);
                                    finish();


                                }
                                catch (Exception e)
                                {

                                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                                }

                            }else if(type.equals(CallConstants.REMOTE_MSG_INVITATION_RESPONSE))
                            {
                                Toast.makeText(getApplicationContext(),"Invitation Cancelled",Toast.LENGTH_LONG).show();
                                onBackPressed();


                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                            finish();

                        }

                    }
                    @Override
                    public void onFailure(@NonNull Call<String> call,@NonNull Throwable t) {

                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                        finish();

                    }
                });

    }


    public void cancellInvitation(String receiversToken, ArrayList<CallUser> receivers)
    {
        try {
            JSONArray tokens=new JSONArray();
            
            if(receiversToken!=null)
            {
                tokens.put(receiversToken);
            }
            if (receivers!=null && receivers.size()>0)
            {
                for(CallUser user: receivers)
                {
                    tokens.put(user.token);
                }
            }
            

            //tokens.put(receiversToken);

            JSONObject body=new JSONObject();
            JSONObject data=new JSONObject();

            data.put(CallConstants.REMOTE_MSG_TYPE, CallConstants.REMOTE_MSG_INVITATION_RESPONSE);
            data.put(CallConstants.REMOTE_MSG_INVITATION_RESPONSE, CallConstants.REMOTE_MSG_INVITATION_CANCELLED);

            body.put(CallConstants.REMOTE_MSG_DATA,data);
            body.put(CallConstants.REMOTE_MSG_REGISTRATION_IDS,tokens);

            sendRemoteMessage(body.toString(), CallConstants.REMOTE_MSG_INVITATION_RESPONSE);


        }catch(Exception e)
        {

        }

    }

    private BroadcastReceiver invitationReceiver=new BroadcastReceiver()
    {

        @Override
        public void onReceive(Context context, Intent intent) {

            String type=intent.getStringExtra(CallConstants.REMOTE_MSG_INVITATION_RESPONSE);
            if(type!=null)
            {
                if(type.equals(CallConstants.REMOTE_MSG_INVITATION_ACCEPTED))
                {


                    Toast.makeText(getApplicationContext(),"Invitation Accepted",Toast.LENGTH_LONG).show();



                    try{

                        URL serverURL=new URL("https://meet.jit.si");

                        JitsiMeetConferenceOptions.Builder builder = new JitsiMeetConferenceOptions.Builder();
                        builder.setServerURL(serverURL);
                        builder.setWelcomePageEnabled(false);
                        builder.setRoom(meetingRoom);
                        if(meetingType.equals("audio"))
                        {
                            builder.setVideoMuted(true);
                        }



                       /* JitsiMeetConferenceOptions conferenceOptions
                                = new JitsiMeetConferenceOptions.Builder()
                                .setServerURL(serverURL)
                                .setWelcomePageEnabled(false)
                                .setRoom(meetingRoom)
                                .build();*/
                        JitsiMeetActivity.launch(CallOutgoingInvitationActivity.this,builder.build());
                        finish();



                    }catch(Exception e)
                    {

                    }
                    //finish();

                }
                else if(type.equals(CallConstants.REMOTE_MSG_INVITATION_REJECTED)){

                    rejectionCount+=1;

                    if(rejectionCount==totalReceivers)
                    {
                        Toast.makeText(getApplicationContext(),"Invitation Rejected",Toast.LENGTH_LONG).show();
                        finish();
                    }




                }
            }

        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(invitationReceiver,new IntentFilter(CallConstants.REMOTE_MSG_INVITATION_RESPONSE));
    }
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(invitationReceiver);

    }

}