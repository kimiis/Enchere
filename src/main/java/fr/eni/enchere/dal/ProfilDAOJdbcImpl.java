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
    private final static String RECUPERER_INFOS = "SELECT id, pseudo, nom, prenom, email, tel, adresse, mdp, credit, admin From UTILISATEURS WHERE pseudo= ?";

    @Override
    public Utilisateur recupererInfos(String pseudo) {
        Utilisateur utilisateur = jdbcTemplate.queryForObject(RECUPERER_INFOS, new BeanPropertyRowMapper<>(Utilisateur.class), pseudo);
        return utilisateur;
    }


    // Modifier les infos de l'utilisateur et les afficher dans son profil

    private final static String MODIFIER_INFOS = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, tel = ?, adresse = ?  WHERE id= ?";

    @Override
    public Utilisateur modifierInfos(Utilisateur utilisateur) {
        jdbcTemplate.update(MODIFIER_INFOS, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTel(), utilisateur.getAdresse(), utilisateur.getId());
        return utilisateur;
    }


    // Supprimer les infos de l'utilisateur

    private final static String SUPPRIMER_PROFIL = "DELETE FROM UTILISATEURS WHERE pseudo= ?";

    @Override
    public void supprimerLigneUtilisateur(String pseudo) {
        jdbcTemplate.update(SUPPRIMER_PROFIL, pseudo);
    }


    // Supprimer le role de l'utilisateur

    private final static String SUPPRIMER_PROFIL_ROLE = "DELETE FROM ROLES WHERE pseudo= ?";

    @Override
    public void supprimerLigneRole(String pseudo) {
        jdbcTemplate.update(SUPPRIMER_PROFIL_ROLE, pseudo);
    }

    // INSERER UTILISATEUR DANS LA BASE



    private final static String INSERT_UTILISATEUR = "" +
            " INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, tel, adresse, mdp, credit, admin) " +
            " VALUES (?,?,?,?,?,?,?,?,?)";



    @Override
    public void add(Utilisateur u) {

        jdbcTemplate.update(INSERT_UTILISATEUR, u.getPseudo(), u.getNom(), u.getPrenom(), u.getEmail(), u.getTel(), u.getAdresse(), u.getMdp(), u.getCredit(), u.isAdmin());
    }


    // INSERER ROLE UTILISATEUR DANS LA BASE

    private final static String INSERT_ROLE = "" +
            " INSERT INTO ROLES (pseudo, role) " +
            " VALUES (?,?)";


    @Override
    public void addRole(Utilisateur ur){
       jdbcTemplate.update(INSERT_ROLE, ur.getPseudo(), "client");

    }

}


