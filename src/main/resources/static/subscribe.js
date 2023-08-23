let inputs;
let infos;
let loginForm

onload = init;

//fonction lancée une fois que la page est chargée*/
function init() {
    // // récup de tous les inputs d'incription
    inputs = document.getElementsByTagName("input");

    //recup de tous les txt qui passeront en rouge si erreur
    infos = document.getElementsByTagName("p");

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
            window.alert("Mail déjà utilisé")
            document.location.href = "/login";
            return
        }
        if (localStorage.getItem("username") === username.value) {
            window.alert("Pseudo déjà pris")
            return
        }
        //vérifier qu'il a tout remplie

        if (username.value == "" || password.value == "") {
            alert("Champs manquant");
        } else {
            // perform operation with form input
            alert("~C'est bon t'es inscrit maintenant~!");
            console.log(`Ce form a un username de ${username.value}et un un pw de ${password.value}`
            );

            localStorage.setItem("username", username.value)
            localStorage.setItem("mail", mail.value)
            localStorage.setItem("password", password.value)

            username.value = "";
            password.value = "";
            mail.value = "";
            document.location.href = "/login"
        }

    });
}
function verifierUtlisateur() {
    //dans l'input "user", j'accede a ce qui a été tapé dedans
    if (inputs.user.value.length < 3) {
        inputs.user.setCustomValidity("C'est trop court");
    }else{
        inputs.user.setCustomValidity("");
    }
}

function verifierMail() {

    if (!(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(inputs.mail.value))) {
        inputs.mail.setCustomValidity("Toujours pas ça Jean-Paul!");
    }else{
        inputs.mail.setCustomValidity("");
    }

function verifierMdp() {

    if (!(/^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$/.test(inputs.mdpInfo.value)) ){
        inputs.mdpInfo.setCustomValidity("T'es mauvais Bernard!");
    }else{
        inputs.mdpInfo.setCustomValidity("");
    }
}
}