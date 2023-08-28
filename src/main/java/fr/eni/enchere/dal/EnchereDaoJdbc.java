//package fr.eni.enchere.dal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class EnchereDaoJdbc implements EnchereDao {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    // Récupérer le crédit de l'utilisateur et les afficher dans son profil
//    private final static String RECUPERER_CREDIT = "SELECT credit From UTILISATEURS WHERE pseudo= ?";
//
//    @Override
//    public int recupererCredit(String pseudo) {
//        int credit = jdbcTemplate.queryForObject(RECUPERER_CREDIT, Integer.class, pseudo);
//
//        return credit;
//    }
//}
