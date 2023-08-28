package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Enchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnchereDaoJdbc implements EnchereDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    // Récupérer le crédit de l'utilisateur et les afficher dans son profil
//    private final static String RECUPERER_CREDIT = "SELECT credit From UTILISATEURS WHERE pseudo= ?";
//
//    @Override
//    public int recupererCredit(String pseudo) {
//        int credit = jdbcTemplate.queryForObject(RECUPERER_CREDIT, Integer.class, pseudo);
//
//        return credit;
//    }
    private final String GET_EN_COURS_PARTICIPE=
        "       SELECT O.nom AS objetNom, DateD, DateF, T.Nom AS typeNom,IdObjet,max(Prix) AS prix\n" +
        "       FROM Enchere AS E INNER JOIN Objet O ON O.Id = E.IdObjet INNER JOIN Type T ON T.Id = O.IdType\n" +
        "       WHERE idAcheteur=:idUser AND DateD < GETDATE() AND DateF > GETDATE() \n" +
        "       GROUP BY IdObjet, O.nom, DateD, DateF, T.Nom;\n";

    private final String GET_WIN=
            "   SELECT O.nom AS objetNom, DateD, DateF, T.Nom AS typeNom,IdObjet,max(Prix) AS prix \n" +
            "   FROM Enchere AS E INNER JOIN dbo.Objet O ON O.Id = E.IdObjet INNER JOIN dbo.Type T ON T.Id = O.IdType\n" +
            "   WHERE idAcheteur=:idUser AND prix = (SELECT MAX(Prix) FROM Enchere where IdObjet = O.Id) AND DateF<GETDATE()\n" +
            "   GROUP BY  IdObjet, O.nom, DateD, DateF, T.Nom";

    public List<Enchere> getEnCoursParticipe(int idUser){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
        return namedParameterJdbcTemplate.query(GET_EN_COURS_PARTICIPE, parametreSource, new EnchereMapper());

    }

    public List<Enchere> getWin(int idUser){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
        return namedParameterJdbcTemplate.query(GET_WIN, parametreSource, new EnchereMapper());
    }
}
