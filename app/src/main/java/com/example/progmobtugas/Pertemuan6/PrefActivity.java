package com.example.progmobtugas.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.progmobtugas.R;

public class PrefActivity extends AppCompatActivity {
    String isLogin="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        Button btnPref = (Button)findViewById(R.id.btnLogin);

        SharedPreferences pref = PrefActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //membaca pref isLogin apakah True or False
        isLogin = pref.getString("isLogin","0");
        if(isLogin.equals("1")){
            btnPref.setText("Logout");
        }else{
            btnPref.setText("Login");
        }

        //pengisian pref
        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin = pref.getString("isLogin","0");
                if(isLogin.equals("0")){
                    editor.putString("isLogin","0");
                    btnPref.setText("Logout");
                }else{
                    editor.putString("isLogin","1");
                    btnPref.setText("Login");
                }
                editor.commit();
            }
        });
    }
}