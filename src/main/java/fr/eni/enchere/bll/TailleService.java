package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Taille;
import fr.eni.enchere.dal.TailleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TailleService {

    @Autowired
    private TailleDAO tailleDAO;

    // Récupérer les infos
    public List<Taille> recupererInfos(){

        return tailleDAO.findAll();

    }
}
