package com.nafim.chattingapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import com.nafim.chattingapp.R;
import com.nafim.chattingapp.adapters.ChatAdapter;
import com.nafim.chattingapp.models.ChatMessage;
import com.nafim.chattingapp.models.User;
import com.nafim.chattingapp.utilities.Constrant;
import com.nafim.chattingapp.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.Date;
//import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class Chat_Activity extends AppCompatActivity {

    private User receiverUser;
    TextView textname,translate;
    ImageView imageback;
    EditText input_message;//,translate;
    ProgressBar progressbar;

    private List<ChatMessage> chatMessages;
    private ChatAdapter chatAdapter;
    private PreferenceManager preferenceManager;
    private FirebaseFirestore database;

    //////////////////////////////////////////

    //FirebaseTranslator englishGermanTranslator;

    Translator englishGermanTranslator;

    ///////////////////////////////////////////



    FrameLayout layout_send;

    RecyclerView chatRecyclerView;

    TextToSpeech t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        //////////////////////////////////////////////
        t1=new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener()
        {

            @Override
            public void onInit(int status) {
                t1.setLanguage(Locale.forLanguageTag("bn"));
            }
        }
        );

        ///////////////////////////////////////



        chatRecyclerView=findViewById(R.id.chatRecyclerView);
        input_message=findViewById(R.id.input_message);

        layout_send=findViewById(R.id.layout_send);
        
        textname=findViewById(R.id.textname);
        progressbar=findViewById(R.id.progressbar);
        translate=findViewById(R.id.translate);

        imageback=findViewById(R.id.imageback);

        setListener();
        loadReceiverDetail();
        init();
        listenMessages();


    }

    public void init()
    {
        preferenceManager=new PreferenceManager(getApplicationContext());
        chatMessages = new ArrayList<>();
        chatAdapter=new ChatAdapter(chatMessages,
                getBitmapFromEncodedString(receiverUser.image),
                preferenceManager.getString(Constrant.KEY_USER_ID) ,getApplicationContext()
                );
        chatRecyclerView.setAdapter(chatAdapter);
        database=FirebaseFirestore.getInstance();

       /* int sz=chatMessages.size();
        if(sz>0)
        {
            takeSpeak(chatMessages.get(sz-1).toString());
        }
        else {

        }*/
    }

    private void listenMessages()
    {
        database.collection(Constrant.KEY_COLLECTION_CHAT)
                .whereEqualTo(Constrant.KEY_SENDER_ID,preferenceManager.getString(Constrant.KEY_USER_ID))
                .whereEqualTo(Constrant.KEY_RECEIVER_ID,receiverUser.id)
                .addSnapshotListener(eventListener);
        database.collection(Constrant.KEY_COLLECTION_CHAT)
                .whereEqualTo(Constrant.KEY_SENDER_ID,receiverUser.id)
                .whereEqualTo(Constrant.KEY_RECEIVER_ID,preferenceManager.getString(Constrant.KEY_USER_ID))
                .addSnapshotListener(eventListener);

    }

    private Bitmap getBitmapFromEncodedString(String encodedImage)
    {
        byte[] bytes= Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0,bytes.length);

    }

    private void loadReceiverDetail()
    {
        receiverUser = (User)getIntent().getSerializableExtra(Constrant.KEY_USER);
        textname.setText(receiverUser.name);

    }

    private void sendMessage()
    {
        String messageText=input_message.getText().toString();

        ///////////////////////////////////////////////////////////////

        //translate.setText(null);

        prepareModel(messageText);

       // takeSpeak(messageText);
        String mess=translate.getText().toString();




        ////////////////////////////////////////////////////////////




        HashMap<String,Object> message=new HashMap<>();
        message.put(Constrant.KEY_SENDER_ID,preferenceManager.getString(Constrant.KEY_USER_ID));
        message.put(Constrant.KEY_RECEIVER_ID,receiverUser.id);
        message.put(Constrant.KEY_MESSAGE,mess/*ageTextinput_message.getText().toString()*/);
        String dateTime=null;

        message.put(Constrant.KEY_TIMESTAMP,dateTime);
        database.collection(Constrant.KEY_COLLECTION_CHAT).add(message);
        input_message.setText(null);
       // translate.setText(null);
    }

    void setListener()
    {
        imageback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        layout_send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });


    }

    private final EventListener<QuerySnapshot> eventListener=((value, error) ->
    {
        if(error!=null){
            return;

        }
        if(value!=null)
        {
            int count=chatMessages.size();
            for(DocumentChange documentChange: value.getDocumentChanges())
            {
                if(documentChange.getType()==DocumentChange.Type.ADDED)
                {
                    ChatMessage chatMessage=new ChatMessage();
                    chatMessage.senderId=documentChange.getDocument().getString(Constrant.KEY_SENDER_ID);
                    chatMessage.receiverId=documentChange.getDocument().getString(Constrant.KEY_RECEIVER_ID);
                    chatMessage.message=documentChange.getDocument().getString(Constrant.KEY_MESSAGE);
                    chatMessage.dateTime=getReadableDateAndTime(documentChange.getDocument().getDate(Constrant.KEY_TIMESTAMP));
                    chatMessage.dateObject=documentChange.getDocument().getDate(Constrant.KEY_TIMESTAMP);


                        takeSpeak(documentChange.getDocument().getString(Constrant.KEY_MESSAGE));


                    chatMessages.add(chatMessage);

                }


            }

           // Collections.sort(chatMessages,(obj1,obj2)->obj1.dateObject.compareTo(obj2.dateObject));
            if(count==0)
            {
                chatAdapter.notifyDataSetChanged();

            }
            else{
                chatAdapter.notifyItemRangeInserted(chatMessages.size(),chatMessages.size());
                chatRecyclerView.setVisibility(View.VISIBLE);
                progressbar.setVisibility(View.GONE);

            }




        }

    }

    );

    private String getReadableDateAndTime(Date date)
    {
        return null;//new SimpleDateFormat("MMMM dd,yyyy - hh:mm a", Locale.getDefault()).format(date);
    }




    public void takeSpeak(String toSpeak)
    {




        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

        /////////////////////////////////////////

        translate.setText(null);


        ///////////////////////////////////


    }

   /* @Override
    protected void onPause() {
        super.onPause();
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }

    }*/




    ////////////////////////////////////////////////////////////////////////

    public String prepareModel(String inputlanguage)
    {
        final String[] result = {inputlanguage};
        TranslatorOptions options =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.fromLanguageTag("bn"))
                        .build();
        englishGermanTranslator =
                Translation.getClient(options);


        DownloadConditions conditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();
        englishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void v) {
                                // Model downloaded successfully. Okay to start translating.
                                // (Set a flag, unhide the translation UI, etc.)

                               result[0] = translateLanguage(inputlanguage);
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Model couldn’t be downloaded or other internal error.
                                // ...

                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

        return result[0];


    }

    public String translateLanguage(String text)
    {
        final String[] result = {text};

        englishGermanTranslator.translate(text)
                .addOnSuccessListener(
                        new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(@NonNull String translatedText) {
                                // Translation successful.

                                //textView.setText(translatedText);
                                result[0] =translatedText;

                                translate.setText(translatedText);

                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Error.

                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                                // ...
                            }
                        });

        return result[0];

    }




    //////////////////////////////////////////////////////////////


    public void record(View view)
    {
       // Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();


        SpeechRecognizer speechRecognizer;
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getBaseContext());
        /*MyRecognitionListener speechListner=new MyRecognitionListener();
        speechRecognizer.setRecognitionListener(speechListner);*/

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
        //intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,"bn");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speake Something");
        try{
            startActivityForResult(intent,1);
        }
        catch(Exception e)
        {

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch(requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK && null!=data)
                {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    input_message.setText(result.get(0));
                    ///////////////////////////////////////////

                    sendMessage();

                    //////////////////////////////////////////

                   // translate();



                }
                break;
        }


    }


    /////////////////////////////////////////////



}