package fr.eni.enchere.Enum.Auto;

public class Auto {
    private int nbRoue;
    private int id;
    private int annee;

    public Auto(int nbRoue, int id, int annee) {
        this.nbRoue = nbRoue;
        this.id = id;
        this.annee = annee;
    }

    public int getNbRoue() {
        return nbRoue;
    }

    public void setNbRoue(int nbRoue) {
        this.nbRoue = nbRoue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
