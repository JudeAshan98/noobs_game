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

public class observe02 extends AppCompatActivity {

    Button observe02;

    public String EEt_extra2;
    public  String myT2;
    private EditText Ans02;
    private  int ans02;

    ScoreCal Anwser02;
    private DatabaseReference reff2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe02);

        Toast.makeText(observe02.this,"Connection Success",Toast.LENGTH_LONG).show();

        Intent testInt2 = new Intent();
        EEt_extra2 = testInt2.getStringExtra("observe01");

        Ans02=(EditText)findViewById(R.id.Ans02);
        observe02= (Button)findViewById(R.id.Observe02);
        Anwser02=new ScoreCal();
        reff2= FirebaseDatabase.getInstance().getReference().child("Observe").child("2").child("ScoreCal");

        observe02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ans02=Integer.valueOf(Ans02.getText().toString());
                Ans02check();
                //Intent OB02 = new Intent(observe02.this, observe03.class);
                //OB02.putExtra("observe02",myT2);
                //startActivity(OB02);
            }
        });
    }

    public void Ans02check(){

        String ans02=Ans02.getText().toString();
        if(!TextUtils.isEmpty(ans02)){

            int ans002=Integer.parseInt(Ans02.getText().toString());

            if (ans002 == 2) {
                /* finalScore(); */


                Anwser02.setAns01(ans02);
               reff2.push().setValue(Anwser02);
                Toast.makeText(observe02.this, "Correct Anwser", Toast.LENGTH_LONG).show();
                Intent OB02 = new Intent(observe02.this, observe03.class);
                OB02.putExtra("observe02", myT2);
                startActivity(OB02);
            } else {

                Toast.makeText(observe02.this, "Wrong Anwser", Toast.LENGTH_LONG).show();
            }
        }

        else{
            Toast.makeText(observe02.this, "Please enter a number", Toast.LENGTH_LONG).show();

        }


    }
}
