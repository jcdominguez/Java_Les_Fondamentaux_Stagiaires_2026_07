package com.demo;

public class Moto extends Vehicule {

    private int cylindree;
    private String typeMoto; // Sportive, ...

    public Moto(String immatriculation, String marque, String modele, Integer annee, boolean disponible, Integer tarifJour
    , int cylindree, String typeMoto, Moteur moteur) {
        super(immatriculation, marque, modele, annee, disponible, tarifJour, moteur);

        this.cylindree = cylindree;
        this.typeMoto = typeMoto;
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    public String getTypeMoto() {
        return typeMoto;
    }

    public void setTypeMoto(String typeMoto) {
        this.typeMoto = typeMoto;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cylindree=" + cylindree +
                ", typeMoto='" + typeMoto + '\'' +
                "} " + super.toString();
    }
}
