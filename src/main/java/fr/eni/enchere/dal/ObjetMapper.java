package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.*;
import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ObjetMapper implements RowMapper<Objet> {
    //Et c'est dans cette fonction, qut tu va créer ton objet, qui va avoir toutes les propriété que tu veux

    private final String GOOD_NAME = "SELECT * FROM Objet o inner join dbo.Couleur C on C.Id = o.IdCouleur inner join dbo.Coupe C2 on C2.Id = o.idCoupeinner join dbo.Energie E on E.Id = o.IdEnergieinner join dbo.Localisation L on L.Id = o.IdLocalisationinner join dbo.Marque M on M.Id = o.IdMarque";

    @Override
    public Objet mapRow(ResultSet rs, int rowNum) throws SQLException {

        Objet objet = new Objet();
        Couleur couleur = new Couleur();
        Coupe coupe = new Coupe();
        Energie energie = new Energie();
        Localisation localisation = new Localisation();
        Marque marque = new Marque();
        Taille taille = new Taille();
        Type type = new Type();

        objet.setId(rs.getInt("IdObjet"));
        objet.setEnergies(rs.getString("Energie"));
        objet.setEncastrable(rs.getBoolean("Encastarble"));
        objet.setNbRoue(rs.getInt("NbRoue"));
        objet.setAnnee(rs.getInt("Annee"));
        objet.setPortbale(rs.getBoolean("Portable"));
        objet.setDateD(rs.getDate("DateD"));
        objet.setDateF(rs.getDate("DateF"));
        objet.setPrix(rs.getInt("prixD"));
        objet.setDescription(rs.getString("description"));
        objet.setIdUser(rs.getInt("iDUtilisateur"));
        objet.setIdRetrait(rs.getInt("idRetrait"));
        couleur.setId(rs.getInt("IdCouleur"));
        coupe.setId(rs.getInt("idCoupe"));
        energie.setId(rs.getInt("IdEnergie"));
        marque.setId(rs.getInt("IdMarque"));
        localisation.setId(rs.getInt("IdLocalisation"));
        type.setId(rs.getInt("IdType"));
        taille.setId(rs.getInt("IdTaille"));
        couleur.setNom(rs.getString("nomCouleur"));
        couleur.setTexte(rs.getString("texteCouleur"));
        coupe.setNom(rs.getString("nomCoupe"));
        coupe.setTexte(rs.getString("texteCoupe"));
        energie.setNom(rs.getString("nomEnergie"));
        energie.setTexte(rs.getString("texteEnergie"));
        localisation.setNom(rs.getString("nomLoca"));
        localisation.setTexte(rs.getString("texteLoca"));
        marque.setNom(rs.getString("nomMarque"));
        marque.setTexte(rs.getString("texteMarque"));
        taille.setTexte(rs.getString("texteTaille"));
        taille.setNom(rs.getString("nomTaille"));
        type.setNom(rs.getString("nomType"));
        type.setTexte(rs.getString("texteType"));

        objet.setCouleur(couleur);
        objet.setCoupe(coupe);
        objet.setEnergie(energie);
        objet.setLocalisation(localisation);
        objet.setMarque(marque);
        objet.setType(type);
        objet.setTaille(taille);
        return objet;
    }

}
 