package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.dal.ObjetDao;
import fr.eni.enchere.dal.ObjetMapper;
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
    private final String SELECT = " SELECT Energie, o.Id as IdObjet, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, o.nom as nomObjet, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, o.IdType, IdLocalisation, IdEnergie, IdTaille, \n" +
            "    C.nom  as nomCouleur    , C.Texte  as texteCouleur,\n" +
            "    C2.nom as nomCoupe      , C2.Texte as texteCoupe,\n" +
            "    E.nom  as nomEnergie    , E.Texte  as texteEnergie,\n" +
            "    L.nom  as nomLoca       , L.Texte  as texteLoca,\n" +
            "    M.nom  as nomMarque     , M.Texte  as texteMarque,\n" +
            "    T.nom  as nomTaille     , T.Texte  as texteTaille,\n" +
            "    T2.nom as nomType       , T2.Texte as texteType";


    private final String JOINTURES =  "    LEFT join Couleur C on C.Id = o.IdCouleur\n" +
            "    LEFT join Coupe C2 on C2.Id = o.idCoupe\n" +
            "    LEFT join Energie E on E.Id = o.IdEnergie\n" +
            "    LEFT join Localisation L on L.Id = o.IdLocalisation\n" +
            "    LEFT join Marque M on M.Id = o.IdMarque\n" +
            "    LEFT join Taille T on T.Id = o.IdTaille\n" +
            "    LEFT join Type T2 on T2.Id = o.IdType\n";
    private final String FIND_ALL = SELECT + " FROM Objet";
    private final String FIND_BY_FILTRE =
            "DECLARE @Condition INT = :condition;" +
                    "SELECT " +
                    "WHERE COULEUR";
    private final String INSERT_OBJET= "INSERT INTO Objet VALUES (null, '', 0, null, null, :dateD, :dateF, :prix,'', :nom,:description, :idUtilisateur, :idRetrait, null,null, null, :idType, null, null, null)";
    private final String FIND_BY_TYPE = SELECT + " from Objet as o" +
            JOINTURES +
            "    where T2.Nom = :typeName";
    private final String FIND_BY_ID = SELECT + " FROM Objet as o " +
            JOINTURES +
            "    WHERE o.Id =:idObjet";

    public void insertObjet(Date dateD,Date dateF, int prix, String nom, String descrip, int idUser, int idRetrait, int idType, int nbRoue, boolean encastrable, boolean portable, int idCoupe, int idCouleur, int idMarque, String localisation, String energie){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("dateD", dateD);
        parametreSource.addValue("dateF", dateF);
        parametreSource.addValue("prix", prix);
        parametreSource.addValue("nom", nom);
        parametreSource.addValue("description", descrip);
        parametreSource.addValue("idUtilisateur", idUser);
        parametreSource.addValue("idRetrait", idRetrait);
        parametreSource.addValue("idType", idType);
        parametreSource.addValue("nbRoue", nbRoue);
        parametreSource.addValue("encastrable", encastrable);
        parametreSource.addValue("idCoupe", idCoupe);
        parametreSource.addValue("idCouleur", idCouleur);
        parametreSource.addValue("idMarque", idMarque);
        parametreSource.addValue("localisation", localisation);
        parametreSource.addValue("energie", energie);

        namedParameterJdbcTemplate.update(INSERT_OBJET, parametreSource);
    }
    public List<Objet> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new ObjetMapper());
    }
    public List<Objet> findByType(String typeName){
        System.out.println("---------------------------------typeName---------------------------------");
        System.out.println(typeName);
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("typeName", typeName);
        return namedParameterJdbcTemplate.query(FIND_BY_TYPE, parametreSource, new ObjetMapper());
    }

    public Objet consulterObjetParId (int idObjet){
        System.out.println("---------------------------------typeName---------------------------------");
        System.out.println(idObjet);
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idObjet", idObjet);
        return namedParameterJdbcTemplate.queryForObject(FIND_BY_ID, parametreSource, new ObjetMapper());
    }
}
 