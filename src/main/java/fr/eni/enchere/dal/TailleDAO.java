package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Taille;

import java.util.List;

public interface TailleDAO {
    List<Taille> findAll();
}
