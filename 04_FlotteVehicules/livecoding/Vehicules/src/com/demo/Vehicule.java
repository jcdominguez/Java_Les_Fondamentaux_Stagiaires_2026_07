package com.demo;

public abstract class Vehicule implements Louable {

    private String immatriculation;
    private String marque;
    private String modele;
    private Integer annee;
    private boolean disponible;
    private Integer tarifJour;
    private Moteur moteur;


    public Vehicule(String immatriculation, String marque, String modele
            , Integer annee, boolean disponible, Integer tarifJour, Moteur moteur) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.disponible = disponible;
        this.tarifJour = tarifJour;
        this.moteur = moteur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getTarifJour() {
        return tarifJour;
    }

    public void setTarifJour(Integer tarifJour) {
        this.tarifJour = tarifJour;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "immatriculation='" + immatriculation + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", disponible=" + disponible +
                ", tarifJour=" + tarifJour +
                ", moteur=" + moteur +
                '}';
    }

    @Override
    public double calculerTarif(int nombreJours){
        return nombreJours * getTarifJour();
    }
}
