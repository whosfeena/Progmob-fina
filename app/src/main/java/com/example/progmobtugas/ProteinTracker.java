package com.example.progmobtugas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProteinTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_tracker);
        TextView txtTracker = (TextView) findViewById(R.id.textViewHelp);
        Bundle b = getIntent().getExtras();
    }
}