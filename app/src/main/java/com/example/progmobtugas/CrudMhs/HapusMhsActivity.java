package com.example.progmobtugas.CrudMhs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.progmobtugas.Model.DefaultResult;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HapusMhsActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_mhs);

        Button btnHapus = (Button)findViewById(R.id.btnHapus);
        TextView txtNimHapus = (TextView)findViewById(R.id.editTextHapus);
        pd = new ProgressDialog(HapusMhsActivity.this);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Tunggu ya, sabar ceuu:3");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_mhs(
                        txtNimHapus.getText().toString(),
                        "72180188"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(HapusMhsActivity.this, "Data Berhasil Dihapus !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(HapusMhsActivity.this, MahasiswaGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusMhsActivity.this, "Gagal Menghapus!", Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }
}
