package com.example.trouvetonclub.Metier;

public class Annonce {

    private String libelle;
    private String poste_recherche;
    private String description;
    private int salaire;
    private String club;



    public Annonce(String libelle, String poste_recherche, String description, int salaire, String club) {
        this.libelle = libelle;
        this.poste_recherche = poste_recherche;
        this.description = description;
        this.salaire = salaire;
        this.club = club;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPoste_recherche() {
        return poste_recherche;
    }

    public void setPoste_recherche(String poste_recherche) {
        this.poste_recherche = poste_recherche;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getSalaire() {

        return salaire;
    }

    public void setSalaire(int salaire) {

        this.salaire = salaire;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
