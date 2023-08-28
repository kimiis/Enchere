package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.bo.FormFiltre;

import java.util.Date;
import java.util.List;

public interface ObjetDao {
    List<Objet> findAll();

    void insertObjet(Date dateD, Date dateF, int prix, String nom, String descrip, int idUser, int idRetrait, int idType, int nbRoue, boolean encastrable, boolean portable, int idCoupe, int idCouleur, int idMarque, int idTaille, int idLocalisation, int idEnergie, String energieElec, int annee);

    List<Objet> findByType(String typeName);

    Objet consulterObjetParId(int idObjet);

    List<Objet> enCoursByIdUser(int idUser);

    List<Objet> finiByIdUser(int idUser);

    List<Objet> futurByIdUser(int idUser);

    List<Objet> searchByNameAndType(String nom, int idType);

    List<Objet> getObjetByFiltre(FormFiltre formFiltre);



}
