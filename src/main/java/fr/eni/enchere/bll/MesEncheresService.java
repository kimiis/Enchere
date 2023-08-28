package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.dal.MesEncheresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesEncheresService {

    @Autowired
    private MesEncheresDAO mesEncheresDAO;

    // On veut recuperer les credits via le pseudo
    public int recupererCredit(String pseudo) {
        return mesEncheresDAO.recupererCredit(pseudo);
    }


}
