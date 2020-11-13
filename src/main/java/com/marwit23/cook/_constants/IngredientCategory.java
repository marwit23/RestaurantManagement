package com.marwit23.cook._constants;

public enum IngredientCategory {
    GRAINS("grains"),
    DAIRY("dairy"),
    VEGETABLES("vegetables"),
    FRUITS("fruits"),
    MEAT("meat"),
    FATS("fats"),
    SPICES("spices");


    private final String displayValue;

    IngredientCategory(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }
}
