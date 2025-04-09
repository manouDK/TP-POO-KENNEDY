package com.example.appareilsvoles;
//  Ordinateur hérite de Appareil
public class Ordinateur extends Appareil {

    // Attributs ordinateur
    private String clavier_tel;
    private String port_tel;

    // Constructeur : on met les attributs propres et aussi les attributs de la super classe
    public Ordinateur(String clavier_tel, String port_tel,
                      String nom_appareil, String num_serie_appareil,
                      String marque_appareil, String couleur_appareil,
                      String description_appareil) {

        // Appel au constructeur de la classe mère Appareil
        super(nom_appareil, num_serie_appareil, marque_appareil, couleur_appareil, description_appareil);

        // Initialisation des attributs propres à Ordinateur
        this.clavier_tel = clavier_tel;
        this.port_tel = port_tel;
    }

    // Getters
    public String getClavier_tel() {
        return clavier_tel;
    }

    public String getPort_tel() {
        return port_tel;
    }

    // Setters
    public void setClavier_tel(String clavier_tel) {
        this.clavier_tel = clavier_tel;
    }

    public void setPort_tel(String port_tel) {
        this.port_tel = port_tel;
    }

    // Méthode spécifique pour indiquer le type de l'appareil
    @Override
    public String getType() {
        return "Ordinateur";
    }
}
