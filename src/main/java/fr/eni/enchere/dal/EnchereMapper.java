package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Enchere;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnchereMapper implements RowMapper<Enchere> {
    //c'est dans cette fonction, qut tu va créer ton enchere, qui va avoir toutes les propriétés que tu veux

    @Override
    public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {


        Enchere enchere = new Enchere();
//on set les proprietes non objet de l'Objet
        enchere.setIdObjet(rs.getInt("IdObjet"));
        enchere.setDateD(rs.getDate("dateD"));
        enchere.setDateF(rs.getDate("dateF"));
        enchere.setTypeNom(rs.getString("typeNom"));
        enchere.setObjetNom(rs.getString("objetNom"));
        enchere.setPrix(rs.getInt("prix"));
        enchere.setIdAcheteur(rs.getInt("idAcheteur"));

        return enchere;
    }
}
