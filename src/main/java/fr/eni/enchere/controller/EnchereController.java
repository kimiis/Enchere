package fr.eni.enchere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EnchereController {

    //----------------------------------Auto--------------------------------------
    @GetMapping("/auto")
    String afficherAuto(){
        return "PagesEncheres/auto";
    }
    //----------------------------------Vetements--------------------------------------
    @GetMapping("/vetements")
    String afficherVet(){
        return "PagesEncheres/vetements";
    }
    //----------------------------------Console--------------------------------------
    @GetMapping("/consoles")
    String afficherConsole(){
        return "PagesEncheres/consoles";
    }
    //----------------------------------ElectroM--------------------------------------
    @GetMapping("/electromenager")
    String afficherElectroM(){
        return "PagesEncheres/electromenager";
    }
    //----------------------------------JeuxSociete--------------------------------------
    @GetMapping("/jeuxSociete")
    String afficherJeuxS(){
        return "HightTech";
    }
    //----------------------------------ProduitBeaute--------------------------------------

    @GetMapping("/produitBeaute")
    String afficherProduitB(){
        return "PagesEncheres/produitBeaute";
    }

}
