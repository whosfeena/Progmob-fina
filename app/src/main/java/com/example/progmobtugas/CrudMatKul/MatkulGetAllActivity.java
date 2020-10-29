package com.example.progmobtugas.CrudMatKul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmobtugas.Adapter.MatkulCRUDRecyclerAdapter;
import com.example.progmobtugas.Model.Matkul;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulGetAllActivity extends AppCompatActivity {
    RecyclerView rvMatkul;
    MatkulCRUDRecyclerAdapter matkulAdapter;
    ProgressDialog pd;
    List<Matkul> matkulList;
    private RetrofitClientInstance GetDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_get_all);

        rvMatkul = (RecyclerView)findViewById(R.id.rvGetMatkulAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Sabar Ceuuu :)");
        pd.show();

        com.example.progmobtugas.Network.GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matkul>> call = service.getMatkul("72180188");

        call.enqueue(new Callback<List<Matkul>>() {
            @Override
            public void onResponse(Call<List<Matkul>> call, Response<List<Matkul>> response) {
                pd.dismiss();
                matkulList = response.body();
                matkulAdapter = new MatkulCRUDRecyclerAdapter(matkulList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetAllActivity.this);
                rvMatkul.setLayoutManager(layoutManager);
                rvMatkul.setAdapter(matkulAdapter);
            }

            @Override
            public void onFailure(Call<List<Matkul>> call, Throwable t) {
                Toast.makeText(MatkulGetAllActivity.this, "ERROR!", Toast.LENGTH_LONG);
            }
        });
    }
}