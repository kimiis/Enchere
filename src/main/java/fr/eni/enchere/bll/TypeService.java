package fr.eni.enchere.bll;

import fr.eni.enchere.dal.TypeDAO;
import fr.eni.enchere.ObjetSQL.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeDAO typeDAO;

    // Récupérer les infos
    public List<Type> recupererInfos(){

        return typeDAO.findAll();

    }
}
