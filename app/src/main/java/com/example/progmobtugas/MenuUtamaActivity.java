package com.example.progmobtugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.progmobtugas.Adapter.MenuUtamaAdapter;
import com.example.progmobtugas.CrudDosen.MainDosenActivity;
import com.example.progmobtugas.CrudMatKul.MainMatkulActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.CrudMhs.MainMhsActivity;

public class MenuUtamaActivity extends AppCompatActivity {
    GridView gridView;
    String[] namaIcon = {"Menu Mahasiswa","Menu Dosen","Menu Matakuliah"};
    int[] nomerIcon = {R.drawable.dosen,R.drawable.mahasiswa,R.drawable.matakuliah};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        gridView = findViewById(R.id.gridView);
        MenuUtamaAdapter muAdapter = new MenuUtamaAdapter(MenuUtamaActivity.this,namaIcon,nomerIcon);
        gridView.setAdapter(muAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Anda Memilih Menu "+namaIcon[i],Toast.LENGTH_SHORT).show();
            }
        });

    }
}