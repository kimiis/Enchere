package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import org.springframework.beans.factory.annotation.Autowired;
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
            "    T2.nom as nomType       , T2.Texte as texteType,\n" +
            "    R.nom  as nomRetrait    , R.Texte  as texteRetrait";



    private final String JOINTURES =  "    LEFT join Couleur C on C.Id = o.IdCouleur\n" +
            "    LEFT join Coupe C2 on C2.Id = o.idCoupe\n" +
            "    LEFT join Energie E on E.Id = o.IdEnergie\n" +
            "    LEFT join Localisation L on L.Id = o.IdLocalisation\n" +
            "    LEFT join Marque M on M.Id = o.IdMarque\n" +
            "    LEFT join Taille T on T.Id = o.IdTaille\n" +
            "    LEFT join Type T2 on T2.Id = o.IdType\n"+
            "    LEFT join ModaliteRetrait R on R.Id = o.IdRetrait\n";

    private final String FIND_ALL = SELECT + " FROM Objet";
    private final String FIND_BY_FILTRE =
            "DECLARE @Condition INT = :condition;" +
                    "SELECT " +
                    "WHERE COULEUR";
    private final String INSERT_OBJET= "INSERT INTO Objet VALUES (:energieElec, :nbRoue, :annee,:portable, :encastrable, :dateD, :dateF, :prix, '', :nom,:description, :idUtilisateur, :idRetrait, :idCoupe, :idCouleur, :idMarque, :idType, :idLocalisation, :idEnergie, :idTaille)";
    private final String FIND_BY_TYPE = SELECT + " FROM Objet AS o" +
            JOINTURES +
            "    WHERE T2.Nom = :typeName";
    private final String FIND_BY_ID = SELECT + " FROM Objet AS o " +
            JOINTURES +
            "    WHERE o.Id =:idObjet";

    private final String FIND_ID_USER_DATE_EN_COURS = SELECT + " FROM Objet AS o" +
            JOINTURES +
            "    WHERE idUtilisateur = :idUser AND DateD < GETDATE() AND DateF > GETDATE() ";


    private final String FIND_ID_USER_DATE_TERMINE = SELECT + " FROM Objet AS o" +
            JOINTURES +
            "    WHERE idUtilisateur = :idUser AND DateF <  GETDATE() ";

    private final String FIND_ID_USER_DATE_FUTUR = SELECT + " FROM Objet AS o" +
            JOINTURES +
            "    WHERE idUtilisateur = :idUser AND DateD >  GETDATE() ";

    private final String SEARCH_BY_NAME_TYPE =  SELECT + " FROM Objet AS o" +
            JOINTURES +
            "    WHERE o.IdType = :idType AND o.nom LIKE :nom";
    public void insertObjet(Date dateD,Date dateF, int prix, String nom, String descrip, int idUser, int idRetrait, int idType, int nbRoue, boolean encastrable, boolean portable, int idCoupe, int idCouleur, int idMarque,int idTaille, int idLocalisation, int idEnergie, String energieElec, int annee){
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("dateD", dateD);
        parametreSource.addValue("dateF", dateF);
        parametreSource.addValue("prix", prix);
        parametreSource.addValue("nom", nom);
        parametreSource.addValue("description", descrip);
        parametreSource.addValue("idUtilisateur", idUser);
        parametreSource.addValue("idRetrait", idRetrait);
        parametreSource.addValue("idType", idType);
        parametreSource.addValue("idTaille", idTaille);
        parametreSource.addValue("nbRoue", nbRoue);
        parametreSource.addValue("encastrable", encastrable);
        parametreSource.addValue("idCoupe", idCoupe);
        parametreSource.addValue("idCouleur", idCouleur);
        parametreSource.addValue("idMarque", idMarque);
        parametreSource.addValue("idLocalisation", idLocalisation);
        parametreSource.addValue("idEnergie",idEnergie);
        parametreSource.addValue("energieElec",energieElec);
        parametreSource.addValue("annee",annee);
        parametreSource.addValue("portable",portable);

        namedParameterJdbcTemplate.update(INSERT_OBJET, parametreSource);
    }
    public List<Objet> findAll(){
        return namedParameterJdbcTemplate.query(FIND_ALL, new ObjetMapper());
    }
    public List<Objet> findByType(String typeName){
        System.out.println("---------------------------------typeName---------------------------------");
        System.out.println(typeName);
//        creer un objet qui va contenir toute les proprietes qui vont etre remplacé dans la requete sql
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("typeName", typeName);
        return namedParameterJdbcTemplate.query(FIND_BY_TYPE, parametreSource, new ObjetMapper());
    }

    public Objet consulterObjetParId (int idObjet){
        System.out.println("---------------------------------typeName---------------------------------");
        System.out.println(idObjet);
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idObjet", idObjet);
//        retourne le premier resultat de la requ sql qui s'appel find by id, en remplaçant à l'inter de cette req les param defini
//        dans mon param source, et ce result va etre mis a l'interieur d'un objet de type objet
        return namedParameterJdbcTemplate.queryForObject(FIND_BY_ID, parametreSource, new ObjetMapper());
    }

    @Override
    public List<Objet> enCoursByIdUser(int idUser) {
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
//        query permet retourner une liste != query for object -> 1 seul objet
        return namedParameterJdbcTemplate.query(FIND_ID_USER_DATE_EN_COURS, parametreSource, new ObjetMapper());

    }

    public List<Objet> finiByIdUser(int idUser) {
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
//        query permet retourner une liste != query for object -> 1 seul objet
        return namedParameterJdbcTemplate.query(FIND_ID_USER_DATE_TERMINE, parametreSource, new ObjetMapper());

    }
    public List<Objet> futurByIdUser(int idUser) {
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("idUser", idUser);
//        query permet retourner une liste != query for object -> 1 seul objet
        return namedParameterJdbcTemplate.query(FIND_ID_USER_DATE_FUTUR, parametreSource, new ObjetMapper());
    }

    public List<Objet> searchByNameAndType(String nom, int idType) {
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
//        %= va rechercher tout ce qui est ecrit a l'interieur des %
//        rajout de "%" car java ne lit pas de la mm façon que sql
        parametreSource.addValue("nom", "%"+nom+"%");
        parametreSource.addValue("idType", idType);
        return namedParameterJdbcTemplate.query(SEARCH_BY_NAME_TYPE, parametreSource, new ObjetMapper());

    }
}
 