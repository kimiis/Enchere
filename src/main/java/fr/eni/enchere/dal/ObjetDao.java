package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;

import java.util.List;

public interface ObjetDao {
    List<Objet> findAll();
}
