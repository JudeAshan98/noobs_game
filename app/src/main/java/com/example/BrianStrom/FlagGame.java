package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class FlagGame extends AppCompatActivity {

    private TextView countDown;

    private CountDownTimer countTime;
    private long timeLeftMS = 10000; //10 seconds
    private boolean timerRunning;

    CountDownTimer countDownTimer;

    ImageView imageView;

    Button button7;
    Spinner spinner;

    TextView textView3, textView4, textView5;

    Random r;

    String[] flagsNames;
    Integer [] images;


    public void itemsOnSpinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,flagsNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }



    int pickedImage =0, lastPicked=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_game);


        flagsNames = FlagInfo.getFlagInfo().flagsNames;
        images = FlagInfo.getFlagInfo().images;

        imageView = (ImageView) findViewById(R.id.imageView);

        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        countDown = findViewById(R.id.timer);

        button7 = (Button) findViewById(R.id.button7);

        itemsOnSpinner();

        r = new Random(flagsNames.length);

        generateFlag();

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (button7.getText().toString().equalsIgnoreCase("submit")) {
                    String selectedCountry = flagsNames[spinner.getSelectedItemPosition()];
                    Log.i("SELECTED", selectedCountry);

                    if (selectedCountry.equalsIgnoreCase(flagsNames[pickedImage])) {

                        textView4.setText("CORRECT");
                        textView4.setTextColor(Color.GREEN);

                    } else {

                        textView4.setText("WRONG");
                        textView4.setTextColor(Color.RED);
                        textView3.setText(flagsNames[pickedImage]);
                        textView3.setTextColor(Color.BLUE);


                    }

                    button7.setText("next");
                    countDownTimer.cancel();
                } else {

                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    generateFlag();

                }



            }
        });




    }

    private void generateFlag() {


        startTimer();



        button7.setText("submit");
        if (!textView4.getText().equals("TIME OUT..!! TRY AGAIN"))
            textView4.setText("");
        textView3.setText("");


        // remove duplicates
        do{

            pickedImage = r.nextInt(images.length);

        }

        while (pickedImage==lastPicked);

        lastPicked=pickedImage;

        // display random image
        imageView.setImageResource(images[pickedImage]);


    }
    public void startTimer() {

        countDownTimer = new CountDownTimer(timeLeftMS,1100) {
            @Override
            public void onTick(long l) {
                int num = (int) l/1000;
                countDown.setText(Integer.toString(num));
            }

            @Override
            public void onFinish() {

                countDown.setText("0");
                textView4.setText("TIME OUT..!! TRY AGAIN");



                generateFlag();



            }
        };


        timerRunning = true;


        countDownTimer.start();




    }



    public void stopTimer(){


        timerRunning = false;



    }


}



