package com.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Chaque operateur est une lambda rangee dans une Map.
 * Le moteur calculer() ne connait aucune operation : il cherche et execute.
 */
public class Calculatrice {

    private final Map<Character, Operation> operations = new HashMap<>();

    public Calculatrice() {
        operations.put('+', (a, b) -> a + b);
        operations.put('-', (a, b) -> a - b);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a, b) -> {
            if (b == 0) throw new ArithmeticException("Division par zero");
            return a / b;
        });
    }

    // Le "moteur" : ne connait aucun operateur
    public double calculer(double a, char op, double b) {
        Operation operation = operations.get(op);
        if (operation == null) throw new IllegalArgumentException("Operateur inconnu : " + op);
        return operation.appliquer(a, b);
    }

    // Extension a chaud : on ajoute un operateur SANS toucher au moteur
    public void ajouterOperation(char symbole, Operation operation) {
        operations.put(symbole, operation);
    }
}
