package fr.eni.enchere.ObjetSQL;

public class Objet {
    private String energies;
    private int id;
    private int nbRoue;
    private int annee;
    private boolean portbale;
    private boolean encastrable;
    private Coupe coupe;
    private Marque marque;
    private Type type;
    private Localisation localisation;
    private Energie energie;
    private Taille taille;

    public Objet(String energies, int id, int nbRoue, int annee, boolean portbale, boolean encastrable, Coupe coupe, Marque marque,
                 Type type, Localisation localisation, Energie energie, Taille taille) {
        this.energies = energies;
        this.id = id;
        this.nbRoue = nbRoue;
        this.annee = annee;
        this.portbale = portbale;
        this.encastrable = encastrable;
        this.coupe = coupe;
        this.marque = marque;
        this.type = type;
        this.localisation = localisation;
        this.energie = energie;
        this.taille = taille;
    }

    public String getenergies() {
        return energies;
    }

    public void setenergies(String energies) {
        this.energies = energies;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public void setEnergie(Energie energie) {
        this.energie = energie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbRoue() {
        return nbRoue;
    }

    public void setNbRoue(int nbRoue) {
        this.nbRoue = nbRoue;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean isPortbale() {
        return portbale;
    }

    public void setPortbale(boolean portbale) {
        this.portbale = portbale;
    }

    public boolean isEncastrable() {
        return encastrable;
    }

    public void setEncastrable(boolean encastrable) {
        this.encastrable = encastrable;
    }

    public Coupe getCoupe() {
        return coupe;
    }

    public void setCoupe(Coupe coupe) {
        this.coupe = coupe;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }
}


