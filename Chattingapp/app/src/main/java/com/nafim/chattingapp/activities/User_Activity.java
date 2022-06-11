package com.nafim.chattingapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.adapters.UserAdapter;
import com.nafim.chattingapp.listener.User_listener;
import com.nafim.chattingapp.models.User;
import com.nafim.chattingapp.utilities.Constrant;
import com.nafim.chattingapp.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class User_Activity extends AppCompatActivity implements User_listener {

    
    ProgressBar progressbar;
    TextView textErrorMessage;
    PreferenceManager preferenceManager;
    RecyclerView usersRecyclerView;
    ImageView imageback;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        usersRecyclerView=findViewById(R.id.usersRecyclerView);
        imageback=findViewById(R.id.imageback);

        progressbar=findViewById(R.id.progressbar);
        textErrorMessage=findViewById(R.id.textErrorMessage);

        preferenceManager=new PreferenceManager(getApplicationContext());
        getUsers();

        imageback.setOnClickListener(v->onBackPressed());


    }

    private void getUsers()
    {
        loading(true);
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        database.collection(Constrant.KEY_COLLECTION_USER)
                .get()
                .addOnCompleteListener(task -> {
                    loading(false);
                    String currentUserId= preferenceManager.getString(Constrant.KEY_USER_ID);
                    if(task.isSuccessful() && task.getResult()!=null)
                    {
                        List<User> users = new ArrayList<>();
                        for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult())
                        {
                            if(currentUserId.equals(queryDocumentSnapshot.getId()))
                            {
                                continue;
                            }
                            User user=new User();
                            user.name=queryDocumentSnapshot.getString(Constrant.KEY_NAME);
                            user.email=queryDocumentSnapshot.getString(Constrant.KEY_EMAIL);
                            user.image=queryDocumentSnapshot.getString(Constrant.KEY_IMAGE);
                            user.token=queryDocumentSnapshot.getString(Constrant.KEY_FMC_TOKEN);
                            user.id=queryDocumentSnapshot.getId();
                            users.add(user);
                            
                            if(users.size()>0)
                            {
                                UserAdapter userAdapter = new UserAdapter(users, this);
                                usersRecyclerView.setAdapter(userAdapter);
                                usersRecyclerView.setVisibility(View.VISIBLE);
                            }
                            else
                            {
                                textErrorMessage();
                            }



                        }
                    }
                    else {
                        textErrorMessage();
                    }
                });

    }

    public void textErrorMessage()
    {
        textErrorMessage.setVisibility(View.VISIBLE);
        textErrorMessage.setText("No user Available");
    }

    private void loading(Boolean isLoading)
    {
        if(isLoading)
        {
            progressbar.setVisibility(View.VISIBLE);

        }
        else
        {
            progressbar.setVisibility(View.GONE);
            
        }

    }

    @Override
    public void onUserClick(User user) {
        Intent intent = new Intent(getApplicationContext(),Chat_Activity.class);
                intent.putExtra(Constrant.KEY_USER,user);
        startActivity(intent);
        finish();

    }
}