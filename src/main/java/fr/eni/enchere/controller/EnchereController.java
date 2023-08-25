package fr.eni.enchere.controller;

import fr.eni.enchere.ObjetSQL.Objet;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.bll.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


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

    public void afficherFiltre(Model model, String typeName) {
        model.addAttribute("listObjet", objetService.findByType(typeName));
        model.addAttribute("marques", marqueService.getMarquesByTypeName(typeName));
        model.addAttribute("couleurs", couleurService.recupererInfos());
        model.addAttribute("retraits", retraitService.recupererInfos());
        model.addAttribute("localisations", localisationService.recupererInfos());
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
        return "vendre_article";
    }

    //----------------------------------Creation objet--------------------------------------
    @GetMapping("/createObjet")
    String afficherPage() {
        return "createObjet";
    }


    @PostMapping("/createObjet")
    String boutonValider(Principal principal, Objet objet) {
        Utilisateur u = profilService.recupererInfos(principal.getName());

        objetService.insertObjet(objet.getDateD(), objet.getDateF(), objet.getPrix(), objet.getNom(), objet.getDescription(), u.getId(), objet.getIdRetrait(), objet.getIdType());
        return "createObjet";
    }

    //----------------------------------Detail objet--------------------------------------
    @GetMapping("/detailObjet")
    public String detailObjet(@RequestParam(name = "idObjet", required = true) int idObjet, Model model) {

        model.addAttribute("detailObjet", objetService.consulterObjetParId(idObjet));

        return "detailObjet";
    }

}
