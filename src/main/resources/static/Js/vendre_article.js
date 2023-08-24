function verifierDate() {
    heureFinElement = document.getElementById("heureF");
    dateDebutElement=document.getElementById("heureD");

    dateDebut = new Date(dateDebutElement.value);
    dateFin = new Date(heureFinElement.value);

    if (dateFin<dateDebut){
        heureFinElement.setCustomValidity("la date de fin doit être supérieur à la date de départ!")
    }else{
        heureFinElement.setCustomValidity("")
    }

    if(dateDebut<=new Date()){
        dateDebutElement.setCustomValidity("la date doit être supérieur ou égal à la date du jour");
    }else{
        dateDebutElement.setCustomValidity("");
    }
}

function verifierPrix() {
    prixDepart = document.getElementById("prix");

    if (prixDepart.value <= 0) {
        prixDepart.setCustomValidity("le prix doit être supérieur à 0");
    } else {
        prixDepart.setCustomValidity("");
    }

}

function verifierNom() {
    nomArticle = document.getElementById("nameArticle");
    //dans l'input "user", j'accede a ce qui a été tapé dedans
    if (nomArticle.value.length < 3) {
        nomArticle.setCustomValidity("le nom doit faire au moins 3 char");
    } else {
        nomArticle.setCustomValidity("");
    }

}

function verifierDescription() {
    descrip = document.getElementById("description");
    //dans l'input "user", j'accede a ce qui a été tapé dedans
    if (descrip.value.length <= 100) {
        descrip.setCustomValidity("la description doit faire au moins 100 char");
    } else {
        descrip.setCustomValidity("");
    }

}