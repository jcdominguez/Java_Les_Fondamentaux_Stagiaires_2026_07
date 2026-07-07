# TP 04 : Gestion d'une Flotte de Vehicules

## Objectif

Creer un systeme de gestion de flotte de vehicules pour une entreprise de location, en mettant en pratique les concepts fondamentaux de la programmation orientee objet en Java.

**Concepts a valider :**
- Composition et associations entre objets
- Heritage et polymorphisme
- Classes abstraites et interfaces
- Redefinition des methodes `toString()` et `equals()`
- Utilisation des classes enveloppes (Wrappers)
- Enumerations

## Structure du projet

```
04_FlotteVehicules/
├── src/
│   └── com/
│       └── demo/
│           ├── TypeMoteur.java
│           ├── Moteur.java
│           ├── Louable.java
│           ├── Vehicule.java
│           ├── Voiture.java
│           ├── Moto.java
│           ├── Camion.java
│           ├── Client.java
│           ├── Reservation.java
│           └── FlotteVehicules.java
├── out/
│   └── production/
│       └── com/
│           └── demo/
│               └── *.class
└── enonce.md
```

## Cahier des charges

Creer un ensemble de classes Java modelisant une flotte de vehicules avec les fonctionnalites suivantes :

### Classes a creer

1. **`TypeMoteur`** (enum) : Types de motorisation (ESSENCE, DIESEL, ELECTRIQUE, HYBRIDE)
2. **`Moteur`** : Caracteristiques du moteur (type, puissance, consommation)
3. **`Louable`** (interface) : Contrat pour le calcul de tarif de location
4. **`Vehicule`** (abstraite) : Classe parent de tous les vehicules
5. **`Voiture`**, **`Moto`**, **`Camion`** : Classes concretes heritant de Vehicule
6. **`Client`** : Informations sur un client
7. **`Reservation`** : Association entre un vehicule et un client
8. **`FlotteVehicules`** : Classe principale avec le menu interactif

### Fonctionnalites du menu

1. Afficher l'inventaire complet des vehicules
2. Rechercher par type de vehicule (Voiture/Moto/Camion)
3. Afficher les vehicules disponibles
4. Creer une reservation
5. Afficher les reservations
6. Comparer deux vehicules
7. Afficher les statistiques de la flotte
8. Quitter

## Contraintes techniques

Vous **devez obligatoirement** implementer :

| Concept | Utilisation attendue |
|---------|---------------------|
| **Composition** | `Vehicule` contient un `Moteur` (cree dans le constructeur) |
| **Association** | `Reservation` reference un `Vehicule` et un `Client` |
| **Heritage** | `Voiture`, `Moto`, `Camion` heritent de `Vehicule` |
| **Classe abstraite** | `Vehicule` avec methode abstraite `demarrer()` |
| **Interface** | `Louable` definit `calculerTarif(int nbJours)` |
| **Polymorphisme** | Parcours d'une liste de `Vehicule` avec appels polymorphiques |
| **Upcasting** | `Vehicule v = new Voiture(...)` |
| **Downcasting** | `if (v instanceof Voiture) { Voiture voit = (Voiture) v; }` |
| **`toString()`** | Redefinition dans chaque classe pour affichage lisible |
| **`equals()`** | Comparaison de vehicules par immatriculation |
| **Wrappers** | `Integer` pour annee/puissance, `Double` pour tarifs |
| **Enum** | `TypeMoteur` avec methode `getLibelle()` |

## Architecture des classes

```
                     Louable (interface)
                         ^
                         | implements
                         |
    Moteur <--------- Vehicule (abstraite)
   (composition)         ^
                        /|\
                       / | \
                      /  |  \
               Voiture  Moto  Camion


    Client <-------- Reservation --------> Vehicule
              (association)         (association)
```

### Detail des attributs

**TypeMoteur (enum)** :
- ESSENCE, DIESEL, ELECTRIQUE, HYBRIDE
- Methode `getLibelle()` retournant le nom en francais

**Moteur** :
- `type` : TypeMoteur
- `puissance` : Integer (en chevaux)
- `consommation` : Double (L/100km ou kWh/100km)

