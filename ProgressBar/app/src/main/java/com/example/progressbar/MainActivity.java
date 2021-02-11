package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    int progress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {//nirdisto somoy por por progress er value change howar jonno a method
            @Override
            public void run() {

                doWork();
            }
        });

        thread.start();
    }

    //style="@android:style/Widget.ProgressBar.Horizontal" ata progressbar er height change korte help korbe..xml file a

    public void doWork() {//likhte hobe Thread.sleep(1000); tarpor alt + enter caple surround with try/catch a nite hobe..
        for(progress = 20; progress <= 100; progress+=20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}