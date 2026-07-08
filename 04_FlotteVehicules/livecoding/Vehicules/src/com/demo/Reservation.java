package com.demo;

import java.time.LocalDate;

public class Reservation {

    private Client client;
    private Vehicule vehicule;
    private LocalDate dateDebut;
    private int nombreJour;

    public Reservation(Client client, Vehicule vehicule, LocalDate dateDebut, int nombreJour) {
        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.nombreJour = nombreJour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getNombreJour() {
        return nombreJour;
    }

    public void setNombreJour(int nombreJour) {
        this.nombreJour = nombreJour;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "client=" + client +
                ", vehicule=" + vehicule +
                ", dateDebut=" + dateDebut +
                ", nombreJour=" + nombreJour +
                '}';
    }
}
