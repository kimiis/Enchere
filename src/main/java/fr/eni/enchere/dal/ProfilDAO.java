package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface ProfilDAO {

    Utilisateur recupererInfos (String pseudo);

}
