package fr.eni.enchere.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ObjetForm {
    private String nom;
    private String description;
    private int idType;
    private int prix;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateD;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateF;
    private int idRetrait;
    private int idCouleur;
    private int idEnergie;
    private int nbRoues;
    private String energieElec;
    private int idTaille;
    private int idLocalisation;
    private int idCoupe;
    private int idMarque;
    private boolean encastrables;
    private int annee;

    private boolean portable;
    public ObjetForm() {
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

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
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

    public int getIdRetrait() {
        return idRetrait;
    }

    public void setIdRetrait(int idRetrait) {
        this.idRetrait = idRetrait;
    }

    public int getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }

    public int getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(int idEnergie) {
        this.idEnergie = idEnergie;
    }

    public int getNbRoues() {
        return nbRoues;
    }

    public void setNbRoues(int nbRoues) {
        this.nbRoues = nbRoues;
    }

    public String getEnergieElec() {
        return energieElec;
    }

    public void setEnergieElec(String energieElec) {
        this.energieElec = energieElec;
    }

    public int getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public int getIdCoupe() {
        return idCoupe;
    }

    public void setIdCoupe(int idCoupe) {
        this.idCoupe = idCoupe;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public boolean isEncastrables() {
        return encastrables;
    }

    public void setEncastrables(boolean encastrables) {
        this.encastrables = encastrables;
    }

    public boolean isPortable() {
        return portable;
    }

    public void setPortable(boolean portable) {
        this.portable = portable;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
