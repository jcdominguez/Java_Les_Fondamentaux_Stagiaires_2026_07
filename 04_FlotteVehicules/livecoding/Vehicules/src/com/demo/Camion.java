package com.demo;

public class Camion extends Vehicule {

    private float capaciteTonnes;
    private boolean hayon;

    public Camion(String immatriculation, String marque, String modele, Integer annee, boolean disponible, Integer tarifJour,
                  float capaciteTonnes, boolean hayon, Moteur moteur) {
        super(immatriculation, marque, modele, annee, disponible, tarifJour, moteur);

        this.capaciteTonnes = capaciteTonnes;
        this.hayon = hayon;
    }

    public float getCapaciteTonnes() {
        return capaciteTonnes;
    }

    public void setCapaciteTonnes(float capaciteTonnes) {
        this.capaciteTonnes = capaciteTonnes;
    }

    public boolean isHayon() {
        return hayon;
    }

    public void setHayon(boolean hayon) {
        this.hayon = hayon;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "capaciteTonnes=" + capaciteTonnes +
                ", hayon=" + hayon +
                "} " + super.toString();
    }
}
