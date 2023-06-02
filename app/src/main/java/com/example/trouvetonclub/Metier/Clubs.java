package com.example.trouvetonclub.Metier;

public class Clubs {
    private String nom_club;
    private String Email;
    private String Num_tel;
    private String Cde_departement;
    private String adresse_club;




    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setNum_tel(String num_tel) {
        this.Num_tel = num_tel;
    }

    public void setCde_departement(String cde_departement) {
        this.Cde_departement = Cde_departement;
    }

    public void setAdresse_club(String adresse_club) {
        this.adresse_club = adresse_club;
    }

    public String getEmail() {
        return Email;
    }

    public String getNum_tel() {
        return Num_tel;
    }

    public String getCde_departement() {
        return Cde_departement;
    }

    public String getNom_club() {
        return nom_club;
    }

    public String getAdresse_club() {
        return adresse_club;
    }

    public Clubs(String nom_club, String email,  String Num_tel,String cde_departement,String adresse_club) {
        this.nom_club = nom_club;
        this.Email = email;
        this.Cde_departement = cde_departement;
        this.Num_tel = Num_tel;
        this.adresse_club = adresse_club;

    }

    public String toString() {
        return nom_club + " " + Email + "  " + Num_tel + " " + Cde_departement + " "+adresse_club;
    }

    public void add(Clubs unClub) {
    }
}



