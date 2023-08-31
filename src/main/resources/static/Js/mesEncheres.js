onload = ()=>{

    var tabs = document.querySelectorAll(".tabs_wrap ul li");
    var mesEncheres = document.querySelectorAll(".mesEncheres");
    var enchereJeParticipe = document.querySelectorAll(".enchereJeParticipe");
    var interieur = document.querySelectorAll(".nowrap");
    tabs.forEach((tab)=>{
        tab.addEventListener("click", ()=>{
            tabs.forEach((tab)=>{
                tab.classList.remove("active");
            })
            tab.classList.add("active");
            var tabval = tab.getAttribute("data-tabs");

            interieur.forEach((item)=>{
                item.style.display = "none";
            })

            if(tabval == "mesEncheres"){
                mesEncheres.forEach((item)=>{
                    item.style.display = "block";
                })
            }else{
                enchereJeParticipe.forEach((item)=>{
                    item.style.display = "block";
                })
            }

        })
    })
}

