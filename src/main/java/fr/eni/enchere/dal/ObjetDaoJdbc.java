package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class ObjetDaoJdbc implements ObjetDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String FIND_ALL = "SELECT * FROM Objet";
    private final String FIND_BY_FILTRE =
            "DECLARE @Condition INT = :condition;" +
                    "SELECT " +
                    "WHERE COULEUR";
private final String INSERT_OBJET= "INSERT INTO Objet VALUES (null, '', 0, null, null, :dateD, :dateF, :prix,'', :nom,:description, :idUtilisateur, :idRetrait, null,null, null, :idType, null, null, null)";
private final String FIND_BY_TYPE = "SELECT * from Objet as o INNER JOIN Type T on o.IdType = T.Id where T.Nom = :typeName";
private final String FIND_BY_ID = "SELECT * FROM Objet as o WHERE o.id =:idObjet";

public void insertObjet(Date dateD,Date dateF, int prix, String nom, String descrip, int idUser, int idRetrait, int idType){
    MapSqlParameterSource parametreSource = new MapSqlParameterSource();
    parametreSource.addValue("dateD", dateD);
    parametreSource.addValue("dateF", dateF);
    parametreSource.addValue("prix", prix);
    parametreSource.addValue("nom", nom);
    parametreSource.addValue("description", descrip);
    parametreSource.addValue("idUtilisateur", idUser);
    parametreSource.addValue("idRetrait", idRetrait);
    parametreSource.addValue("idType", idType);

   namedParameterJdbcTemplate.update(INSERT_OBJET, parametreSource);
}
    public List<Objet> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Objet.class));
    }
    public List<Objet> findByType(String typeName){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("typeName", typeName);
        return namedParameterJdbcTemplate.query(FIND_BY_TYPE, parametreSource, new BeanPropertyRowMapper<>(Objet.class));
    }

    public Objet consulterObjetParId (int idObjet){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idObjet", idObjet);
        return namedParameterJdbcTemplate.queryForObject(FIND_BY_ID, parametreSource, new BeanPropertyRowMapper<>(Objet.class));
    }
}
