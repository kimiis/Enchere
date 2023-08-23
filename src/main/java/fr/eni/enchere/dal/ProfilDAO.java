package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Utilisateur;

public interface ProfilDAO {


    // Récupérer les infos de l'utilisateur et les afficher dans son profil
    Utilisateur recupererInfos(String pseudo);


    // Modifier les infos de l'utilisateur et les afficher dans son profil
    Utilisateur modifierInfos(Utilisateur utilisateur);


    // Supprimer les infos de l'utilisateur

    void supprimerProfil(int noUtilisateur);

<<<<<<< HEAD
    void add (Utilisateur u);

    void addRole (Utilisateur ur);


=======
>>>>>>> 596e611ea851c5464d0e0b3a8e02a2bf77a7b369
}
