package fr.eni.enchere.bo;

public class Utilisateur {

    private int noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private String adresse;
     private String mdp;
    private int credit;
    private boolean admin;

    private ArticleVendu articleVendu;

    public Utilisateur() {
        this.nom = "";
        this.prenom="";
        this.tel= "";
        this.adresse= "";

    }

    public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom,
                       String email, String tel, String adresse, String mdp,
                       int credit, boolean admin) {
        this.noUtilisateur = noUtilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;

        this.mdp = mdp;
        this.credit = credit;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "noUtilisateur=" + noUtilisateur +
                ", pseudo='" + pseudo + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mdp='" + mdp + '\'' +
                ", credit=" + credit +
                ", admin=" + admin +
                ", articleVendu=" + articleVendu +
                '}';
    }

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

     public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
