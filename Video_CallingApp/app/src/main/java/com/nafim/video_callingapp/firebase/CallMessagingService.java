package com.nafim.video_callingapp.firebase;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.nafim.video_callingapp.activities.CallIncomingInvitationActivity;
import com.nafim.video_callingapp.utility.CallConstants;

public class CallMessagingService extends FirebaseMessagingService
{
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        //Toast.makeText(getApplicationContext(),"Token: "+token,Toast.LENGTH_SHORT).show();

      //  Log.d("FCM", "Token: "+token);


    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remotemessage) {
        super.onMessageReceived(remotemessage);

        //Toast.makeText(getApplicationContext(),"Massage: "+remotemessage.getNotification().getBody(),Toast.LENGTH_SHORT).show();

        String type=remotemessage.getData().get(CallConstants.REMOTE_MSG_TYPE);

        if(type!=null)
        {
            if(type.equals(CallConstants.REMOTE_MSG_INVITATION))
            {
                Intent intent=new Intent(getApplicationContext(), CallIncomingInvitationActivity.class);
                intent
                        .putExtra(CallConstants
                                .REMOTE_MSG_MEETING_TYPE,remotemessage
                                .getData()
                                .get(CallConstants.REMOTE_MSG_MEETING_TYPE));
                intent.putExtra(CallConstants
                        .KEY_FIRST_NAME,remotemessage
                        .getData()
                        .get(CallConstants.KEY_FIRST_NAME));
                intent.putExtra(
                        CallConstants
                                .KEY_LAST_NAME,remotemessage
                                .getData()
                                .get(CallConstants.KEY_LAST_NAME)
                );
                intent.putExtra(CallConstants
                        .KEY_EMAIL,remotemessage
                        .getData()
                        .get(CallConstants.KEY_EMAIL));

                intent.putExtra(CallConstants.REMOTE_MSG_MEETING_ROOM,"OK" /*remotemessage.getData().get(Constants.REMOTE_MSG_MEETING_ROOM)*/);

                intent.putExtra(CallConstants.REMOTE_MSG_INVITER_TOKEN,
                        remotemessage
                                .getData()
                                .get(CallConstants
                                        .REMOTE_MSG_INVITER_TOKEN));

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }

            else if(type.equals(CallConstants.REMOTE_MSG_INVITATION_RESPONSE))
            {
                Intent intent=new Intent(CallConstants.REMOTE_MSG_INVITATION_RESPONSE);
                intent.putExtra(CallConstants.REMOTE_MSG_INVITATION_RESPONSE,remotemessage
                        .getData()
                        .get(CallConstants.REMOTE_MSG_INVITATION_RESPONSE));

                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

            }

        }

    }
}
