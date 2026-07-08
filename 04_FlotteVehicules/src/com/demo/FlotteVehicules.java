package com.demo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale du systeme de gestion de flotte de vehicules.
 * Demontre :
 * - Polymorphisme (parcours de liste avec appels polymorphiques)
 * - Upcasting (Vehicule v = new Voiture(...))
 * - Downcasting avec instanceof
 * - Utilisation des wrappers pour les statistiques
 */
public class FlotteVehicules {
    private ArrayList<Vehicule> vehicules;
    private ArrayList<Reservation> reservations;
    private Scanner scanner;

    public FlotteVehicules() {
        vehicules = new ArrayList<>();
        reservations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Initialise la flotte avec des vehicules de demonstration.
     * Demontre l'UPCASTING : on stocke des Voiture, Moto, Camion dans une liste de Vehicule.
     */
    public void initialiserFlotte() {
        // UPCASTING : Voiture -> Vehicule
        vehicules.add(new Voiture("AA-123-BB", "Renault", "Clio", 2022,
                TypeMoteur.ESSENCE, 90, 6.5, 45.0, 5, true));

        vehicules.add(new Voiture("GG-111-HH", "Peugeot", "308", 2023,
                TypeMoteur.ELECTRIQUE, 156, 15.0, 55.0, 5, true));

        // UPCASTING : Moto -> Vehicule
        vehicules.add(new Moto("CC-456-DD", "Yamaha", "MT-07", 2023,
                TypeMoteur.ESSENCE, 75, 4.2, 35.0, 689, "Roadster"));

        vehicules.add(new Moto("II-222-JJ", "BMW", "R1250GS", 2022,
                TypeMoteur.ESSENCE, 136, 5.1, 85.0, 1254, "Trail"));

        // UPCASTING : Camion -> Vehicule
        vehicules.add(new Camion("EE-789-FF", "Mercedes", "Actros", 2021,
                TypeMoteur.DIESEL, 400, 28.0, 120.0, 20.0, true));

        System.out.println("Initialisation de la flotte avec " + vehicules.size() + " vehicules...\n");
    }

    /**
     * Affiche l'inventaire complet.
     * Demontre le POLYMORPHISME : toString() est appele sur chaque vehicule
     * mais execute la version specifique (Voiture, Moto ou Camion).
     */
    public void afficherInventaire() {
        System.out.println("\n=== INVENTAIRE COMPLET ===\n");
        for (Vehicule v : vehicules) {
            System.out.println(v);  // Appel polymorphique de toString()
            System.out.println();
        }
    }

    /**
     * Recherche par type de vehicule.
     * Demontre le DOWNCASTING avec instanceof.
     */
    public void rechercherParType() {
        System.out.println("\n=== RECHERCHE PAR TYPE ===");
        System.out.print("Quel type ? (1=Voiture, 2=Moto, 3=Camion) : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        System.out.println();
        int count = 0;

        for (Vehicule v : vehicules) {
            boolean match = false;

            // DOWNCASTING avec instanceof
            if (choix == 1 && v instanceof Voiture) {
                Voiture voiture = (Voiture) v;  // Downcasting explicite
                System.out.println("- " + v.getDescription() + " | " + v.getImmatriculation());
                System.out.println("  " + voiture.getNombrePortes() + " portes, Clim: " +
                        (voiture.getClimatisation() ? "Oui" : "Non"));
                match = true;
            } else if (choix == 2 && v instanceof Moto) {
                Moto moto = (Moto) v;  // Downcasting explicite
                System.out.println("- " + v.getDescription() + " | " + v.getImmatriculation());
                System.out.println("  " + moto.getCylindree() + " cc, Type: " + moto.getTypeMoto());
                match = true;
            } else if (choix == 3 && v instanceof Camion) {
                Camion camion = (Camion) v;  // Downcasting explicite
                System.out.println("- " + v.getDescription() + " | " + v.getImmatriculation());
                System.out.println("  " + camion.getCapaciteTonnes() + " tonnes, Hayon: " +
                        (camion.getHayon() ? "Oui" : "Non"));
                match = true;
            }

            if (match) count++;
        }

        if (count == 0) {
            System.out.println("Aucun vehicule de ce type trouve.");
        } else {
            System.out.println("\n" + count + " vehicule(s) trouve(s).");
        }
    }

    /**
     * Affiche les vehicules disponibles.
     */
    public void afficherDisponibles() {
        System.out.println("\n=== VEHICULES DISPONIBLES ===\n");
        int count = 0;

        for (Vehicule v : vehicules) {
            if (v.getDisponible()) {  // Utilisation du wrapper Boolean
                System.out.println("- " + v.getDescription() + " | " + v.getImmatriculation() +
                        " | " + String.format("%.2f", v.getTarifJournalier()) + " EUR/jour");
                count++;
            }
        }

        System.out.println("\n" + count + " vehicule(s) disponible(s) sur " + vehicules.size() + ".");
    }

    /**
     * Cree une nouvelle reservation.
     * Demontre l'ASSOCIATION entre Reservation, Vehicule et Client.
     */
    public void creerReservation() {
        System.out.println("\n=== NOUVELLE RESERVATION ===");
        System.out.print("Immatriculation du vehicule : ");
        String immat = scanner.nextLine();

        Vehicule vehiculeTrouve = null;
        for (Vehicule v : vehicules) {
            if (v.getImmatriculation().equalsIgnoreCase(immat)) {
                vehiculeTrouve = v;
                break;
            }
        }

        if (vehiculeTrouve == null) {
            System.out.println("Vehicule non trouve.");
            return;
        }

        if (!vehiculeTrouve.getDisponible()) {
            System.out.println("Ce vehicule n'est pas disponible.");
            return;
        }

        System.out.println("Vehicule trouve : " + vehiculeTrouve.getDescription());

        // Demarrage du vehicule (polymorphisme)
        vehiculeTrouve.demarrer();

        System.out.print("\nNom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Telephone : ");
        String tel = scanner.nextLine();
        System.out.print("Nombre de jours : ");
        int nbJours = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date de debut (JJ/MM/AAAA) : ");
        String date = scanner.nextLine();

        // Creation du client et de la reservation (ASSOCIATION)
        Client client = new Client(nom, tel);
        Reservation reservation = new Reservation(vehiculeTrouve, client, nbJours, date);

        System.out.println("\n--- RECAPITULATIF ---");
        System.out.println("Client : " + client);
        System.out.println("Vehicule : " + vehiculeTrouve.getDescription() + " - " + vehiculeTrouve.getImmatriculation());
        System.out.println("Duree : " + nbJours + " jours");
        System.out.println("Montant total : " + String.format("%.2f", reservation.getMontantTotal()) +
                " EUR (" + String.format("%.2f", vehiculeTrouve.getTarifJournalier()) + " EUR/jour)");

        System.out.print("\nConfirmer la reservation ? (o/n) : ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("o")) {
            reservations.add(reservation);
            System.out.println("\nReservation enregistree !");
            System.out.println("Le vehicule " + immat + " n'est plus disponible.");
        } else {
            vehiculeTrouve.setDisponible(true);  // Annuler la reservation
            System.out.println("Reservation annulee.");
        }
    }

    /**
     * Affiche toutes les reservations.
     */
    public void afficherReservations() {
        System.out.println("\n=== LISTE DES RESERVATIONS ===\n");

        if (reservations.isEmpty()) {
            System.out.println("Aucune reservation enregistree.");
            return;
        }

        for (Reservation r : reservations) {
            System.out.println(r);
            System.out.println();
        }
    }

    /**
     * Compare deux vehicules.
     * Demontre l'utilisation de equals() redefini.
     */
    public void comparerVehicules() {
        System.out.println("\n=== COMPARAISON DE VEHICULES ===");
        System.out.print("Immatriculation vehicule 1 : ");
        String immat1 = scanner.nextLine();
        System.out.print("Immatriculation vehicule 2 : ");
        String immat2 = scanner.nextLine();

        Vehicule v1 = null, v2 = null;
        for (Vehicule v : vehicules) {
            if (v.getImmatriculation().equalsIgnoreCase(immat1)) v1 = v;
            if (v.getImmatriculation().equalsIgnoreCase(immat2)) v2 = v;
        }

        if (v1 == null || v2 == null) {
            System.out.println("Un ou plusieurs vehicules non trouves.");
            return;
        }

        // Utilisation de equals() redefini
        if (v1.equals(v2)) {
            System.out.println("\nLes deux vehicules sont identiques (meme immatriculation).");
        } else {
            System.out.println("\nLes deux vehicules sont differents.");
            System.out.println("Comparaison :");
            System.out.println("- " + v1.getDescription() + " : " +
                    String.format("%.2f", v1.getTarifJournalier()) + " EUR/jour, " +
                    v1.getMoteur());
            System.out.println("- " + v2.getDescription() + " : " +
                    String.format("%.2f", v2.getTarifJournalier()) + " EUR/jour, " +
                    v2.getMoteur());
        }
    }

    /**
     * Affiche les statistiques de la flotte.
     * Demontre l'utilisation des WRAPPERS (Integer, Double) pour les calculs.
     */
    public void afficherStatistiques() {
        System.out.println("\n=== STATISTIQUES DE LA FLOTTE ===");

        Integer nbVoitures = 0;
        Integer nbMotos = 0;
        Integer nbCamions = 0;
        Integer nbDisponibles = 0;
        Integer totalPuissance = 0;
        Double totalTarif = 0.0;

        for (Vehicule v : vehicules) {
            // Comptage par type avec instanceof
            if (v instanceof Voiture) nbVoitures++;
            else if (v instanceof Moto) nbMotos++;
            else if (v instanceof Camion) nbCamions++;

            // Comptage disponibles
            if (v.getDisponible()) nbDisponibles++;

            // Sommes pour moyennes (utilisation des wrappers)
            totalPuissance += v.getMoteur().getPuissance();  // unboxing Integer -> int
            totalTarif += v.getTarifJournalier();            // unboxing Double -> double
        }

        Integer nbTotal = vehicules.size();
        Integer nbLoues = nbTotal - nbDisponibles;
        Double puissanceMoyenne = totalPuissance.doubleValue() / nbTotal;
        Double tarifMoyen = totalTarif / nbTotal;

        System.out.println("Nombre total de vehicules : " + nbTotal);
        System.out.println("  - Voitures : " + nbVoitures);
        System.out.println("  - Motos : " + nbMotos);
        System.out.println("  - Camions : " + nbCamions);
        System.out.println("Vehicules disponibles : " + nbDisponibles);
        System.out.println("Vehicules loues : " + nbLoues);
        System.out.println("Puissance moyenne : " + puissanceMoyenne.intValue() + " ch");
        System.out.println("Tarif moyen : " + String.format("%.2f", tarifMoyen) + " EUR/jour");
    }

    /**
     * Affiche le menu principal et gere les choix.
     */
    public void lancerMenu() {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Afficher l'inventaire complet");
            System.out.println("2. Rechercher par type de vehicule");
            System.out.println("3. Afficher les vehicules disponibles");
            System.out.println("4. Creer une reservation");
            System.out.println("5. Afficher les reservations");
            System.out.println("6. Comparer deux vehicules");
            System.out.println("7. Statistiques de la flotte");
            System.out.println("8. Quitter");
            System.out.print("\nVotre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    afficherInventaire();
                    break;
                case 2:
                    rechercherParType();
                    break;
                case 3:
                    afficherDisponibles();
                    break;
                case 4:
                    creerReservation();
                    break;
                case 5:
                    afficherReservations();
                    break;
                case 6:
                    comparerVehicules();
                    break;
                case 7:
                    afficherStatistiques();
                    break;
                case 8:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        System.out.println("\nMerci d'avoir utilise le systeme de gestion de flotte !");
        scanner.close();
    }

    /**
     * Point d'entree du programme.
     */
    public static void main(String[] args) {
        System.out.println("=== SYSTEME DE GESTION DE FLOTTE ===\n");

        FlotteVehicules flotte = new FlotteVehicules();
        flotte.initialiserFlotte();
        flotte.lancerMenu();
    }
}
