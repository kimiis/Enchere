package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MarqueDAOJdbc implements MarqueDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String FIND_ALL = "SELECT M.nom, M.Id, M.Texte, M.IdType FROM Marque AS M INNER JOIN Type T on M.IdType = T.Id WHERE T.Nom = :nomType";

    private final String FIND_MARQUES_BY_TYPE_NAME = "SELECT * FROM Marque";

    public List<Marque> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Marque.class));
    }
    public List<Marque> getMarquesByTypeName(String typeName){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("nomType", typeName);
        return namedParameterJdbcTemplate.query(FIND_ALL, parametreSource, new BeanPropertyRowMapper<>(Marque.class));

    }
}
