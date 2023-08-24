package fr.eni.enchere.ObjetSQL;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Objet {
    private String energies;
    private int id;
    private int nbRoue;
    private int annee;
    private boolean portbale;
    private boolean encastrable;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateD;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateF;
    private String nom;
    private String description;
    private int idUser;
    private int idRetrait;
    private int prix;
    private int idType;
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }



    public Objet() {
    }

    public Objet(String energies, int id, int nbRoue, int annee, boolean portbale, boolean encastrable, Date dateD, Date dateF, String nom, String description, int idUser, int idRetrait, int prix) {
        this.energies = energies;
        this.id = id;
        this.nbRoue = nbRoue;
        this.annee = annee;
        this.portbale = portbale;
        this.encastrable = encastrable;
        this.dateD = dateD;
        this.dateF = dateF;
        this.nom = nom;
        this.description = description;
        this.idUser = idUser;
        this.idRetrait = idRetrait;
        this.prix = prix;
    }

    public String getEnergies() {
        return energies;
    }

    public void setEnergies(String energies) {
        this.energies = energies;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRetrait() {
        return idRetrait;
    }

    public void setIdRetrait(int idRetrait) {
        this.idRetrait = idRetrait;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}