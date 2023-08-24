package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Marque;
import fr.eni.enchere.dal.MarqueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    private MarqueDAO marqueDAO;

    // Récupérer les infos
    public List<Marque> recupererInfos(){
        return marqueDAO.findAll();
    }
}

