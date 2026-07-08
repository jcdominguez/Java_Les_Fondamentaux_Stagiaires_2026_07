package com.demo;

/**
 * Classe abstraite representant un vehicule generique.
 * Demontre :
 * - Classe abstraite avec methode abstraite
 * - Implementation d'interface (Louable)
 * - Composition (contient un Moteur)
 * - Utilisation des Wrappers
 * - Redefinition de toString() et equals()
 */
public abstract class Vehicule implements Louable {
    protected String immatriculation;
    protected String marque;
    protected String modele;
    protected Integer annee;
    protected Boolean disponible;
    protected Double tarifJournalier;
    protected Moteur moteur;    // COMPOSITION : le moteur appartient au vehicule

    public Vehicule(String immatriculation, String marque, String modele,
                    Integer annee, TypeMoteur typeMoteur, Integer puissance,
                    Double consommation, Double tarifJournalier) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.disponible = true;
        this.tarifJournalier = tarifJournalier;
        // COMPOSITION : le moteur est cree ici, il n'existe pas sans le vehicule
        this.moteur = new Moteur(typeMoteur, puissance, consommation);
    }

    /**
     * Methode abstraite : chaque type de vehicule demarre differemment.
     */
    public abstract void demarrer();

    /**
     * Implementation de l'interface Louable.
     */
    @Override
    public Double calculerTarif(int nbJours) {
        return tarifJournalier * nbJours;
    }

    @Override
    public String getDescription() {
        return marque + " " + modele + " (" + annee + ")";
    }

    // Getters et Setters
    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Integer getAnnee() {
        return annee;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Double getTarifJournalier() {
        return tarifJournalier;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    /**
     * Redefinition de equals() : deux vehicules sont egaux s'ils ont la meme immatriculation.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Vehicule)) return false;
        Vehicule vehicule = (Vehicule) obj;
        return immatriculation.equals(vehicule.immatriculation);
    }

    /**
     * Retourne le type de vehicule pour l'affichage.
     */
    protected abstract String getTypeVehicule();

    @Override
    public String toString() {
        return "[" + getTypeVehicule() + "] " + immatriculation + " | " +
               marque + " " + modele + " (" + annee + ")\n" +
               "  Moteur : " + moteur + "\n";
    }
}
