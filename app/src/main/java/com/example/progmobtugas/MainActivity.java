package com.example.progmobtugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.progmobtugas.Pertemuan3.ListActivity;
import com.example.progmobtugas.Pertemuan3.RecyclerActivity;

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
        Button btnTracker = (Button) findViewById(R.id.btnTracker);

        //Variable pertemuan2
        Button btnList = (Button) findViewById(R.id.btnListView);
        Button btnRecycler = (Button) findViewById(R.id.btnRecyclerView);
        Button btnCard = (Button) findViewById(R.id.btnCardView);

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
                b.putString("help_string",myEditText.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProteinTracker.class);
                Bundle b = new Bundle();
                b.putString("trackerString",myEditText.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}