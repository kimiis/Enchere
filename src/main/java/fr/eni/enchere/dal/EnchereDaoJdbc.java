package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Enchere;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnchereDaoJdbc implements EnchereDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public EnchereDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Enchere> getEnCoursParticipe(int idUser) {

        final String GET_EN_COURS_PARTICIPE =
                "       SELECT O.nom AS objetNom, DateD, DateF, T.Nom AS typeNom,IdObjet,max(Prix) AS prix\n" +
                        "       FROM Enchere AS E INNER JOIN Objet O ON O.Id = E.IdObjet INNER JOIN Type T ON T.Id = O.IdType\n" +
                        "       WHERE idAcheteur=:idUser AND DateD < GETDATE() AND DateF > GETDATE() \n" +
                        "       GROUP BY IdObjet, O.nom, DateD, DateF, T.Nom;\n";
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
        return namedParameterJdbcTemplate.query(GET_EN_COURS_PARTICIPE, parametreSource, new EnchereMapper());

    }

    public List<Enchere> getWin(int idUser) {
        final String GET_WIN =
                "   SELECT O.nom AS objetNom, DateD, DateF, T.Nom AS typeNom,IdObjet,max(Prix) AS prix \n" +
                        "   FROM Enchere AS E INNER JOIN dbo.Objet O ON O.Id = E.IdObjet INNER JOIN dbo.Type T ON T.Id = O.IdType\n" +
                        "   WHERE idAcheteur=:idUser AND prix = (SELECT MAX(Prix) FROM Enchere where IdObjet = O.Id) AND DateF<GETDATE()\n" +
                        "   GROUP BY  IdObjet, O.nom, DateD, DateF, T.Nom";

        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
        return namedParameterJdbcTemplate.query(GET_WIN, parametreSource, new EnchereMapper());
    }

    public void addEnchere(int idUser, int idObjet, int prix) {
        final String ADD_ENCHERE = "INSERT INTO ENCHERE (idAcheteur, idObjet, prix) VALUES (:idUser, :idObjet, :prix)";

        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
        parametreSource.addValue("idObjet", idObjet);
        parametreSource.addValue("prix", prix);
        namedParameterJdbcTemplate.update(ADD_ENCHERE, parametreSource);
    }

    public Enchere getEncherePlusHaute(int idObjet) {
        final String GET_PLUS_HAUT =
                "        SELECT O.nom AS objetNom, DateD, DateF, T.Nom AS typeNom,IdObjet,prix, idAcheteur \n" +
                        "FROM Enchere AS E INNER JOIN Objet O ON O.Id = E.IdObjet INNER JOIN Type T ON T.Id = O.IdType\n" +
                        "WHERE prix = (SELECT MAX(prix) FROM Enchere  WHERE IdObjet = E.IdObjet ) AND IdObjet = :idObjet\n";

        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idObjet", idObjet);
        return namedParameterJdbcTemplate.queryForObject(GET_PLUS_HAUT, parametreSource, new EnchereMapper());

    }

////     Récupérer le crédit de l'utilisateur et les afficher dans son profil
//    private final static String RECUPERER_CREDIT = "SELECT credit From UTILISATEURS WHERE pseudo= :idUser";
//
//    public int recupererCredit(String pseudo) {
//        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
//        parametreSource.addValue("pseudo", pseudo);
//
//        namedParameterJdbcTemplate.queryForObject(RECUPERER_CREDIT, Integer.class, pseudo);
//
//        return credit;}


}
