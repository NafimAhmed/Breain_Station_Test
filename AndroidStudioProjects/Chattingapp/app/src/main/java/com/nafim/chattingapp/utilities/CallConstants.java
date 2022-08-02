package com.nafim.chattingapp.utilities;

import java.util.HashMap;

public class CallConstants
{
    public static final String KEY_COLLECTION_USERS="users";
    public static final String KEY_FIRST_NAME="first_name";
    public static final String KEY_LAST_NAME="last_name";
    public static final String KEY_EMAIL="email";
    public static final String KEY_PASSWORD="password";

    public static final String KEY_PREFERENCE_NAME="VideoMeetingPreference";
    public static final String KEY_FCM_TOKEN="fcm_token";

    public static final String KEY_IS_SIGNED_IN="isSignedIn";
    public static final String KEY_USER_ID="user_id";

    public static final String REMOTE_MESSAGE_CONTENT_TYPE ="Content-Type";
    public static final String REMOTE_MESSAGE_AUTHORIZATION="Authorization";


    public static final String REMOTE_MSG_INVITATION_ACCEPTED ="accepted";
    public static final String REMOTE_MSG_INVITATION_REJECTED ="rejected";
    public static final String REMOTE_MSG_INVITATION_CANCELLED ="cancelled";


    public static final String REMOTE_MSG_INVITATION ="invitation";
    public static final String REMOTE_MSG_MEETING_TYPE ="meetingType";

    public static final String REMOTE_MSG_INVITER_TOKEN ="inviterToken";
    public static final String REMOTE_MSG_DATA ="data";

    public static final String REMOTE_MSG_TYPE ="type";
    public static final String REMOTE_MSG_REGISTRATION_IDS ="registration_ids";

    public static final String REMOTE_MSG_INVITATION_RESPONSE ="invitationrResponse";

    public static final String REMOTE_MSG_MEETING_ROOM ="meetingRoom";







    public static HashMap<String,String> getRemoteMessageHeaders()
    {
        HashMap<String,String> headers = new HashMap<>();
        headers.put(CallConstants.REMOTE_MESSAGE_AUTHORIZATION,
                "key=AAAAveCj1u4:APA91bHNs6LdcqnpMDnrb8ixkxeA6dqC5mp_SK7ZvgX_BuRzjdqBxN9VObB9yqqX1lYpfzgggIw-A1GknsgAnoEPW21UwDcRyma7fb7y9-_eFuOhLxNvjhh0FiQrDSTyoOb5OcyXbvvq"
                );
        headers.put(CallConstants.REMOTE_MESSAGE_CONTENT_TYPE,"application/json");
        return headers;
    }


}
