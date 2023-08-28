package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class MesEncheresDAOJdbcImpl implements MesEncheresDAO{


    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Récupérer le crédit de l'utilisateur et les afficher dans son profil
    private final static String RECUPERER_CREDIT = "SELECT credit From UTILISATEURS WHERE pseudo= ?";

    @Override
    public int recupererCredit(String pseudo) {
        int credit = jdbcTemplate.queryForObject(RECUPERER_CREDIT, Integer.class, pseudo);

        return credit;
    }

}
