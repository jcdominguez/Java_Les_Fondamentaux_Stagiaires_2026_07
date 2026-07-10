# TP 10b : Calculatrice Extensible - Interfaces fonctionnelles

## Introduction

Dans le TP 03, la calculatrice utilisait un `switch` : chaque nouvel operateur obligeait a rouvrir le code, ajouter un `case` et recompiler le moteur. Le comportement etait fige dans le code.

Dans ce TP, nous allons debloquer le super-pouvoir des lambdas : **du code qui se manipule comme une donnee**. Une operation devient une valeur qu'on range dans une variable, qu'on stocke dans une Map, qu'on passe en parametre...

Resultat : une calculatrice dont le moteur tient en 3 lignes, ne connait aucun operateur, et a laquelle on ajoute `^` ou `%` **a chaud, sans modifier une seule ligne existante**.

## Objectif

Apprendre a creer ses propres interfaces fonctionnelles et a manipuler des lambdas comme des **comportements ranges dans des variables et des collections**.


## Structure du projet

```
TP_CalculatriceExtensible/
├── enonce.md
├── src/
│   └── com/
│       └── demo/
│           ├── Operation.java        # Interface fonctionnelle (Partie 1)
│           ├── Calculatrice.java     # Moteur + Map d'operations (Partie 2 et 3)
│           └── RunCalculatrice.java  # Demonstration (classe principale)
└── out/
    └── production/
```

---

## Partie 1 : L'interface fonctionnelle

Commencons par creer le contrat que toutes nos operations vont respecter.

### Cahier des charges

Creer l'interface `Operation` :

```java
package com.demo;

@FunctionalInterface
public interface Operation {
    // TODO: declarer UNE methode abstraite
    // double appliquer(double a, double b);
}
```

Puis, dans `RunCalculatrice.java`, creer deux lambdas et les executer :

```java
Operation addition       = /* TODO: lambda qui additionne */;
Operation multiplication = /* TODO: lambda qui multiplie */;

System.out.println(addition.appliquer(3, 4));       // 7.0
System.out.println(multiplication.appliquer(3, 4)); // 12.0
```

**A retenir** : une interface fonctionnelle est une interface avec **une seule methode abstraite** (regle SAM : *Single Abstract Method*). C'est cette unicite qui permet d'ecrire une lambda : le compilateur sait quelle methode elle implemente.

L'annotation `@FunctionalInterface` est optionnelle : l'interface reste fonctionnelle sans elle. Mais elle est recommandee, car elle demande au compilateur de verifier la regle SAM — si un jour quelqu'un ajoute une deuxieme methode abstraite, le code ne compilera plus (erreur claire au bon endroit, plutot que sur la lambda).

---

## Partie 2 : Des comportements dans une Map

### Cahier des charges

Creer la classe `Calculatrice` :

- Un attribut `private final Map<Character, Operation> operations`
- Le constructeur enregistre 4 operations sous forme de lambdas :
  - `'+'`, `'-'`, `'*'`
  - `'/'` : si le diviseur vaut 0, lever une `ArithmeticException("Division par zero")`
- Une methode `calculer(double a, char op, double b)` :
  - cherche l'operation dans la Map
  - si l'operateur est inconnu, lever une `IllegalArgumentException`
  - sinon, executer l'operation et retourner le resultat

```java
package com.demo;

import java.util.HashMap;
import java.util.Map;

public class Calculatrice {

    private final Map<Character, Operation> operations = new HashMap<>();

    public Calculatrice() {
        // TODO: enregistrer '+', '-', '*', '/'
    }

    public double calculer(double a, char op, double b) {
        // TODO: 3 lignes suffisent
        return 0;
    }
}
```

**Observation cle** : le moteur `calculer()` ne connait **aucun** operateur. La Map contient des **comportements**, pas des donnees.

---

## Partie 3 : Extension a chaud

### Cahier des charges

Ajouter dans `Calculatrice` :

```java
public void ajouterOperation(char symbole, Operation operation) {
    // TODO
}
```

Puis, dans `RunCalculatrice.java`, ajouter deux nouveaux operateurs **sans toucher au moteur** :

- `'^'` : puissance (utiliser `Math.pow`)
- `'%'` : modulo

---

## Exemple d'execution

```
=== PARTIE 1 : lambdas dans des variables ===
addition.appliquer(3, 4)       = 7.0
multiplication.appliquer(3, 4) = 12.0

=== PARTIE 2 : la calculatrice ===
6.0 + 2.0 = 8.0
6.0 - 2.0 = 4.0
6.0 * 2.0 = 12.0
6.0 / 2.0 = 3.0

=== PARTIE 3 : extension a chaud ===
Ajout des operateurs '^' et '%'...
2.0 ^ 10.0 = 1024.0
7.0 % 3.0 = 1.0
```

## Indices / Rappels de syntaxe

### Lambda simple et lambda bloc

```java
// Expression simple : pas de return, pas d'accolades
Operation addition = (a, b) -> a + b;

// Bloc : accolades + return obligatoire
Operation division = (a, b) -> {
    if (b == 0) throw new ArithmeticException("Division par zero");
    return a / b;
};
```

### Map : enregistrer et retrouver

```java
Map<Character, Operation> operations = new HashMap<>();
operations.put('+', (a, b) -> a + b);

Operation op = operations.get('+');   // null si absent
```
