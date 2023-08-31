package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class ProfilDAOJdbcImpl implements ProfilDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Récupérer les infos de l'utilisateur et les afficher dans son profil
    private final static String RECUPERER_INFOS = "SELECT * From UTILISATEURS WHERE pseudo= ?";

    @Override
    public Utilisateur recupererInfos(String pseudo) {
        Utilisateur utilisateur = jdbcTemplate.queryForObject(RECUPERER_INFOS, new BeanPropertyRowMapper<>(Utilisateur.class), pseudo);
        return utilisateur;
    }


    // Modifier les infos de l'utilisateur et les afficher dans son profil

    private final static String MODIFIER_INFOS = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, tel = ?, adresse = ?  WHERE id= ?";

//    ça ne marchait pas car dans le html tu n'as pas mis le bon nom qui est id
    @Override

    public void modifierInfos(Utilisateur utilisateur) {
        jdbcTemplate.update(MODIFIER_INFOS, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTel(), utilisateur.getAdresse(), utilisateur.getId());

    }


    // Supprimer les infos de l'utilisateur

    private final static String SUPPRIMER_PROFIL = "DELETE FROM UTILISATEURS WHERE pseudo= ?";

    @Override
    public void supprimerUtilisateur(String pseudo) {
        jdbcTemplate.update(SUPPRIMER_PROFIL, pseudo);
    }


    // Supprimer le role de l'utilisateur

    private final static String SUPPRIMER_PROFIL_ROLE = "DELETE FROM ROLES WHERE pseudo= ?";

    @Override
    public void supprimerRole(String pseudo) {
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

//    VERIFIE SI CA MARCHE !

    @Override
    public void addRole(Utilisateur ur){
       jdbcTemplate.update(INSERT_ROLE, ur.getPseudo(), "ROLE_CLIENT");

    }

    public void modifCredit(int credit, int idUser){
        final String UPDATE_USER_CREDIT="UPDATE UTILISATEURS SET credit = :credit WHERE id= :idUser ";

        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
        parametreSource.addValue("credit", credit);

        namedParameterJdbcTemplate.update(UPDATE_USER_CREDIT, parametreSource);
    }
//va servire a trouver l'ancien plus gros encherisseur
    public Utilisateur getUserById (int idUtilisateur){
        final String GET_USER_BY_ID="SELECT * FROM UTILISATEURS WHERE ID= ?";
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new BeanPropertyRowMapper<>(Utilisateur.class), idUtilisateur );
    }


}


