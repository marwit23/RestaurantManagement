package com.marwit23.cook.inventory;


// ! TO NIE JEST ENTITY

// ? Zamienić na Service?


public class Inventory {

    private String inventoryIngredientName;
    private int totalIngredientQuantity;
    private int orderedIngredientQuantity;
    private int safeIngredientQuantity;
    private int notSafeIngredientQuantity;

    public String getInventoryIngredientName() {
        return inventoryIngredientName;
    }

    public int getTotalIngredientQuantity() {
        return totalIngredientQuantity;
    }

    public int getOrderedIngredientQuantity() {
        return orderedIngredientQuantity;
    }

    public int getSafeIngredientQuantity() {
        return safeIngredientQuantity;
    }

    public int getNotSafeIngredientQuantity() {
        return notSafeIngredientQuantity;
    }
}
