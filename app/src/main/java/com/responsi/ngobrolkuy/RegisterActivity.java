package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText uname, email, password, confirm_pass;
    private String s_uname, s_email, s_pass, s_con_pass;
    private Button register, btnmasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uname = findViewById(R.id.uname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_pass = findViewById(R.id.confirm_pass);

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s_uname = uname.getText().toString();
                s_email = email.getText().toString();
                s_pass = password.getText().toString();
                s_con_pass = confirm_pass.getText().toString();
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                i.putExtra("username", s_uname);
                i.putExtra("email", s_email);
                i.putExtra("password", s_pass);
                i.putExtra("konfirmasi password", s_con_pass);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftar = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(daftar);
            }
        });
    }
}