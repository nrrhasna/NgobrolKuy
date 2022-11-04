package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomChatActivity extends AppCompatActivity {
    private TextView bukachat;
    private Button btnchat;
    private ImageView pp, setting;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_roomchat);

            pp = findViewById(R.id.ft2);
            bukachat = findViewById(R.id.namachat);

            btnchat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Intent i = new Intent(RoomChatActivity.this, HomeChat.class);
                }
            });
            setting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent set = new Intent(RoomChatActivity.this, SettingActivity.class);
                }
            });
        }
    }