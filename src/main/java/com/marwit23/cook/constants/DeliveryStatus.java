package com.marwit23.cook.constants;

public enum DeliveryStatus {
    ORDERED("ordered"),
    DELIVERED("delivered");

    private final String displayValue;

    DeliveryStatus(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }
}
