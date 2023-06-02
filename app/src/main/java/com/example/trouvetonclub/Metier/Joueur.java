package com.example.trouvetonclub.Metier;

public class Joueur {

    private String nom_joueur;
    private String prenom;
    private String email;
    private String num_tel;
    private String cde_departement;

    public Joueur(String nom_joueur, String prenom, String email, String num_tel, String cde_departement) {
        this.nom_joueur = nom_joueur;
        this.prenom = prenom;
        this.email = email;
        this.num_tel = num_tel;
        this.cde_departement = cde_departement;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getCde_departement() {
        return cde_departement;
    }

    public void setCde_departement(String cde_departement) {
        this.cde_departement = cde_departement;
    }
}
