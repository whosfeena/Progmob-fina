package com.example.progmobtugas.CrudMatKul;

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

public class MatkulUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_update);

        final EditText txtKodeCari = (EditText)findViewById(R.id.txtKodeCari);
        final EditText updateKodeMatkul = (EditText)findViewById(R.id.updateKodeMatkul);
        final EditText updateNamaMatkul = (EditText)findViewById(R.id.updateNamaMatkul);
        final EditText updateHari = (EditText)findViewById(R.id.updateHari);
        final EditText updateSesi = (EditText)findViewById(R.id.updateSesi);
        final EditText updateSks = (EditText)findViewById(R.id.updateSks);
        Button btnUpdateMatkul = (Button) findViewById(R.id.btnUpdateMatkul);
        pd = new ProgressDialog(MatkulUpdateActivity.this);
        Intent data = getIntent(); //
        if (data!=null){
            txtKodeCari.setText(data.getStringExtra("kode"));
            updateKodeMatkul.setText(data.getStringExtra("kode"));
            updateNamaMatkul.setText(data.getStringExtra("nama"));
            updateHari.setText(data.getStringExtra("hari"));
            updateSesi.setText(data.getStringExtra("sesi"));
            updateSks.setText(data.getStringExtra("sks"));
        }

        btnUpdateMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> del= service.delete_matkul(
                        txtKodeCari.getText().toString(),
                        "72180188"

                );
                GetDataService services = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = services.update_matkul(
                        updateKodeMatkul.getText().toString(),
                        updateNamaMatkul.getText().toString(),
                        updateHari.getText().toString(),
                        updateSesi.getText().toString(),
                        updateSks.getText().toString(),
                        "72180188"
                );

                del.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(MatkulUpdateActivity.this,"Berhasil Update", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Error!",Toast.LENGTH_LONG).show();
                    }
                });

                Call<DefaultResult> add= service.add_matkul(
                        updateKodeMatkul.getText().toString(),
                        updateNamaMatkul.getText().toString(),
                        updateHari.getText().toString(),
                        updateSesi.getText().toString(),
                        updateSks.getText().toString(),
                        "72180188"
                );

                add.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Berhasil Di Update",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MatkulUpdateActivity.this, MatkulGetAllActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}