package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.ModaliteRetrait;

import java.util.List;

public interface RetraitDAO {
    List<ModaliteRetrait> findAll();
}
