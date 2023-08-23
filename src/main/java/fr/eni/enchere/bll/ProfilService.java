package fr.eni.enchere.bll;


import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ProfilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfilService {

    @Autowired
    private ProfilDAO profilDao;


    // Récupérer les infos de l'utilisateur et les afficher dans son profil

    public Utilisateur recupererInfos(String pseudo) {
        return profilDao.recupererInfos(pseudo);
    }


    // Modifier les infos de l'utilisateur et les afficher dans son profil
    public Utilisateur modifierInfos(Utilisateur utilisateur) {
        return profilDao.modifierInfos(utilisateur);
    }

    // Supprimer les infos de l'utilisateur

    public void supprimerProfil(int noUtilisateur) {
        profilDao.supprimerProfil(noUtilisateur);
    }



//    @Transactional
//    public void ajouter(Utilisateur u) {
//        profilDao.add(u);
//
//    }

}
