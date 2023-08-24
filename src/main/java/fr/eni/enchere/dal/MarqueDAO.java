package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Marque;

import java.util.List;

public interface MarqueDAO {
    List<Marque> findAll();

    List<Marque> getMarquesByTypeName(String nomType);
}
