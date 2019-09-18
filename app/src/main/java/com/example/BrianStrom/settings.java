package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    String myT = "text";
    String takeExtra;
    Button btn;
    Button btnbonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent Myintent = new Intent();
        takeExtra = Myintent.getStringExtra("testExtra");

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, MainActivity.class);
                intent.putExtra("test",myT);
                startActivity(intent);
            }
        });
        btnbonus = (Button)findViewById(R.id.button2);
        btnbonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, bonusLevel.class);
                intent.putExtra("test",myT);
                startActivity(intent);
            }
        });
    }
}
