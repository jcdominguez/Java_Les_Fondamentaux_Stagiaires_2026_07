package com.demo;

public class Client {

    private static int compteurId;

    private Integer id;

    private String prenom;
    private String nom;
    private String telephone;

    public Client(String prenom, String nom, String telephone) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;

        Client.compteurId++;
        this.id = Client.compteurId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
