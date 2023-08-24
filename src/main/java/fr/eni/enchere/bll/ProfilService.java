package fr.eni.enchere.bll;


import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.dal.ProfilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Transactional
    public void supprimerProfil(String pseudo) {
        profilDao.supprimerLigneUtilisateur(pseudo);
        profilDao.supprimerLigneRole(pseudo);
    }

    // Supprimer le role de l'utilisateur




    @Transactional
    public void ajouter(Utilisateur u) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        u.setMdp(encoder.encode(u.getMdp()));
        profilDao.add(u);
        profilDao.addRole(u);

    }

}
