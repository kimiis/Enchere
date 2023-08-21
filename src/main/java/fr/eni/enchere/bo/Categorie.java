package fr.eni.enchere.bo;

public class Categorie {
    private ArticleVendu articleVendu;
    private int noCate;
    private String libelle;

    public Categorie() {
    }

    public Categorie(ArticleVendu articleVendu, int noCate, String libelle) {
        this.articleVendu = articleVendu;
        this.noCate = noCate;
        this.libelle = libelle;
    }

    public ArticleVendu getArticleVendu() {
        return articleVendu;
    }

    public void setArticleVendu(ArticleVendu articleVendu) {
        this.articleVendu = articleVendu;
    }

    public int getNoCate() {
        return noCate;
    }

    public void setNoCate(int noCate) {
        this.noCate = noCate;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
