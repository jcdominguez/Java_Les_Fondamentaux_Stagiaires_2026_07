package com.demo;

public class Moteur {

    private TypeMoteur type;
    private int puissance;
    private float consommation;

    public Moteur(TypeMoteur type, int puissance, float consommation) {
        this.type = type;
        this.puissance = puissance;
        this.consommation = consommation;
    }

    public TypeMoteur getType() {
        return type;
    }

    public void setType(TypeMoteur type) {
        this.type = type;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public float getConsommation() {
        return consommation;
    }

    public void setConsommation(float consommation) {
        this.consommation = consommation;
    }

    @Override
    public String toString() {
        return "Moteur{" +
                "type=" + type +
                ", puissance=" + puissance +
                ", consommation=" + consommation +
                '}';
    }
}
