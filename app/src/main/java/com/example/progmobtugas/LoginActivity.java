package com.example.progmobtugas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmobtugas.CrudDosen.MainDosenActivity;
import com.example.progmobtugas.Model.Login;
import com.example.progmobtugas.Network.GetDataService;
import com.example.progmobtugas.Network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ProgressDialog pd;
    String isLogin="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText txtNimLogin =(EditText)findViewById(R.id.txtNimLogin);
        EditText txtPass =(EditText)findViewById(R.id.txtPass);
        Button btnLogin =(Button)findViewById(R.id.btnLogin);
        pd=new ProgressDialog(LoginActivity.this);

        SharedPreferences pref = LoginActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        isLogin =pref.getString("isLogin","0");
        if(isLogin.equals("1")) {
            Intent intent = new Intent(LoginActivity.this, MenuUtamaActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Logging In");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                /*Call<List<Login>> login = service.Login(
                        txtNimLogin.getText().toString(),
                        txtPass.getText().toString()
                );*/
                Call<List<Login>> login = service.Login(
                        txtNimLogin.getText().toString(),
                        txtPass.getText().toString()
                );


                login.enqueue(new Callback<List<Login>>() {
                    @Override
                    public void onResponse(Call<List<Login>> call, Response<List<Login>> response) {
                        if (response.body().size() != 0) {
                            editor.putString("isLogin", "1");
                            editor.commit();
                            pd.dismiss();
                            Intent intent = new Intent(LoginActivity.this, MenuUtamaActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "failed", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Login>> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this,"Failed",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}