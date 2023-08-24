package fr.eni.enchere.controller;

import fr.eni.enchere.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EnchereController {

    @Autowired
    CouleurDAOJdbc couleurDAOJdbc;
    @Autowired
    EnergieDAOJdbc energieDAOJdbc;
    @Autowired
    LocalisationDAOJdbc localisationDAOJdbc;
    @Autowired
    MarqueDAOJdbc marqueDAOJdbc;
    @Autowired
    ModaliteRetraitDAOJdbc modaliteRetraitDAOJdbc;
    @Autowired
    TailleDAOJdbc tailleDAOJdbc;
    @Autowired
    TypeDAOJdbc typeDAOJdbc;

    public void afficherFiltre(Model model){
        model.addAttribute("marques", marqueDAOJdbc.findAll());
        model.addAttribute("couleurs", couleurDAOJdbc.findAll());
        model.addAttribute("retraits", modaliteRetraitDAOJdbc.findAll());
        model.addAttribute("localisations", localisationDAOJdbc.findAll());
    }
    //----------------------------------Auto--------------------------------------
    @GetMapping("/auto")
    String afficherFiltreAuto(Model model){
        afficherFiltre(model);
        System.out.println(marqueDAOJdbc.findAll());
        model.addAttribute("energies", energieDAOJdbc.findAll());
        return "PagesEncheres/auto";
    }
    //----------------------------------Vetements--------------------------------------
    @GetMapping("/vetements")
    String afficherFiltreVet(Model model){
        afficherFiltre(model);
        model.addAttribute("tailles", tailleDAOJdbc.findAll());
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
