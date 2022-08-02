package com.nafim.chattingapp.listener;

import com.nafim.chattingapp.models.CallUser;

public interface CallUsersListener
{
    void initiateVideoMeeting(CallUser user);


    void initiateAudioMeeting(CallUser user);

    void onMultipleUserAction(Boolean isMultipleUserSelected);

}
