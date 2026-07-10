package com.demo;

public class RunCalculatrice {

    public static void main(String[] args) {
        // --- Partie 1 : des lambdas dans des variables ---
        System.out.println("=== PARTIE 1 : lambdas dans des variables ===");

        Operation addition       = (a, b) -> a + b;
        Operation multiplication = (a, b) -> a * b;

        System.out.println("addition.appliquer(3, 4)       = " + addition.appliquer(3, 4));
        System.out.println("multiplication.appliquer(3, 4) = " + multiplication.appliquer(3, 4));

        // --- Partie 2 : la calculatrice ---
        System.out.println("\n=== PARTIE 2 : la calculatrice ===");

        Calculatrice calc = new Calculatrice();
        System.out.println("6.0 + 2.0 = " + calc.calculer(6, '+', 2));
        System.out.println("6.0 - 2.0 = " + calc.calculer(6, '-', 2));
        System.out.println("6.0 * 2.0 = " + calc.calculer(6, '*', 2));
        System.out.println("6.0 / 2.0 = " + calc.calculer(6, '/', 2));

        // --- Partie 3 : extension a chaud ---
        System.out.println("\n=== PARTIE 3 : extension a chaud ===");
        System.out.println("Ajout des operateurs '^' et '%'...");

        calc.ajouterOperation('^', (a, b) -> Math.pow(a, b));
        calc.ajouterOperation('%', (a, b) -> a % b);

        System.out.println("2.0 ^ 10.0 = " + calc.calculer(2, '^', 10));
        System.out.println("7.0 % 3.0 = " + calc.calculer(7, '%', 3));
    }
}
