package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;

import java.util.Date;
import java.util.List;

public interface ObjetDao {
    List<Objet> findAll();
   void insertObjet(Date dateD, Date dateF, int prix, String nom, String descrip, int idUser, int idRetrait,int idType);
    List<Objet> findByType(String typeName);

   Objet consulterObjetParId (int idObjet);
}
