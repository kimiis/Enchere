package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Enchere;
import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.dal.EnchereDao;
import fr.eni.enchere.dal.ProfilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service

public class EnchereService {
    @Autowired
    private EnchereDao enchereDAO;

    @Autowired
    private ProfilDAO profilDAO;

    @Autowired
    ObjetService objetService;

    public List<Enchere> getEnCoursParticipe(int idUser) {
        return enchereDAO.getEnCoursParticipe(idUser);
    }

    public List<Enchere> getWin(int idUser) {
        return enchereDAO.getWin(idUser);
    }

    public Enchere getEncherePlusHaute(int idObjet) {
        return enchereDAO.getEncherePlusHaute(idObjet);
    }
    // ça n'a pas pu marcher car tu declares une propiete dans une interface
//    // On veut recuperer les credits via le pseudo
//    public int recupererCredit(String pseudo) {
//        return mesEncheresDAO.recupererCredit(pseudo);
//    }

    //    cas je suis la 1ere encherisseuse
    @Transactional(rollbackFor = Exception.class) // Rollback for all exceptions
//    indique à Spring de gérer une transaction autour de cette méthode et de la rollback si une exception est levée.
//    L'argument rollbackFor = Exception.class signifie que la transaction sera annulée pour toutes les exceptions, ce qui inclut
//    Error et ses sous-classes.

    public void addEnchere(Utilisateur utilisateur, Objet objet, int prix) throws Error {
//idObjet = iDvendeur
        int prixD = objet.getPrix();
        Enchere enchere = enchereDAO.getEncherePlusHaute(objet.getId());
        int prixActu = prixD;

        if (!Objects.isNull(enchere.getPrix())) {
            prixActu = enchere.getPrix();
        }
//        si l'utilisateur co n'est pas le plus haut encherisseur
        if (enchere.getIdAcheteur() == utilisateur.getId()) {
            throw new Error("c'est déjà toi qui à la plus grosse !");
        }
        if (utilisateur.getCredit() < prixActu) {
            throw new Error("t'es trop pauvre !");
        } else if (prix < prixActu) {
            throw new Error("wsh arrete de faire ton radin augmente la mise!");
        }
        enchereDAO.addEnchere(utilisateur.getId(), objet.getId(), prix);
    }

}
