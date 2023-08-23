package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Localisation;

import java.util.List;

public interface LocalisationDAO {
    List<Localisation> findAll();
}
