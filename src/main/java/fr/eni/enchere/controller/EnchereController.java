package fr.eni.enchere.controller;

import fr.eni.enchere.ObjetSQL.Enchere;
import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.ObjetSQL.Type;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.bll.*;
import fr.eni.enchere.bo.EnchereForm;
import fr.eni.enchere.bo.ObjetForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller

public class EnchereController {

    @Autowired
    CouleurService couleurService;
    @Autowired
    EnergieService energieService;
    @Autowired
    LocalisationService localisationService;
    @Autowired
    MarqueService marqueService;
    @Autowired
    RetraitService retraitService;
    @Autowired
    TailleService tailleService;
    @Autowired
    TypeService typeService;
    @Autowired
    ObjetService objetService;
    @Autowired
    ProfilService profilService;
    @Autowired
    CoupeService coupeService;
    @Autowired
    EnchereService enchereService;


    //----------------------------------Filtre--------------------------------------

    public void afficherFiltre(Model model, String typeName) {
//        va permettre de recuperer tous les objets de type typeName
        model.addAttribute("listObjet", objetService.findByType(typeName));
        model.addAttribute("marques", marqueService.getMarquesByTypeName(typeName));
        model.addAttribute("couleurs", couleurService.recupererInfos());
        model.addAttribute("retraits", retraitService.recupererInfos());
        model.addAttribute("localisations", localisationService.recupererInfos());
    }

    @ModelAttribute("types")
    public List<Type> types() {
        return typeService.recupererInfos();
    }

    //----------------------------------Auto--------------------------------------
    @GetMapping("/auto")
    String afficherFiltreAuto(Model model) {
        afficherFiltre(model, "vehicule");
        model.addAttribute("energies", energieService.recupererInfos());
        return "PagesEncheres/auto";
    }

    //----------------------------------Vetements--------------------------------------
    @GetMapping("/vetements")
    String afficherFiltreVet(Model model) {
        afficherFiltre(model, "vet");
        model.addAttribute("tailles", tailleService.recupererInfos());
        model.addAttribute("coupes", coupeService.recupererInfos());

        return "PagesEncheres/vetements";
    }

    //----------------------------------Console--------------------------------------
    @GetMapping("/consoles")
    String afficherFiltreConsole(Model model) {
        afficherFiltre(model, "console");
        return "PagesEncheres/consoles";
    }

    //----------------------------------ElectroM--------------------------------------
    @GetMapping("/electromenager")
    String afficherFiltreElectroM(Model model) {
        afficherFiltre(model, "elec");
        return "PagesEncheres/electromenager";
    }

    //----------------------------------JeuxSociete--------------------------------------
    @GetMapping("/highTech")
    String afficherFiltreHigh(Model model) {
        afficherFiltre(model, "ht");
        return "PagesEncheres/highTech";
    }
    //----------------------------------ProduitBeaute--------------------------------------

    @GetMapping("/produitBeaute")
    String afficherFiltreProduitB(Model model) {
        afficherFiltre(model, "pb");
        return "PagesEncheres/produitBeaute";
    }
    //----------------------------------Vente--------------------------------------

    @GetMapping("/vendre_article")
    String addType(Model model) {
        model.addAttribute("retraits", retraitService.recupererInfos());
        model.addAttribute("types", typeService.recupererInfos());
        model.addAttribute("couleurs", couleurService.recupererInfos());
        model.addAttribute("coupes", coupeService.recupererInfos());
        model.addAttribute("localisations", localisationService.recupererInfos());
        model.addAttribute("energies", energieService.recupererInfos());
        model.addAttribute("tailles", tailleService.recupererInfos());
        model.addAttribute("marques", marqueService.recupererInfos());


        return "vendre_article";
    }

    //----------------------------------Creation objet--------------------------------------
    @GetMapping("/createObjet")
    String afficherPage() {
        return "createObjet";
    }

    @PostMapping("/createObjet")
// principal est une class  de SpringBoot, utilisateur = utilisateur créer par la page s'inscrire, et principal = utilisateur coté springsecurity
    String boutonValider(Principal principal, ObjetForm objet) {
        Utilisateur u = profilService.recupererInfos(principal.getName());
        objetService.insertObjet( u.getId(),objet);
        return "createObjet";
    }


    //----------------------------------Detail objet--------------------------------------
    //je récupere Objet objet pour l'afficher dans détailObjet
    @GetMapping("/detailObjet")
    public String detailObjet(@RequestParam(name = "idObjet", required = true) int idObjet, Model model) {
        Objet objet = objetService.consulterObjetParId(idObjet);
        int prix = objet.getPrix();
        List<Enchere> enchereLapLusHaute = enchereService.getEncherePlusHaute(idObjet);
        if(!enchereLapLusHaute.isEmpty()){
            prix = enchereLapLusHaute.get(0).getPrix();
        }

        model.addAttribute("detailObjet", objetService.consulterObjetParId(idObjet));
        model.addAttribute("enchereLaPlusHaute", prix);
        if(!enchereLapLusHaute.isEmpty()){
            model.addAttribute("topEncherisseur", profilService.getUserById(enchereLapLusHaute.get(0).getIdAcheteur()).getNom());
        }

        return "detailObjet";
    }

    //----------------------------------Mes enchères--------------------------------------
    @GetMapping("/mesEncheres")
    public String afficherPageEncheres(Principal principal, Model model) {
        //Ici, grace au principal on récupere le pseudo de l'utilisateur connecté
        //Ensuite on va chercher l'id de l'utilisateur grace a son pseudo dans le service profile Service
        //Le service nous retourne un objet Utilisateur sur lequel on récupere l'id
        int userId = profilService.recupererInfos(principal.getName()).getId();
        model.addAttribute("enCours", objetService.enCoursByIdUser(userId));
        model.addAttribute("termine", objetService.finiByIdUser(userId));
        model.addAttribute("futur", objetService.futurByIdUser(userId));
        model.addAttribute("enCoursParticipe", enchereService.getEnCoursParticipe(userId));
        model.addAttribute("win", enchereService.getWin(userId));

        return "mesEncheres";


    }

    //----------------------------------Faire une enchere--------------------------------------
    @PostMapping("/creerEnchere")
//création de ...Form afin de recuperer tous les champs du form par leurs names

    public String creeEnchere(Model model ,Principal principal, EnchereForm enchereForm) {
        //récuperation de toutes les infos du user
        Utilisateur u = profilService.recupererInfos(principal.getName());
//    objetService.consulterObjetParId() permet de rcup en bdd un objet grace à son ID
        Objet objet = objetService.consulterObjetParId(enchereForm.getIdObjet());
//    pas de maj car sinon je recupe type et non instanciation

//Avant de passer dans le controller, je laisse l'erreur se propager -> remonter jusqu'au main qui va afficher
// la page erreur.
//        on dit essaye (try) de faire toute l'action dans le try, et si on rencontre une erreur du type defini () on
//        on passe dans le catch.
//        catch evite de faire remonter plus haut l'erreur, et pour ça on va envoyer un msg erreur qui est set dans
//        encherService, et on lui return la fonction pour afficher /detailObjet

        try {
            enchereService.addEnchere(u, objet, enchereForm.getPrix());
        } catch (Error e) {
            model.addAttribute("erreur", e.getMessage());
           return detailObjet(enchereForm.getIdObjet(),model);
        }

        return "/nouvelEncherisseur";
    }
    //bouton = post mapping car, permet de ne pas avoir a afficher une page

}
