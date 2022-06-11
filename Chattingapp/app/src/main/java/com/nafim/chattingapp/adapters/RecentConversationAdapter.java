package com.nafim.chattingapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nafim.chattingapp.databinding.ItemContainerRecentConversionBinding;
import com.nafim.chattingapp.models.ChatMessage;

import java.util.List;

public class RecentConversationAdapter extends RecyclerView.Adapter<RecentConversationAdapter.CoversationViewHolder>
{
    private final List<ChatMessage> chatMessages;

    public RecentConversationAdapter(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }


    @NonNull
    @Override
    public CoversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CoversationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CoversationViewHolder extends RecyclerView.ViewHolder
    {
        ItemContainerRecentConversionBinding binding;

        public CoversationViewHolder(ItemContainerRecentConversionBinding itemContainerRecentConversionBinding) {
            super(itemContainerRecentConversionBinding.getRoot());
            this.binding = itemContainerRecentConversionBinding;
        }

        void setData(ChatMessage chatMessage)
        {
            binding.imageProfile.setImageBitmap(getConversationImage(chatMessage.conversionImage));
            binding.textname.setText(chatMessage.conversionName);
            binding.textRecentMessage.setText(chatMessage.message);
        }


    }

    private Bitmap getConversationImage(String encodedImage)
    {
        byte[] bytes= Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0, bytes.length);
    }
}
