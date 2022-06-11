package com.nafim.chattingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.databinding.ActivitySignInBinding;
import com.nafim.chattingapp.utilities.Constrant;
import com.nafim.chattingapp.utilities.PreferenceManager;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    TextView createAccount;
    EditText email,password;
    MaterialButton buttonSignIn;
    ProgressBar progressbar;
    PreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        preferenceManager=new PreferenceManager(getApplicationContext());

        if(preferenceManager.getBoolean(Constrant.KEY_IS_SIGNED_IN))
        {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            //Intent intent=new Intent(getApplicationContext(),User_Activity.class);
            startActivity(intent);
            finish();
        }

        createAccount = findViewById(R.id.textCreatNewAccount);
        buttonSignIn=findViewById(R.id.buttonSignIn);
        progressbar=findViewById(R.id.progressbar);
        email=findViewById(R.id.enterEmail);
        password=findViewById(R.id.enterPassword);

        buttonSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUppActivity.class);
                startActivity(intent);
            }
        });

       // binding.buttonSignIn.setOnClickListener(v->addDataToFirebase());

        }

        public void signIn()
        {
            loading(true);
            FirebaseFirestore database= FirebaseFirestore.getInstance();
            database.collection(Constrant.KEY_COLLECTION_USER)
                    .whereEqualTo(Constrant.KEY_EMAIL,email.getText().toString())
                    .whereEqualTo(Constrant.KEY_PASSWORD,password.getText().toString())
                    .get()
                    .addOnCompleteListener(task ->{

                        if(task.isSuccessful() && task.getResult()!=null && task.getResult().getDocuments().size()>0)
                        {
                            DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                            preferenceManager.putBoolean(Constrant.KEY_IS_SIGNED_IN,true);
                            preferenceManager.putString(Constrant.KEY_USER_ID,documentSnapshot.getId());
                            preferenceManager.putString(Constrant.KEY_NAME,documentSnapshot.getString(Constrant.KEY_NAME));
                            preferenceManager.putString(Constrant.KEY_IMAGE,documentSnapshot.getString(Constrant.KEY_IMAGE));

                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                            finish();
                        }

                        else{
                            loading(false);
                            
                        }

                    } );

        }

        private void showToast(String message)
        {

        }

        private boolean isValidUserData()
        {
            if(email.getText().toString().trim().isEmpty())
            {
                return false;

            }

            else if(password.getText().toString().trim().isEmpty())
            {
                return false;

            }

            else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches())
            {
                return false;

            }
            else{
                return true;

            }

        }


       /* private void addDataToFirebase()
        {
            FirebaseFirestore database=FirebaseFirestore.getInstance();

            HashMap<String, Object> data=new HashMap<>();
            
            data.put("First_name","Chirag");
            data.put("Last_name","Kacchadia");

            database.collection("user")
                    .add(data)
                    .addOnSuccessListener(documentReference -> {

                        Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();

                    })
                    .addOnFailureListener(exception->
                    {
                        Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_SHORT).show();
                    });

        }*/

    private void loading(boolean isLoading)
    {
        if(isLoading)
        {
            progressbar.setVisibility(View.VISIBLE);
            buttonSignIn.setVisibility(View.INVISIBLE);
        }
        else
        {
            progressbar.setVisibility(View.INVISIBLE);
            buttonSignIn.setVisibility(View.VISIBLE);
        }
    }


}