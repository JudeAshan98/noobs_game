package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class more_games extends AppCompatActivity {

    Button read_num;
    private String more = "go_more";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_games);

        read_num = (Button)findViewById(R.id.read_num);

        read_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(more_games.this,mind_num_reader.class);
                intent.putExtra("go_more",more);
                startActivity(intent);
            }
        });

    }
}
