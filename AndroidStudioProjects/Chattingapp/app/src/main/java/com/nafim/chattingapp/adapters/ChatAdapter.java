package com.nafim.chattingapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nafim.chattingapp.activities.Chat_Activity;
import com.nafim.chattingapp.databinding.ItemContainerReceivedMessageBinding;
import com.nafim.chattingapp.databinding.ItemContainerSendMessageBinding;
import com.nafim.chattingapp.databinding.ItemContainerUserBinding;
import com.nafim.chattingapp.models.ChatMessage;

import java.util.List;
import java.util.Locale;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private final List<ChatMessage> chatMessage;
    private final Bitmap receiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT=1;
    public static final int VIEW_TYPE_RECEIVED=2;

    public Context context;

    TextToSpeech t1;

    public ChatAdapter(List<ChatMessage> chatMessage, Bitmap receiverProfileImage, String senderId,Context context) {
        this.chatMessage = chatMessage;
        this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
        this.context=context;
        //takeSpeak(chatMessage.toString());

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_SENT)
        {
            return new SendMessageViewHolder(ItemContainerSendMessageBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false));
        }

        else
        {
            return new ReceiveMessageViewHolder(ItemContainerReceivedMessageBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
        }


        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        if(getItemViewType(position)==VIEW_TYPE_SENT)
        {
            ((SendMessageViewHolder)holder).setData(chatMessage.get(position));
        }
        else{
            ((ReceiveMessageViewHolder)holder).setData(chatMessage.get(position),receiverProfileImage);
        }

    }

    @Override
    public int getItemCount() {
        return chatMessage.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (chatMessage.get(position).senderId.equals(senderId))
        {
            return VIEW_TYPE_SENT;
        }
        else {
            return VIEW_TYPE_RECEIVED;
        }
        
        //return super.getItemViewType(position);
    }

    static class SendMessageViewHolder extends RecyclerView.ViewHolder
    {
        private final ItemContainerSendMessageBinding binding;


        public SendMessageViewHolder(ItemContainerSendMessageBinding itemContainerSendMessageBinding)
        {
            super(itemContainerSendMessageBinding.getRoot());
            this.binding = itemContainerSendMessageBinding;
        }

        void setData(ChatMessage chatMessage)
        {
            binding.textmessage.setText(chatMessage.message);
            binding.textdateandtime.setText(chatMessage.dateTime);

        }


    }

    public static class ReceiveMessageViewHolder extends RecyclerView.ViewHolder {
        private final ItemContainerReceivedMessageBinding binding;
        //Context context;

        ReceiveMessageViewHolder(ItemContainerReceivedMessageBinding itemContainerReceivedMessageBinding) {
            super(itemContainerReceivedMessageBinding.getRoot());
            binding = itemContainerReceivedMessageBinding;


        }

        public void setData(ChatMessage chatMessage, Bitmap receiverProfileImage) {
            binding.textmessage.setText(chatMessage.message);
            binding.textdateandtime.setText(chatMessage.dateTime);
            binding.imageProfile.setImageBitmap(receiverProfileImage);


        }

    }


    public void takeSpeak(String toSpeak)
    {
        t1=new TextToSpeech(context,new TextToSpeech.OnInitListener()
        {

            @Override
            public void onInit(int status) {
                t1.setLanguage(Locale.ENGLISH);
            }
        }
        );



        //String toSpeak =trsfr; //translateLanguageTV.getText().toString();
        //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

    }






}
