package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TypeDAOJdbc implements TypeDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String FIND_ALL = "SELECT * FROM Type";
    private  final  String FIND_TYPE_BY_ID = "SELECT * FROM Type WHERE id = :id";

    public List<Type> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Type.class));
    }
    public Type getTypeById(int id){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();

        parametreSource.addValue("id", id);
//        query permet retourner une liste != query for object -> 1 seul objet
        return namedParameterJdbcTemplate.queryForObject(FIND_TYPE_BY_ID, parametreSource, new BeanPropertyRowMapper<>(Type.class));
    }
}
