package com.example.progmobtugas.CrudMhs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.progmobtugas.CrudMatKul.HapusMatkulActivity;
import com.example.progmobtugas.R;

public class MainMhsActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menumahasiswa,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addMhsTool:
                Toast.makeText(MainMhsActivity.this, "Tambah Mahasiswa", Toast.LENGTH_LONG).show();
                Intent intentaddMhs = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intentaddMhs);
                return true;
            case (R.id.getMhsTool):
                Toast.makeText(MainMhsActivity.this, "Lihat Daftar Mahasiswa", Toast.LENGTH_LONG).show();
                Intent intenteditMhs = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intenteditMhs);
                return true;
            case (R.id.delMhsTool):
                Toast.makeText(MainMhsActivity.this, "Hapus Mahasiswa", Toast.LENGTH_LONG).show();
                Intent intentdelMhs = new Intent(MainMhsActivity.this, HapusMhsActivity.class);
                startActivity(intentdelMhs);
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        androidx.appcompat.widget.Toolbar mhsToolbar = (Toolbar)findViewById(R.id.toolbarMhs);
        setSupportActionBar(mhsToolbar);

    }
}