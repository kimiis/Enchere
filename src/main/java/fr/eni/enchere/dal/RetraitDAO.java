package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Retrait;

import java.util.List;

public interface RetraitDAO {
    List<Retrait> findAll();
}
