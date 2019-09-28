package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Score extends AppCompatActivity {

    public String EEt_extra6;
    public  String MENU="test";


    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent testInt = new Intent();
        EEt_extra6 = testInt.getStringExtra("observe06");


        menu= (Button)findViewById(R.id.Menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MENU = new Intent(Score.this,MainGameMenu.class);
                MENU.putExtra("test",MENU);
                startActivity(MENU);
            }
        });


    }
}
