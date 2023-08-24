package fr.eni.enchere.ObjetSQL;

import java.util.Date;

public class Enchere {
    private String nom;
    private int id;
    private String texte;
    private Date dateD;
    private Date dateF;
    private int prix;
    private int idObjet;

    public Enchere(String nom, int id, String texte, Date dateD, Date dateF, int prix, int idObjet) {
        this.nom = nom;
        this.id = id;
        this.texte = texte;
        this.dateD = dateD;
        this.dateF = dateF;
        this.prix = prix;
        this.idObjet = idObjet;
    }

    public Enchere() {
    }

    public Date getDateD() {
        return dateD;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public Date getDateF() {
        return dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }


}

