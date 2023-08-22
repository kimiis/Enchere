package fr.eni.enchere.Enum.HighT;

import fr.eni.enchere.Enum.Auto.Marque;

public class HighTech {
    private boolean portable;
    private int annee;
    private Marque marque;
    private TypeHighT typeHighT;

    public HighTech(boolean portable, int annee, Marque marque, TypeHighT typeHighT) {
        this.portable = portable;
        this.annee = annee;
        this.marque = marque;
        this.typeHighT = typeHighT;
    }

    public boolean isPortable() {
        return portable;
    }

    public void setPortable(boolean portable) {
        this.portable = portable;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public TypeHighT getTypeHighT() {
        return typeHighT;
    }

    public void setTypeHighT(TypeHighT typeHighT) {
        this.typeHighT = typeHighT;
    }
}
