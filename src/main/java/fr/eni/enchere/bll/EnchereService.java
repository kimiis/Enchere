package fr.eni.enchere.bll;

import fr.eni.enchere.ObjetSQL.Enchere;
import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.dal.EnchereDao;
import fr.eni.enchere.dal.ProfilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service

public class EnchereService {
    @Autowired
    private EnchereDao enchereDAO;

    @Autowired
    private ProfilDAO profilDAO;

    @Autowired
    ObjetService objetService;

    public List<Enchere> getEnCoursParticipe(int idUser) {
        return enchereDAO.getEnCoursParticipe(idUser);
    }

    public List<Enchere> getWin(int idUser) {
        return enchereDAO.getWin(idUser);
    }

    public List<Enchere> getEncherePlusHaute(int idObjet) {
        return enchereDAO.getEncherePlusHaute(idObjet);
    }

    @Transactional(rollbackFor = Exception.class) // Rollback for all exceptions
//    indique à Spring de gérer une transaction autour de cette méthode et de la rollback si une exception est levée.
//    L'argument rollbackFor = Exception.class signifie que la transaction sera annulée pour toutes les exceptions, ce qui inclut
//    Error et ses sous-classes.

    public void addEnchere(Utilisateur utilisateur, Objet objet, int prix) throws Error {
        //On récupere le prix départ de l'objet sur lequel le nouvel encherisseur veux encherir
        int prixD = objet.getPrix();
        // On récupere l'enchere la plus haute de cet objet et on la stocke dans objet
        List<Enchere> enchere = enchereDAO.getEncherePlusHaute(objet.getId());
        // On initialise le prix actuel au prix départ de l'objet
        int prixActu = prixD;

        //Si l'objet a au moins une enchere
        //if(!Objects.isNull(enchere.getPrix()))
        //Pourquoi Objects
//c'est la class qui permet de verifier si un objet est null, en fait comme sur null on peux faire aucune fonction
// (si jamais tu fait un truc genre null.IsNull()) Ca te diras "NullPointerExeption"
// Il fallait qu'il mette quelque par la fonction pour verifier qu'un objet est null,Du coups ils l'on mis dans Objects
// vu qu'on verifie un objet
        if (!enchere.isEmpty()) {
            //On met le prix actuel au prix de l'enchere la plus haute
            prixActu = enchere.get(0).getPrix();
        }
        //Si l'utilisateur est déja l'encherisseur qui a la plus haute enchere
        if (!enchere.isEmpty() && enchere.get(0).getIdAcheteur() == utilisateur.getId()) {
            //On sort d'ici
            throw new Error("c'est déjà toi qui à la plus grosse !");
        }
        // Si l'utilisateur qui encherit n'as pas assez de crédit sur son compte pour payer le prix qu'il a mis
        if (utilisateur.getCredit() < prixActu) {
            // on sort
            throw new Error("t'es trop pauvre !");
            // SI l'offre de l'encherisseur est inferieur au prix actuel de l'objet (Soit prix départ si pas enchere, soit prix plus haute enchere si enchere
        } else if (prix < prixActu) {
            // on sort
            throw new Error("wsh arrete de faire ton radin augmente la mise!");
        }
        if(new Date().after(objet.getDateF())){
            throw new Error("trop tard c'est fini!");
        }
        // je le debite
        profilDAO.modifCredit(utilisateur.getCredit() - prix,utilisateur.getId());
        // Si l'objet a au moins une enchere, on sait deja que j'ai la plus grosse,
        if (!enchere.isEmpty()) {
            //je vais get mon ancien encherisseur
            Utilisateur ancienEncherisseur = profilDAO.getUserById(enchere.get(0).getIdAcheteur());
            //je le rembourse
            profilDAO.modifCredit( ancienEncherisseur.getCredit()+ enchere.get(0).getPrix(), ancienEncherisseur.getId());
        }
        // Enfin on créer la nouvelle enchere, avec l'utilisateur actuel, son prix et on la lie à l'objet sur lequel il veux faire une enchere
        enchereDAO.addEnchere(utilisateur.getId(), objet.getId(), prix);
    }



}
