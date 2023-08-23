package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository

public class ProfilDAOJdbcImpl implements ProfilDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Récupérer les infos de l'utilisateur et les afficher dans son profil
    private final static String RECUPERER_INFOS = "SELECT noUtilisateur, pseudo, nom, prenom, email, tel, adresse, cpo, mdp, credit, admin From UTILISATEURS WHERE pseudo= ?";

    @Override
    public Utilisateur recupererInfos(String pseudo) {
        Utilisateur utilisateur = jdbcTemplate.queryForObject(RECUPERER_INFOS, new BeanPropertyRowMapper<>(Utilisateur.class), pseudo);
        return utilisateur;
    }


    // Modifier les infos de l'utilisateur et les afficher dans son profil

    private final static String MODIFIER_INFOS = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, tel = ?, adresse = ?, cpo = ?, mdp = ?, credit = ?, admin = ?  WHERE noUtilisateur= ?";

    @Override
    public Utilisateur modifierInfos(Utilisateur utilisateur) {
        jdbcTemplate.update(MODIFIER_INFOS, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTel(), utilisateur.getAdresse(), utilisateur.getMdp(), utilisateur.getCredit(), utilisateur.isAdmin(), utilisateur.getNoUtilisateur());
        return utilisateur;
    }


    // Supprimer les infos de l'utilisateur

    private final static String SUPPRIMER_PROFIL = "DELETE FROM UTILISATEURS WHERE noUtilisateur= ?";

    @Override
    public void supprimerProfil(int noUtilisateur) {
        jdbcTemplate.update(SUPPRIMER_PROFIL, noUtilisateur);
    }

}
