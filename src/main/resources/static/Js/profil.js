<<<<<<< HEAD

// création d'une fonction pour le bouton modifier quand on clique dessus. Lorsque la boite de dialogue s'affiche et que l'on clique sur annuler, ça reset les infos précédentes, sinon ça modifie.
function confirmModif() {

    modif = confirm("Voulez-vous modifier vos information?");
if (modif == false) {
    document.getElementById("modifForm").reset();

}
    return modif;
};


// function confirmModif() {
//     modif = confirm("Voulez-vous modifier vos information?");
//     if(modif == true){
//         return modif
//     }else{
//         return document.getElementById("annuler");
//     }
//
// };


// let modif = document.querySelector("modif");
// modif.addEventListener("click", (event) => {
//     // modif.innerHTML = `Nombre de clics : ${event.detail}`;
//     modif = confirm("Voulez-vous modifier vos information?");
//     if( modif == true ) {
//         document.write ("Modification effectuée!");
//     } else {
//         document.write ("Modification annulée!");
//     }
//
// });




=======
function confirmModif() {

    modif = confirm("Voulez-vous modifier vos information?");
    if (modif == false) {
        document.getElementById("modifForm").reset();

    }
    return modif;
};
>>>>>>> 5d2148ed383f4fc801ed72da5ac2538291e7fb5c
