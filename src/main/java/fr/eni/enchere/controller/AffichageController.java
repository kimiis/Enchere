package fr.eni.enchere.controller;

import fr.eni.enchere.bll.EnchereService;
import fr.eni.enchere.bo.UtilisateurInscription;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes({"connecte"})

public class AffichageController {
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

    @PostMapping("/subscribe")
    public String verifInscription(UtilisateurInscription user) {
//        boolean est ce que pseudo > 3
        System.out.println("hola");
        if (user.getPseudo().length() < 3) {
            return "ErreurInscription";
        }
        if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "ErreurInscription";
        }
        if (!user.getMdp().matches("^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$")) {
            return "ErreurInscription";
        }
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
    String afficherProfil(Principal principal) {
        System.out.println(principal.getName());

        return "profil";
    }
//
//    @PostMapping("/profil")
//    public afficherInfos<user.getPseudo()> create(@RequestBody user newUser) {
//
//        User user = userService.save(newUser);
//        if (user == null) {
//            throw new ServerException();
//        } else {
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        }
//    }


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
