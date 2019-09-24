package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mind_num_reader extends AppCompatActivity {

    private TextView tv_info;

    private Button b_yes, b_higher , b_lower , b_ok;

    private int tries = 0;

    private int left = 1, right = 1000;
    private int mid;

    private String getExtra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_num_reader);

        Intent intent = new Intent();
        getExtra = intent.getStringExtra("go_more");

        tv_info = (TextView)findViewById(R.id.tv_info);
        b_yes   = (Button)findViewById(R.id.b_yes);
        b_higher= (Button)findViewById(R.id.b_higher);
        b_lower = (Button)findViewById(R.id.b_lower);
        b_ok    = (Button)findViewById(R.id.b_ok);

        tv_info.setText("Think of a number Between 1 and 1000 , I will find it under 10 moves !");

        b_yes.setVisibility(View.INVISIBLE);
        b_higher.setVisibility(View.INVISIBLE);
        b_lower.setVisibility(View.INVISIBLE);
        b_ok.setVisibility(View.VISIBLE);

        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b_yes.setVisibility(View.VISIBLE);
                b_higher.setVisibility(View.VISIBLE);
                b_lower.setVisibility(View.VISIBLE);
                b_ok.setVisibility(View.INVISIBLE);

                guess();
            }
        });

        b_lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right = mid - 1;
                guess();
            }
        });

        b_higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                left = mid + 1;
                guess();

            }
        });

        b_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_info.setText("Wow I guessed in "+tries+" moves. Awasome !");

                b_yes.setVisibility(View.INVISIBLE);
                b_higher.setVisibility(View.INVISIBLE);
                b_lower.setVisibility(View.INVISIBLE);
                b_ok.setVisibility(View.VISIBLE);

                b_ok.setText("New Try!");
                tries = 0;
                left = 2;
                right =1000;
            }
        });
    }

    private void guess(){
        mid = (right + left)/2;
        tries++;
        tv_info.setText("My Guess is : " + mid);
    }
}
