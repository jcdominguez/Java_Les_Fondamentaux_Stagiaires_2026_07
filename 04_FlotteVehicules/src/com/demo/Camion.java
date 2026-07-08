package com.demo;

/**
 * Classe concrete representant un camion.
 * Demontre l'heritage : Camion EST UN Vehicule.
 */
public class Camion extends Vehicule {
    private Double capaciteTonnes;
    private Boolean hayon;

    public Camion(String immatriculation, String marque, String modele,
                  Integer annee, TypeMoteur typeMoteur, Integer puissance,
                  Double consommation, Double tarifJournalier,
                  Double capaciteTonnes, Boolean hayon) {
        super(immatriculation, marque, modele, annee, typeMoteur, puissance,
              consommation, tarifJournalier);
        this.capaciteTonnes = capaciteTonnes;
        this.hayon = hayon;
    }

    @Override
    public void demarrer() {
        System.out.println("Le camion " + marque + " " + modele + " demarre avec un grondement sourd.");
    }

    @Override
    protected String getTypeVehicule() {
        return "CAMION";
    }

    // Getters
    public Double getCapaciteTonnes() {
        return capaciteTonnes;
    }

    public Boolean getHayon() {
        return hayon;
    }

    @Override
    public String toString() {
        return super.toString() +
               "  Capacite : " + capaciteTonnes + " tonnes | Hayon : " +
               (hayon ? "Oui" : "Non") + "\n" +
               "  Tarif : " + String.format("%.2f", tarifJournalier) + " EUR/jour | " +
               "Disponible : " + (disponible ? "Oui" : "Non");
    }
}
