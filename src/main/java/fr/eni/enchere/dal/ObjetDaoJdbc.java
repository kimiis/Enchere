package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.bo.FormFiltre;
import fr.eni.enchere.bo.ObjetForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    private final String JOINTURES = "    LEFT join Couleur C on C.Id = o.IdCouleur\n" +
            "    LEFT join Coupe C2 on C2.Id = o.idCoupe\n" +
            "    LEFT join Energie E on E.Id = o.IdEnergie\n" +
            "    LEFT join Localisation L on L.Id = o.IdLocalisation\n" +
            "    LEFT join Marque M on M.Id = o.IdMarque\n" +
            "    LEFT join Taille T on T.Id = o.IdTaille\n" +
            "    LEFT join Type T2 on T2.Id = o.IdType\n" +
            "    LEFT join ModaliteRetrait R on R.Id = o.IdRetrait\n";

    private final String FIND_ALL = SELECT + " FROM Objet";
    private final String FIND_BY_FILTRE =
            "DECLARE @Condition INT = :condition;" +
                    "SELECT " +
                    "WHERE COULEUR";
    private final String INSERT_OBJET = "INSERT INTO Objet VALUES (:energieElec, :nbRoue, :annee,:portable, :encastrable, :dateD, :dateF, :prix, '', :nom,:description, :idUtilisateur, :idRetrait, :idCoupe, :idCouleur, :idMarque, :idType, :idLocalisation, :idEnergie, :idTaille)";
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

    private final String SEARCH_BY_NAME_TYPE = SELECT + " FROM Objet AS o" +
            JOINTURES +
            "    WHERE o.IdType = :idType AND o.nom LIKE :nom";

    private final String GET_OBJET_BY_FILTRE = SELECT + " FROM Objet AS o" +
            JOINTURES +
            " WHERE ";


    public void insertObjet(int idUser, ObjetForm objetForm) {
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("dateD", objetForm.getDateD());
        parametreSource.addValue("dateF", objetForm.getDateF());
        parametreSource.addValue("prix", objetForm.getPrix());
        parametreSource.addValue("nom", objetForm.getNom());
        parametreSource.addValue("description", objetForm.getDescription());
        parametreSource.addValue("idUtilisateur", idUser);
        parametreSource.addValue("idRetrait", objetForm.getIdRetrait());
        parametreSource.addValue("idType", objetForm.getIdType());
        parametreSource.addValue("idTaille", objetForm.getIdTaille());
        parametreSource.addValue("nbRoue", objetForm.getNbRoues());
        parametreSource.addValue("encastrable", objetForm.isEncastrables());
        parametreSource.addValue("idCoupe", objetForm.getIdCoupe());
        parametreSource.addValue("idCouleur", objetForm.getIdCouleur());
        parametreSource.addValue("idMarque", objetForm.getIdMarque());
        parametreSource.addValue("idLocalisation", objetForm.getIdLocalisation());
        parametreSource.addValue("idEnergie", objetForm.getIdEnergie());
        parametreSource.addValue("energieElec", objetForm.getEnergieElec());
        parametreSource.addValue("annee", objetForm.getAnnee());
        parametreSource.addValue("portable", objetForm.isPortable());

        namedParameterJdbcTemplate.update(INSERT_OBJET, parametreSource);
    }

    public List<Objet> findAll() {
        return namedParameterJdbcTemplate.query(FIND_ALL, new ObjetMapper());
    }

    public List<Objet> findByType(String typeName) {
        System.out.println("---------------------------------typeName---------------------------------");
        System.out.println(typeName);
//        creer un objet (parametreSource) qui va contenir toute les proprietes qui vont etre remplacé dans la requete sql
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();
        parametreSource.addValue("typeName", typeName);
        return namedParameterJdbcTemplate.query(FIND_BY_TYPE, parametreSource, new ObjetMapper());
    }

    public Objet consulterObjetParId(int idObjet) {
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
        parametreSource.addValue("nom", "%" + nom + "%");
        parametreSource.addValue("idType", idType);
        return namedParameterJdbcTemplate.query(SEARCH_BY_NAME_TYPE, parametreSource, new ObjetMapper());

    }

    public List<Objet> getObjetByFiltre(FormFiltre formFiltre) {
        MapSqlParameterSource parametreSource = new MapSqlParameterSource();

        List<String> sqlCondition = new ArrayList<String>();

        if (formFiltre.isOn() && formFiltre.isOn()) {
            sqlCondition.add(" DateD < GETDATE() ");

        } else if (formFiltre.isOn()) {
            sqlCondition.add(" DateD < GETDATE() AND DateF > GETDATE() ");

        } else if (formFiltre.isOff()) {
            sqlCondition.add("DateF <  GETDATE() ");
        }
//        on verif qu'o nest pas une couleur a  null, si c'est null on ne rentre as dedans;
//        ensuite on met le && qui verif si le string n'est pas empty si tous est ok on rentre dans la condition
        if(!"".equals(formFiltre.getCouleur()) && !Objects.isNull(formFiltre.getCouleur()) ) {
            sqlCondition.add(" C.nom = '"  + formFiltre.getCouleur() + "' ");
        }
        if(!"".equals(formFiltre.getEnergie()) && !Objects.isNull(formFiltre.getEnergie()) ) {
            sqlCondition.add(" E.nom = '"  + formFiltre.getEnergie() + "' ");
        }
        if(!"".equals(formFiltre.getLocalisation()) && !Objects.isNull(formFiltre.getLocalisation()) ) {
            sqlCondition.add(" L.nom = '"  + formFiltre.getLocalisation() + "' ");
        }
        if(!"".equals(formFiltre.getPrixMax()) && !Objects.isNull(formFiltre.getPrixMax()) ) {
            sqlCondition.add(" prixD < "  + formFiltre.getPrixMax() + " ");
        }
        if(!"".equals(formFiltre.getPrixMin()) && !Objects.isNull(formFiltre.getPrixMin()) ) {
            sqlCondition.add(" prixD > " + formFiltre.getPrixMin() + " ");
        }
        return namedParameterJdbcTemplate.query(GET_OBJET_BY_FILTRE + String.join("AND",sqlCondition), new ObjetMapper());

    }
    public List<Objet> getEnCoursParticipe (int idUser){

        return null;
    }


}
 