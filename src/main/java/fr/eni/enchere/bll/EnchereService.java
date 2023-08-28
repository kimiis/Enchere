package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Enchere;
import fr.eni.enchere.dal.EnchereDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EnchereService {
    @Autowired
   private EnchereDao enchereDAO;

    public List<Enchere> getEnCoursParticipe(int idUser){
        return enchereDAO.getEnCoursParticipe(idUser);
    }

    public List<Enchere> getWin(int idUser){
        return enchereDAO.getWin(idUser);
    }
// ça n'a pas pu marcher car tu declares une propiete dans une interface
//    // On veut recuperer les credits via le pseudo
//    public int recupererCredit(String pseudo) {
//        return mesEncheresDAO.recupererCredit(pseudo);
//    }
}
