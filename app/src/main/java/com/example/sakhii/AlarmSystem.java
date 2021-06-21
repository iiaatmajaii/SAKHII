package com.example.sakhii;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmSystem extends AppCompatActivity {
    public Button siren;
    final MediaPlayer srn = MediaPlayer.create(this, R.raw.sirensound);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       Button siren;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_system);
        siren = (Button)findViewById(R.id.siren);
    }

   public void siren(View view) {
        srn.start();
    }


    }