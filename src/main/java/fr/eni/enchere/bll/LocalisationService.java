package fr.eni.enchere.bll;


import fr.eni.enchere.ObjetSQL.Localisation;
import fr.eni.enchere.dal.LocalisationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalisationService {

    @Autowired
    private LocalisationDAO localisationDAO;

    // Récupérer les infos

    public List<Localisation> recupererInfos(){

        return localisationDAO.findAll();

    }
}

