package com.nafim.chattingapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.adapters.CallUsersAdapter;
import com.nafim.chattingapp.listener.CallUsersListener;
import com.nafim.chattingapp.models.CallUser;
import com.nafim.chattingapp.utilities.CallConstants;
import com.nafim.chattingapp.utilities.CallPreferenceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CAllMainActivity extends AppCompatActivity implements CallUsersListener {

    private CallPreferenceManager preferenceManager;
    TextView textTitle,textSignout,textErrorMessage;

    private List<CallUser> users;
    private CallUsersAdapter userAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView imageConference;

    private int REQUEST_CODE_BATTERY_OPTIMIZATIONS=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_main);

        preferenceManager=new CallPreferenceManager(getApplicationContext());

        imageConference=findViewById(R.id.imageConference);

        textTitle=findViewById(R.id.textTitle);
        textTitle.setText(String.format("%s %s",
                preferenceManager.getString(CallConstants.KEY_FIRST_NAME),
                preferenceManager.getString(CallConstants.KEY_LAST_NAME)));




        textSignout=findViewById(R.id.textSignout);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(this::getUser);

        textSignout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                signout();
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////



       /* FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        Log.d("IID_TOKEN", task.getResult().getToken());
                    }
                });*/

        /////////////////////////////////////////////////////////////////////////////////

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {

                if(task.isSuccessful() && task.getResult()!=null)
                {
                    sendFCMTokenToDataBase(task.getResult());

                }

            }
        });


