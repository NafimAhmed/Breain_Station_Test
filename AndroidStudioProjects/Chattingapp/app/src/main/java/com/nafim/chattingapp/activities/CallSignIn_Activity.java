package com.nafim.chattingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.utilities.CallConstants;
import com.nafim.chattingapp.utilities.CallPreferenceManager;

public class CallSignIn_Activity extends AppCompatActivity {

    TextView textSignUp;
    MaterialButton buttonSignIn;
    EditText inputEmail,inputPassword;
    ProgressBar signInProgressBar;
    CallPreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_sign_in);

        preferenceManager=new CallPreferenceManager(getApplicationContext());

        if(preferenceManager.getBoolean(CallConstants.KEY_IS_SIGNED_IN))
        {
            Intent intent = new Intent(getApplicationContext(),CAllMainActivity.class);
            startActivity(intent);
            finish();
        }

        textSignUp=findViewById(R.id.textSignUp);
        buttonSignIn=findViewById(R.id.buttonSignIn);
        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);

        signInProgressBar=findViewById(R.id.signInProgressBar);



        textSignUp.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), CallSignup_Activity.class);
            startActivity(intent);

        });

        buttonSignIn.setOnClickListener(view->{

             if(inputEmail.getText().toString().trim().isEmpty())
            {
                return;
            }
            else if(inputPassword.getText().toString().trim().isEmpty())
            {
                return;
            }

            else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString().trim()).matches())
            {
                return;
            }
            else
             {
                 signIn();

             }

        });




        /*FirebaseFirestore database=FirebaseFirestore.getInstance();
        HashMap<String,Object> user=new HashMap<>();
        user.put("FirstName","John");
        user.put("LastName","Doe");
        user.put("Email","recentnafimahmed@gmail.com");

        database.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>()

                                      {

                                          @Override
                                          public void onSuccess(DocumentReference documentReference) {

                                              Toast.makeText(getApplicationContext(),"Successfully Uploaded",Toast.LENGTH_LONG).show();

                                          }
                                      }

                )
                .addOnFailureListener(new OnFailureListener()
                {

                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"Fail to Upload",Toast.LENGTH_LONG).show();

                    }
                }

                );*/



    }

    private void signIn()
    {
        signInProgressBar.setVisibility(View.VISIBLE);
        buttonSignIn.setVisibility(View.INVISIBLE);

        FirebaseFirestore database=FirebaseFirestore.getInstance();
        database.collection(CallConstants.KEY_COLLECTION_USERS)
                .whereEqualTo(CallConstants.KEY_EMAIL,inputEmail.getText().toString())
                .whereEqualTo(CallConstants.KEY_PASSWORD,inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful() && task.getResult()!=null && task.getResult().getDocuments().size()>0)
                        {
                            DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                            preferenceManager.putBoolean(CallConstants.KEY_IS_SIGNED_IN,true);
                            preferenceManager.putString(CallConstants.KEY_USER_ID,documentSnapshot.getId());
                            preferenceManager.putString(CallConstants.KEY_FIRST_NAME,documentSnapshot.getString(CallConstants.KEY_FIRST_NAME));
                            preferenceManager.putString(CallConstants.KEY_LAST_NAME,documentSnapshot.getString(CallConstants.KEY_LAST_NAME));
                            preferenceManager.putString(CallConstants.KEY_EMAIL,documentSnapshot.getString(CallConstants.KEY_EMAIL));

                            Intent intent=new Intent(getApplicationContext(),CAllMainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else {
                            signInProgressBar.setVisibility(View.INVISIBLE);
                            buttonSignIn.setVisibility(View.VISIBLE);

                            Toast.makeText(getApplicationContext(),"Unable to Signin",Toast.LENGTH_LONG).show();

                        }

                    }
                });

    }













}