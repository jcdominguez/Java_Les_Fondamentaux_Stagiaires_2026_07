package com.demo;

/**
 * Enumeration representant les types de motorisation disponibles.
 * Demontre l'utilisation des enums avec attributs et methodes.
 */
public enum TypeMoteur {
    ESSENCE("Essence"),
    DIESEL("Diesel"),
    ELECTRIQUE("Electrique"),
    HYBRIDE("Hybride");

    private String libelle;

    TypeMoteur(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getUniteConsommation() {
        if (this == ELECTRIQUE) {
            return "kWh/100km";
        }
        return "L/100km";
    }
}
