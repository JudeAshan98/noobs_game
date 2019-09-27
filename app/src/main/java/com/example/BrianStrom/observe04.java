package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class observe04 extends AppCompatActivity {

    Button observe04;

    public String EEt_extra4;
    public  String myT4;
    private EditText Ans04;
    private  int ans04;

    ScoreCal Anwser04;
   // private DatabaseReference reff4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe04);

        Toast.makeText(observe04.this,"Connection Success",Toast.LENGTH_LONG).show();

        Intent testInt = new Intent();
        EEt_extra4 = testInt.getStringExtra("observe03");

        Ans04=(EditText)findViewById(R.id.Ans04);
        observe04= (Button)findViewById(R.id.Observe04);

        Anwser04=new ScoreCal();
      //  reff4= FirebaseDatabase.getInstance().getReference().child("ScoreCal");

        observe04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ans04=Integer.valueOf(Ans04.getText().toString());
                Ans04check();
                // Intent OB04 = new Intent(observe04.this, observe05.class);
                //OB04.putExtra("observe04",myT);
                //startActivity(OB04);
            }
        });
    }

    public void Ans04check(){

        String ans04=Ans04.getText().toString();
        if(!TextUtils.isEmpty(ans04)){

            int ans004=Integer.parseInt(Ans04.getText().toString());

            if (ans004 == 17) {
                /* finalScore(); */


                Anwser04.setAns01(ans04);
              //  reff4.push().setValue(Anwser04);
                Toast.makeText(observe04.this, "Correct Anwser", Toast.LENGTH_LONG).show();
                Intent OB04 = new Intent(observe04.this, observe05.class);
                OB04.putExtra("observe04", myT4);
                startActivity(OB04);
            } else {

                Toast.makeText(observe04.this, "Wrong Anwser", Toast.LENGTH_LONG).show();
            }
        }

        else{
            Toast.makeText(observe04.this, "Please enter a number", Toast.LENGTH_LONG).show();

        }
    }


}
