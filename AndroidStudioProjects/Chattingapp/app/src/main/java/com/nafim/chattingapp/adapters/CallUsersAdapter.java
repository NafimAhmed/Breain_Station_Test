package com.nafim.chattingapp.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.nafim.chattingapp.R;
import com.nafim.chattingapp.listener.CallUsersListener;
import com.nafim.chattingapp.models.CallUser;

import java.util.ArrayList;
import java.util.List;

public class CallUsersAdapter extends RecyclerView.Adapter<CallUsersAdapter.UserViewHolder>
{


    private List<CallUser> users;
    private CallUsersListener usersListener;
    private List<CallUser> selectedUser;

    public CallUsersAdapter(List<CallUser> users, CallUsersListener usersListener) {

        this.users = users;
        this.usersListener=usersListener;
        selectedUser=new ArrayList<>();
    }

    public List<CallUser> getSelectedUsers()
    {
        return selectedUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.call_item_container_user,parent,false)
        );
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

        TextView textFirstChar,textUserName,textEmail;
        ImageView imageAudioMeeting, imageVideoMeeting;
        ConstraintLayout userContainer;
        ImageView imageIsSelected;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textFirstChar=itemView.findViewById(R.id.textFirstChar);
            textUserName=itemView.findViewById(R.id.textUserName);
            textEmail=itemView.findViewById(R.id.textEmail);
            imageAudioMeeting=itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting=itemView.findViewById(R.id.imageVideoMeeting);
            userContainer=itemView.findViewById(R.id.userContainer);
            imageIsSelected=itemView.findViewById(R.id.imageSelected);



        }

        void setUserData(CallUser call_user)
        {
            textFirstChar.setText(call_user.firstName.substring(0,1));
            textUserName.setText(String.format("%s %s",call_user.firstName,call_user.lastName));
            textEmail.setText(call_user.email);
            imageAudioMeeting.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    usersListener.initiateAudioMeeting(call_user);


                }
            });

            imageVideoMeeting.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    usersListener.initiateVideoMeeting(call_user);
                }
            });



            userContainer.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View v) {

                    if(imageIsSelected.getVisibility()!=View.VISIBLE){

                        selectedUser.add(call_user);
                        imageIsSelected.setVisibility(View.VISIBLE);
                        imageVideoMeeting.setVisibility(View.GONE);
                        imageAudioMeeting.setVisibility(View.GONE);
                        usersListener.onMultipleUserAction(true);

                    }

                    return true;
                }
            });

            userContainer.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {

                    if(imageIsSelected.getVisibility()==View.VISIBLE)
                    {
                        selectedUser.remove(call_user);
                        imageIsSelected.setVisibility(View.GONE);
                        imageVideoMeeting.setVisibility(View.VISIBLE);
                        imageAudioMeeting.setVisibility(View.VISIBLE);
                        if(selectedUser.size()==0)
                        {
                            usersListener.onMultipleUserAction(false);
                        }
                    }
                    else{
                        if(selectedUser.size()>0)
                        {
                            usersListener.onMultipleUserAction(false);
                            selectedUser.add(call_user);
                            imageIsSelected.setVisibility(View.VISIBLE);
                            imageVideoMeeting.setVisibility(View.GONE);
                            imageAudioMeeting.setVisibility(View.GONE);
                        }

                    }


                }
            });
        }

    }


}
