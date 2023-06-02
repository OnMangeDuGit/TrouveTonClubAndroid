package com.example.trouvetonclub.Support;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvetonclub.R;
import com.example.trouvetonclub.Metier.Annonce;

import java.util.ArrayList;
import java.util.List;

public class AnnonceBDDAdapter extends RecyclerView.Adapter {

    private Context context;
    private Activity activity;
    List<Annonce> lesAnnonces = new ArrayList<Annonce>();

    public AnnonceBDDAdapter(List<Annonce> lesAnnonces) {
        this.lesAnnonces = lesAnnonces;
    }

    @NonNull
    @Override
    public AnnonceBDDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.annonce, parent, false);
        return new AnnonceBDDViewHolder(view);
    }

   /* @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Annonce lAnnonce = lesAnnonces.get(position);
        ((AnnonceViewHolder)holder).remplirViewHolder(lAnnonce, position);
    }*/

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Annonce lAnnonce = lesAnnonces.get(position);
        ((AnnonceBDDViewHolder)holder).remplirViewHolder(lAnnonce, position);
    }
    @Override
    public int getItemCount() {
        if(lesAnnonces != null) {
            return lesAnnonces.size();
        }
        else
            return 0;
    }
    /*
    class AnnonceViewHolder extends RecyclerView.ViewHolder {

        TextView annonce_id_txt, libelle_txt, poste_recherche_txt, description_txt, salaire_txt, club_txt;
        LinearLayout mainLayout;

        AnnonceBDDViewHolder(@NonNull View itemView) {
            super(itemView);
            annonce_id_txt = itemView.findViewById(R.id.annonce_id_txt);
            libelle_txt = itemView.findViewById(R.id.libelle_txt);
            poste_recherche_txt = itemView.findViewById(R.id.poste_recherche_txt);
            description_txt = itemView.findViewById(R.id.description_txt);
            salaire_txt = itemView.findViewById(R.id.salaire_txt);
            club_txt = itemView.findViewById(R.id.club_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }*/
}
