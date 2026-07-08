package com.demo;

/**
 * Classe representant un moteur de vehicule.
 * Utilisee en COMPOSITION par la classe Vehicule.
 * Le moteur n'existe pas independamment du vehicule.
 */
public class Moteur {
    private TypeMoteur type;
    private Integer puissance;      // en chevaux
    private Double consommation;    // L/100km ou kWh/100km

    public Moteur(TypeMoteur type, Integer puissance, Double consommation) {
        this.type = type;
        this.puissance = puissance;
        this.consommation = consommation;
    }

    // Getters
    public TypeMoteur getType() {
        return type;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public Double getConsommation() {
        return consommation;
    }

    @Override
    public String toString() {
        return type.getLibelle() + " " + puissance + "ch - " +
               consommation + " " + type.getUniteConsommation();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moteur moteur = (Moteur) obj;
        return type == moteur.type &&
               puissance.equals(moteur.puissance) &&
               consommation.equals(moteur.consommation);
    }
}
