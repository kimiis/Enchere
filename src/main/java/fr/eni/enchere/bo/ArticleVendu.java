package fr.eni.enchere.bo;

import java.time.LocalDate;

public class ArticleVendu {

    private int noArticle;

    private String nomArticle;

    private String description;

    private LocalDate dateDebutEncheres;

    private LocalDate dateFinEncheres;

    private int miseAPrix;

    private int prixVente;

    private String etatVente;

    private Utilisateur utilistaeur;

    private Retrait retrait;

    private Categorie categorie;



    public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
                        LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente,
                        Utilisateur utilistaeur, Retrait retrait, Categorie categorie) {

        super();

        this.noArticle = noArticle;

        this.nomArticle = nomArticle;

        this.description = description;

        this.dateDebutEncheres = dateDebutEncheres;

        this.dateFinEncheres = dateFinEncheres;

        this.miseAPrix = miseAPrix;

        this.prixVente = prixVente;

        this.etatVente = etatVente;

        this.utilistaeur = utilistaeur;

        this.retrait = retrait;

        this.categorie = categorie;

    }

    @Override

    public String toString() {

        return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description

                + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";

    }

    public int getNoArticle() {

        return noArticle;

    }
    public void setNoArticle(int noArticle) {

        this.noArticle = noArticle;

    }
    public String getNomArticle() {

        return nomArticle;

    }

    public void setNomArticle(String nomArticle) {

        this.nomArticle = nomArticle;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public LocalDate getDateDebutEncheres() {

        return dateDebutEncheres;

    }

    public void setDateDebutEncheres(LocalDate dateDebutEncheres) {

        this.dateDebutEncheres = dateDebutEncheres;

    }

    public LocalDate getDateFinEncheres() {

        return dateFinEncheres;

    }

    public void setDateFinEncheres(LocalDate dateFinEncheres) {

        this.dateFinEncheres = dateFinEncheres;

    }

    public int getMiseAPrix() {

        return miseAPrix;

    }
    public void setMiseAPrix(int miseAPrix) {

        this.miseAPrix = miseAPrix;

    }

    public int getPrixVente() {

        return prixVente;

    }

    public void setPrixVente(int prixVente) {

        this.prixVente = prixVente;

    }

    public String getEtatVente() {

        return etatVente;

    }

    public void setEtatVente(String etatVente) {

        this.etatVente = etatVente;

    }

    public Utilisateur getUtilistaeur() {

        return utilistaeur;

    }

    public void setUtilistaeur(Utilisateur utilistaeur) {

        this.utilistaeur = utilistaeur;

    }

    public Retrait getRetrait() {

        return retrait;

    }

    public void setRetrait(Retrait retrait) {

        this.retrait = retrait;

    }

    public Categorie getCategorie() {

        return categorie;

    }

    public void setCategorie(Categorie categorie) {

        this.categorie = categorie;

    }

}
