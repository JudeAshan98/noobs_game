package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class observation_level extends AppCompatActivity {

    Button btnbonus;
    ImageButton info;
    public String EEt_extra;
    public  String myT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation_level);

        Intent testInt = new Intent();
        EEt_extra = testInt.getStringExtra("test");


        btnbonus = (Button)findViewById(R.id.Start);
        btnbonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(observation_level.this, observe01.class);
                intent.putExtra("test",myT);
                startActivity(intent);
            }
        });

        info=(ImageButton)findViewById(R.id.Info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infor = new Intent(observation_level.this,Instructions.class);
                infor.putExtra("information",myT);
                startActivity(infor);
            }
        });
    }
}
