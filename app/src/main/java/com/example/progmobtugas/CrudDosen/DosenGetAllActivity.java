package com.example.progmobtugas.CrudDosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmobtugas.Adapter.DosenCRUDRecyclerAdapter;
import com.example.progmobtugas.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.Model.Dosen;
import com.example.progmobtugas.Model.Mahasiswa;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenGetAllActivity extends AppCompatActivity {

    RecyclerView rvDosen;
    DosenCRUDRecyclerAdapter dosenAdapter;
    ProgressDialog pd;
    List<Dosen> dosenList;
    private RetrofitClientInstance GetDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_get_all);

        rvDosen = (RecyclerView)findViewById(R.id.rvGetDosenAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Sabar Ceuuu :)");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Dosen>> call = service.getDosen("72180188");

        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {
                pd.dismiss();
                dosenList = response.body();
                dosenAdapter = new DosenCRUDRecyclerAdapter(dosenList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DosenGetAllActivity.this);
                rvDosen.setLayoutManager(layoutManager);
                rvDosen.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                Toast.makeText(DosenGetAllActivity.this, "ERROR!", Toast.LENGTH_LONG);
            }
        });
    }
}