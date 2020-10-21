package com.example.progmobtugas.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmobtugas.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.progmobtugas.Model.Mahasiswa;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaGetAllActivity extends AppCompatActivity {

    RecyclerView rvMhs;
    MahasiswaCRUDRecyclerAdapter mhsAdapter;
    ProgressDialog pd;
    List<Mahasiswa> mahasiswaList;
    private RetrofitClientInstance GetDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_get_all);

        rvMhs = (RecyclerView)findViewById(R.id.rvGetMhsAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Sabar Ceuuu :)");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Mahasiswa>> call = service.getMahasiswa("72180188");

        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                pd.dismiss();
                mahasiswaList = response.body();
                mhsAdapter = new MahasiswaCRUDRecyclerAdapter(mahasiswaList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaGetAllActivity.this);
                rvMhs.setLayoutManager(layoutManager);
                rvMhs.setAdapter(mhsAdapter);
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                Toast.makeText(MahasiswaGetAllActivity.this, "ERROR!", Toast.LENGTH_LONG);
            }
        });
    }
}