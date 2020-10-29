package com.example.progmobtugas.CrudMatKul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmobtugas.CrudDosen.DosenAddActivity;
import com.example.progmobtugas.CrudDosen.DosenGetAllActivity;
import com.example.progmobtugas.CrudDosen.DosenUpdateActivity;
import com.example.progmobtugas.CrudDosen.HapusDosenActivity;
import com.example.progmobtugas.CrudDosen.MainDosenActivity;
import com.example.progmobtugas.R;

public class MainMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);

        Button btnGetMatkul = (Button)findViewById(R.id.btnGetMatkul);
        Button btnAddMatkul = (Button)findViewById(R.id.btnAddMatkul);
        Button btnDelMatkul = (Button)findViewById(R.id.btnDelMatkul);
        //Button btnUpdateMatkul = (Button)findViewById(R.id.btnUpdateMatkul);

        btnGetMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnAddMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulAddActivity.class);
                startActivity(intent);
            }
        });

        btnDelMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, HapusMatkulActivity.class);
                startActivity(intent);
            }
        });

        /*btnUpdateMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulUpdateActivity.class);
                startActivity(intent);
            }
        });*/
    }
}