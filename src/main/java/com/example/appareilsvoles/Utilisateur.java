package com.example.appareilsvoles;

public  class Utilisateur {
    // attrivbuts de la classe en private
    private String matricule_utilisateur;
    private String nom_utilisateur;
    private String statut_utilisateur;
    private String mot_de_passe_utilisateur ;
    // constructeur
    public Utilisateur (String matricule_utilisateur, String nom_utilisateur, String statut_utilisateur, String mot_de_passe_utilisateur){
        this.matricule_utilisateur = matricule_utilisateur;
        this.nom_utilisateur = nom_utilisateur ;
        this.statut_utilisateur = statut_utilisateur ;
        this.mot_de_passe_utilisateur = mot_de_passe_utilisateur ;
    }
    public String getMatricule_utilisateur() {
        return matricule_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getMot_de_passe_utilisateur() {
        return mot_de_passe_utilisateur;
    }

    public String getStatut_utilisateur() {
        return statut_utilisateur;
    }

    public void setMatricule_utilisateur(String matricule_utilisateur) {
        this.matricule_utilisateur = matricule_utilisateur;
    }

    public void setMot_de_passe_utilisateur(String mot_de_passe_utilisateur) {
        this.mot_de_passe_utilisateur = mot_de_passe_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setStatut_utilisateur(String statut_utilisateur) {
        this.statut_utilisateur = statut_utilisateur;
    }

}
