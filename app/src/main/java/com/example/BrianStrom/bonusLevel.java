package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class bonusLevel extends AppCompatActivity {

    public String noobExtra = "text";
    Button StrtBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_level);

//      button.setOnClickListener(new View.OnClickListener(){
//          @Override
//                  public void onClick(View view){
//                  Intent intent =  new Intent(bonusLevel.this,settings.class);
//                  intent.putExtra("testExtra",noobExtra);
//                  startActivity(intent);
//                }
//        });

    }
}
