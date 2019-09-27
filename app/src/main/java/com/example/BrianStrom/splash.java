package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        final Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setProgress(i);
                        sleep(20);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(),land_on_page.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
