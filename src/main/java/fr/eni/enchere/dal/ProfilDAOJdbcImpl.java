//package fr.eni.enchere.dal;
//
//import fr.eni.enchere.bo.Utilisateur;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.stereotype.Repository;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Repository
//
//public class ProfilDAOJdbcImpl implements ProfilDAO {
//
//
//    private final static String RECUPERER_INFOS = "SELECT pseudo, nom, prenom, email, telephone, adresse From UTILISATEURS WHERE pseudo= ?";
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Utilisateur recupererInfos(String pseudo) {
//        Utilisateur utilisateur = jdbcTemplate.queryForObject(RECUPERER_INFOS, new BeanPropertyRowMapper<>(Utilisateur.class), pseudo);
//        return utilisateur;
//    }
//}