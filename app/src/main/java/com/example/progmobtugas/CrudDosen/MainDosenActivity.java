package com.example.progmobtugas.CrudDosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;

import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.CrudMhs.MainMhsActivity;
import com.example.progmobtugas.R;

public class MainDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dosen);

        Button btnAddDosen = (Button)findViewById(R.id.btnAddDosen);
        Button btnGetDosen = (Button)findViewById(R.id.btnGetDosen);
        Button btnDelDosen = (Button)findViewById(R.id.btnDelDosen);
        //Button btnUpdateDosen = (Button)findViewById(R.id.btnUpdateDosen);

        btnGetDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnAddDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });

        btnDelDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, HapusDosenActivity.class);
                startActivity(intent);
            }
        });

        /*btnUpdateDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenUpdateActivity.class);
                startActivity(intent);
            }
        });*/
    }
}