package com.example.trouvetonclub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    int[] lesPages = {
            R.layout.liste_annonce,
            R.layout.profil,
            R.layout.acceuil,
            R.layout.ajout_annonce,

    };

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
        Button profil = findViewById(R.id.profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), ProfilActivity.class);
                view.getContext().startActivity(laSuite);
            }

        });
        Button annonce = findViewById(R.id.annonce);
        annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent laSuite = new Intent(view.getContext(), AnnonceActivity.class);
                //view.getContext().startActivity(laSuite);
                Intent laSuite = new Intent(getApplicationContext(), AnnonceActivity.class);
                startActivity(laSuite);
            }
        });


    }
}
