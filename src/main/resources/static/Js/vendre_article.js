onload = init
let selectCate;

function init() {

// ----------------------------------Recuperation info categorie--------------------------------------
    selectCate = document.getElementById("type")
// ----------------------------------Ajout listeners--------------------------------------
    selectCate.addEventListener("change", afficherChamps);
}

function verifierDate() {
    let heureFinElement = document.getElementById("heureF");
    let dateDebutElement = document.getElementById("heureD");

    let dateDebut = new Date(dateDebutElement.value);
    let dateFin = new Date(heureFinElement.value);

    if (dateFin < dateDebut) {
        heureFinElement.setCustomValidity("la date de fin doit être supérieur à la date de départ!")
    } else {
        heureFinElement.setCustomValidity("")
    }

    if (dateDebut <= new Date()) {
        dateDebutElement.setCustomValidity("la date doit être supérieur ou égal à la date du jour");
    } else {
        dateDebutElement.setCustomValidity("");
    }
}

function verifierPrix() {
    let prixDepart = document.getElementById("prix");

    if (prixDepart.value <= 0) {
        prixDepart.setCustomValidity("le prix doit être supérieur à 0");
    } else {
        prixDepart.setCustomValidity("");
    }

}

function verifierNom() {
    let nomArticle = document.getElementById("nameArticle");
    //dans l'input "user", j'accede a ce qui a été tapé dedans
    if (nomArticle.value.length < 3) {
        nomArticle.setCustomValidity("le nom doit faire au moins 3 char");
    } else {
        nomArticle.setCustomValidity("");
    }

}

function verifierDescription() {
    let descrip = document.getElementById("description");
    //dans l'input "user", j'accede a ce qui a été tapé dedans
    if (descrip.value.length <= 100) {
        descrip.setCustomValidity("la description doit faire au moins 100 char");
    } else {
        descrip.setCustomValidity("");
    }
}

// ----------------------------------Afficher champs suivant catégorie --------------------------------------
function afficherChamps() {
    //je prend toute les div de mon form et je les hide
    let divs = document.getElementById("form").getElementsByTagName("div")
    for (let i = 0; i < divs.length; i++) {
        divs[i].setAttribute("hidden", "true")
    }
    let val = selectCate.options[selectCate.selectedIndex].text
    document.getElementById("type")
    const listAllTypes = document.getElementsByName("all_type")
    for (let i = 0; i < listAllTypes.length; i++) {
        // La on a que un element html
        listAllTypes[i].removeAttribute("hidden")
    }

    // ----------------------------------Vehicule--------------------------------------
    //sur l'elem selectCate je veux l'elem qui est selec et jeux recuperer son texte
    if (val === "Vehicule") {

        document.getElementById("roue").removeAttribute("hidden")
        document.getElementById("carburant").removeAttribute("hidden")
        document.getElementById("encastrables").removeAttribute("hidden")
    }

    // ----------------------------------Console--------------------------------------

    if (val === "console") {

        document.getElementById("portable").removeAttribute("hidden")
        document.getElementById("encastrables").removeAttribute("hidden")
    }
    // ----------------------------------Vetement--------------------------------------

    if (val === "Vetement") {
        document.getElementById("taille").removeAttribute("hidden")
        document.getElementById("coupe").removeAttribute("hidden")
    }
    // ----------------------------------Produit de beaute--------------------------------------

    if (val === "Produit de beaute") {
        document.getElementById("encastrables").removeAttribute("hidden")

    }
    // ----------------------------------Electromenager--------------------------------------

    if (val === "Electromenager") {
        document.getElementById("energieElec").removeAttribute("hidden")
        document.getElementById("encastrables").removeAttribute("hidden")

    }
    // ----------------------------------HighTech--------------------------------------

    if (val === "High Tech") {
        document.getElementById("encastrables").removeAttribute("hidden")
    }

}