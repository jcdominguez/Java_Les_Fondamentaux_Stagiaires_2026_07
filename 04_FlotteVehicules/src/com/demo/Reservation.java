package com.demo;

/**
 * Classe representant une reservation de vehicule.
 * Demontre l'ASSOCIATION : la reservation reference un vehicule et un client
 * qui existent independamment d'elle.
 */
public class Reservation {
    private Vehicule vehicule;  // ASSOCIATION : reference a un vehicule existant
    private Client client;      // ASSOCIATION : reference a un client existant
    private int nbJours;
    private String dateDebut;

    private static Integer compteurReservation = 0;
    private Integer numeroReservation;

    public Reservation(Vehicule vehicule, Client client, int nbJours, String dateDebut) {
        this.numeroReservation = ++compteurReservation;
        this.vehicule = vehicule;
        this.client = client;
        this.nbJours = nbJours;
        this.dateDebut = dateDebut;
        // Marquer le vehicule comme non disponible
        vehicule.setDisponible(false);
    }

    /**
     * Calcule le montant total de la reservation.
     * Utilise le polymorphisme : appelle calculerTarif() du vehicule concret.
     */
    public Double getMontantTotal() {
        return vehicule.calculerTarif(nbJours);
    }

    // Getters
    public Integer getNumeroReservation() {
        return numeroReservation;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public Client getClient() {
        return client;
    }

    public int getNbJours() {
        return nbJours;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * Annule la reservation et libere le vehicule.
     */
    public void annuler() {
        vehicule.setDisponible(true);
    }

    @Override
    public String toString() {
        return "=== Reservation N°" + numeroReservation + " ===\n" +
               "Client : " + client + "\n" +
               "Vehicule : " + vehicule.getDescription() + " - " + vehicule.getImmatriculation() + "\n" +
               "Date debut : " + dateDebut + "\n" +
               "Duree : " + nbJours + " jours\n" +
               "Montant total : " + String.format("%.2f", getMontantTotal()) + " EUR " +
               "(" + String.format("%.2f", vehicule.getTarifJournalier()) + " EUR/jour)";
    }
}
