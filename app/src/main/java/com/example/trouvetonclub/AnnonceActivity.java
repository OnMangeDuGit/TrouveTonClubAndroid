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
import com.example.trouvetonclub.Metier.Annonce;
import com.example.trouvetonclub.Metier.Clubs;
import com.example.trouvetonclub.Metier.Joueur;
import com.example.trouvetonclub.Support.AnnonceBDDAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnnonceActivity extends AppCompatActivity {

    //Déclaration de la liste pour qu'elle soit accessible à toutes les methodes
    List<Clubs> lesClubs = new ArrayList<Clubs>();
    List<Joueur> lesJoueurs = new ArrayList<Joueur>();
    List<Annonce> lesAnnonces = new ArrayList<Annonce>();
    GestionBD sgbd = new GestionBD(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_annonce);

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;

        sgbd.open();
        initDonnees();
        adapter = new AnnonceBDDAdapter(lesAnnonces);
        recyclerView = findViewById(R.id.rcvAnnonce);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        Button acceuil =findViewById(R.id.retour_annonce);
        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(laSuite);
            }
        });
        Button profil = findViewById(R.id.button_prof);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), ProfilActivity.class);
                view.getContext().startActivity(laSuite);
            }

        });
        Button creer_annonce = findViewById(R.id.button_creer_annonce);
        creer_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), CreerAnnonceActivity.class);
                view.getContext().startActivity(laSuite);
                Log.i("butonCA", "Créer annonce ");
            }

        });
    }

    private void initDonnees() {
        Log.i("mainA","Teste Base :"+sgbd.testBaseAnnonce());
        if (sgbd.testBaseAnnonce() == 0){
            String fichier = lectureFichierLocal();
            recupAnnonce(fichier);
        }else{
            lesAnnonces=sgbd.donneLesAnnonces();
        }
    }

    private void recupAnnonce(String fichier) {
        Annonce uneAnnonce =null;
        String leLibelle, laDescription, lePoste_recherche, leclub;
        int leSalaire;
        JSONArray jsa = null;
        JSONObject jsAnnonces, jObj;
        if(fichier != null){
            try {
                jObj = new JSONObject(fichier);
                //Transformer l'objet global en tableau d'objet json
                jsa = jObj.getJSONArray("lesAnnonces"); //La clé en paramètre
                //Traitement du tableau json pour instancier des annonces et mal la liste
                for(int i=0; i<jsa.length(); i++){
                    //Récup l\'annonce à la ligne i
                    jsAnnonces = (JSONObject) jsa.get(i);
                    leLibelle = jsAnnonces.getString("libelle");
                    laDescription = jsAnnonces.getString("description");
                    lePoste_recherche = jsAnnonces.getString("poste_recherche");
                    leSalaire = Integer.parseInt(jsAnnonces.getString("salaire"));
                    leclub = jsAnnonces.getString("club");
                    // TODO : recup de la date
                    //instanciation de l\'annonce
                    //uneAnnonce = new Annonce(leLibelle,laDescription,lePoste_recherche,leSalaire);
                    uneAnnonce = new Annonce(leLibelle,laDescription,lePoste_recherche,1500,leclub);
                    //Ajout de l\'annonce dans la liste
                    lesAnnonces.add(uneAnnonce);
                }
                Log.i("initA", "les annonces : "+lesAnnonces.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String lectureFichierLocal() {
        StringBuilder builder = new StringBuilder();
        String ligne = null;
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.les_annonces)));
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

