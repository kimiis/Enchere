package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Coupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CoupeJdbc implements CoupeDAO{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String FIND_ALL = "SELECT * FROM COUPE";

    public List<Coupe> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Coupe.class));
    }
}
