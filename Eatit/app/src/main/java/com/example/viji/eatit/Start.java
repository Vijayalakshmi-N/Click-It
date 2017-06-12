package com.example.viji.eatit;

/**
 * Created by Viji on 6/12/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Start extends AppCompatActivity {
    MediaPlayer mp;
    Button button4;
    ImageButton b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mp=MediaPlayer.create(this,R.raw.music);
        mp.setLooping(true);
        mp.start();


        button4=(Button)findViewById(R.id.button4);
        b5=(ImageButton)findViewById(R.id.pause);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it1);

            }
        });
        if (getIntent().getBooleanExtra("EXIT", false)) {

            finishAffinity();
        }


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mp.isPlaying()){
                    mp.pause();
                }
                else {
                    mp.start();
                }}
        });

    }
    protected void onDestroy()
    {
        super.onDestroy();
        mp.stop();
        mp.reset();


    }
}





