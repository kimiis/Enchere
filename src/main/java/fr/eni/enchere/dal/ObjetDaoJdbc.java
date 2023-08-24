package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ObjetDaoJdbc implements ObjetDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String FIND_ALL = "SELECT * FROM Objet";

    public List<Objet> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Objet.class));
    }
}
