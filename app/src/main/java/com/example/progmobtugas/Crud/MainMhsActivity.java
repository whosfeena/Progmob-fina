package com.example.progmobtugas.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmobtugas.R;

public class MainMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        Button btnGetMhs = (Button)findViewById(R.id.btnGetMhs);
        Button btnAddMhs = (Button)findViewById(R.id.btnAddMhs);


        btnGetMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnAddMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intent);
            }
        });
    }
}