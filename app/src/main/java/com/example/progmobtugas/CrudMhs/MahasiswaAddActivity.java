package com.example.progmobtugas.CrudMhs;

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

public class MahasiswaAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_add);

        EditText editTextNama = (EditText)findViewById(R.id.editTextNama);
        EditText editTextNim = (EditText)findViewById(R.id.editTextNim);
        EditText editTextAlamat = (EditText)findViewById(R.id.editTextAlamat);
        EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        Button btnSimpan = (Button)findViewById(R.id.btnSimpan);
        pd = new ProgressDialog(MahasiswaAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Sek Sebentar");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mhs(
                        editTextNama.getText().toString(),
                        editTextNim.getText().toString(),
                        editTextAlamat.getText().toString(),
                        editTextEmail.getText().toString(),
                        "Kosongkan aja soalnya sembarang dirandom sistem",
                        "72180188"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MahasiswaAddActivity.this, MahasiswaGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "GAGAL!", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}