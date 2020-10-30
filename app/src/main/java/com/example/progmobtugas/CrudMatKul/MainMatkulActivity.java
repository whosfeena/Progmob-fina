package com.example.progmobtugas.CrudMatKul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.progmobtugas.CrudDosen.DosenAddActivity;
import com.example.progmobtugas.CrudDosen.DosenGetAllActivity;
import com.example.progmobtugas.CrudDosen.DosenUpdateActivity;
import com.example.progmobtugas.CrudDosen.HapusDosenActivity;
import com.example.progmobtugas.CrudDosen.MainDosenActivity;
import com.example.progmobtugas.R;

public class MainMatkulActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menumatakuliah,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addMatkulTool:
                Toast.makeText(MainMatkulActivity.this, "Tambah Matkul", Toast.LENGTH_LONG).show();
                Intent intentAddMatkul = new Intent(MainMatkulActivity.this, MatkulAddActivity.class);
                startActivity(intentAddMatkul);
                return true;
            case (R.id.getMatkulTool):
                Toast.makeText(MainMatkulActivity.this, "Lihat Daftar Matkul", Toast.LENGTH_LONG).show();
                Intent intentgetMatkul = new Intent(MainMatkulActivity.this, MatkulGetAllActivity.class);
                startActivity(intentgetMatkul);
                return true;
            case (R.id.delMatkulTool):
                Toast.makeText(MainMatkulActivity.this, "Hapus Matkul", Toast.LENGTH_LONG).show();
                Intent intentdelMatkul = new Intent(MainMatkulActivity.this, HapusMatkulActivity.class);
                startActivity(intentdelMatkul);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);

        androidx.appcompat.widget.Toolbar matkulToolbar = (Toolbar)findViewById(R.id.toolbarMatkul);
        setSupportActionBar(matkulToolbar);

    }
}