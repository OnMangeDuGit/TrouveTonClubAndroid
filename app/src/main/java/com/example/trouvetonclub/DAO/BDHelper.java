package com.example.trouvetonclub.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "TrouveTonClub.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME  = "annonce";
    private static final String COLUMN_ID = "id_annonce";
    private static final String LIBELLE = "libelle";
    private static final String POSTE_RECHERCHER = "poste_recherche";
    private static final String DESCRIPTION = "description";
    private static final String SALAIRE = "salaire";
    private static final String CLUB = "club_id";

    public BDHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LIBELLE + " TEXT, " +
                POSTE_RECHERCHER + " TEXT, " +
                DESCRIPTION + " TEXT, " +
                SALAIRE + " INTEGER, " +
                CLUB + " TEXT);";
        sqLiteDatabase.execSQL(query);



        String req2 = "create table club (" +
                "id_club integer, " +
                "nom_club text, " +
                "email_club text, " +
                "tel_club text, " +
                "cde_departement_club text," +
                "adresse_club text, "+
                "annonce_publie integer,"+
                "FOREIGN KEY(annonce_publie) REFERENCES annonce(id_annonce))";
        sqLiteDatabase.execSQL(req2);
        String req3 = "create table joueur (" +
                "id_joueur integer," +
                "nom_joueur text, " +
                "prenom_joueur text, " +
                "email_joueur text, " +
                "mdp_joueur text, " +
                "num_tel text, " +
                "poste_joueur text, " +
                "cde_departement text," +
                "annonce_postule integer," +
                "FOREIGN KEY(annonce_postule) REFERENCES annonce(id_annonce))";
        sqLiteDatabase.execSQL(req3);
        String req4 = "create table admin (" +
                "id_admin integer," +
                "nom_admin text, " +
                "prenom_admin text, " +
                "email_admin text, " +
                "mdp_admin text )";
        sqLiteDatabase.execSQL(req4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void ajouteAnnonce(String libelle, String description, String poste_recherche, int salaire, String club){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(LIBELLE, libelle);
        cv.put(POSTE_RECHERCHER, poste_recherche);
        cv.put(DESCRIPTION, description);
        cv.put(SALAIRE, salaire);
        cv.put(CLUB, club);
        long result = db.insert(TABLE_NAME,null,cv);
        //maBase.insert("annonce",null,cv);
        if (result == -1){
            Toast.makeText(context, "Erreur dans l'ajout de la donnée",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Ajout effectuer!", Toast.LENGTH_SHORT).show();
        }

        Log.i("result","insertion données suivantes : "+libelle+" "+poste_recherche+" "+description+" "+salaire+" "+club);
        Log.i("result3","result = "+result);
    }
    //methode pour la Modification d'une donnée
    public void modifAnnonce(String id_annonce, String libelle, String description, String poste_recherche, String salaire, String club) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LIBELLE, libelle);
        cv.put(POSTE_RECHERCHER, poste_recherche);
        cv.put(DESCRIPTION, description);
        cv.put(SALAIRE, salaire);
        cv.put(CLUB, club);
        long result = db.update(TABLE_NAME, cv, "annonce_id", new String[]{id_annonce});
        //maBase.insert("annonce",null,cv);
        if (result == -1) {
            Toast.makeText(context, "Erreur dans la modification de la donnée", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "modification effectuer!", Toast.LENGTH_SHORT).show();
        }

        Log.i("resultModif", "modification des données suivantes : " + libelle + " " + poste_recherche + " " + description + " " + salaire + " " + club);
        Log.i("resultModif2", "result = " + result);
    }
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    /*public void supprimmeLesAnnonces(){
        SQLiteDatabase db = this.getWritableDatabase();

        long resultDelete = db.delete("annonce","_id=?",null);
        if (resultDelete == -1){
            Toast.makeText(context, "Erreur pour supprimer la donnée",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Suppression effectuer!", Toast.LENGTH_SHORT).show();
        }
    }*/
    public void supprimmeLesAnnonces(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long resultDelete = db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
        if (resultDelete == -1){
            Toast.makeText(context, "Erreur pour supprimer la donnée",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Suppression effectuer!", Toast.LENGTH_SHORT).show();
        }
    }
}
