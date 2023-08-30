let p = 0
let nbr = 0
let g,d;
window.onload = function () {
    image();
}
let image = () => {

    nbr = 8 /*j'ai 8 images*/
    p = 0 /*position 0 par defaut effet carousel*/

    container = document.getElementById("container");
    g = document.getElementById("droite");
    d = document.getElementById("gauche");
    afficherMasquer();
    container.style.width = (118 * nbr) + "rem";
    console.log(container)

    for (let i = 0; i < nbr; i++) {
        div = document.createElement("div");
        div.className = "photo";
        /*mettre des images*/
        div.style.backgroundImage = `url('img/barbie${i + 1}.jpg')`
        container.appendChild(div);
    }

    d.onclick=function () {

        if (p > -nbr + 1)/* une fois que j'atteind la val -7 carrousel ne marche plus*/
            p--;
        container.style.transform = "translate("+p*110+"rem)";
        container.style.transition = "all 0.5s ease";
        afficherMasquer();
    }

    g.onclick=function () {

        if (p < 0)
            p++;
        container.style.transform = "translate("+p*110+"rem)";
        container.style.transition = "all 0.5s ease";
        afficherMasquer();

    }
}
function afficherMasquer(){

    if (p == -nbr + 1)
        d.style.visibility = "hidden";
    else
        d.style.visibility = "visible";

    if (p == 0)
        g.style.visibility = "hidden";
    else
        g.style.visibility = "visible";
}



