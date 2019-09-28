package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainGameMenu extends AppCompatActivity {

    Button game1_btn,flag_btn,max_min_btn,game_4_btn,bonus_btn;
    private String IntentGo = "test",EEt_extra;
    public  String MENU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_menu);


        Intent testInt = new Intent();
        EEt_extra = testInt.getStringExtra("test");

        Intent testIntq = new Intent();
        MENU = testIntq.getStringExtra("test");

        game1_btn = (Button)findViewById(R.id.game1_btn);
        flag_btn = (Button)findViewById(R.id.flag_btn);
        max_min_btn = (Button)findViewById(R.id.max_min_btn);
        game_4_btn = (Button)findViewById(R.id.game_4_btn);
        bonus_btn = (Button)findViewById(R.id.bonus_btn);


        flag_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGameMenu.this,FlagGame.class);
                intent.putExtra(IntentGo,"test");
                startActivity(intent);
            }
        });

        bonus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGameMenu.this, bonusLevel.class);
                intent.putExtra(IntentGo,"test");
                startActivity(intent);
            }
        });

       /* game1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGameMenu.this, game1_btn.class);
                intent.putExtra(IntentGo,"test");
                startActivity(intent);
            }
        });*/

        /*max_min_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGameMenu.this, max_min_btn.class);
                intent.putExtra(IntentGo,"test");
                startActivity(intent);
            }
        });*/

        game_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGameMenu.this, observation_level.class);
                intent.putExtra(IntentGo,"test");
                startActivity(intent);
            }
        });


    }
}
