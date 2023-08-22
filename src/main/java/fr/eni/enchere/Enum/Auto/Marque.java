package fr.eni.enchere.Enum.Auto;

public class Marque {
    private String nom;
    private int id;
    private String texte;

    public Marque(String nom, int id, String texte) {
        this.nom = nom;
        this.id = id;
        this.texte = texte;
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
