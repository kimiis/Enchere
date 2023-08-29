package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Enchere;

import java.util.List;

public interface EnchereDao {

    //        int recupererCredit(String pseudo);

    List<Enchere> getEnCoursParticipe(int idUser);
    List<Enchere> getWin(int idUser);

    void addEnchere(int idUser, int idObjet, int prix);

    Enchere getEncherePlusHaute (int idObjet);

}
