package com.demo;

/**
 * Classe representant un client de l'entreprise de location.
 * Demontre l'utilisation des wrappers et la redefinition de toString/equals.
 */
public class Client {
    private Integer id;
    private String nom;
    private String telephone;

    private static Integer compteurId = 0;

    public Client(String nom, String telephone) {
        this.id = ++compteurId;
        this.nom = nom;
        this.telephone = telephone;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return nom + " (Tel: " + telephone + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id.equals(client.id);
    }
}
