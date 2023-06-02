package com.example.trouvetonclub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvetonclub.DAO.GestionBD;
import com.example.trouvetonclub.Metier.Clubs;
import com.example.trouvetonclub.Metier.Joueur;
import com.example.trouvetonclub.Support.ClubsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfilActivity extends AppCompatActivity {
    //Déclaration de la liste pour qu'elle soit accessible à toutes les methodes
    List<Clubs> lesAnnonces= new ArrayList<Clubs>();
    List<Joueur> lesJoueurs = new ArrayList<Joueur>();
    List<Clubs> lesClubs = new ArrayList<Clubs>();
    GestionBD sgbd = new GestionBD(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;

        sgbd.open();
        initDonnees();
        adapter = new ClubsAdapter(lesClubs);
        recyclerView = findViewById(R.id.info_club);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        Button acceuil =findViewById(R.id.accueil   );
        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(laSuite);
            }
        });
        Button annonce = findViewById(R.id.annonce2);
        annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), AnnonceActivity.class);
                view.getContext().startActivity(laSuite);
            }

        });
    }

    private void initDonnees() {
        Log.i("main","Teste Base :"+sgbd.testBaseClub());
        if (sgbd.testBaseClub() == 0){
            String fichier = lectureFichierLocal();
            recupClub(fichier);
        }else{
            lesClubs=sgbd.donneLesClub();
        }
    }

    private void recupClub(String fichier) {
        Clubs unClub =null;
        String nom_club, email_club,cde_departement,Num_tel,adresse_club ;
        JSONArray jsa = null;
        JSONObject jsClub, jObj;
        if(fichier != null){
            try {
                jObj = new JSONObject(fichier);
                //Transformer l'objet global en tableau d'objet json
                jsa = jObj.getJSONArray("lesClubs"); //La clé en paramètre
                //Traitement du tableau json pour instancier des annonces et mal la liste
                for(int i=0; i<jsa.length(); i++){
                    //Récup l\'annonce à la ligne i
                    jsClub = (JSONObject) jsa.get(i);
                    nom_club = jsClub.getString("nom_club");
                    email_club = jsClub.getString("email_club");
                    Num_tel = jsClub.getString("num_tel");
                    cde_departement =jsClub.getString("cde_departement");
                    // Num_tel = Integer.parseInt(jsAnnonces.getString("salaire"));
                    adresse_club =jsClub.getString("adresse_club");
                    // TODO : recup de la date
                    //instanciation de l\'annonce
                    //uneAnnonce = new Annonce(leLibelle,laDescription,lePoste_recherche,leSalaire);
                    unClub = new Clubs(nom_club,email_club,cde_departement,Num_tel,adresse_club);
                    //Ajout de l\'annonce dans la liste
                    lesClubs.add(unClub);
                }
                Log.i("initA", "les clubs: "+lesClubs.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String lectureFichierLocal() {
        StringBuilder builder = new StringBuilder();
        String ligne = null;
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.les_clubs)));
        try {
            while ((ligne = br.readLine())!= null){
                builder.append(ligne).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("Main","recup fichier : "+builder.toString());
        return builder.toString();

    }


}
