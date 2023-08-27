package fr.eni.enchere.controller;

import fr.eni.enchere.ObjetSQL.Type;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.bll.*;
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



    //----------------------------------Filtre--------------------------------------

    public void afficherFiltre(Model model, String typeName) {
        model.addAttribute("listObjet", objetService.findByType(typeName));
        model.addAttribute("marques", marqueService.getMarquesByTypeName(typeName));
        model.addAttribute("couleurs", couleurService.recupererInfos());
        model.addAttribute("retraits", retraitService.recupererInfos());
        model.addAttribute("localisations", localisationService.recupererInfos());
    }
    @ModelAttribute("types")//au moment où j'arrive sur la page je suis déco
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
        model.addAttribute("marques",marqueService.recupererInfos());


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
        objetService.insertObjet(objet.getDateD(), objet.getDateF(), objet.getPrix(), objet.getNom(),
                objet.getDescription(), u.getId(), objet.getIdRetrait(), objet.getIdType(), objet.getNbRoues(),
                objet.isEncastrables(),objet.isPortable(), objet.getIdCoupe(),objet.getIdCouleur(),objet.getIdMarque(),
                objet.getIdTaille(),objet.getIdLocalisation(),objet.getIdEnergie(), objet.getEnergieElec(), objet.getAnnee());
        return "createObjet";
    }


    //----------------------------------Detail objet--------------------------------------
    @GetMapping("/detailObjet")
    public String detailObjet(@RequestParam(name = "idObjet", required = true) int idObjet, Model model) {

        model.addAttribute("detailObjet", objetService.consulterObjetParId(idObjet));

        return "detailObjet";
    }
    //----------------------------------Mes enchères--------------------------------------
@GetMapping("/mesEncheres")
    public String afficherPageEncheres(Principal principal, Model model ){
    //Ici, grace au principal on récupere le pseudo de l'utilisateur
    //Ensuite on va chercher l'id de l'utilisateur grace a son pseudo dans le service profile Service
    //Le service nous retourne un objet Utilisateur sur lequel on récupere l'id
    int userName = profilService.recupererInfos(principal.getName()).getId();
    model.addAttribute("enCours", objetService.enCoursByIdUser(userName));
    model.addAttribute("termine", objetService.finiByIdUser(userName));
    model.addAttribute("futur", objetService.futurByIdUser(userName));
    System.out.println(principal);
    return "mesEncheres";
}

}
