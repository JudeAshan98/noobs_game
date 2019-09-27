package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class land_on_page extends AppCompatActivity {

    public String EET_Setings = "test";
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_on_page);

        btn1 = (Button)findViewById(R.id.wel);
        btn2 = (Button)findViewById(R.id.setiings_btn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(land_on_page.this,MainGameMenu.class);
                intent.putExtra("test",EET_Setings);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(land_on_page.this,settings.class);
                intent.putExtra("test",EET_Setings);
                startActivity(intent);
            }
        });

    }
}
