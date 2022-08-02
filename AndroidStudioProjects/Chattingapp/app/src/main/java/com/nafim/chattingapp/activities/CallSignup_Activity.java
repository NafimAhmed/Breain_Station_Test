package com.nafim.chattingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.utilities.CallConstants;
import com.nafim.chattingapp.utilities.CallPreferenceManager;

import java.util.HashMap;

public class CallSignup_Activity extends AppCompatActivity {

    TextView textSignIn;
    ImageView imageBack;

    EditText inputFirstname,inputLastName,inputEmail,inputPassword,inputConfirmPassword;
    MaterialButton buttonSignUp;
    ProgressBar SignupProgressBar;

    CallPreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_signup);

        preferenceManager=new CallPreferenceManager(getApplicationContext());

        textSignIn=findViewById(R.id.textSignIn);

        imageBack=findViewById(R.id.imageBack);
        inputFirstname=findViewById(R.id.inputFirstname);
        inputLastName=findViewById(R.id.inputLastName);
        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        inputConfirmPassword=findViewById(R.id.inputConfirmPassword);
        buttonSignUp=findViewById(R.id.buttonSignUp);
        SignupProgressBar=findViewById(R.id.SignupProgressBar);

        imageBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        textSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        buttonSignUp.setOnClickListener(view -> {
            if(inputFirstname.getText().toString().trim().isEmpty())
            {
                return;
            }
            else if(inputLastName.getText().toString().trim().isEmpty())
            {
                return;
            }

            else if(inputEmail.getText().toString().trim().isEmpty())
            {
                return;
            }
            else if(inputPassword.getText().toString().trim().isEmpty())
            {
                return;
            }
            else if(inputConfirmPassword.getText().toString().trim().isEmpty())
            {
                return;
            }
           /* else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString().trim()).matches())
            {
                return;
            }*/
           /* else if(inputPassword.getText().toString().equals(inputConfirmPassword.getText().toString()) )
            {
                return;
            }*/

            else {

                signUp();

            }

        });



    }

    private void signUp()
    {
        buttonSignUp.setVisibility(View.INVISIBLE);
        SignupProgressBar.setVisibility(View.VISIBLE);

        FirebaseFirestore database=FirebaseFirestore.getInstance();
        HashMap<String,Object> user=new HashMap<>();
        user.put(CallConstants.KEY_FIRST_NAME,inputFirstname.getText().toString());
        user.put(CallConstants.KEY_LAST_NAME,inputLastName.getText().toString());
        user.put(CallConstants.KEY_EMAIL,inputEmail.getText().toString());
        user.put(CallConstants.KEY_PASSWORD,inputPassword.getText().toString());

        database.collection(CallConstants.KEY_COLLECTION_USERS)
                .add(user)
                .addOnSuccessListener(documentReference -> {

                   /* buttonSignUp.setVisibility(View.INVISIBLE);
                    SignupProgressBar.setVisibility(View.INVISIBLE);

                    Toast.makeText(getApplicationContext(),"Successfully Uploaded",Toast.LENGTH_LONG).show();*/

                    preferenceManager.putBoolean(CallConstants.KEY_IS_SIGNED_IN,true);
                    preferenceManager.putString(CallConstants.KEY_USER_ID,documentReference.getId());
                    preferenceManager.putString(CallConstants.KEY_FIRST_NAME,inputFirstname.getText().toString());
                    preferenceManager.putString(CallConstants.KEY_LAST_NAME,inputLastName.getText().toString());
                    preferenceManager.putString(CallConstants.KEY_EMAIL,inputEmail.getText().toString());
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }

                )
                .addOnFailureListener(e -> {

                    buttonSignUp.setVisibility(View.VISIBLE);
                    SignupProgressBar.setVisibility(View.INVISIBLE);

                    Toast.makeText(getApplicationContext(),"Error : "+e.getMessage(),Toast.LENGTH_LONG).show();


                   // Toast.makeText(getApplicationContext(),"Fail to Upload",Toast.LENGTH_LONG).show();

                }

                );

    }


}