package com.example.trouvetonclub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trouvetonclub.DAO.BDHelper;

import java.nio.charset.StandardCharsets;

public class ModifAnnonceActivity extends AppCompatActivity {
    EditText libelle_input;
    EditText poste_recherche_input;
    EditText description_input;
    EditText salaire_input;
    EditText club_input;
    Button buttonSubmit;
    Button buttonDelete;

    String id_annonce;
    String libelle;
    String poste_recherche;
    String description;
    String salaire;
    String club;
    @Override
  /*  protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_annonce);

        // Get references to the form elements
        libelle = findViewById(R.id.libelle_text);
        poste_recherche = findViewById(R.id.poste_recherche_text);
        description = findViewById(R.id.description_text);
        salaire = findViewById(R.id.salaire_text);
        club = findViewById(R.id.club_text);
        buttonSubmit = findViewById(R.id.valider_button);
        buttonDelete = findViewById(R.id.effacer_button);
        public void onClick(View v) {
            BDHelper mydb = new BDHelper(CreerAnnonceActivity.this, "annonce",null,1 );
            mydb.ajouteAnnonce(
                    libelle.getText().toString().trim(),
                    poste_recherche.getText().toString().trim(),
                    description.getText().toString().trim()
                    Integer.valueOf(salaire.getText().toString().trim()),
                    club.getText().toString().trim());
        }

    }*/

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.modif_annonce);

        //First we call this
      //  getAndSetIntentData();

        // on recupère les données du formulaires
        libelle_input = findViewById(R.id.modif_libelle_text);
        poste_recherche_input = findViewById(R.id.modif_poste_recherche_text);
        description_input = findViewById(R.id.modif_description_text);
        salaire_input = findViewById(R.id.modif_salaire_int);
        club_input = findViewById(R.id.modif_club_text);
        buttonSubmit = findViewById(R.id.validerModif_button);
        buttonDelete = findViewById(R.id.effacer_button);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDHelper mydb = new BDHelper(ModifAnnonceActivity.this);
                libelle = libelle_input.getText().toString().trim();
                poste_recherche = poste_recherche_input.getText().toString().trim();
                description = description_input.getText().toString().trim();
                salaire = String.valueOf(Integer.valueOf(salaire_input.getText().toString().trim()));
                club = club_input.getText().toString().trim();
                mydb.modifAnnonce(id_annonce,libelle, poste_recherche, description, salaire, club);
                Log.d("donnéesModif", libelle+" "+poste_recherche+" "+description+" "+salaire+" "+club);
            }
        });
        /*private void getAndSetIntentData(){
            if(getIntent().hasExtra("id_annonce") && getIntent().hasExtra("libelle") &&
                    getIntent().hasExtra("poste_recherche") && getIntent().hasExtra("description") &&
                    getIntent().hasExtra("salaire")&& getIntent().hasExtra("club")){
                //Getting Data from Intent
                id_annonce = getIntent().getStringExtra("id_annonce");
                libelle = getIntent().getStringExtra("libelle");
                poste_recherche = getIntent().getStringExtra("poste_recherche");
                description = getIntent().getStringExtra("description");
                salaire = getIntent().getStringExtra("salaire");
                club = getIntent().getStringExtra("club");


                //Setting Intent Data
                libelle_input.setText(libelle);
                poste_recherche_input.setText(poste_recherche);
                description_input.setText(description);
                salaire_input.setText(salaire);
                club_input.setText(club);
                Log.d("donnéesModif", libelle+" "+poste_recherche+" "+description+" "+salaire+" "+club);
            }else {
                Toast.makeText(this, "Pas de données.", Toast.LENGTH_SHORT).show();
            }
        }*/

        // Gestion du clic sur le bouton Effacer
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Effacement des données du formulaire
                libelle_input.setText("");
                poste_recherche_input.setText("");
                description_input.setText("");
                salaire_input.setText("");
                club_input.setText("");
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

 /*   private void ajouteAnnonce(EditText libelle, EditText poste_recherche, EditText description, EditText salaire, EditText club) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
            cv.put("libelle", String.valueOf(libelle));
            cv.put("description", String.valueOf(description));
            cv.put("poste recherche",String.valueOf(poste_recherche));
            cv.put("salaire",String.valueOf(salaire));
            cv.put("club",String.valueOf(club));
            maBase.insert("annonce",null,cv);
        }

    private SQLiteDatabase getWritableDatabase() {
    }*/
    //String query = "INSERT INTO annonce (libelle, poste_recherche,description,salaire,club) VALUES (Libelle,Poste_recherche,Description,Salaire,Club)";

}

