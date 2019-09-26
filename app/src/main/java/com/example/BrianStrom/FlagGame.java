package com.example.BrianStrom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class FlagGame extends AppCompatActivity {

    private TextView countDown;
    DatabaseReference dbref;
    private CountDownTimer countTime;
    private long timeLeftMS = 10000; //10 seconds
    private boolean timerRunning;

    CountDownTimer countDownTimer;
    private int  mscore =0 ;
    private int round=10;
    ImageView imageView;

    Button btflagsubmit;
    Spinner spinner;
    public String flagGame;
    TextView textView3, textView4, textView5,score;

    Random r;

    String[] flagsNames;
    Integer [] images;
    String uname, gname;



    public void itemsOnSpinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,flagsNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent testInt = new Intent();
        flagGame = testInt.getStringExtra("test");
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
        score = (TextView)findViewById(R.id.score);
        countDown = findViewById(R.id.timer);

        btflagsubmit = (Button) findViewById(R.id.btflagsubmit);
        score.setText("Score is :" + mscore);
        itemsOnSpinner();

        uname = "Laka";
        gname = "bomus";

//        r = new Random(flagsNames.length);
        r = new Random(10);
        generateFlag();

        btflagsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btflagsubmit.getText().toString().equalsIgnoreCase("submit")) {
                    String selectedCountry = flagsNames[spinner.getSelectedItemPosition()];
                    Log.i("SELECTED", selectedCountry);

                    if (selectedCountry.equalsIgnoreCase(flagsNames[pickedImage])) {

                        round--;
                        GameOver();
                        mscore++;
                        score.setText("Score is :" + mscore);
                        textView4.setText("CORRECT");
                        textView4.setTextColor(Color.GREEN);


                    } else {

                        round--;
                        GameOver();
                        textView4.setText("WRONG");
                        textView4.setTextColor(Color.RED);
                        textView3.setText(flagsNames[pickedImage]);
                        textView3.setTextColor(Color.BLUE);


                    }

                    btflagsubmit.setText("next");
                    countDownTimer.cancel();
                } else {

//                    round--;
//                    GameOver();
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }

//                    round--;
//                    GameOver();
                    generateFlag();

                }



            }
        });




    }

    private void generateFlag() {


        startTimer();



        btflagsubmit.setText("submit");
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

    private void gamepop() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FlagGame.this);
        alertDialogBuilder
                .setMessage("Game Over ! Your Score is :" + mscore)
                .setCancelable(false)
                .setPositiveButton("Try Agin",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity( new Intent(getApplicationContext(),FlagGame.class));
                             dbref = FirebaseDatabase.getInstance().getReference().child("User");
                              final  DbGame d = new DbGame();
                                d.setUname(uname);
                                d.setGame(gname);
                                d.setScore(mscore);
                             dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                                 @Override
                                 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                     if(dataSnapshot.hasChild(d.getUname())){
                                         if(dataSnapshot.child(d.getUname()).hasChild(d.getGame())){
                                            // int i =Integer.parseInt(dataSnapshot.child(d.getUname()).child(d.getGame()).child("score").getValue().toString());
                                             dbref.child(d.getUname()).child(d.getGame()).child("score").setValue(mscore);
                                         }else{
                                             DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("User").child(d.getUname()).child(d.getGame());
                                             ref.setValue(d);
                                         }
                                     }else {
                                         dbref.child(d.getUname()).child(d.getGame()).setValue(d);
                                         Toast.makeText(getApplicationContext(),"Data inset Succesfully",Toast.LENGTH_SHORT).show();
                                     }
                                 }

                                 @Override
                                 public void onCancelled(@NonNull DatabaseError databaseError) {

                                 }
                             });



                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

private void GameOver(){
        if(round == 0){
            textView4.setText("Your Final Score is : "+mscore);
            gamepop();
        }
        else
        {
            onResume();
        }
}
}



