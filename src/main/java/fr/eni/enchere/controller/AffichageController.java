package fr.eni.enchere.controller;

import fr.eni.enchere.bll.EnchereService;
import fr.eni.enchere.bo.UtilisateurInscription;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"connecte"})

public class AffichageController {
    //----------------------------------Accueil--------------------------------------
    @GetMapping("/accueil")
    public String afficherPageAcc(@ModelAttribute("connecte")boolean connect) {
        System.out.println(connect);
        return "accueil";
    }

    //----------------------------------Subscribe--------------------------------------
    @GetMapping("/subscribe")
    public String afficherPageSub() {
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public String verifInscription(UtilisateurInscription user){
//        boolean est ce que pseudo > 3
        System.out.println("hola");
       if(user.getPseudo().length()<3) {
           return "ErreurInscription";
       }
       if(!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
           return "ErreurInscription";
       }
       if(!user.getMdp().matches("^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$")){
           return "ErreurInscription";
       }
        return "succes";


    }
    //----------------------------------Connexion--------------------------------------
    @GetMapping("/connexion")
    String afficherConnexion(@ModelAttribute("connecte") boolean connect) {
        System.out.println("co");
        connect = true;
        System.out.println(connect);
        return "login";
    }

    @PostMapping("/connexion")//au mmt je clique sur login connect passe a true donc je suis co
    String connexion(@ModelAttribute("connecte") boolean connect ){
        System.out.println("co");
        connect=true;
        return "accueil";
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

    @ModelAttribute("connecte")//au moment où j'arrive sur la page je suis déco
    public boolean initConnecte() {
        return false;
    }

}
