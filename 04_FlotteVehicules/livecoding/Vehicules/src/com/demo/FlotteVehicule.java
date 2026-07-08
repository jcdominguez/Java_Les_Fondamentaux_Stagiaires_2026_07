package com.demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class FlotteVehicule {

    private ArrayList<Vehicule> vehicules = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();


    static void main() {
        FlotteVehicule flotte = new FlotteVehicule();

        flotte.vehicules.add(new Voiture("AZ-1234", "Mercedes", "Sprinter",
                2000, true, 100, 5, true, new Moteur(TypeMoteur.ESSENCE, 120, 9.9f)));
        flotte.vehicules.add(new Voiture("AZ-1239", "Opel", "Sprinter",
                2000, true, 90, 5, true, new Moteur(TypeMoteur.ESSENCE, 120, 9.9f)));
        flotte.vehicules.add(new Voiture("BB-1234", "Renault", "Sprinter",
                2000, true, 180, 5, false, new Moteur(TypeMoteur.ESSENCE, 120, 9.9f)));

        flotte.vehicules.add(new Camion("Mercedes", "Sprinter", "XXX", 2026,true, 500,
        10, true, new Moteur(TypeMoteur.DIESEL, 120, 9.9f)));
        flotte.vehicules.add(new Camion("Mercedes", "Sprinter", "XXX", 2026,true, 500,
                10, true, new Moteur(TypeMoteur.ESSENCE, 120, 9.9f)));

        flotte.vehicules.add(new Moto("4576-ZD", "Suzuki", "XS12", 2020, true, 200
    , 250, "Sportive", new Moteur(TypeMoteur.ESSENCE, 120, 9.9f)));





        for (Vehicule v : flotte.vehicules){
            System.out.println(v);
            System.out.println(v.calculerTarif(7));
        }


        Client client1 = new Client("JC", "Duss", "04505050550");
        flotte.clients.add(client1);
        LocalDate dateDebut = LocalDate.of(2026, 8, 15);
        Reservation resa = new Reservation( client1,
                flotte.vehicules.get(0),
               dateDebut,
                7
        );
        flotte.reservations.add(resa);

        for(Reservation r : flotte.reservations){
            System.out.println(r);
        }

    }

}
