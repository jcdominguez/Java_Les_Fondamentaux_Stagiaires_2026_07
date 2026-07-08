package com.demo;

/**
 * Classe concrete representant une moto.
 * Demontre l'heritage : Moto EST UN Vehicule.
 */
public class Moto extends Vehicule {
    private Integer cylindree;  // en cc
    private String typeMoto;    // Roadster, Sportive, Trail, Custom...

    public Moto(String immatriculation, String marque, String modele,
                Integer annee, TypeMoteur typeMoteur, Integer puissance,
                Double consommation, Double tarifJournalier,
                Integer cylindree, String typeMoto) {
        super(immatriculation, marque, modele, annee, typeMoteur, puissance,
              consommation, tarifJournalier);
        this.cylindree = cylindree;
        this.typeMoto = typeMoto;
    }

    @Override
    public void demarrer() {
        System.out.println("La moto " + marque + " " + modele + " vrombrit !");
    }

    @Override
    protected String getTypeVehicule() {
        return "MOTO";
    }

    // Getters
    public Integer getCylindree() {
        return cylindree;
    }

    public String getTypeMoto() {
        return typeMoto;
    }

    @Override
    public String toString() {
        return super.toString() +
               "  " + cylindree + " cc | Type : " + typeMoto + "\n" +
               "  Tarif : " + String.format("%.2f", tarifJournalier) + " EUR/jour | " +
               "Disponible : " + (disponible ? "Oui" : "Non");
    }
}
