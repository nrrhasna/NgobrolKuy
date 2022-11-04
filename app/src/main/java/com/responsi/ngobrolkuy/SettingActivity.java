package com.responsi.ngobrolkuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
 private ImageView backhome, gantipoto;
 private String s_email, s_pass;
 private EditText password;
 private Button perubahan, gantifoto;
 Uri imageUri;

 private static final int GALLERY_REQUEST_CODE = 1;

 @Override
    protected void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_setting);

     gantipoto.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent gantipp = new Intent(SettingActivity.this, RoomChatActivity.class);
             gantipp.putExtra("imageUri", imageUri.toString());
             startActivity(gantipp);
         }
     });
     backhome.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent balik = new Intent(SettingActivity.this, RoomChatActivity.class);
             startActivity(balik);
         }
     });
     perubahan.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             s_pass = password.getText().toString();

             Intent ubah = new Intent(SettingActivity.this, SettingActivity.class );
             ubah.putExtra("Password baru", password.getText().toString());
             startActivity(ubah);
         }
     });
 }
}
