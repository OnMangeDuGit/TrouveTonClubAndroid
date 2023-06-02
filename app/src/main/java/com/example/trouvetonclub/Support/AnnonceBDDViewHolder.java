package com.example.trouvetonclub.Support;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvetonclub.Metier.Annonce;
import com.example.trouvetonclub.R;
import com.example.trouvetonclub.SuiteActivity;

public class AnnonceBDDViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvAnnonce;
    public AnnonceBDDViewHolder(final View view) {
        super(view);
        tvAnnonce = (TextView) view.findViewById(R.id.tvAnnonce);
        tvAnnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), SuiteActivity.class);
                String lAnnonce = tvAnnonce.getText().toString();
                Log.i("avantDetail","->"+lAnnonce);
                String [] lesInfos = lAnnonce.split(" - ");
                Log.i("avantDetail","->"+lesInfos[1]+"---"+lesInfos[0]);
                laSuite.putExtra("lAnnonce", lesInfos[1]);
                laSuite.putExtra("laPosition", lesInfos[0]);
                view.getContext().startActivity(laSuite);
            }
        });
    }
    public void remplirViewHolder(String lesinfos) {
        tvAnnonce.setText(lesinfos);
    }
    public void remplirViewHolder(Annonce lAnnonce, int position) {
        String lesinfos = lAnnonce.getLibelle()+"\n Poste recherché : "+lAnnonce.getPoste_recherche()+"\n Salaire : "+lAnnonce.getSalaire()+
                "€\n Déscription : "+lAnnonce.getDescription()+"\n Le club : "+lAnnonce.getClub();
        Log.i("message","les infos : "+lesinfos.toString());
        //String ladescription = lAnnonce.getDescription();
        Log.i("ViewHolder", "position du clic");
        tvAnnonce.setText(position+" - "+lesinfos);
    }
}
