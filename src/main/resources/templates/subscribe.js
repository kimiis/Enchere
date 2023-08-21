let inputs;
let infos;
let indicateur_faible;
let indicateur_moyen;
let indicateur_fort;
let loginForm

onload = init;
//fonction lancée une fois que la page est chargée*/
function init() {
    // // récup de tous les inputs d'incription
    inputs = document.getElementsByTagName("input");

    //recup de tous les txt qui passeront en rouge si erreur
    infos = document.getElementsByTagName("p");

    indicateur_faible = document.getElementById("faible");
    indicateur_moyen = document.getElementById("moyen");
    indicateur_fort = document.getElementById("fort");

    inputs.user.addEventListener("input", verifierUtlisateur);
    inputs.mail.addEventListener("input", verifierMail);
    inputs.mdpInfo.addEventListener("input", verifierMdp);


    loginForm = document.getElementById("subForm");
    loginForm.addEventListener("submit", (e) => {
        e.preventDefault();


        let username = document.getElementById("user");
        let mail = document.getElementById("mail");
        let password = document.getElementById("mdpInfo");

        // si mail deja utilisé

        if (localStorage.getItem("mail") === mail.value) {
            window.alert("t'es déjà une licorne")
            document.location.href = "./login.html";
            return
        }
        if (localStorage.getItem("username") === username.value){
            window.alert("pseudo déjà pris")
            return
        }
        //vérifier qu'il a tout remplie

        if (username.value == "" || password.value == "") {
            alert("Champs manquant");
        } else {
            // perform operation with form input
            alert("~C'est bon t'es une licone maintenant~!");
            console.log(
                `This form has a username of ${username.value} and password of ${password.value}`
            );
            localStorage.setItem("username", username.value)
            localStorage.setItem("mail", mail.value)
            localStorage.setItem("password", password.value)

            username.value = "";
            password.value = "";
            mail.value = "";
            document.location.href = "./login.html"
        }

    });

}

function verifierUtlisateur() {
    //dans l'input "user", j'accede a ce qui a été tapé dedans
    if (inputs.user.value.length < 3) {
        infos.userInfo.style.color = "red";
    } else {
        infos.userInfo.style.color = "black";
    }
}
function verifierMail() {

    if (/^[\w-\.]+([\w-]+\.)+[\w-]{2,}$/.test(inputs.mail.value)) {
        infos.mailU.style.color = "black";
    } else {
        infos.mailU.style.color = "red";
    }
}
function verifierMdp() {

    if (/^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$/.test(inputs.mdpInfo.value)) {
        infos.mdpI.style.color = "black";
    } else {
        infos.mdpI.style.color = "red";
    }
    // Vérification du niveau de sécurité du mot de passe
    let symboleOK = /[#?!@$%^&*-]/.test(inputs.mdpInfo.value);
    let nombreOK = /[\d]/.test(inputs.mdpInfo.value);

    // Vérification des contraintes de mdp fort
    if (inputs.mdpInfo.value.length >= 6
        && symboleOK
        && nombreOK) {
        indicateur_faible.style.opacity = "100%";
        indicateur_moyen.style.opacity = "100%";
        indicateur_fort.style.opacity = "100%";
    }
    // Vérification des contraintes de mdp moyen
    else if (inputs.mdpInfo.value.length > 6
        && (symboleOK || nombreOK)) {
        indicateur_faible.style.opacity = "100%";
        indicateur_moyen.style.opacity = "100%";
        indicateur_fort.style.opacity = "0%";
    } else {
        indicateur_faible.style.opacity = "100%";
        indicateur_moyen.style.opacity = "0%";
        indicateur_fort.style.opacity = "0%";
    }
}