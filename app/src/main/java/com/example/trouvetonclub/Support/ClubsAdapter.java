package com.example.trouvetonclub.Support;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvetonclub.Metier.Annonce;
import com.example.trouvetonclub.Metier.Clubs;
import com.example.trouvetonclub.R;

import java.util.ArrayList;
import java.util.List;

/*public class ClubsAdapter extends RecyclerView.Adapter {
    private final List<Clubs> lesClubs;

    public ClubsAdapter(List<Clubs> lesClubs) {
        this.lesClubs = lesClubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.profil, parent, false);
        return  new com.example.trouvetonclub.Support.ClubsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        if(lesClubs != null) {
            return lesClubs.size();
        }
        else
            return 0;
    }*/
    public class ClubsAdapter extends RecyclerView.Adapter {

        List<Clubs> lesClubs = new ArrayList<Clubs>();

        public ClubsAdapter(List<Clubs> lesClubs) {
            this.lesClubs = lesClubs;
        }

        @NonNull
        @Override
        public ClubsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.club, parent, false);
            return new ClubsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Clubs lClub = lesClubs.get(position);
            ((ClubsViewHolder)holder).remplirViewHolder(lClub, position);
        }

        @Override
        public int getItemCount() {
            if(lesClubs != null) {
                return lesClubs.size();
            }
            else
                return 0;
        }
}
