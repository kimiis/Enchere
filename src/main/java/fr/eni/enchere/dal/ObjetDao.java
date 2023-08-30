package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.bo.FormFiltre;
import fr.eni.enchere.bo.ObjetForm;

import java.util.List;

public interface ObjetDao {
    List<Objet> findAll();

    void insertObjet(int idUser, ObjetForm objetForm);
    List<Objet> findByType(String typeName);

    Objet consulterObjetParId(int idObjet);

    List<Objet> enCoursByIdUser(int idUser);

    List<Objet> finiByIdUser(int idUser);

    List<Objet> futurByIdUser(int idUser);

    List<Objet> searchByNameAndType(String nom, int idType);

    List<Objet> getObjetByFiltre(FormFiltre formFiltre);


}
