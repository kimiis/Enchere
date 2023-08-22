package fr.eni.enchere.Enum.Consoles;

import fr.eni.enchere.Enum.Auto.Marque;

public class Console {
    private boolean portable;
    private int annee;

    private Marque marque;
    private TypeConsole typeConsole;

    public Console(boolean portable, int annee, Marque marque, TypeConsole typeConsole) {
        this.portable = portable;
        this.annee = annee;
        this.marque = marque;
        this.typeConsole = typeConsole;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public TypeConsole getTypeConsole() {
        return typeConsole;
    }

    public void setTypeConsole(TypeConsole typeConsole) {
        this.typeConsole = typeConsole;
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
}
