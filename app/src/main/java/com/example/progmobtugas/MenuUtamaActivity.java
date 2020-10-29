package com.example.progmobtugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmobtugas.CrudDosen.MainDosenActivity;
import com.example.progmobtugas.CrudMatKul.MainMatkulActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.CrudMhs.MainMhsActivity;

public class MenuUtamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        Button btnMahasiswa = (Button)findViewById(R.id.btnMahasiswa);
        Button btnDosen = (Button)findViewById(R.id.btnDosen);
        Button btnMatkul = (Button)findViewById(R.id.btnMatkul);

        btnMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtamaActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });

        btnDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtamaActivity.this, MainDosenActivity.class);
                startActivity(intent);
            }
        });

        btnMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtamaActivity.this, MainMatkulActivity.class);
                startActivity(intent);
            }
        });
    }
}