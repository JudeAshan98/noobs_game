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

public class observe03 extends AppCompatActivity {

    Button observe03;

    public String EEt_extra3;
    public String myT3;
    private EditText Ans03;
    private int ans03;
    ScoreCal Anwser03;
    private DatabaseReference reff3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe03);

        Toast.makeText(observe03.this, "Connection Success", Toast.LENGTH_LONG).show();

        Intent testInt = new Intent();
        EEt_extra3 = testInt.getStringExtra("observe02");

        Ans03 = (EditText) findViewById(R.id.Ans03);
        observe03 = (Button) findViewById(R.id.Observe03);
        Anwser03 = new ScoreCal();
        reff3 = FirebaseDatabase.getInstance().getReference().child("Observe").child("3").child("ScoreCal");

        observe03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ans03=Integer.valueOf(Ans03.getText().toString());
                Ans03check();
                // Intent OB03 = new Intent(observe03.this, observe04.class);
                // OB03.putExtra("observe03",myT3);
                // startActivity(OB03);
            }
        });
    }

    public void Ans03check() {

        String ans03 = Ans03.getText().toString();
        if (!TextUtils.isEmpty(ans03)) {

            int ans003 = Integer.parseInt(Ans03.getText().toString());

            if (ans003 == 93) {
                /* finalScore(); */


                Anwser03.setAns01(ans03);
               reff3.push().setValue(Anwser03);
                Toast.makeText(observe03.this, "Correct Anwser", Toast.LENGTH_LONG).show();
                Intent OB03 = new Intent(observe03.this, observe04.class);
                OB03.putExtra("observe03", myT3);
                startActivity(OB03);
            } else {

                Toast.makeText(observe03.this, "Wrong Anwser", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(observe03.this, "Please enter a number", Toast.LENGTH_LONG).show();

        }


    }
}
