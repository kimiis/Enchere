function confirmModif() {

    modif = confirm("Voulez-vous modifier vos information?");
    if (modif == false) {
        document.getElementById("modifForm").reset();

    }
    return modif;
};