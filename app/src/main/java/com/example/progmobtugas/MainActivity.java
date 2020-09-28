package com.example.progmobtugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable
        final TextView txtView = (TextView) findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button) findViewById(R.id.button1);
        final EditText myEditText = (EditText) findViewById(R.id.editText1);
        Button btnHelp = (Button) findViewById(R.id.btnHelp);

        //action
        txtView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("COBA KLIK NICH",myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                Bundle b = new Bundle();
                b.putString("helpString",myEditText.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}