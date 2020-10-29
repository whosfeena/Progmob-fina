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

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);

        final EditText upNimLama = (EditText)findViewById(R.id.upNimLama);
        final EditText upNama = (EditText)findViewById(R.id.upNama);
        final EditText upNim = (EditText)findViewById(R.id.upNim);
        final EditText upAlamat = (EditText)findViewById(R.id.upAlamat);
        final EditText upEmail = (EditText)findViewById(R.id.upEmail);
        Button btnUpdt = (Button) findViewById(R.id.btnUpdt);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);
        Intent data = getIntent(); //
        if (data!=null){
            upNimLama.setText(data.getStringExtra("nim"));
            upNama.setText(data.getStringExtra("nama"));
            upNim.setText(data.getStringExtra("nim"));
            upAlamat.setText(data.getStringExtra("alamat"));
            upEmail.setText(data.getStringExtra("email"));
        }



        btnUpdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> del= service.delete_mhs(
                        upNimLama.getText().toString(),
                        "72180188"

                );
                GetDataService services = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = services.update_mhs(
                        upNama.getText().toString(),
                        upNim.getText().toString(),
                        upAlamat.getText().toString(),
                        upEmail.getText().toString(),
                        "Kosongkan aja soalnya sembarang dirandom sistem",
                        "72180188"
                );

                del.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(MahasiswaUpdateActivity.this,"Berhasil Update", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Error!",Toast.LENGTH_LONG).show();
                    }
                });

                Call<DefaultResult> add= service.add_mhs(
                        upNama.getText().toString(),
                        upNim.getText().toString(),
                        upAlamat.getText().toString(),
                        upEmail.getText().toString(),
                        "kosongkan saja",
                        "72180188"
                );
                add.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Berhasil disimpan",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MahasiswaUpdateActivity.this, MahasiswaGetAllActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}