package com.example.progmobtugas.CrudDosen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaUpdateActivity;
import com.example.progmobtugas.Model.DefaultResult;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;
import com.example.progmobtugas.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);

        final EditText upNidnCari = (EditText)findViewById(R.id.upNidnCari);
        final EditText upNamaDosen = (EditText)findViewById(R.id.upNamaDosen);
        final EditText upNidn = (EditText)findViewById(R.id.upNidn);
        final EditText upAlamatDosen = (EditText)findViewById(R.id.upAlamatDosen);
        final EditText upEmailDosen = (EditText)findViewById(R.id.upEmailDosen);
        final EditText upGelar = (EditText)findViewById(R.id.upGelar);
        Button btnUpdateDosen = (Button) findViewById(R.id.btnUpdateDosen);
        pd = new ProgressDialog(DosenUpdateActivity.this);
        Intent data = getIntent(); //
        if (data!=null){
            upNidnCari.setText(data.getStringExtra("nidn"));
            upNamaDosen.setText(data.getStringExtra("nama"));
            upNidn.setText(data.getStringExtra("nidn"));
            upAlamatDosen.setText(data.getStringExtra("alamat"));
            upEmailDosen.setText(data.getStringExtra("email"));
            upGelar.setText(data.getStringExtra("gelar"));
        }

        btnUpdateDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> del= service.delete_dosen(
                        upNidnCari.getText().toString(),
                        "72180188"

                );
                GetDataService services = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = services.update_dosen(
                        upNamaDosen.getText().toString(),
                        upNidn.getText().toString(),
                        upAlamatDosen.getText().toString(),
                        upEmailDosen.getText().toString(),
                        upGelar.getText().toString(),
                        "Kosongkan aja soalnya sembarang dirandom sistem",
                        "72180188"
                );

                del.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(DosenUpdateActivity.this,"Berhasil Update", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Error!",Toast.LENGTH_LONG).show();
                    }
                });

                Call<DefaultResult> add= service.add_dosen(
                        upNamaDosen.getText().toString(),
                        upNidn.getText().toString(),
                        upAlamatDosen.getText().toString(),
                        upEmailDosen.getText().toString(),
                        upGelar.getText().toString(),
                        "kosongkan saja",
                        "72180188"
                );
                add.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Berhasil Di Update",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DosenUpdateActivity.this, DosenGetAllActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}