package fr.eni.enchere.Enum.Auto;

public enum Energie {
//enum = liste
    DIESEL("diesel", "Diesel"),
    ESSENCE("essence", "Essence"),
    HYBRIDE("hybride", "Hybride"),
    ETHANOL("ethanol", "Ethanol"),
    AUTRE("autre", "Autre");
    private final String displayNom;
//    propriété constante de chaque objet

    public String getNom() {
        return nom;
    }

    private final String nom;

    private Energie(String nom, String displayNom) {
        this.displayNom = displayNom;
        this.nom = nom;
    }

    public String getDisplayNom() {
        return displayNom;
    }

}

