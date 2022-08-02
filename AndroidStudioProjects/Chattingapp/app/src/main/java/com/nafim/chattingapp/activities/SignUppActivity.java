package com.nafim.chattingapp.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.utilities.Constrant;
import com.nafim.chattingapp.utilities.PreferenceManager;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

public class SignUppActivity extends AppCompatActivity {



    TextView tv,imageText;
    EditText name,email,password,confirmPassword;
    RoundedImageView riv;
    Button signupButton;
    ProgressBar progressBar;
    FrameLayout imageProfile;
    private String encodedImage;

    private PreferenceManager preferenceManager;

    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_upp);

        preferenceManager=new PreferenceManager(getApplicationContext());


        riv =findViewById(R.id.image);
        tv=findViewById(R.id.textSign);
        name=findViewById(R.id.entername);
        email=findViewById(R.id.enterEmail);
        password= findViewById(R.id.enterPassword);
        confirmPassword=findViewById(R.id.confirmPassword);
        signupButton=findViewById(R.id.buttonSignUp);
        progressBar= findViewById(R.id.progressbar);
        imageText=findViewById(R.id.imageText);
        imageProfile=findViewById(R.id.imageProfile);

        tv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(getApplicationContext(),SignUppActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                signup();
            }
        });

        imageProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                        .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                pickImage.launch(intent);
            }
        });

    }


    private void showToast(String message)
    {
        
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }

    private void signup()
    {

        loading(true);
        FirebaseFirestore database=FirebaseFirestore.getInstance();

        HashMap<String, Object> user=new HashMap<>();

        user.put(Constrant.KEY_NAME,name.getText().toString());
        user.put(Constrant.KEY_EMAIL,email.getText().toString());
        user.put(Constrant.KEY_PASSWORD,password.getText().toString());
        user.put(Constrant.KEY_IMAGE,encodedImage);


        database.collection(Constrant.KEY_COLLECTION_USER)
                .add(user)
                .addOnSuccessListener(documentReference -> {

                    //Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();
                    loading(false);
                    preferenceManager.putBoolean(Constrant.KEY_IS_SIGNED_IN,true);
                    preferenceManager.putString(Constrant.KEY_USER_ID,documentReference.getId());
                    preferenceManager.putString(Constrant.KEY_NAME,name.getText().toString());
                    preferenceManager.putString(Constrant.KEY_IMAGE,encodedImage);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                })
                .addOnFailureListener(exception->
                {
                    loading(false);
                    Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_SHORT).show();
                });


    }

    private String encodedImage(Bitmap bitmap)
    {
        int previewheight=150;
        int previewHeight=bitmap.getHeight()*previewheight/bitmap.getWidth();
        Bitmap previewBitmap=Bitmap.createScaledBitmap(bitmap,previewheight,previewHeight,false);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes,Base64.DEFAULT);

    }
    private final ActivityResultLauncher<Intent> pickImage=registerForActivityResult(
          new ActivityResultContracts.StartActivityForResult(),result -> {
              if(result.getResultCode()==RESULT_OK)
                  if(result.getData()!=null)
                  {
                      Uri imageuri=result.getData().getData();
                      try
                      {
                          InputStream inputStream= getContentResolver().openInputStream(imageuri);
                          Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                          riv.setImageBitmap(bitmap);
                          imageText.setVisibility(View.GONE);
                          encodedImage = encodedImage(bitmap);
                      }
                      catch(Exception e)
                      {

                      }

                  }
            }
    );

    private Boolean isValidSignUpDetail()
    {
        if(encodedImage ==null)
        {
            showToast("Enter Image");
            return false;
        }
        else if (name.getText().toString().trim().isEmpty())
        {
            showToast("Enter name");
            return false;

        }
        else if (email.getText().toString().trim().isEmpty())
        {
            showToast("Enter Image");
            return false;

        }
        else if (password.getText().toString().trim().isEmpty())
        {
            return false;

        }
        else if (confirmPassword.getText().toString().trim().isEmpty())
        {
            return false;

        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
        {
            return false;

        }

        else if (!confirmPassword.getText().toString().equals(password.getText().toString()))
        {
            return false;

        }



        else{
            return true;
        }

    }

    private void loading(boolean isLoading)
    {
        if(isLoading)
        {
            progressBar.setVisibility(View.VISIBLE);
            signupButton.setVisibility(View.INVISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
            signupButton.setVisibility(View.VISIBLE);
        }
    }





}