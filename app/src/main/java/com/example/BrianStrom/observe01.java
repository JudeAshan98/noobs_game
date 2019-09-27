package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class observe01 extends AppCompatActivity {

    Button observe01;

    public String EEt_extra1;
    public  String myT1;
    private EditText Ans01;
    ScoreCal Anwser01;
    DatabaseReference reff1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe01);

        Toast.makeText(observe01.this,"Connection Success",Toast.LENGTH_LONG).show();

        Intent testInt = new Intent();
        EEt_extra1 = testInt.getStringExtra("test");

        Ans01=(EditText)findViewById(R.id.Ans01);
        observe01= (Button)findViewById(R.id.Observe01);
        Anwser01=new ScoreCal();
       reff1= FirebaseDatabase.getInstance().getReference().child("Observe").child("1").child("ScoreCal");
        observe01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ans01check();

            }
        });
    }

    public void Ans01check(){

        String ans01=Ans01.getText().toString();
        if(!TextUtils.isEmpty(ans01)){

            int ans001=Integer.parseInt(Ans01.getText().toString());

            if (ans001 == 98) {
                /* finalScore(); */


                Anwser01.setAns01(ans01);
                reff1.push().setValue(Anwser01);
                Toast.makeText(observe01.this, "Correct Anwser", Toast.LENGTH_LONG).show();
                Intent OB01 = new Intent(observe01.this, observe02.class);
                OB01.putExtra("observe01", myT1);
                startActivity(OB01);
            } else {

                Toast.makeText(observe01.this, "Wrong Anwser", Toast.LENGTH_LONG).show();
            }
        }

        else{
            Toast.makeText(observe01.this, "Please enter a number", Toast.LENGTH_LONG).show();

        }


    }
}
