package fr.eni.enchere.Enum.Vetements;

import fr.eni.enchere.Enum.Auto.Marque;

public class Vetement {

    private Coupe coupe;
    private Taille taille;
    private TypeVet typeVet;
    private Marque marque;

    public Vetement(Coupe coupe, Taille taille, TypeVet typeVet, Marque marque) {
        this.coupe = coupe;
        this.taille = taille;
        this.typeVet = typeVet;
        this.marque = marque;
    }

    public Coupe getCoupe() {
        return coupe;
    }

    public void setCoupe(Coupe coupe) {
        this.coupe = coupe;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public TypeVet getTypeVet() {
        return typeVet;
    }

    public void setTypeVet(TypeVet typeVet) {
        this.typeVet = typeVet;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }
}
