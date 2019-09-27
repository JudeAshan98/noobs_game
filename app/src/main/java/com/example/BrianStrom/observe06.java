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

public class observe06 extends AppCompatActivity {

    Button observe06;

    public String EEt_extra6;
    public  String myT6;
    private EditText Ans06;
    private  int ans06;

    ScoreCal Anwser06;
    private DatabaseReference reff6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe06);

        Toast.makeText(observe06.this,"Connection Success",Toast.LENGTH_LONG).show();

        Intent testInt = new Intent();
        EEt_extra6 = testInt.getStringExtra("observe05");

        Ans06=(EditText)findViewById(R.id.Ans06);
        observe06= (Button)findViewById(R.id.Observe06);

        Anwser06=new ScoreCal();
        reff6= FirebaseDatabase.getInstance().getReference().child("Observer").child("6").child("ScoreCal");

        observe06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ans06=Integer.valueOf(Ans06.getText().toString());
                Ans06check();
                //Intent OB06 = new Intent(observe06.this, Score.class);
                //OB06.putExtra("observe06",myT);
                //startActivity(OB06);
            }
        });
    }

    public void Ans06check(){

        String ans06=Ans06.getText().toString();
        if(!TextUtils.isEmpty(ans06)){

            int ans006=Integer.parseInt(Ans06.getText().toString());

            if (ans006 == 97) {
                /* finalScore(); */


                Anwser06.setAns01(ans06);
              //  reff6.push().setValue(Anwser06);
                Toast.makeText(observe06.this, "Correct Anwser", Toast.LENGTH_LONG).show();
                Intent OB06 = new Intent(observe06.this, Score.class);
                OB06.putExtra("observe06", myT6);
                startActivity(OB06);
            } else {

                Toast.makeText(observe06.this, "Wrong Anwser", Toast.LENGTH_LONG).show();
            }
        }

        else{
            Toast.makeText(observe06.this, "Please enter a number", Toast.LENGTH_LONG).show();

        }
    }
}
