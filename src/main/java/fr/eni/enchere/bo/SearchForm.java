package fr.eni.enchere.bo;

public class SearchForm {
    private String nom;
    private int idType;

    public SearchForm() {
    }

    public SearchForm(String nom, int idType) {
        this.nom = nom;
        this.idType = idType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}
