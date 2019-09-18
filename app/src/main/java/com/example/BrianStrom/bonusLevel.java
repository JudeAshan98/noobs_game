package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bonusLevel extends AppCompatActivity{

    public String noobExtra = "text";
    public String EEt_extra;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_level);

        Intent testInt = new Intent();
        EEt_extra = testInt.getStringExtra("test");

        btn1 = (Button)findViewById(R.id.StrtBtn);
        btn1.setOnClickListener(new View.OnClickListener(){
          @Override
                  public void onClick(View view){
                  Intent intent =  new Intent(bonusLevel.this, settings.class);
                  intent.putExtra("testExtra",noobExtra);
                  startActivity(intent);
                }
        });


    }
}
