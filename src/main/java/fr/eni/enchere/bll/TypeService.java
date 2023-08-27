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

    /**
     * Permet de récuperer tous les types en base
     * @return List<Type> Une liste de tous les types
     */
    public List<Type> recupererInfos(){

        return typeDAO.findAll();

    }
    public Type getTypeById(int id){

        return typeDAO.getTypeById(id);

    }
}
