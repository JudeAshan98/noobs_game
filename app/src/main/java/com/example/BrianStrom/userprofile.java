package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class userprofile extends AppCompatActivity {

    public String getExtra;
    TextView editText3 ,editText2;
    Button btnfromprofiletohome;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        btnfromprofiletohome = (Button)findViewById(R.id.btnfromprofiletohome);
        imageView2 = (ImageView)findViewById(R.id.imageView2);

        Intent intent = new Intent();
        getExtra = intent.getStringExtra("test");

    }


}
