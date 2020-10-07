package com.example.progmobtugas.Model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.progmobtugas.Adapter.MahasiswaRecycleAdapter;
import com.example.progmobtugas.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecycleAdapter mahasiswaRecycleAdapter;

        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Alfina Febri P", "72180188", "08996245174");
        Mahasiswa m2 = new Mahasiswa("Keren Kezia", "72180222", "08996245175");
        Mahasiswa m3 = new Mahasiswa("Vinanda K", "72180216", "08996245176");
        Mahasiswa m4 = new Mahasiswa("Natasha Fortunata", "72180210", "08996245177");
        Mahasiswa m5 = new Mahasiswa("Dycha Rizky Prastya", "72180194", "08996245178");
        Mahasiswa m6 = new Mahasiswa("Hakkel Hutabarat", "72180256", "08996245179");
        Mahasiswa m7 = new Mahasiswa("Desta Siwi P", "72170126", "08996245180");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);
        mahasiswaList.add(m6);
        mahasiswaList.add(m7);

        mahasiswaRecycleAdapter = new MahasiswaRecycleAdapter(RecyclerActivity.this);
        mahasiswaRecycleAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        rv.setAdapter(mahasiswaRecycleAdapter);
    }
}