package com.marwit23.cook.constants;

public enum ToDoStatus {
    TO_DO("pending"),
    DONE("done"),
    CANCELLED("cancelled");

    private final String displayValue;

    ToDoStatus(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }

}
