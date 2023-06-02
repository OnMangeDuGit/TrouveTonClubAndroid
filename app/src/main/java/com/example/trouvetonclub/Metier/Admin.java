package com.example.trouvetonclub.Metier;

public class Admin {
    private String nom_A;
    private String prenom_A;
    private String email_A;
    private String mdp_A;

    public Admin(String nom_A, String prenom_A, String email_A, String mdp_A) {
        this.nom_A = nom_A;
        this.prenom_A = prenom_A;
        this.email_A = email_A;
        this.mdp_A = mdp_A;
    }

    public String getNom_A() {
        return nom_A;
    }

    public void setNom_A(String nom_A) {
        this.nom_A = nom_A;
    }

    public String getPrenom_A() {
        return prenom_A;
    }

    public void setPrenom_A(String prenom_A) {
        this.prenom_A = prenom_A;
    }

    public String getEmail_A() {
        return email_A;
    }

    public void setEmail_A(String email_A) {
        this.email_A = email_A;
    }

    public String getMdp_A() {
        return mdp_A;
    }

    public void setMdp_A(String mdp_A) {
        this.mdp_A = mdp_A;
    }
}
