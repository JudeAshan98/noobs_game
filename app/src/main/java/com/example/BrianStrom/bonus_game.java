package com.example.BrianStrom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class bonus_game extends AppCompatActivity {

    Button answer1 , answer2,answer3,answer4;
    TextView score , questoin ,tries;
    public String EEt_extra;

    private questions mQuestions = new questions();

    private String mAnswer;
    private int mScore = 0;

    private int tryies = 10;
    private int mQuestionsLength = mQuestions.mQuestions.length;



    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_game);

        Intent testInt = new Intent();
        EEt_extra = testInt.getStringExtra("test");


        r = new Random();


        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);

        score = (TextView)findViewById(R.id.score);
        tries = (TextView)findViewById(R.id.tries);
        questoin= (TextView)findViewById(R.id.question);

        score.setText("Score : " +mScore);
        tries.setText("Remaining : "+ tryies);

        updateQuestoin(r.nextInt(mQuestionsLength));


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gametale();
                if(answer1.getText()==mAnswer){
                    mScore = mScore + 10;
                    score.setText("Score : " +mScore);
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    Log.i("NextQuiz","="+(r.nextInt(mQuestionsLength)));
                    gametale();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }else{
                    gametale();
                    wrongAnswer();
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    gametale();
                    Log.i("NextQuiz","="+(r.nextInt(tryies+1)));
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gametale();
                if(answer2.getText()==mAnswer){
                    mScore = mScore + 10;
                    score.setText("Score : " +mScore);
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    gametale();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }else{
                    gametale();
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    wrongAnswer();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gametale();
                if(answer3.getText()==mAnswer){
                    mScore = mScore + 10;
                    score.setText("Score : " +mScore);
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    gametale();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }else{
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    gametale();
                    wrongAnswer();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gametale();
                if(answer4.getText()==mAnswer){
                    mScore = mScore + 10;
                    score.setText("Score : " +mScore);
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    gametale();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }else{
                    tryies --;
                    tries.setText("Remaining : "+ tryies);
                    gametale();
                    wrongAnswer();
                    updateQuestoin(r.nextInt(mQuestionsLength));
                }
            }
        });
    }

    private void updateQuestoin(int qno){
        questoin.setText(mQuestions.getQuestion(qno));
        answer1.setText(mQuestions.getChoice1(qno));
        answer2.setText(mQuestions.getChoice2(qno));
        answer3.setText(mQuestions.getChoice3(qno));
        answer4.setText(mQuestions.getChoice4(qno));

        mAnswer = mQuestions.getCorrectAnswer(qno);

    }

    private void wrongAnswer(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(bonus_game.this);
        alertDialogBuilder
                .setMessage("Invalid Answer !")
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                onResume();
                            }
                        })
                .setNegativeButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(bonus_game.this);
        alertDialogBuilder
                .setMessage("Game Over ! Your Score is :" + mScore)
                .setCancelable(true)
                .setPositiveButton("Try Agin",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity( new Intent(getApplicationContext(),bonus_game.class));
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void gametale(){
        if( tryies == 0){
            gameOver();
            //finish();
        }
        else
        {
            onResume();
        }
    }
}
