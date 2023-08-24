package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Type;

import java.util.List;

public interface TypeDAO {
    List<Type> findAll();
}
