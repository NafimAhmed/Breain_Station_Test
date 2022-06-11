package com.nafim.chattingapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nafim.chattingapp.databinding.ItemContainerUserBinding;
import com.nafim.chattingapp.listener.User_listener;
import com.nafim.chattingapp.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

   private final List<User> users;
   private final User_listener userlistener;


    public UserAdapter(List<User> users, User_listener userlistener) {

        this.users = users;
        this.userlistener = userlistener;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemContainerUserBinding itemContainerUserBinding=ItemContainerUserBinding
                .inflate(LayoutInflater.from(parent.getContext()),
                        parent, false
                        );


        return new UserViewHolder(itemContainerUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.setUserData(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder
    {
        ItemContainerUserBinding binding;

        public UserViewHolder(ItemContainerUserBinding itemContainerUserBinding) {
            super(itemContainerUserBinding.getRoot());
            binding=itemContainerUserBinding;
        }

        void setUserData(User user)
        {
            binding.textname.setText(user.name);
            binding.textemail.setText(user.email);
            binding.imageProfile.setImageBitmap(null);//setImageBitmap(getUserImage(user.image));
            binding.getRoot().setOnClickListener(v->userlistener.onUserClick(user));

        }
    }

    private Bitmap getUserImage(String encodedImage)
    {
        byte[] bytes= Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }


}
