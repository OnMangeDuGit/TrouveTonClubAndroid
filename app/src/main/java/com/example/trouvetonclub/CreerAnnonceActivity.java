package com.example.trouvetonclub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trouvetonclub.DAO.BDHelper;

public class CreerAnnonceActivity extends AppCompatActivity {
    EditText libelle;
    EditText poste_recherche;
    EditText description;
    EditText salaire;
    EditText club;
    Button buttonSubmit;
    Button buttonDelete;


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
        setContentView(R.layout.ajout_annonce);

        // on recupère les données du formulaires
        libelle = findViewById(R.id.libelle_text);
        poste_recherche = findViewById(R.id.poste_recherche_text);
        description = findViewById(R.id.description_text);
        salaire = findViewById(R.id.salaire_int);
        club = findViewById(R.id.club_text);
        buttonSubmit = findViewById(R.id.valider_button);
        buttonDelete = findViewById(R.id.effacer_button);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            /*public void onClick(View v) {

                // Get the values entered by the user
                String Libelle = libelle.getText().toString();
                String Poste_recherche = poste_recherche.getText().toString();
                String Description = description.getText().toString();
                String Salaire = salaire.getText().toString();
                String Club = club.getText().toString();


                // Validate the user input
                if (TextUtils.isEmpty(Libelle)) {
                    libelle.setError("le libelle est obligatoire");
                    libelle.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Poste_recherche)) {
                    poste_recherche.setError("le poste_recherche est obligatoire");
                    poste_recherche.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Description)) {
                    description.setError("la description est obligatoire");
                    description.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Salaire)) {
                    salaire.setError("le salaire est obligatoire");
                    salaire.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Club)) {
                    club.setError("le Club est obligatoire");
                    club.requestFocus();
                    return;
                }

                // Insertion des données dans la base de données
                //mydb.ajouteAnnonce(libelle, poste_recherche, description, salaire, club);

                // Affichage d'un message de confirmation
                Toast.makeText(CreerAnnonceActivity.this, "Données enregistrées avec succès !", Toast.LENGTH_SHORT).show();
            }*/
            public void onClick(View v) {
                BDHelper mydb = new BDHelper(CreerAnnonceActivity.this);
                mydb.ajouteAnnonce(
                        libelle.getText().toString().trim(),
                        poste_recherche.getText().toString().trim(),
                        description.getText().toString().trim(),
                        Integer.valueOf(salaire.getText().toString().trim()),
                        club.getText().toString().trim());
                Log.i("mydb", "mydb" + mydb);
                Log.i("value","Value des données suivantes : "+libelle+" "+poste_recherche+" "+description+" "+salaire+" "+club);

            }
        });
        // Gestion du clic sur le bouton Effacer
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Effacement des données du formulaire
                libelle.setText("");
                poste_recherche.setText("");
                description.setText("");
                salaire.setText("");
                club.setText("");
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

