package com.demo;

/**
 * Classe concrete representant une voiture.
 * Demontre l'heritage : Voiture EST UN Vehicule.
 */
public class Voiture extends Vehicule {
    private Integer nombrePortes;
    private Boolean climatisation;

    public Voiture(String immatriculation, String marque, String modele,
                   Integer annee, TypeMoteur typeMoteur, Integer puissance,
                   Double consommation, Double tarifJournalier,
                   Integer nombrePortes, Boolean climatisation) {
        super(immatriculation, marque, modele, annee, typeMoteur, puissance,
              consommation, tarifJournalier);
        this.nombrePortes = nombrePortes;
        this.climatisation = climatisation;
    }

    @Override
    public void demarrer() {
        System.out.println("La voiture " + marque + " " + modele + " demarre en douceur.");
    }

    @Override
    protected String getTypeVehicule() {
        return "VOITURE";
    }

    // Getters
    public Integer getNombrePortes() {
        return nombrePortes;
    }

    public Boolean getClimatisation() {
        return climatisation;
    }

    @Override
    public String toString() {
        return super.toString() +
               "  " + nombrePortes + " portes | Climatisation : " +
               (climatisation ? "Oui" : "Non") + "\n" +
               "  Tarif : " + String.format("%.2f", tarifJournalier) + " EUR/jour | " +
               "Disponible : " + (disponible ? "Oui" : "Non");
    }
}
