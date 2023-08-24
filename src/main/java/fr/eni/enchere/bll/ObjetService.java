package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.dal.ObjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ObjetService {
    @Autowired
    private ObjetDao objetDAO;

    // Récupérer les infos

    public void insertObjet(Date dateD, Date dateF, int prix, String nom, String descrip, int idUser, int idRetrait, int idType){

        objetDAO.insertObjet(dateD, dateF,  prix, nom, descrip, idUser, idRetrait, idType);

    }
    public List<Objet> findByType(String typeName){
        return objetDAO.findByType(typeName);
    }

    public Objet consulterObjetParId (int idObjet){
        return  objetDAO.consulterObjetParId(idObjet);

    }
}
