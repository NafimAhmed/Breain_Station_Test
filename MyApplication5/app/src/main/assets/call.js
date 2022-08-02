
let localVideo=document.getElementById("local-video");
let remoteVideo=document.getElementById("remote-video");

localVideo.style.opacity=0;
remoteVideo.style.opacity=0;
localVideo.onplaying=()=>{localVideo.style.opacity=1}
remoteVideo.onplaying=()=>{remoteVideo.style.opecity=1}

let peer

function init(userId)
{
    peer= new Peer(userId,{
        host:'192.168.1.13',
        port:9000,
        path:'/videocallapp'
    })

    peer.on('open',()=>{

    })

    listen()
}


let locatstream

function listen()
{
    peer.on(call,(call)=>{
        navigator.getUserMedia({
            audio:true,
            video:true
        },
        (stream)=>{

            localVideo.srcObject= stream
            locatstream=stream

            call.answer(stream)
            call.on('stream',(remoteStream)=>{
                remoteVideo.srcObject=remoteStream

                remoteVideo.className="primary-video"
                localVideo.className="secondary-video"
            })
        }


        )
    })
}


function startCall(oterUserId)
{
   // document.getElementById("video-call-div").style.display="inline"

    navigator.getUserMedia({
        
        audio:true,
        video:true
    }, (stream)=>{

        localVideo.srcObject=stream
        locatstream=stream

        const call=peer.call(oterUserId, stream)

        call.on('stream',(remoteStream)=>{
            remoteVideo.srcObject=remoteStream

            remoteVideo.className="primary-video"
            localVideo.className="secondary-video"
        })
    }
    
    )

}

function toggleVideo(b)
{
    if(b=="true")
    {
        locatstream.getVideoTracks()[0].enabled=true
    }
    else
    {
        locatstream.getVideoTracks()[0].enabled=false
    }
}

function toggleAudio(b)
{
    if(b=="true")
    {
        locatstream.getAudioTracks()[0].enabled=true
    }
    else
    {
        locatstream.getAudioTracks()[0].enabled=false
    }
}