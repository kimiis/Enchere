package fr.eni.enchere.controller;

import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.bll.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes({"connecte"})


public class AffichageController {

    @Autowired
    ProfilService profilService;


    //----------------------------------Accueil--------------------------------------
    @GetMapping({"/accueil", "/"})
    public String afficherPageAcc(@ModelAttribute("connecte") boolean connect) {
        System.out.println(connect);
        return "accueil";
    }

    //----------------------------------Subscribe--------------------------------------
    @GetMapping("/subscribe")
    public String afficherPageSub() {
        return "subscribe";
    }

//    @PostMapping("/subscribe")
//    public String verifInscription(UtilisateurInscription user) {
////        boolean est ce que pseudo > 3
//        System.out.println("hola");
//        if (user.getPseudo().length() < 3) {
//            return "ErreurInscription";
//        }
//        if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
//            return "ErreurInscription";
//        }
//        if (!user.getMdp().matches("^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$")) {
//            return "ErreurInscription";
//        }
//
//
//        return "succes";
//    }

    @PostMapping("/subscribe")
    public String verifInscription(Utilisateur u) {
//        boolean est ce que pseudo > 3
        System.out.println("hola");
        profilService.ajouter(u);


        return "succes";
    }

    //----------------------------------Connexion--------------------------------------
    @GetMapping("/login")
//    lorque que j'arrive sur la page je suis en true
    String afficherConnexion(@ModelAttribute("connecte") boolean connect) {
        connect = true;
        return "login";
    }

    //----------------------------------Succes--------------------------------------
    @GetMapping("/succes")
    String redirectionSucces() {
        return "succes";
    }

    //----------------------------------Vendre--------------------------------------
    @GetMapping("/vendre_article")
    String afficherVendre() {
        return "vendre_article";
    }

    //----------------------------------Profil--------------------------------------
    @GetMapping("/profil")
    String afficherProfil(Principal principal, Model model) {
        System.out.println(principal.getName());
        Utilisateur u = profilService.recupererInfos(principal.getName());
        model.addAttribute("profUti",u);
        return "profil";

    }

    @PostMapping("/profil")
    String modifierProfil(Utilisateur utilisateur){
        System.out.println(utilisateur);
        Utilisateur um = profilService.modifierInfos(utilisateur);
       return "redirect:/profil";

    }

    @PostMapping("/delete")
    String supprimerProfil(int noUtilisateur ) {
        //System.out.println(noUtilisateur);
        profilService.supprimerProfil(noUtilisateur);
        return "redirect:/";
    }


    //----------------------------------Deconnexion--------------------------------------
    @GetMapping("/deconnexion")
    String redirectAccueil(){
        return "accueil";
    }

    @ModelAttribute("connecte")//au moment où j'arrive sur la page je suis déco
    public boolean initConnecte() {
        return false;
    }




}
