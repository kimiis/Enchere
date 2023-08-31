onload = ()=>{
    const registerButton = document.getElementById('register')
    const loginButton = document.getElementById('login')
    const container = document.getElementById('containerLogin')
    inputs = document.getElementsByTagName("input");
    inputs.user.addEventListener("input", verifierUtlisateur);
    inputs.mail.addEventListener("input", verifierMail);
    inputs.mdpInfo.addEventListener("input", verifierMdp);

    loginForm = document.getElementById("subForm");


    registerButton.onclick = function(){
        container.className = 'active'
    }
    loginButton.onclick = function(){
        container.className = 'close'
    }



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
    } else {
        inputs.mail.setCustomValidity("");
    }
}
function verifierMdp() {

    if (!(/^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$/.test(inputs.mdpInfo.value)) ){
        inputs.mdpInfo.setCustomValidity("T'es mauvais Bernard!");
    }else{
        inputs.mdpInfo.setCustomValidity("");
    }
}

// function verifierUtlisateur() {
//     //dans l'input "user", j'accede a ce qui a été tapé dedans
//     if (inputs.user.value.length < 3) {
//         infos.userInfo.style.color = "red";
//     } else {
//         infos.userInfo.style.color = "black";
//     }
// }
//
// function verifierMdp() {
//
//     if (/^((?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*[#?!@$%^&*-])).{6,}$/.test(inputs.mdpInfo.value)) {
//         infos.mdpI.style.color = "black";
//     } else {
//         infos.mdpI.style.color = "red";
//     }
//
// }


