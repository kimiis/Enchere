package fr.eni.enchere.bo;

public class EnchereForm {
    private int prix;
    private int idObjet;

    public EnchereForm() {
    }

    public EnchereForm(int prix, int idObjet) {
        this.prix = prix;
        this.idObjet = idObjet;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }
}
