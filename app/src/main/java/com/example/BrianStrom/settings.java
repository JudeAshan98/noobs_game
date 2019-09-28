package com.example.BrianStrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class settings extends AppCompatActivity {

    String myT = "text";
    String takeExtra;
    Button btn,buttonh;
    Button btnbonus;
    Switch sound, noti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent Myintent = new Intent();
        takeExtra = Myintent.getStringExtra("testExtra");

        sound = (Switch)findViewById(R.id.sound);
        noti  = (Switch)findViewById(R.id.noti);

        btn = (Button)findViewById(R.id.button);
//        button5 =(Button)findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, more_games.class);
                intent.putExtra("test",myT);
                startActivity(intent);
            }
        });
       /* btnbonus = (Button)findViewById(R.id.button2);
        btnbonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, bonusLevel.class);
                intent.putExtra("test",myT);
                startActivity(intent);
            }
        });
        buttonh = (Button)findViewById(R.id.button5);
        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, FlagGame.class);
                intent.putExtra("test",myT);
                startActivity(intent);
            }
        });
*/

        //sound on off function

        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unmute();
                    Toast.makeText(getApplicationContext(),"Sound On",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mute();
                    Toast.makeText(getApplicationContext(),"Sound Off",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Notification on-Off Function
        noti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Notifications On",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Notifications Off",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void mute() {
        //mute audio
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
    }

    public void unmute() {
        //unmute audio
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
    }
}
