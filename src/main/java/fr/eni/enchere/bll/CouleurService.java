package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Couleur;
import fr.eni.enchere.dal.CouleurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouleurService {

        @Autowired
        private CouleurDAO couleurDAO;

        // Récupérer les infos

        public List<Couleur> recupererInfos(){

            return couleurDAO.findAll();

        }


}
