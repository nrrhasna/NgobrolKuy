package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView tambah_foto;
    private CircleImageView profile_pict;
    private TextView lanjut;
    private TextView skip;
    Uri imageUri;

    private static final int GALLERY_REQUEST_CODE = 1;
    private static final String TAG = RegisterActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        tambah_foto = findViewById(R.id.tambahft);
        profile_pict = findViewById(R.id.profilePic);
        lanjut = findViewById(R.id.lanjut);
        skip = findViewById(R.id.skip);

        tambah_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
                        GALLERY_REQUEST_CODE);
            }
        });

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambahft = new Intent(ProfilePicActivity.this, RoomChatActivity.class);
                tambahft.putExtra("imageUri", imageUri.toString());
                startActivity(tambahft);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lewati = new Intent(ProfilePicActivity.this, RoomChatActivity.class);
                startActivity(lewati);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Gambar batal diunggah", Toast.LENGTH_SHORT).show();
            return;
        }else if (requestCode == GALLERY_REQUEST_CODE){
            if (data != null){
                try{
                    imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    tambah_foto.setImageBitmap(bitmap);
                    lanjut.setVisibility(View.VISIBLE);
                    skip.setVisibility(View.INVISIBLE);
                }
                catch (IOException e){
                    Toast.makeText(this, "Tidak dapat memuat gambar", Toast.LENGTH_SHORT).show();
                }
            }
        }else Toast.makeText(this, "Tidak terdeteksi", Toast.LENGTH_SHORT).show();
    }
}