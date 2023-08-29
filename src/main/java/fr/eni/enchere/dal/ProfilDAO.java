package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Utilisateur;

public interface ProfilDAO {


    // Récupérer les infos de l'utilisateur et les afficher dans son profil
    Utilisateur recupererInfos(String pseudo);


    // Modifier les infos de l'utilisateur et les afficher dans son profil
    void modifierInfos(Utilisateur utilisateur);


    // Supprimer les infos de l'utilisateur

    void supprimerUtilisateur(String pseudo);
    void supprimerRole(String pseudo);

    // ajouter utilisateur et role

    void add(Utilisateur u);

    void addRole(Utilisateur ur);


}
