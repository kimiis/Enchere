package fr.eni.enchere.controller;

import fr.eni.enchere.bll.EnchereService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AffichageController {
    //----------------------------------Accueil--------------------------------------
    @GetMapping("/accueil")
    public String afficherPageAcc() {
        return "accueil";
    }

    //----------------------------------Subscribe--------------------------------------
    @GetMapping("/subscribe")
    public String afficherPageSub() {
        return "subscribe";
    }

    //----------------------------------Connexion--------------------------------------
    @GetMapping("/login")
    String afficherConnexion() {
        return "login";
    }
    //----------------------------------Vendre--------------------------------------
    @GetMapping("/vendre_article")
    String afficherVendre() {
        return "vendre_article";
    }

    //----------------------------------Profil--------------------------------------
    @GetMapping("/profil")
    String afficherProfil() {
        return "profil";
    }
}
