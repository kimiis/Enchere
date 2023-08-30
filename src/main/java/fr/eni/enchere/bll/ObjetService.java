package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.bo.FormFiltre;
import fr.eni.enchere.bo.ObjetForm;
import fr.eni.enchere.dal.ObjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetService {
    @Autowired
    private ObjetDao objetDAO;

    // créer objet

    public void insertObjet(int idUser, ObjetForm objetForm){

        objetDAO.insertObjet(idUser,objetForm);

                }
        //recuperer objet par type
    public List<Objet> findByType(String typeName){
        return objetDAO.findByType(typeName);
    }

    //recuperer objet par id
    public Objet consulterObjetParId(int idObjet){
        return  objetDAO.consulterObjetParId(idObjet);
    }

    // recuperer objet en cours par idUser, dateD avant dateNow && dateF après dateNow
    public List<Objet> enCoursByIdUser(int idUser){
        return objetDAO.enCoursByIdUser(idUser);
    }
    // recuperer objet terminée par idUser, dateD avant dateNow && dateF après dateNow

    public List<Objet> finiByIdUser(int idUser){
        return objetDAO.finiByIdUser(idUser);
    }
    public List<Objet> futurByIdUser(int idUser){
        return objetDAO.futurByIdUser(idUser);
    }


    public List<Objet> searchByNameAndType(String nom, int idType) {
        return objetDAO.searchByNameAndType(nom, idType);
    }

    public List<Objet> getObjetByFiltre(FormFiltre formFiltre){
        return objetDAO.getObjetByFiltre(formFiltre);
    }

}


