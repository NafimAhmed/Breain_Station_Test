package com.nafim.chattingapp.firebase;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MassagingService extends FirebaseMessagingService
{
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        //Toast.makeText(getApplicationContext(),"Token: "+token,Toast.LENGTH_SHORT).show();

        Log.d("FCM", "Token: "+token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        Toast.makeText(getApplicationContext(),"Massage: "+message.getNotification().getBody(),Toast.LENGTH_SHORT).show();

    }




}
