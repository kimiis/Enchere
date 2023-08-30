package fr.eni.enchere.dal;

import fr.eni.enchere.ObjetSQL.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ObjetMapper implements RowMapper<Objet> {
    //Et c'est dans cette fonction, que tu vas créer ton objet, qui va avoir toutes les propriété que tu veux


    @Override
    public Objet mapRow(ResultSet rs, int rowNum) throws SQLException {

        Objet objet = new Objet();

        // on declare les proprietes objet le l'objet Objet

        Couleur couleur = new Couleur();
        Coupe coupe = new Coupe();
        Energie energie = new Energie();
        Localisation localisation = new Localisation();
        Marque marque = new Marque();
        Taille taille = new Taille();
        Type type = new Type();
        Retrait retrait = new Retrait();

//on set les proprietes non objet de l'Objet
        objet.setId(rs.getInt("IdObjet"));
        objet.setNom(rs.getString("nomObjet"));
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

        //on declare les proprietes des sous objet du type Objet
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
        retrait.setNom(rs.getString("nomRetrait"));
        retrait.setId(rs.getInt("idRetrait"));
        retrait.setTexte(rs.getString("texteRetrait"));

        // on ajoute les objets au propriete de l'Objet
        objet.setCouleur(couleur);
        objet.setCoupe(coupe);
        objet.setEnergie(energie);
        objet.setLocalisation(localisation);
        objet.setMarque(marque);
        objet.setType(type);
        objet.setTaille(taille);
        objet.setRetrait(retrait);

        return objet;
    }

}
 