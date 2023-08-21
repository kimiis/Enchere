package fr.eni.enchere.bo;

public class Retrait {
    private String adresse;

    public Retrait(String adresse) {
        this.adresse = adresse;
    }

    public Retrait() {
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
