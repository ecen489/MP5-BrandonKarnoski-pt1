package com.example.musicplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.view.View;

public class MainActivity extends AppCompatActivity  {
    //ADD image view
    RadioGroup radioGroup;
    RadioButton radioButton, radioButton2, radioButton3;
    MediaPlayer song;
    Button playBtn;
    Button resetBtn;
    ImageView coverArt;
    boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        playBtn = (Button) findViewById(R.id.playBtn);
        //playBtn.setOnClickListener(this);
        resetBtn = (Button) findViewById(R.id.restartBtn);
        //resetBtn.setOnClickListener(this);
        coverArt = (ImageView) findViewById(R.id.albumArt);
        //Dont know if need these below
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
    }


    public void radioClick(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        song = MediaPlayer.create(this, R.raw.tamu);
    //implement song starting and stopping
        if (radioId == R.id.radioButton){

            if(playing == true) {
                try {
                    song.reset();
                    song.prepare();
                    song.stop();
                    song.release();
                    playing = false;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            coverArt.setImageResource(R.drawable.tamu);
            playing = true;
            song = MediaPlayer.create(this, R.raw.tamu);
            song.start();

        }else if (radioId == R.id.radioButton2){

            if(song.isPlaying() == true) {
                try {
                    song.reset();
                    song.prepare();
                    song.stop();
                    song.release();
                    playing = false;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            coverArt.setImageResource(R.drawable.kenny);
            playing = true;
            song = MediaPlayer.create(this, R.raw.summertime);
            song.start();

        }else if (radioId == R.id.radioButton3){

            if(song.isPlaying() == true) {
                try {
                    song.reset();
                    song.prepare();
                    song.stop();
                    song.release();
                    playing = false;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            coverArt.setImageResource(R.drawable.zac);
            playing = true;
            song = MediaPlayer.create(this, R.raw.toes);
            song.start();
        }
    }
    public void playBtn(View view) {
        //Button click action
        //Change state of the play button start and stop song
        try {
            if (song.isPlaying() == true) {
                song.pause();
            } else if (song.isPlaying() == false) {
                song.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void songReset(View view){
        //Restarts the song
        if(playing) {
            try {
                song.pause();
                song.seekTo(0);
                song.start();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
