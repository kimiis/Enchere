let p = 0
let nbr = 0
let g,d;
window.onload = function () {
    image();
}
let image = () => {

    nbr = 7 /*j'ai 8 images*/
    p = 0 /*position 0 par defaut effet carousel*/

    container = document.getElementById("container");
    g = document.getElementById("gauche");
    d = document.getElementById("droite");
    afficherMasquer();
    container.style.width = (118 * nbr) + "rem";
    console.log(container)

    for (let i = 0; i < nbr; i++) {
        div = document.createElement("div");
        div.className = "photo";
        /*mettre des images*/
        div.style.backgroundImage = `url('/images/caroussel/caroussel${i+1}.png')`
        container.appendChild(div);
    }

    d.onclick=function () {

        if (p > -nbr + 1)/* une fois que j'atteind la val -7 carrousel ne marche plus*/
            p--;
        container.style.transform = "translate("+p*108+"rem)";
        container.style.transition = "all 0.5s ease";
        afficherMasquer();
    }

    g.onclick=function () {

        if (p < 0)
            p++;
        container.style.transform = "translate("+p*108+"rem)";
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



