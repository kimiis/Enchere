package fr.eni.enchere.bo;

public class UtilisateurInscription {
    private String pseudo;
    private String email;
    private String mdp;

    public UtilisateurInscription() {
    }

    public UtilisateurInscription(String pseudo, String email, String mdp) {
        this.pseudo = pseudo;
        this.email = email;
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
