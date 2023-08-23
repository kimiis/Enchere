package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Energie;

import java.util.List;

public interface EnergieDAO {
    List<Energie>findAll();
}
