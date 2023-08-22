package fr.eni.enchere.Enum.ElectroM;

import fr.eni.enchere.Enum.Auto.Marque;

public class ElectroM {
    private boolean encastrable;
    private String energie;

    private Marque marque;
    private TypeElectro typeElectro;

    public ElectroM(boolean encastrable, String energie, Marque marque, TypeElectro typeElectro) {
        this.encastrable = encastrable;
        this.energie = energie;
        this.marque = marque;
        this.typeElectro = typeElectro;
    }

    public boolean isEncastrable() {
        return encastrable;
    }

    public void setEncastrable(boolean encastrable) {
        this.encastrable = encastrable;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public TypeElectro getTypeElectro() {
        return typeElectro;
    }

    public void setTypeElectro(TypeElectro typeElectro) {
        this.typeElectro = typeElectro;
    }
}
