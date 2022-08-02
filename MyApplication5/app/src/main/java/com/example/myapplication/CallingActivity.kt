package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class CallingActivity : AppCompatActivity() {

    var username=""
    var friendUserName=""
    var isPeerConnected=false;

    var webView : WebView = TODO()
    var callLayout: LinearLayout ;
    var incomingCallingText: TextView;
    var acceptBtn: ImageView;
    var inputLayout:LinearLayout;
    
    var callControlLayout:LinearLayout


    var firebaseRef=Firebase.database.getReference("users")
    var isAudio=true;
    var isVideo=true;

    





    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling)

        callLayout=findViewById(R.id.callLayout)
        incomingCallingText=findViewById(R.id.incomingCallingText)
        acceptBtn=findViewById(R.id.acceptBtn)
        inputLayout=findViewById(R.id.inputLayout)
        callControlLayout=findViewById(R.id.callControlLayout)

        username=intent.getStringExtra("username")!!

        val togglAudioBtn=findViewById<Button>(R.id.toggleAudioBtn)
        val toggleVideoBtn=findViewById<Button>(R.id.toggleVideoBtn)

       val callBtn= findViewById<Button>(R.id.callBtn)

        callBtn.setOnClickListener {
            TODO()
        }

        togglAudioBtn.setOnClickListener {
            TODO()
        }

        toggleVideoBtn.setOnClickListener {
            TODO()
        }

        setupWebView()
    }

    @SuppressLint("JavascriptInterface")
    private fun setupWebView()
    {
        webView= findViewById<WebView>(R.id.webView)
        webView.webChromeClient= object: WebChromeClient()
        {
            override fun onPermissionRequest(request: PermissionRequest?) {
                //super.onPermissionRequest(request)
                request?.grant(request.resources)


            }
        }

        webView.settings.javaScriptEnabled=true
        webView.settings.mediaPlaybackRequiresUserGesture=false;
        webView.addJavascriptInterface(JavascriptInterface(),"Android")


        loadVideo();

    }

    var uniqueId=""

    private fun initializePeer() {

        uniqueId=getUniqueID()

        callJavaScriptFunction("javasript:init(\"${uniqueId}\")")

        firebaseRef.child(username).child("incoming").addValueEventListener(object:
            ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                callRequest(snapshot.value as? String)
            }

            })

    }

    private fun callRequest(caller: String?) {
        if(caller!=null)
        {
            return
        }

        callLayout.visibility = View.VISIBLE
        incomingCallingText.text="$caller is calling"

        acceptBtn.setOnClickListener {

            firebaseRef.child(username).child("connId").setValue(uniqueId)
            firebaseRef.child(username).child("isAvailable").setValue(true)
            callLayout.visibility=View.GONE;

            switchToControls()

            }
        




    }

    private fun switchToControls() {

        inputLayout.visibility=View.GONE
        

    }

    private fun callJavaScriptFunction(functionString: String){

        webView.post{webView.evaluateJavascript(functionString,null)}

    }

    private fun getUniqueID(): String
    {
        return UUID.randomUUID().toString()
    }

    private fun loadVideo() {
        /*val filePath="file:android_asset/call.html"
        webView.loadUrl(filePath)*/

        val filePath="file:android_asset/call.html"
        webView.loadUrl(filePath)

        webView.webViewClient=object : WebViewClient()
        {
            override fun onPageFinished(view: WebView?, url: String?)
            {
                initializePeer()
            }
        }
    }

    fun onPeerConnected() {
        isPeerConnected=true
    }


}