**Vehicule (abstraite)** :
- `immatriculation` : String
- `marque` : String
- `modele` : String
- `annee` : Integer
- `disponible` : Boolean
- `tarifJournalier` : Double
- `moteur` : Moteur (composition)
- Methode abstraite : `demarrer()`

**Voiture** : herite de Vehicule
- `nombrePortes` : Integer
- `climatisation` : Boolean

**Moto** : herite de Vehicule
- `cylindree` : Integer (en cc)
- `typeMoto` : String (Roadster, Sportive, Trail...)

**Camion** : herite de Vehicule
- `capaciteTonnes` : Double
- `hayon` : Boolean

**Client** :
- `id` : Integer
- `nom` : String
- `telephone` : String

**Reservation** :
- `vehicule` : Vehicule (association)
- `client` : Client (association)
- `nbJours` : int
- `dateDebut` : String

## Exemple d'execution

```
=== SYSTEME DE GESTION DE FLOTTE ===

Initialisation de la flotte avec 5 vehicules...

=== MENU PRINCIPAL ===
1. Afficher l'inventaire complet
2. Rechercher par type de vehicule
3. Afficher les vehicules disponibles
4. Creer une reservation
5. Afficher les reservations
6. Comparer deux vehicules
7. Statistiques de la flotte
8. Quitter

Votre choix : 1

=== INVENTAIRE COMPLET ===

[VOITURE] AA-123-BB | Renault Clio (2022)
  Moteur : Essence 90ch - 6.5 L/100km
  5 portes | Climatisation : Oui
  Tarif : 45.00 EUR/jour | Disponible : Oui

[MOTO] CC-456-DD | Yamaha MT-07 (2023)
  Moteur : Essence 75ch - 4.2 L/100km
  689 cc | Type : Roadster
  Tarif : 35.00 EUR/jour | Disponible : Oui

[CAMION] EE-789-FF | Mercedes Actros (2021)
  Moteur : Diesel 400ch - 28.0 L/100km
  Capacite : 20.0 tonnes | Hayon : Oui
  Tarif : 120.00 EUR/jour | Disponible : Oui

[VOITURE] GG-111-HH | Peugeot 308 (2023)
  Moteur : Electrique 156ch - 15.0 kWh/100km
  5 portes | Climatisation : Oui
  Tarif : 55.00 EUR/jour | Disponible : Oui

[MOTO] II-222-JJ | BMW R1250GS (2022)
  Moteur : Essence 136ch - 5.1 L/100km
  1254 cc | Type : Trail
  Tarif : 85.00 EUR/jour | Disponible : Oui

Votre choix : 2

=== RECHERCHE PAR TYPE ===
Quel type ? (1=Voiture, 2=Moto, 3=Camion) : 1

Vehicules de type VOITURE :
- [VOITURE] AA-123-BB | Renault Clio (2022)
- [VOITURE] GG-111-HH | Peugeot 308 (2023)

Votre choix : 4

=== NOUVELLE RESERVATION ===
Immatriculation du vehicule : AA-123-BB
Vehicule trouve : Renault Clio

Nom du client : Martin Dupont
Telephone : 0612345678
Nombre de jours : 7
Date de debut (JJ/MM/AAAA) : 15/01/2025

--- RECAPITULATIF ---
Client : Martin Dupont (0612345678)
Vehicule : [VOITURE] Renault Clio - AA-123-BB
Duree : 7 jours
Montant total : 315.00 EUR (45.00 EUR/jour)

Confirmer la reservation ? (o/n) : o

Reservation enregistree !
Le vehicule AA-123-BB n'est plus disponible.

Votre choix : 6

=== COMPARAISON DE VEHICULES ===
Immatriculation vehicule 1 : AA-123-BB
Immatriculation vehicule 2 : GG-111-HH

Les deux vehicules sont differents.
Comparaison :
- Renault Clio : 45.00 EUR/jour, Essence 90ch
- Peugeot 308 : 55.00 EUR/jour, Electrique 156ch

Votre choix : 7

=== STATISTIQUES DE LA FLOTTE ===
Nombre total de vehicules : 5
  - Voitures : 2
  - Motos : 2
  - Camions : 1
Vehicules disponibles : 4
Vehicules loues : 1
Puissance moyenne : 171 ch
Tarif moyen : 68.00 EUR/jour

Votre choix : 8

Merci d'avoir utilise le systeme de gestion de flotte !
```

