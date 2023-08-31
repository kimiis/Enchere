package fr.eni.enchere.bll;


import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.dal.ProfilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
    public void modifierInfos(Utilisateur utilisateur) {
        profilDao.modifierInfos(utilisateur);
    }

    @Autowired
    private EnchereService enchereService;

    @Transactional
    public void supprimerProfil(String pseudo) {
        // Supprimer les infos de l'utilisateur

        profilDao.supprimerUtilisateur(pseudo);
        // Supprimer le role de l'utilisateur
        profilDao.supprimerRole(pseudo);
    }

// ENCODER LE MDP
    @Transactional
    public void ajouter(Utilisateur u) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        u.setMdp(encoder.encode(u.getMdp()));
        profilDao.add(u);
        profilDao.addRole(u);

    }


//    private final String UPDATE_USER_CREDIT="UPDATE UTILISATEURS SET credit :credit WHERE id= :idUser ) ";
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    @Transactional
//    public void modifCredit(int credit, int idUser){
//        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
//        parametreSource.addValue("idUser", idUser);
//        parametreSource.addValue("credit", credit);


    public void modifCredit(int credit, int idUser) {
        profilDao.modifCredit(credit, idUser);
    }
    public Utilisateur getUserById (int idUtilisateur){
        return profilDao.getUserById(idUtilisateur);
    }

// prevoyance si je fais page Admin
//    public void modifCredit(int credit, int idUser) {
//        profilDao.modifCredit(credit, idUser);
//    }
//    public Utilisateur getUserById (int idUtilisateur){
//        return profilDao.getUserById(idUtilisateur);
//    }





}