///////////////////////////////////////////////////////////////////////////////////


        RecyclerView userRecyclerView = findViewById(R.id.usersRecyclerView);

        users=new ArrayList<>();
        userAdapter=new CallUsersAdapter(users,this);
        userRecyclerView.setAdapter(userAdapter);
        textErrorMessage=findViewById(R.id.textErrorMessage);
        //userProgressBar =findViewById(R.id.userProgressBar);


        //////////////////////////////////////////////////////

        //preferenceManager=new PreferenceManager(getApplicationContext());

        /*textTitle=findViewById(R.id.textTitle);
        textTitle.setText(String.format("%s %s",
                preferenceManager.getString(Constants.KEY_FIRST_NAME),
                preferenceManager.getString(Constants.KEY_LAST_NAME)));*/

        getUser();
        checkForBatteryOptimization();

    }


    private void getUser()
    {
        swipeRefreshLayout.setRefreshing(true);
        //userProgressBar.setVisibility(View.VISIBLE);
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        database.collection(CallConstants.KEY_COLLECTION_USERS)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        // userProgressBar.setVisibility(View.GONE);
                        swipeRefreshLayout.setRefreshing(false);
                        String myUserId=preferenceManager.getString(CallConstants.KEY_USER_ID);
                        if(task.isSuccessful() && task.getResult()!=null)
                        {
                            users.clear();
                            for(QueryDocumentSnapshot documentSnapshot:task.getResult())
                            {
                                if(myUserId.equals(documentSnapshot.getId()))
                                {
                                    continue;
                                }

                                CallUser user=new CallUser();
                                user.firstName=documentSnapshot.getString(CallConstants.KEY_FIRST_NAME);
                                user.lastName=documentSnapshot.getString(CallConstants.KEY_LAST_NAME);
                                user.email=documentSnapshot.getString(CallConstants.KEY_EMAIL);
                                user.token =documentSnapshot.getString(CallConstants.KEY_FCM_TOKEN);

                                users.add(user);


                            }

                            if(users.size()>0)
                            {
                                userAdapter.notifyDataSetChanged();
                            }
                            else{
                                textErrorMessage.setText("No user Available");
                                textErrorMessage.setVisibility(View.VISIBLE);
                            }

                        }
                    }
                });
    }





    private void sendFCMTokenToDataBase(String token)
    {
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        DocumentReference documentReference=database.collection(CallConstants.KEY_COLLECTION_USERS)
                .document(preferenceManager.getString(CallConstants.KEY_USER_ID)
                );
        documentReference.update(CallConstants.KEY_FCM_TOKEN,token)
                .addOnSuccessListener(new OnSuccessListener()
                                      {

                                          @Override
                                          public void onSuccess(Object o) {

                                              Toast.makeText(getApplicationContext(),"Token is Updated Successfully",Toast.LENGTH_SHORT).show();

                                          }
                                      }
                ).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"unable to send Token : "+e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }



    public void signout()
    {
        FirebaseFirestore database= FirebaseFirestore.getInstance();
        DocumentReference documentReference=database.collection(CallConstants.KEY_COLLECTION_USERS)
                .document(preferenceManager.getString(CallConstants.KEY_USER_ID));

        HashMap<String,Object> updates=new HashMap<>();
        updates.put(CallConstants.KEY_FCM_TOKEN, FieldValue.delete());

        documentReference.update(updates)
                .addOnSuccessListener(new OnSuccessListener<Void>(){

                    @Override
                    public void onSuccess(Void unused) {

                        preferenceManager.clearPreferences();

                        Intent intent=new Intent(getApplicationContext(), CallSignIn_Activity.class);
                        startActivity(intent);
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"Signout Failed",Toast.LENGTH_SHORT).show();

                    }
                });


    }



    @Override
    public void initiateVideoMeeting(CallUser user) {

        if(user.token ==null || user.token.isEmpty())
        {
            Toast
                    .makeText(getApplicationContext(),user.firstName+" "+user.lastName+"is not available",Toast.LENGTH_SHORT)
                    .show();

        }
        else {
           /* Toast
                    .makeText(getApplicationContext(),user.firstName+" "+user.lastName+"is available",Toast.LENGTH_SHORT)
                    .show();*/
            Intent intent=new Intent(getApplicationContext(), CallOutgoingInvitationActivity.class);
            intent.putExtra("user",user);
            intent.putExtra("type","video");
            intent.putExtra(CallConstants.REMOTE_MSG_MEETING_ROOM,"OK");
            startActivity(intent);

        }


    }

    @Override
    public void initiateAudioMeeting(CallUser user) {

        if(user.token ==null || user.token.isEmpty())
        {
            Toast
                    .makeText(getApplicationContext(),user.firstName+" "+user.lastName+"is not available",Toast.LENGTH_SHORT)
                    .show();

        }
        else {
            Toast
                    .makeText(getApplicationContext(),user.firstName+" "+user.lastName+"is available",Toast.LENGTH_SHORT)
                    .show();
            Intent intent=new Intent(getApplicationContext(), CallOutgoingInvitationActivity.class);
            intent.putExtra("user",user);
            intent.putExtra("type","audio");
            startActivity(intent);


        }


    }

    @Override
    public void onMultipleUserAction(Boolean isMultipleUserSelected) {

        if(isMultipleUserSelected)
        {
            imageConference.setVisibility(View.VISIBLE);
            imageConference.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), CallOutgoingInvitationActivity.class);
                    intent.putExtra("selecteUses", new Gson().toJson(userAdapter.getSelectedUsers()));
                    intent.putExtra("type","video");
                    intent.putExtra("isMultiple",true);
                    startActivity(intent);
                }
            });
        }
        else{
            imageConference.setVisibility(View.GONE);
        }

    }


    private void checkForBatteryOptimization()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);


            if(!powerManager.isIgnoringBatteryOptimizations(getPackageName()))
            {
                AlertDialog.Builder builder=new AlertDialog.Builder(CAllMainActivity.this)
                        .setTitle("Warning")
                        .setMessage("Battery optimisation is running in Background. it can Interrupt service")
                        .setPositiveButton("Disabled",new DialogInterface.OnClickListener()
                        {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                                startActivityForResult(intent,REQUEST_CODE_BATTERY_OPTIMIZATIONS);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                builder.create().show();
            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==REQUEST_CODE_BATTERY_OPTIMIZATIONS)
        {
            checkForBatteryOptimization();
        }

    }


}