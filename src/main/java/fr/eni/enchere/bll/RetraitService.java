package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.ModaliteRetrait;
import fr.eni.enchere.dal.RetraitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetraitService {

    @Autowired
    private RetraitDAO retraitDAO;

    // Récupérer les infos

    public List<ModaliteRetrait> recupererInfos(){

        return retraitDAO.findAll();

    }
}


