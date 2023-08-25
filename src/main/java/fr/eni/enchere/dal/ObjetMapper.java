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


        objet.setId(rs.getInt("o.Id"));
        objet.setEnergies(rs.getString("Energie"));
        objet.setEncastrable(rs.getBoolean("Encastrable"));
        objet.setNbRoue(rs.getInt("NbRoue"));
        objet.setAnnee(rs.getInt("Annee"));
        objet.setPortbale(rs.getBoolean("Portable"));
        objet.setDateD(rs.getDate("DateD"));
        objet.setDateF(rs.getDate("DateF"));
        objet.setPrix(rs.getInt("prixD"));
        objet.setNom(rs.getString("o.Nom"));
        objet.setDescription(rs.getString("description"));
        objet.setIdUser(rs.getInt("iDUtilisateur"));
        objet.setIdRetrait(rs.getInt("idRetrait"));


        couleur.setId(rs.getInt("C.Id"));
        couleur.setNom(rs.getString("C.Nom"));
        couleur.setTexte(rs.getString("C.Texte"));
        coupe.setId(rs.getInt("C2.Id"));
        coupe.setNom(rs.getString("C2.Nom"));
        coupe.setTexte(rs.getString("C2.Texte"));
        energie.setNom(rs.getString("E.Nom"));
        energie.setTexte(rs.getString("E.Texte"));
        energie.setId(rs.getInt("E.id"));
        localisation.setId(rs.getInt("L.id"));
        localisation.setNom(rs.getString("L.Nom"));
        localisation.setTexte(rs.getString("L.Texte"));
        marque.setId(rs.getInt("M.Id"));
        marque.setNom(rs.getString("M.Nom"));
        marque.setTexte(rs.getString("M.Texte"));


        objet.setCouleur(couleur);
        objet.setCoupe(coupe);
        objet.setEnergie(energie);
        objet.setLocalisation(localisation);
        objet.setMarque(marque);
        return objet;
    }

}
