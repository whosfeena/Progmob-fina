package com.example.progmobtugas.CrudDosen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmobtugas.Model.DefaultResult;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);

        EditText txtNama = (EditText)findViewById(R.id.txtNama);
        EditText txtNidn = (EditText)findViewById(R.id.txtNidn);
        EditText txtAlamat = (EditText)findViewById(R.id.txtAlamat);
        EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        EditText txtGelar = (EditText)findViewById(R.id.txtGelar);
        Button btnSimpan = (Button)findViewById(R.id.btnSimpan);
        pd = new ProgressDialog(DosenAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Sek Sebentar");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dosen(
                        txtNama.getText().toString(),
                        txtNidn.getText().toString(),
                        txtAlamat.getText().toString(),
                        txtEmail.getText().toString(),
                        txtGelar.getText().toString(),
                        "Kosongkan aja soalnya sembarang dirandom sistem",
                        "72180188"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DosenAddActivity.this, DosenGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "GAGAL!", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
