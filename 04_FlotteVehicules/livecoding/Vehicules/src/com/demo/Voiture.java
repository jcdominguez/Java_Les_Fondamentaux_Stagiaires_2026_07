package com.demo;

public class Voiture extends Vehicule {

    private int nombrePortes;
    private boolean clim;

    public Voiture(String immatriculation, String marque, String modele, Integer annee, boolean disponible, Integer tarifJour
            , int nombrePortes, boolean clim, Moteur moteur) {
        super(immatriculation, marque, modele, annee, disponible, tarifJour, moteur);

        this.nombrePortes = nombrePortes;
        this.clim = clim;
    }

    public int getNombrePortes() {
        return nombrePortes;
    }

    public void setNombrePortes(int nombrePortes) {
        this.nombrePortes = nombrePortes;
    }

    public boolean isClim() {
        return clim;
    }

    public void setClim(boolean clim) {
        this.clim = clim;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "nombrePortes=" + nombrePortes +
                ", clim=" + clim +
                "} " + super.toString();
    }


}
