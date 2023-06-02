package com.example.trouvetonclub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuiteActivityClub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        Bundle extras = getIntent().getExtras();
        String lClub = extras.getString("lClub");
        int position = Integer.parseInt(extras.getString("laPosition"));
        TextView mtv = findViewById(R.id.mtvClub);
        mtv.setText(lClub);


    }
}