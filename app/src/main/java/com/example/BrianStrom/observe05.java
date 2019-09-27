package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class observe05 extends AppCompatActivity {

    Button observe05;

    public String EEt_extra5;
    public  String myT5;
    private EditText Ans05;
    private  int ans05;

    ScoreCal Anwser05;
   // private DatabaseReference reff5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe05);

        Toast.makeText(observe05.this,"Connection Success",Toast.LENGTH_LONG).show();

        Intent testInt = new Intent();
        EEt_extra5 = testInt.getStringExtra("observe04");

        Ans05=(EditText)findViewById(R.id.Ans05);
        observe05= (Button)findViewById(R.id.Observe05);
        Anwser05=new ScoreCal();
       // reff5= FirebaseDatabase.getInstance().getReference().child("ScoreCal");

        observe05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ans05=Integer.valueOf(Ans05.getText().toString());
                Ans05check();
                //  Intent OB05 = new Intent(observe05.this, observe06.class);
                //OB05.putExtra("observe05",myT5);
                // startActivity(OB05);
            }
        });

    }

    public void Ans05check(){

        String ans05=Ans05.getText().toString();
        if(!TextUtils.isEmpty(ans05)){

            int ans005=Integer.parseInt(Ans05.getText().toString());

            if (ans005 == 15) {
                /* finalScore(); */


                Anwser05.setAns01(ans05);
          //      reff5.push().setValue(Anwser05);
                Toast.makeText(observe05.this, "Correct Anwser", Toast.LENGTH_LONG).show();
                Intent OB05 = new Intent(observe05.this, observe06.class);
                OB05.putExtra("observe05", myT5);
                startActivity(OB05);
            } else {

                Toast.makeText(observe05.this, "Wrong Anwser", Toast.LENGTH_LONG).show();
            }
        }

        else{
            Toast.makeText(observe05.this, "Please enter a number", Toast.LENGTH_LONG).show();

        }
    }
}
