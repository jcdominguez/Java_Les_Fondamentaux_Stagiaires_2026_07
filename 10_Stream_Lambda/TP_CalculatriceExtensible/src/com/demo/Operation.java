package com.demo;

/**
 * Interface fonctionnelle : une seule methode abstraite (SAM).
 * L'annotation @FunctionalInterface est optionnelle mais recommandee :
 * le compilateur verifie la regle et refuse de compiler sinon.
 */
@FunctionalInterface
public interface Operation {
    double appliquer(double a, double b);
}
