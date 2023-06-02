package com.example.trouvetonclub.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.trouvetonclub.Metier.Admin;
import com.example.trouvetonclub.Metier.Clubs;
import com.example.trouvetonclub.Metier.Joueur;
import com.example.trouvetonclub.Metier.Annonce;


import java.util.ArrayList;
import java.util.List;

public class GestionBD {
    BDHelper bdHelper;
    SQLiteDatabase maBase;

    public GestionBD(Context context){
        this.bdHelper = new BDHelper(context);
    }

    public void open(){
        maBase = bdHelper.getWritableDatabase();
    }
    public void close(){
        maBase.close();
    }

    //-----------------------------------Partie Club -----------------------------------------------

    public void ajouteClub(Clubs unClub){
        ContentValues cv = new ContentValues();
        cv.put("nom",unClub.getNom_club());
        cv.put("email",unClub.getEmail());
        cv.put("telephone",unClub.getNum_tel());
        cv.put("departement",unClub.getCde_departement());
        cv.put("adresse",unClub.getAdresse_club());
        maBase.insert("club",null,cv);
    }
    public int testBaseClub(){
        String req = "select count(*) from club";
        Cursor cursor = maBase.rawQuery(req,null,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public List<Clubs> donneLesClub()  {
        List<Clubs> lesClubs = new ArrayList<Clubs>();
        String req ="select * from club order by nom" ;
        //le cursor est une structure (en RAM) qui contient les pilotes
        Cursor cursor =maBase.rawQuery(req,null,null);
        //Tant qu'il reste sur le cursor
        while (cursor.moveToNext()){
            String leNom = cursor.getString(0);
            String email = cursor.getString(1);
            String leTelephone = cursor.getString(2);
            String leDepartement = cursor.getString(3);
            String ladresse = cursor.getString(4);
            Clubs unClub = new Clubs(leNom, email,leTelephone,leDepartement, ladresse);
            lesClubs.add(unClub);
        }
        return lesClubs;

    }
    public void supprimmeLesClubs(){
        maBase.delete("club",null,null);
    }

    //-----------------------------------Partie Annonce --------------------------------------------
    public void ajouteAnnonce(Annonce uneAnnonce){
        ContentValues cv = new ContentValues();
        cv.put("libelle",uneAnnonce.getLibelle());
        cv.put("description",uneAnnonce.getDescription());
        cv.put("poste_recherche",uneAnnonce.getPoste_recherche());
        cv.put("salaire",uneAnnonce.getSalaire());
        cv.put("club",uneAnnonce.getClub());
        maBase.insert("annonce",null,cv);
    }
    public int testBaseAnnonce(){
        String req = "select count(*) from annonce";
        Cursor cursor = maBase.rawQuery(req,null,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public List<Annonce> donneLesAnnonces()  {
        List<Annonce> lesAnnonces = new ArrayList<Annonce>();
        String req ="select * from annonce order by libelle" ;
        //le cursor est une structure (en RAM) qui contient les pilotes
        Cursor cursor =maBase.rawQuery(req,null,null);
        //Tant qu'il reste sur le cursor
        while (cursor.moveToNext()){
            String leLibelle = cursor.getString(1);
            String laDescription = cursor.getString(2);
            String lePoste_recherche = cursor.getString(3);
            int leSalaire = cursor.getInt(4);
            String leClub = cursor.getString(5);
            Annonce uneAnnonce = new Annonce(leLibelle, laDescription,lePoste_recherche,leSalaire, leClub);
            lesAnnonces.add(uneAnnonce);

        }
        return lesAnnonces;

    }
    public void supprimmeLesAnnonces(){
        maBase.delete("annonce",null,null);
    }

    //-----------------------------------Partie Joueur ---------------------------------------------
    public void ajouteJoueur(Joueur unJoueur){
        ContentValues cv = new ContentValues();
        cv.put("nom",unJoueur.getNom_joueur());
        cv.put("prenom",unJoueur.getPrenom());
        cv.put("email",unJoueur.getEmail());
        cv.put("telephone",unJoueur.getNum_tel());
        cv.put("departement",unJoueur.getCde_departement());
        maBase.insert("joueur",null,cv);
    }
    public int testBaseJoueur(){
        String req = "select count(*) from joueur";
        Cursor cursor = maBase.rawQuery(req,null,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public List<Joueur> donneLesJoueurs()  {
        List<Joueur> lesJoueurs = new ArrayList<Joueur>();
        String req ="select * from joueur order by nom" ;
        //le cursor est une structure (en RAM) qui contient les pilotes
        Cursor cursor =maBase.rawQuery(req,null,null);
        //Tant qu'il reste sur le cursor
        while (cursor.moveToNext()){
            String leNom = cursor.getString(0);
            String lePrenom = cursor.getString(1);
            String email = cursor.getString(2);
            String leTelephone = cursor.getString(3);
            String leDepartement = cursor.getString(4);
            Joueur unJoueur = new Joueur(leNom, lePrenom, email,leTelephone,leDepartement);
            lesJoueurs.add(unJoueur);
        }
        return lesJoueurs;

    }
    public void supprimmeLesJoueurs(){
        maBase.delete("joueur",null,null);
    }
    //-----------------------------------Partie Admin ----------------------------------------------
    public void ajouteAdmin(Admin unAdmin){
        ContentValues cv = new ContentValues();
        cv.put("nom",unAdmin.getNom_A());
        cv.put("prenom",unAdmin.getPrenom_A());
        cv.put("email",unAdmin.getEmail_A());
        cv.put("mot_de_passe",unAdmin.getMdp_A());
        maBase.insert("admin",null,cv);
    }
    public int testBaseAdmin(){
        String req = "select count(*) from admin";
        Cursor cursor = maBase.rawQuery(req,null,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }
    public void supprimmeLesAdmins(){
        maBase.delete("admin",null,null);
    }
}
