package com.example.progmobtugas.CrudMatKul;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmobtugas.CrudDosen.DosenAddActivity;
import com.example.progmobtugas.CrudDosen.DosenGetAllActivity;
import com.example.progmobtugas.Model.DefaultResult;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_add);

        EditText txtKodeMatkul = (EditText)findViewById(R.id.txtKodeMatkul);
        EditText txtNamaMatkul = (EditText)findViewById(R.id.txtNamaMatkul);
        EditText txtHari = (EditText)findViewById(R.id.txtHari);
        EditText txtSesi = (EditText)findViewById(R.id.txtSesi);
        EditText txtSks = (EditText)findViewById(R.id.txtSks);
        Button btnSimpanMatkul = (Button)findViewById(R.id.btnSimpanMatkul);
        pd = new ProgressDialog(MatkulAddActivity.this);

        btnSimpanMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Sek Sebentar");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_matkul(
                        txtKodeMatkul.getText().toString(),
                        txtNamaMatkul.getText().toString(),
                        txtHari.getText().toString(),
                        txtSesi.getText().toString(),
                        txtSks.getText().toString(),
                        "72180188"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MatkulAddActivity.this, MatkulGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "GAGAL!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}