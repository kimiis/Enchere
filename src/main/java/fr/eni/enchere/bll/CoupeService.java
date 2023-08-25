package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Coupe;
import fr.eni.enchere.dal.CoupeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoupeService {

    @Autowired
    CoupeDAO coupeDAO;

    public List<Coupe> recupererInfos(){

        return coupeDAO.findAll();

    }
}