## Indices / Rappels de syntaxe

### Enumeration avec methode
```java
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
}
```

### Classe abstraite
```java
public abstract class Vehicule implements Louable {
    // attributs...

    public abstract void demarrer();  // methode abstraite

    // methodes concretes...
}
```

### Interface
```java
public interface Louable {
    Double calculerTarif(int nbJours);
    String getDescription();
}
```

### Composition (creation dans le constructeur)
```java
public class Vehicule {
    private Moteur moteur;  // composition

    public Vehicule(String immat, TypeMoteur type, Integer puissance, Double conso) {
        this.moteur = new Moteur(type, puissance, conso);  // cree ici
    }
}
```

### Association (reference passee en parametre)
```java
public class Reservation {
    private Vehicule vehicule;  // association
    private Client client;      // association

    public Reservation(Vehicule vehicule, Client client) {
        this.vehicule = vehicule;  // reference existante
        this.client = client;
    }
}
```

### Redefinition de toString()
```java
@Override
public String toString() {
    return "[VOITURE] " + immatriculation + " | " + marque + " " + modele;
}
```

### Redefinition de equals()
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Vehicule other = (Vehicule) obj;
    return immatriculation.equals(other.immatriculation);
}
```

### Downcasting avec instanceof
```java
for (Vehicule v : flotte) {
    if (v instanceof Voiture) {
        Voiture voiture = (Voiture) v;
        System.out.println("Portes : " + voiture.getNombrePortes());
    } else if (v instanceof Moto) {
        Moto moto = (Moto) v;
        System.out.println("Cylindree : " + moto.getCylindree() + " cc");
    }
}
```

### Classes enveloppes (Wrappers)
```java
Integer puissance = 90;        // autoboxing : int -> Integer
int p = puissance;             // unboxing : Integer -> int

Double tarif = 45.50;
String s = tarif.toString();   // methode de la classe wrapper

Integer annee = Integer.valueOf("2024");  // parsing
```

## Criteres de validation

Avant de consulter la solution, verifiez que votre programme :

- [ ] Compile sans erreur
- [ ] Tous les fichiers sont dans le package `com.demo`
- [ ] L'enum `TypeMoteur` possede une methode `getLibelle()`
- [ ] L'interface `Louable` definit `calculerTarif()` et `getDescription()`
- [ ] La classe `Vehicule` est abstraite et implemente `Louable`
- [ ] La classe `Vehicule` a une methode abstraite `demarrer()`
- [ ] `Voiture`, `Moto`, `Camion` heritent de `Vehicule`
- [ ] La composition `Vehicule`-`Moteur` est correcte (moteur cree dans le constructeur)
- [ ] L'association `Reservation`-`Vehicule`-`Client` est correcte
- [ ] `toString()` est redefinie dans toutes les classes
- [ ] `equals()` est redefinie dans `Vehicule` (comparaison par immatriculation)
- [ ] Le polymorphisme est utilise pour l'affichage et le calcul de tarif
- [ ] `instanceof` et le downcasting sont utilises pour la recherche par type
- [ ] Les wrappers (`Integer`, `Double`, `Boolean`) sont utilises
- [ ] Le menu interactif fonctionne correctement
- [ ] Les reservations modifient la disponibilite des vehicules

## Solution

La solution est disponible dans le dossier `src/com/demo/`.

Fichiers :
- `src/com/demo/TypeMoteur.java`
- `src/com/demo/Moteur.java`
- `src/com/demo/Louable.java`
- `src/com/demo/Vehicule.java`
- `src/com/demo/Voiture.java`
- `src/com/demo/Moto.java`
- `src/com/demo/Camion.java`
- `src/com/demo/Client.java`
- `src/com/demo/Reservation.java`
- `src/com/demo/FlotteVehicules.java`
