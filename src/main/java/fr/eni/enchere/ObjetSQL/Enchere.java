package fr.eni.enchere.ObjetSQL;

import java.util.Date;

public class Enchere {
    private String typeNom;
    private String objetNom;
    private int id;
    private Date dateD;
    private Date dateF;
    private int prix;
    private int idObjet;

    private int idAcheteur;

    public Enchere(String typeNom, String objetNom, int id, Date dateD, Date dateF, int prix, int idObjet, int idAcheteur) {
        this.typeNom = typeNom;
        this.objetNom = objetNom;
        this.id = id;
        this.dateD = dateD;
        this.dateF = dateF;
        this.prix = prix;
        this.idObjet = idObjet;
        this.idAcheteur = idAcheteur;
    }

    public Enchere() {
    }

    public int getIdAcheteur() {
        return idAcheteur;
    }

    public void setIdAcheteur(int idAcheteur) {
        this.idAcheteur = idAcheteur;
    }

    public String getTypeNom() {
        return typeNom;
    }

    public void setTypeNom(String typeNom) {
        this.typeNom = typeNom;
    }

    public String getObjetNom() {
        return objetNom;
    }

    public void setObjetNom(String objetNom) {
        this.objetNom = objetNom;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

