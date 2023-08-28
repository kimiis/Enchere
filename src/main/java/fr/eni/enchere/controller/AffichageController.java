package fr.eni.enchere.controller;

import fr.eni.enchere.ObjetSQL.Type;
import fr.eni.enchere.ObjetSQL.Utilisateur;
import fr.eni.enchere.bll.*;
import fr.eni.enchere.bo.FormFiltre;
import fr.eni.enchere.bo.SearchForm;
import fr.eni.enchere.dal.RetraitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes({"connecte"})


public class AffichageController {

    @Autowired
    ProfilService profilService;
    @Autowired
    private RetraitDAO modaliteRetraitDAO;
    @Autowired
    private ObjetService objetService;
    @Autowired
    private TypeService typeService;
    @Autowired
    LocalisationService localisationService;
    @Autowired
    CouleurService couleurService;
    @Autowired
    EnergieService energieService;
    @Autowired
    MarqueService marqueService;
    @Autowired
    RetraitService retraitService;
    @Autowired
    CoupeService coupeService;

    @Autowired
    TailleService tailleService;

    /**
     * Une fonction qui permet de mettre en session le type pour toutes les pages
     *
     * @return List<Type> La liste de tous les types présent en base
     */
    @ModelAttribute("types")
    public List<Type> types() {
        return typeService.recupererInfos();
    }

    @ModelAttribute("connecte")
    public boolean connecte() {
        return false;
    }
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
    public String encodage(Utilisateur u) {
        System.out.println("hola");
        if (u.getPseudo().length() < 3) {
            return "ErreurInscription";
        }
        if (!u.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "ErreurInscription";
        }
        if (!u.getMdp().matches("^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$")) {
            return "ErreurInscription";
        }
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


    //----------------------------------Profil--------------------------------------
    @GetMapping("/profil")
    String afficherProfil(Principal principal, Model model) {
        System.out.println(principal.getName());
        Utilisateur u = profilService.recupererInfos(principal.getName());
        model.addAttribute("profUti", u);
        return "profil";

    }

    @PostMapping("/profil")
    String modifierProfil(Utilisateur utilisateur) {
        System.out.println(utilisateur);
        Utilisateur um = profilService.modifierInfos(utilisateur);
        return "redirect:/profil";

    }

    @PostMapping("/delete")
    String supprimerProfil(String pseudo) {
        profilService.supprimerProfil(pseudo);
        return "redirect:/";
    }

    //----------------------------------Deconnexion--------------------------------------
    @GetMapping("/deconnexion")
    String redirectAccueil() {
        return "accueil";
    }

    //----------------------------------Search by name--------------------------------------
    @PostMapping("/searchByNameAndType")
    String searchByNameAndType(Model model, SearchForm searchForm) {
        objetService.searchByNameAndType(searchForm.getNom(), searchForm.getIdType());
        model.addAttribute("listObjet", objetService.searchByNameAndType(searchForm.getNom(), searchForm.getIdType()));
        model.addAttribute("marques", marqueService.getMarquesByTypeName(typeService.getTypeById(searchForm.getIdType()).getNom()));
        model.addAttribute("couleurs", couleurService.recupererInfos());
        model.addAttribute("retraits", retraitService.recupererInfos());
        model.addAttribute("localisations", localisationService.recupererInfos());


        switch (searchForm.getIdType()) {
            case 1:
                model.addAttribute("energies", energieService.recupererInfos());
                return "PagesEncheres/auto";


            case 2:
                return "PagesEncheres/consoles";

            case 3:
                model.addAttribute("tailles", tailleService.recupererInfos());
                model.addAttribute("coupes", coupeService.recupererInfos());
                return "PagesEncheres/vetements";

            case 4:
                return "PagesEncheres/produitBeaute";

            case 5:
                return "PagesEncheres/electromenager";

            case 6:
                return "PagesEncheres/highTech";

            case 7:
                return "PagesEncheres/services";


        }
        return "accueil";
    }
    //----------------------------------filtre recherche--------------------------------------

    @PostMapping("/filtre")
    public String filtreRecherche(FormFiltre formFiltre, Model model){

            return "filtre";
    }

}
