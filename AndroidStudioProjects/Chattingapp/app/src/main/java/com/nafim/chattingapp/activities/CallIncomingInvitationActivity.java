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

import com.nafim.chattingapp.R;
import com.nafim.chattingapp.network.CallApiClient;
import com.nafim.chattingapp.network.CallApiService;
import com.nafim.chattingapp.utilities.CallConstants;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallIncomingInvitationActivity extends AppCompatActivity {

    String meetingType=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_incoming_invitation);

        ImageView imageMeetingType=findViewById(R.id.imageMeetingType);
        meetingType= getIntent().getStringExtra(CallConstants.REMOTE_MSG_MEETING_TYPE);



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

        TextView textFirstChar,textUserName,textEmail;
        textUserName=findViewById(R.id.textUserName);
        textEmail=findViewById(R.id.textEmail);
        textFirstChar=findViewById(R.id.textFirstChar);

        String firstName=getIntent().getStringExtra(CallConstants.KEY_FIRST_NAME);
        if(firstName!=null)
        {
            textFirstChar.setText(firstName.substring(0, 1));
        }

        textUserName.setText(firstName+" "+getIntent().getStringExtra(CallConstants.KEY_LAST_NAME));
        textEmail.setText(getIntent().getStringExtra(CallConstants.KEY_EMAIL));

        ImageView imageAcceptInvitation=findViewById(R.id.imageAcceptInvitation);
        imageAcceptInvitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInvitatinResponse(
                        CallConstants.REMOTE_MSG_INVITATION_ACCEPTED,
                        getIntent()
                                .getStringExtra(CallConstants.REMOTE_MSG_INVITER_TOKEN));
            }
        });

        ImageView imageRejectInvitation=findViewById(R.id.imageRejectInvitation);
        imageRejectInvitation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                sendInvitatinResponse(
                        CallConstants.REMOTE_MSG_INVITATION_REJECTED,
                        getIntent()
                                .getStringExtra(CallConstants.REMOTE_MSG_INVITER_TOKEN));

            }
        });


    }

    public void sendInvitatinResponse(String type,String receiversToken)
    {
        try {
            JSONArray tokens=new JSONArray();
            tokens.put(receiversToken);

            JSONObject body=new JSONObject();
            JSONObject data=new JSONObject();

            data.put(CallConstants.REMOTE_MSG_TYPE, CallConstants.REMOTE_MSG_INVITATION_RESPONSE);
            data.put(CallConstants.REMOTE_MSG_INVITATION_RESPONSE,type);

            body.put(CallConstants.REMOTE_MSG_DATA,data);
            body.put(CallConstants.REMOTE_MSG_REGISTRATION_IDS,tokens);

            sendRemoteMessage(body.toString(), type);


        }catch(Exception e)
        {

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

        }

    }


    private void sendRemoteMessage(String remoteMessageBody, String type)
    {
        CallApiClient.getClient()
                .create(CallApiService.class)
                .sendRemoteMessage(CallConstants.getRemoteMessageHeaders(),remoteMessageBody)
                .enqueue(new Callback<String>(){

                    @Override
                    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                        if (response.isSuccessful())
                        {

                            if(type.equals(CallConstants.REMOTE_MSG_INVITATION_ACCEPTED))
                            {
                                Toast.makeText(getApplicationContext(),"Invitation Accepted",Toast.LENGTH_LONG).show();

                                try {
                                    URL serverURL=new URL("https://meet.jit.si");

                                    JitsiMeetConferenceOptions.Builder builder = new JitsiMeetConferenceOptions.Builder();
                                    builder.setServerURL(serverURL);
                                    builder.setWelcomePageEnabled(false);
                                    builder.setRoom(getIntent().getStringExtra(CallConstants.REMOTE_MSG_MEETING_ROOM));
                                    if(meetingType.equals("audio"))
                                    {
                                        builder.setVideoMuted(true);
                                    }


                                   /* JitsiMeetConferenceOptions conferenceOptions
                                            = new JitsiMeetConferenceOptions.Builder()
                                            .setServerURL(serverURL)
                                            .setWelcomePageEnabled(false)
                                            .setRoom(getIntent().getStringExtra(Constants.REMOTE_MSG_MEETING_ROOM))
                                            .build();*/
                                    JitsiMeetActivity.launch(CallIncomingInvitationActivity.this,builder.build());
                                    finish();





                                } catch (MalformedURLException e) {
                                    e.printStackTrace();

                                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();




                                }


                            }else{
                                Toast.makeText(getApplicationContext(),"Invitation Rejected",Toast.LENGTH_LONG).show();
                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                           // finish();

                        }

                        finish();

                    }
                    @Override
                    public void onFailure(@NonNull Call<String> call,@NonNull Throwable t) {

                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                        finish();

                    }
                });

    }


    private BroadcastReceiver invitationReceiver=new BroadcastReceiver()
    {

        @Override
        public void onReceive(Context context, Intent intent) {

            String type=intent.getStringExtra(CallConstants.REMOTE_MSG_INVITATION_RESPONSE);
            if(type!=null)
            {
                if(type.equals(CallConstants.REMOTE_MSG_INVITATION_CANCELLED))
                {
                    Toast.makeText(getApplicationContext(),"Invitation Cancelled",Toast.LENGTH_LONG).show();
                    finish();

                }
                /*else if(type.equals(Constants.REMOTE_MSG_INVITATION_REJECTED)){
                    Toast.makeText(getApplicationContext(),"Invitation Rejected",Toast.LENGTH_LONG).show();
                    finish();*/


                }
            }

        };

    protected void onStart() {

        super.onStart();

        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(
          invitationReceiver,new IntentFilter(CallConstants.REMOTE_MSG_INVITATION_RESPONSE)
        );
    }

    protected void onStop() {

        super.onStop();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(invitationReceiver);
    }







}