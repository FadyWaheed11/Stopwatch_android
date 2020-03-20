package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnStart,btnStop;
    ImageView bgcircle;
    Animation roundingalone;
    Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnStart);
        bgcircle = findViewById(R.id.bgcircle);
        btnStop = findViewById(R.id.btnStop);
        timer = findViewById(R.id.timer);

        btnStop.setAlpha(0);
        //Load Animation
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);

        //Import fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //Customize fonts
        btnStart.setTypeface(MMedium);
        btnStop.setTypeface(MMedium);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passing Animation
                bgcircle.startAnimation(roundingalone);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                btnStart.setEnabled(false);
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgcircle.clearAnimation();
                btnStart.setEnabled(true);
                btnStart.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();
                timer.stop();
            }
        });
    }
}
