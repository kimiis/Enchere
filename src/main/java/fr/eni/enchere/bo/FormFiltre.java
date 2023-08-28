package fr.eni.enchere.bo;

public class FormFiltre {
    private String couleur;
    private String energie;
    private String prixMin;
    private String prixMax;
    private String Localisation;
    private boolean on;
    private boolean off;
    private String nomType;
    private int idCategorie;

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(String prixMin) {
        this.prixMin = prixMin;
    }

    public String getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(String prixMax) {
        this.prixMax = prixMax;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String localisation) {
        Localisation = localisation;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isOff() {
        return off;
    }

    public void setOff(boolean off) {
        this.off = off;
    }

    public FormFiltre() {
    }

    public FormFiltre(String couleur, String energie, String prixMin, String prixMax, String localisation, boolean on, boolean off) {
        this.couleur = couleur;
        this.energie = energie;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        Localisation = localisation;
        this.on = on;
        this.off = off;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
}
