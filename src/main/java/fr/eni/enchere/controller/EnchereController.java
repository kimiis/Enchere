package fr.eni.enchere.controller;

import fr.eni.enchere.bll.*;
import fr.eni.enchere.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    public void afficherFiltre(Model model){
        model.addAttribute("marques", marqueService.recupererInfos());
        model.addAttribute("couleurs", couleurService.recupererInfos());
        model.addAttribute("retraits", retraitService.recupererInfos());
        model.addAttribute("localisations", localisationService.recupererInfos());
    }
    //----------------------------------Auto--------------------------------------
    @GetMapping("/auto")
    String afficherFiltreAuto(Model model){
        afficherFiltre(model);
        model.addAttribute("energies", energieService.recupererInfos());
        return "PagesEncheres/auto";
    }
    //----------------------------------Vetements--------------------------------------
    @GetMapping("/vetements")
    String afficherFiltreVet(Model model){
        afficherFiltre(model);
        model.addAttribute("tailles", tailleService.recupererInfos());
        return "PagesEncheres/vetements";
    }
    //----------------------------------Console--------------------------------------
    @GetMapping("/consoles")
    String afficherFiltreConsole(Model model){
        afficherFiltre(model);
        return "PagesEncheres/consoles";
    }
    //----------------------------------ElectroM--------------------------------------
    @GetMapping("/electromenager")
    String afficherFiltreElectroM(Model model){
        afficherFiltre(model);
        return "PagesEncheres/electromenager";
    }
    //----------------------------------JeuxSociete--------------------------------------
    @GetMapping("/highTech")
    String afficherFiltreHigh(Model model){
        afficherFiltre(model);
        return "PagesEncheres/highTech";
    }
    //----------------------------------ProduitBeaute--------------------------------------

    @GetMapping("/produitBeaute")
    String afficherFiltreProduitB(Model model){
        afficherFiltre(model);
        return "PagesEncheres/produitBeaute";
    }

}
