package com.example.appareilsvoles;

public abstract class Appareil {
    // declaration des attributs de Appareil  en private
    private String nom_appareil;
    private String num_serie_appareil ;
    private String marque_appareil ;
    private String couleur_appareil ;
    private  String description_appareil;
    // constructeur de Appareil
    public Appareil (String nom_appareil, String num_serie_appareil, String marque_appareil, String couleur_appareil, String description_appareil){
       this.nom_appareil = nom_appareil ;
       this.num_serie_appareil = num_serie_appareil ;
       this.marque_appareil = marque_appareil ;
       this.couleur_appareil = couleur_appareil ;
       this.description_appareil = description_appareil;
    }
    // les methodes get et set  : les getters permettent de retourner les attributs déclarés en private et les setters permettent
    // de modifier les attributs de la classe déclarés en private
    public String getDescription_appareil() {
        return description_appareil;
    }

    public void setDescription_appareil(String description_appareil) {
        this.description_appareil = description_appareil;
    }

    public String getMarque_appareil() {
        return marque_appareil;
    }

    public String getCouleur_appareil() {
        return couleur_appareil;
    }

    public String getNom_appareil() {
        return nom_appareil;
    }

    public String getNum_serie_appareil() {
        return num_serie_appareil;
    }

    public void setCouleur_appareil(String couleur_appareil) {
        this.couleur_appareil = couleur_appareil;
    }

    public void setMarque_appareil(String marque_appareil) {
        this.marque_appareil = marque_appareil;
    }

    public void setNom_appareil(String nom_appareil) {
        this.nom_appareil = nom_appareil;
    }

    public void setNum_serie_appareil(String num_serie_appareil) {
        this.num_serie_appareil = num_serie_appareil;
    }
    // Méthode que les sous-classes peuvent personnaliser
    public abstract String getType();

}
