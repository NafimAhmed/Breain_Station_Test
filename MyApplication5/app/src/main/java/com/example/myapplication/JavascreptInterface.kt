package com.example.myapplication

import android.webkit.JavascriptInterface

class JavascreptInterface(val callActivity: CallingActivity)
{
    @JavascriptInterface
    public fun onPeerConnected()
    {
        callActivity.onPeerConnected()
    }

}

