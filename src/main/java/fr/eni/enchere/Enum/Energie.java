package fr.eni.enchere.Enum;

import java.util.List;

public enum Energie {

    DIESEL("diesel", "Diesel"),
    ESSENCE("essence", "Essence"),
    HYBRIDE("hybride", "Hybride"),
    ETHANOL("ethanol", "Ethanol"),
    AUTRE("autre", "Autre");
    private final String displayValue;

    public String getValue() {
        return value;
    }

    private final String value;

    private Energie(String value, String displayValue) {
        this.displayValue = displayValue;
        this.value = value;
    }

    public String getDisplayValue() {
        return displayValue;
    }
    List
}

