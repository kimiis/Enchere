package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Enchere;
import fr.eni.enchere.ObjetSQL.Utilisateur;

import java.util.List;

public interface EnchereDao {
//    ça ne peut as marcher non plus, car il manque beaucoup de chose et c'est au mauvais endroit

    //        int recupererCredit(String pseudo);

    List<Enchere> getEnCoursParticipe(int idUser);
    List<Enchere> getWin(int idUser);

    void addEnchere(int idUser, int idObjet, int prix);

    List<Enchere> getEncherePlusHaute (int idObjet);

}
