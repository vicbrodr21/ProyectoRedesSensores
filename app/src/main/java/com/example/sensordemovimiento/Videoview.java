package com.example.sensordemovimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

public class Videoview extends AppCompatActivity {


    VideoView videoview;
    //colocar el url
    String videoUrl="";
    ProgressDialog pd;
    int current=0;
    int duration=0;
    TextView durationTimer;
   // boolean isPlaying;
    //ProgressBar progressBar;
    //variables de las elementos de ventana
   // ImageView imageView;
   // TextView textView1, textView2;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview);
       // imageView =(ImageView) fin
        //isPlaying=false;
        durationTimer=(TextView)findViewById(R.id.idDuration);
        videoview=(VideoView)findViewById(R.id.video);
        pd= new ProgressDialog(Videoview.this);
        pd.show();
        uri=Uri.parse(videoUrl);
        videoview.setVideoURI(uri);
        //videoview.resquestFocus();
        videoview.start();
        /*videoview.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {

                if(what == mp.MEDIA_INFO_BUFFERING_START){
                    bufferProgress.setVisibility();


                }
                return false;
            }
        });*/
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                duration= mp.getDuration()/1000;
                String durating = String.format("%02d:%02d",duration/60,duration%60);
                durationTimer.setText(durating);
                pd.dismiss();

            }
        });

    }
}