package com.example.trouvetonclub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trouvetonclub.DAO.BDHelper;

public class SuiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.annonce_detail);
        Bundle extras = getIntent().getExtras();
        String lAnnonce = extras.getString("lAnnonce");
        Log.i("suite","->"+lAnnonce);
        int position = Integer.parseInt(extras.getString("laPosition"));
        Log.i("suite","->"+position);
        TextView mtv = findViewById(R.id.mtvAnnonce);
        mtv.setText(lAnnonce);


        Button modif_annonce = findViewById(R.id.modifier_button);
        modif_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), ModifAnnonceActivity.class);
                view.getContext().startActivity(laSuite);
            }
        });
        Button supp_annonce = findViewById(R.id.supprimer_button);
        supp_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDHelper mydb = new BDHelper(SuiteActivity.this);
                mydb.supprimmeLesAnnonces(

                Log.i("mydb", "mydb" + mydb));
               // Log.i("value","Value des données suivantes : "+libelle+" "+poste_recherche+" "+description+" "+salaire+" "+club);

            }
        });
        Button list_annonce = findViewById(R.id.retour_annonce);
        list_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), AnnonceActivity.class);
                view.getContext().startActivity(laSuite);
            }

        });


    }
}