package com.example.trouvetonclub.Support;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvetonclub.R;
import com.example.trouvetonclub.Metier.Clubs;
//import com.example.trouvetonclub.SuiteActivity;
import com.example.trouvetonclub.SuiteActivityClub;

/*public class ClubsViewHolder extends RecyclerView.ViewHolder {
    private TextView club;
    private TextView  profil_club;

    public ClubsViewHolder(final View view) {
        super(view);
        club= (TextView)  view.findViewById(R.id.info_club);
        profil_club = (TextView) view.findViewById(R.id.profil);
        Intent clubs = new Intent(view.getContext(), com.example.trouvetonclub.ProfilActivity.class);
        String les_clubs = club.getText().toString();
        //laSuite.putExtra("lePilote",lePilote);
        view.getContext().startActivity(clubs);

    }

    public void remplirViewHolder(String leNom) {club.setText(leNom);
    }


    public void remplirViewHolder(Clubs leClub, int position) {
        String leNom =leClub.getNom_club()+""+leClub.getEmail() + leClub.getNum_tel()  + leClub.getCde_departement();
        Log.i("ViewHolder","position du clic"+position);
        club.setText(position+" - "+leNom);;
    }
}*/
public class ClubsViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvClub;
    public ClubsViewHolder(final View view) {
        super(view);
        tvClub = (TextView) view.findViewById(R.id.tvClub);
        tvClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent laSuite = new Intent(view.getContext(), SuiteActivityClub.class);
                String lClub = tvClub.getText().toString();
                String [] lesInfosC = lClub.split(" - ");
                laSuite.putExtra("lClub", lesInfosC[1]);
                laSuite.putExtra("laPosition", lesInfosC[0]);
                view.getContext().startActivity(laSuite);
            }
        });
    }
    public void remplirViewHolder(String lesinfosC) {
        tvClub.setText(lesinfosC);
    }
    public void remplirViewHolder(Clubs lClub, int position) {

        String lesinfosC ="Club : "+lClub.getNom_club()+"\nEmail : "+lClub.getEmail() +"\nDépartement : "+ lClub.getNum_tel()+"\nTéléphone "  + lClub.getCde_departement();
        Log.i("messageClub","les infos : "+lesinfosC.toString());
        Log.i("ViewHolderClub", "position du clic");
        tvClub.setText(position+" - "+lesinfosC);
    }
}
