package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Energie;
import fr.eni.enchere.ObjetSQL.ModaliteRetrait;
import fr.eni.enchere.dal.EnergieDAO;
import fr.eni.enchere.dal.RetraitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EnergieService {
    @Autowired
    private EnergieDAO energieDAO;

    // Récupérer les infos

    public List<Energie> recupererInfos(){

        return energieDAO.findAll();

    }
}
