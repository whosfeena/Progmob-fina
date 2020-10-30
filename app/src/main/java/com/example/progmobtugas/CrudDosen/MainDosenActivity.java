package com.example.progmobtugas.CrudDosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.progmobtugas.CrudMhs.HapusMhsActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaAddActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.CrudMhs.MainMhsActivity;
import com.example.progmobtugas.R;

public class MainDosenActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menudosen,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addDosenTool:
                Toast.makeText(MainDosenActivity.this, "Tambah Dosen", Toast.LENGTH_LONG).show();
                Intent intentAddDosen = new Intent(MainDosenActivity.this, DosenAddActivity.class);
                startActivity(intentAddDosen);
                return true;
            case (R.id.getDosenTool):
                Toast.makeText(MainDosenActivity.this, "Lihat Daftar Dosen", Toast.LENGTH_LONG).show();
                Intent intentgetDosen = new Intent(MainDosenActivity.this, DosenGetAllActivity.class);
                startActivity(intentgetDosen);
                return true;
            case (R.id.delDosenTool):
                Toast.makeText(MainDosenActivity.this, "Hapus Dosen", Toast.LENGTH_LONG).show();
                Intent intentdelDosen = new Intent(MainDosenActivity.this, HapusDosenActivity.class);
                startActivity(intentdelDosen);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dosen);

        androidx.appcompat.widget.Toolbar dosenToolbar = (Toolbar)findViewById(R.id.toolbarDosen);
        setSupportActionBar(dosenToolbar);

    }
}