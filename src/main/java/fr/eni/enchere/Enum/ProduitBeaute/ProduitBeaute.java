package fr.eni.enchere.Enum.ProduitBeaute;

import fr.eni.enchere.Enum.Auto.Marque;

public class ProduitBeaute {

    private TypeProdB typeProdB;
    private Marque marque;

    public ProduitBeaute(TypeProdB typeProdB, Marque marque) {
        this.typeProdB = typeProdB;
        this.marque = marque;
    }

    public TypeProdB getTypeProdB() {
        return typeProdB;
    }

    public void setTypeProdB(TypeProdB typeProdB) {
        this.typeProdB = typeProdB;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }
}
