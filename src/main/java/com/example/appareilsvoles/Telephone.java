package com.example.appareilsvoles;


public class Telephone extends Appareil{
    // attributs de la classe
    private String addresse_mac ;
    private String reseau_cellulaire ;
    // constructeurs
    public Telephone(String adresse_mac, String reseau_cellulaire, String nom_appareil,
                     String num_serie_appareil, String marque_appareil, String couleur_appareil,
                     String description_appareil) {
        super(nom_appareil, num_serie_appareil, marque_appareil, couleur_appareil, description_appareil);
        this.addresse_mac = adresse_mac;
        this.reseau_cellulaire = reseau_cellulaire;
    }
    // getteurs et setteurs
    public String getReseau_cellulaire() {
        return reseau_cellulaire;
    }

    public String getAddresse_mac() {
        return addresse_mac;
    }

    public void setAddresse_mac(String addresse_mac) {
        this.addresse_mac = addresse_mac;
    }

    public void setReseau_cellulaire(String reseau_cellulaire) {
        this.reseau_cellulaire = reseau_cellulaire;
    }

    @Override
    public String getType() {
        return "";
    }
}
