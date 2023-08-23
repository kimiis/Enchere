package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Coupe;

import java.util.List;

public interface CoupeDAO {
    List<Coupe> findAll();
}
