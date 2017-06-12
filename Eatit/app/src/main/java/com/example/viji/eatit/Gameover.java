package com.example.viji.eatit;

/**
 * Created by Viji on 6/12/2017.
 */

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Gameover extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        TextView tv3=(TextView)findViewById(R.id.tv3);
        TextView tv1=(TextView)findViewById(R.id.tv1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);



        int score=getIntent().getIntExtra("Score",0);
        tv3.setText(score + " ");
        SharedPreferences settings=getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore=settings.getInt("HIGH SCORE",0);

        if(score > highScore){
            tv1.setText("High Score:"+ score);
            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("HIGH SCORE",score);
            editor.commit();
        }
        else {
            tv1.setText("High Score:" + highScore);

        }



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(Gameover.this);
                alertDialogbuilder.setMessage("Are you sure, You wanted to quit");
                alertDialogbuilder.setCancelable(false);
                alertDialogbuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getApplicationContext(), Start.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                        finish();

                    }
                });

                alertDialogbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();


                    }
                });


                AlertDialog alertDialog = alertDialogbuilder.create();
                alertDialog.setTitle("QUIT?");
                alertDialog.show();

            };

        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Start.class);
                startActivity(i);
                finish();

            }

        });

    }

}




